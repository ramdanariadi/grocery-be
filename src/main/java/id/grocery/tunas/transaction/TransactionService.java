package id.grocery.tunas.transaction;

import com.fasterxml.uuid.Generators;
import com.google.common.base.Strings;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.product.ProductRepository;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserService;
import id.grocery.tunas.transaction.TransactionRepository.ITransactionResponse;
import id.grocery.tunas.transaction.cart.CartRepository;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public TransactionResponse makeTransaction(String jsonObject){
        JsonObject reqBody = new JsonObject(jsonObject);
        Optional<User> user = userService.findById(reqBody.getString("userId"));
        Transaction transaction = new Transaction();
        transaction.setId(Generators.timeBasedGenerator().generate());
        transaction.setTransactionDate(new DateTime().toDate());
        transaction.setUser(user.get());

        JsonArray products = reqBody.getJsonArray("products");
        List<DetailTransaction> detailTransactions = products.stream().map(o -> {
            JsonObject product = (JsonObject) o;
            DetailTransaction detailTransaction = new DetailTransaction();
            detailTransaction.setId(UUID.fromString(product.getString("di")));
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
        ITransactionResponse savedTransaction = transactionRepository.getTransactionById(transaction.getId());
        List<DetailTransactionRepository.IDetailTransactions> savedDetailTransaction = detailTransactionRepository.
                getDetailTransactionsByTransactionId(transaction.getId());
        return new TransactionResponse(savedTransaction,savedDetailTransaction);
    }

    TransactionResponse getTransactionById(UUID id){
        ITransactionResponse savedTransaction = transactionRepository.getTransactionById(id);
        List<DetailTransactionRepository.IDetailTransactions> savedDetailTransaction = detailTransactionRepository.
                getDetailTransactionsByTransactionId(id);
        return new TransactionResponse(savedTransaction,savedDetailTransaction);
    }

    @Transactional(rollbackOn = ApiRequestException.class)
    int destroyTransaction(UUID id){
        transactionRepository.destroyTransactionDetail(id);
        int transactionDestroy = transactionRepository.destroyTransaction(id);
        if(transactionDestroy < 1){
            throw new ApiRequestException("",HttpStatus.NOT_MODIFIED);
        }
        return transactionDestroy;
    }

    List<TransactionResponse> getTransactionByCustomerId(UUID id){
        List<ITransactionResponse> iTransactionResponses = transactionRepository.getTransactionsByUserId(id);
        List<DetailTransactionRepository.IDetailTransactions> iDetailTransactions = detailTransactionRepository.getDetailTransactionsByUserId(id);
        List<TransactionResponse> transactionResponseList = iTransactionResponses.stream().map((t) -> {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setTransaction(t);
            transactionResponse.setDetailTransaction(iDetailTransactions.stream().filter(e -> e.getTransactionId().toString().equals(t.getId().toString())).collect(Collectors.toList()));
            return transactionResponse;
        }).collect(Collectors.toList());
        return transactionResponseList;
    }
}
