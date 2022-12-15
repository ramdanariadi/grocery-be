package id.grocery.tunas.transaction;

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
import id.grocery.tunas.transaction.cart.CartRepository;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Service
public class TransactionService {

    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    private final DetailTransactionRepository detailTransactionRepository;
    private final CartRepository cartRepository;

    @Autowired
    public TransactionService(UserService userService, TransactionRepository transactionRepository, ProductRepository productRepository, DetailTransactionRepository detailTransactionRepository, CartRepository cartRepository) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.detailTransactionRepository = detailTransactionRepository;
        this.cartRepository = cartRepository;
    }

    @Transactional
    public TransactionData makeTransaction(String jsonObject){
        JsonObject reqBody = new JsonObject(jsonObject);
        Optional<User> user = userService.findById(reqBody.getString("userId"));
        Transaction transaction = new Transaction();
        transaction.setId(Generators.timeBasedGenerator().generate());
        transaction.setCreatedAt(new DateTime().toDate());
        transaction.setUser(user.get());

        JsonArray products = reqBody.getJsonArray("products");
        List<DetailTransaction> detailTransactions = products.stream().map(o -> {
            JsonObject product = (JsonObject) o;
            DetailTransaction detailTransaction = new DetailTransaction();
            detailTransaction.setId(UUID.fromString(product.getString("id")));
            detailTransaction.setImageUrl(Strings.emptyToNull(product.getString("imageUrl")));
            detailTransaction.setName(product.getString("name"));
            detailTransaction.setPerUnit(product.getInteger("perUnit"));
            detailTransaction.setWeight(product.getInteger("weight"));
            detailTransaction.setPrice(product.getLong("price"));
            detailTransaction.setTotal(product.getInteger("total"));
            return detailTransaction;
        }).collect(Collectors.toList());

        Long totalPrice = 0L;
        for (DetailTransaction d: detailTransactions){
            totalPrice += ((d.getWeight() * d.getTotal()) / d.getPerUnit()) * d.getPrice();
            Product product = productRepository.findProductById(d.getId());
            d.setProduct(product);
            d.setId(Generators.timeBasedGenerator().generate());
            d.setTransaction(transaction);
        }
        transaction.setTotalPrice(totalPrice);
        transactionRepository.save(transaction);
        detailTransactionRepository.saveAll(detailTransactions);
        cartRepository.destroyUserCart(user.get().getId());
        ITransactionData savedTransaction = transactionRepository.getTransactionById(transaction.getId());
        List<DetailTransactionRepository.IDetailTransactions> savedDetailTransaction = detailTransactionRepository.
                getDetailTransactionsByTransactionId(transaction.getId());
        return new TransactionData(savedTransaction,savedDetailTransaction);
    }

    TransactionData getTransactionById(UUID id){
        ITransactionData savedTransaction = transactionRepository.getTransactionById(id);
        List<DetailTransactionRepository.IDetailTransactions> savedDetailTransaction = detailTransactionRepository.
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
        List<DetailTransactionRepository.IDetailTransactions> iDetailTransactions = detailTransactionRepository.getDetailTransactionsByUserId(id);
        List<TransactionData> transactionResponseList = iTransactionResponses.stream().map((t) -> {
            TransactionData transactionResponse = new TransactionData();
            transactionResponse.setTransaction(t);
            transactionResponse.setDetailTransaction(iDetailTransactions.stream().filter(e -> e.getTransactionId().toString().equals(t.getId().toString())).collect(Collectors.toList()));
            return transactionResponse;
        }).collect(Collectors.toList());
        return transactionResponseList;
    }
}
