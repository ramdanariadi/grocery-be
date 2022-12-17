package id.grocery.tunas.transaction;

import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.grpc.Transaction;
import id.grocery.tunas.grpc.*;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserService;
import io.grpc.ManagedChannel;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final UserService userService;
    private final TransactionServiceGrpc.TransactionServiceBlockingStub transactionServiceBlockingStub;
    private final String STATUS_FAILED = "FAILED";
    private final String STATUS_SUCCESS = "SUCCESS";

    @Autowired
    public TransactionService(UserService userService, ManagedChannel managedChannel) {
        this.userService = userService;
        this.transactionServiceBlockingStub = TransactionServiceGrpc.newBlockingStub(managedChannel);
    }

    @Transactional
    public void makeTransaction(String jsonObject){
        JsonObject reqBody = new JsonObject(jsonObject);
        Optional<User> user = userService.findById(reqBody.getString("userId"));

        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        TransactionBody transactionBody = TransactionBody.newBuilder()
                .addAllProducts(reqBody.getJsonArray("products").stream().map(o -> {
                    JsonObject product = (JsonObject)o;
                    TransactionProduct transactionProduct = TransactionProduct.newBuilder()
                            .setProductId(product.getString("id"))
                            .setTotal(product.getInteger("total")).build();
                    return transactionProduct;
                }).collect(Collectors.toList()))
                .setUserId(reqBody.getString("userId")).build();

        Response response = transactionServiceBlockingStub.save(transactionBody);

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }

    public Map<String, Object> getTransactionById(UUID id){
        TransactionResponse response = transactionServiceBlockingStub.findByTransactionId(TransactionId.newBuilder()
                        .setId(id.toString()).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }

        return fetchTransactionToMap(response.getData());
    }

    @Transactional(rollbackOn = ApiRequestException.class)
    public void destroyTransaction(UUID id){
        Response response = transactionServiceBlockingStub.delete(TransactionId.newBuilder().setId(id.toString()).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }

    public List<Map<String, Object>> getTransactionByUserId(UUID id){
        MultipleTransactionResponse response = transactionServiceBlockingStub.findByUserId(TransactionUserId.newBuilder().setId(id.toString()).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
        return response.getDataList().stream()
                .map(this::fetchTransactionToMap).collect(Collectors.toList());
    }

    private Map<String, Object> fetchTransactionToMap(Transaction data){
        Map<String, Object> result = new HashMap<>();
        result.put("id", data.getId());
        result.put("total", data.getTotalPrice());
        result.put("transactionDate", data.getTransactionDate());

        List<Map<String, Object>> transactionDetail =
                data.getProductsList().stream().map(transactionProductDetail -> {
                    Map<String, Object> detail = new HashMap<>();
                    detail.put("id", transactionProductDetail.getId());
                    detail.put("name", transactionProductDetail.getName());
                    detail.put("price", transactionProductDetail.getPrice());
                    detail.put("perUnit", transactionProductDetail.getPerUnit());
                    detail.put("imageUrl", transactionProductDetail.getImageUrl());
                    detail.put("total", transactionProductDetail.getTotal());
                    return detail;
                }).collect(Collectors.toList());

        result.put("products", transactionDetail);
        return result;
    }
}
