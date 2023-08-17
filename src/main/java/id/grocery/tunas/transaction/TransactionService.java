package id.grocery.tunas.transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.google.common.base.Strings;

import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.product.ProductRepository;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserService;
import id.grocery.tunas.transaction.TransactionRepository.ITransactionData;
import id.grocery.tunas.cart.CartRepository;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Service
public class TransactionService {

    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    private final TransactionDetailRepository transactionDetailRepository;
    private final CartRepository cartRepository;

    @Autowired
    public TransactionService(UserService userService, TransactionRepository transactionRepository, ProductRepository productRepository, TransactionDetailRepository transactionDetailRepository, CartRepository cartRepository) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.transactionDetailRepository = transactionDetailRepository;
        this.cartRepository = cartRepository;
    }

    @Transactional
    public TransactionData makeTransaction(String jsonObject){
        JsonObject reqBody = new JsonObject(jsonObject);
        Optional<User> user = userService.findById(reqBody.getString("userId"));

        if(user.isEmpty()){
            throw new ApiRequestException(ApiRequestException.BAD_REQUEST,HttpStatus.UNAUTHORIZED);
        }

        Transaction transaction = new Transaction();
        transaction.setId(Generators.timeBasedGenerator().generate());
        transaction.setCreatedAt(new DateTime().toDate());
        transaction.setUser(user.get());

        JsonArray products = reqBody.getJsonArray("products");
        List<TransactionDetail> transactionDetails = products.stream().map(o -> {
            JsonObject product = (JsonObject) o;
            TransactionDetail transactionDetail = new TransactionDetail();
            transactionDetail.setId(UUID.fromString(product.getString("id")));
            transactionDetail.setImageUrl(Strings.emptyToNull(product.getString("imageUrl")));
            transactionDetail.setName(product.getString("name"));
            transactionDetail.setPerUnit(product.getInteger("perUnit"));
            transactionDetail.setWeight(product.getInteger("weight"));
            transactionDetail.setPrice(BigDecimal.valueOf(product.getLong("price")));
            transactionDetail.setTotal(product.getInteger("total"));
            return transactionDetail;
        }).collect(Collectors.toList());

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (TransactionDetail d: transactionDetails){
            BigDecimal weight = BigDecimal.valueOf(d.getWeight());
            BigDecimal total = BigDecimal.valueOf(d.getTotal());
            BigDecimal perUnit = BigDecimal.valueOf(d.getPerUnit());
            totalPrice = totalPrice.add(((weight.multiply(total)).divide(perUnit)).multiply(d.getPrice()));
            Product product = productRepository.findProductById(d.getId());
            d.setProduct(product);
            d.setId(Generators.timeBasedGenerator().generate());
            d.setTransaction(transaction);
        }
        transaction.setTotalPrice(totalPrice);
        transactionRepository.save(transaction);
        transactionDetailRepository.saveAll(transactionDetails);
        cartRepository.destroyUserCart(user.get().getId());
        ITransactionData savedTransaction = transactionRepository.getTransactionById(transaction.getId());
        List<TransactionDetailRepository.IDetailTransactions> savedDetailTransaction = transactionDetailRepository.
                getDetailTransactionsByTransactionId(transaction.getId());
        return new TransactionData(savedTransaction,savedDetailTransaction);
    }

    TransactionData getTransactionById(UUID id){
        ITransactionData savedTransaction = transactionRepository.getTransactionById(id);
        List<TransactionDetailRepository.IDetailTransactions> savedDetailTransaction = transactionDetailRepository.
                getDetailTransactionsByTransactionId(id);
        return new TransactionData(savedTransaction,savedDetailTransaction);
    }

    @Transactional(rollbackOn = ApiRequestException.class)
    public int destroyTransaction(UUID id){
        transactionRepository.destroyTransactionDetail(id);
        int transactionDestroy = transactionRepository.destroyTransaction(id);
        if(transactionDestroy < 1){
            throw new ApiRequestException("",HttpStatus.NOT_MODIFIED);
        }
        return transactionDestroy;
    }

    public List<TransactionData> getTransactionByCustomerId(UUID id){
        List<ITransactionData> iTransactionResponses = transactionRepository.getTransactionsByUserId(id);
        List<TransactionDetailRepository.IDetailTransactions> iDetailTransactions = transactionDetailRepository.getDetailTransactionsByUserId(id);
        List<TransactionData> transactionResponseList = iTransactionResponses.stream().map((t) -> {
            TransactionData transactionResponse = new TransactionData();
            transactionResponse.setTransaction(t);
            transactionResponse.setDetailTransaction(iDetailTransactions.stream().filter(e -> e.getTransactionId().toString().equals(t.getId().toString())).collect(Collectors.toList()));
            return transactionResponse;
        }).collect(Collectors.toList());
        return transactionResponseList;
    }
}
