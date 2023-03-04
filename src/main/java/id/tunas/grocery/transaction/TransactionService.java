package id.tunas.grocery.transaction;

import id.tunas.grocery.exception.ApiRequestException;
import id.tunas.grocery.grpc.Transaction;
import id.grocery.tunas.grpc.*;
import id.tunas.grocery.security.user.User;
import id.tunas.grocery.security.user.UserService;
import id.tunas.grocery.utils.GrpcResponseUtil;
import id.tunas.grocery.grpc.*;
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
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public Map<String, Object> getTransactionById(UUID id){
        TransactionResponse response = transactionServiceBlockingStub.findByTransactionId(TransactionId.newBuilder()
                        .setId(id.toString()).build());
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        return fetchTransactionToMap(response.getData());
    }

    @Transactional(rollbackOn = ApiRequestException.class)
    public void destroyTransaction(UUID id){
        Response response = transactionServiceBlockingStub.delete(TransactionId.newBuilder().setId(id.toString()).build());
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public List<Map<String, Object>> getTransactionByUserId(UUID id){
        MultipleTransactionResponse response = transactionServiceBlockingStub.findByUserId(TransactionUserId.newBuilder().setId(id.toString()).build());
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

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
