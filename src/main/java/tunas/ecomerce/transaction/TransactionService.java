package tunas.ecomerce.transaction;

import com.fasterxml.uuid.Generators;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import tunas.ecomerce.messaging.QueueSender;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;
import tunas.ecomerce.security.user.User;
import tunas.ecomerce.security.user.UserService;
import tunas.ecomerce.transaction.TransactionRepository.ITransactionResponse;
import tunas.ecomerce.transaction.cart.CartRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionService {

    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    private final DetailTransactionRepository detailTransactionRepository;
    private final CartRepository cartRepository;

    @Autowired
    private QueueSender queueSender;

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
        JSONObject reqBody = new JSONObject(jsonObject);
        User user = userService.findById(UUID.fromString(reqBody.getString("userId")));
        System.out.println(reqBody.getString("userId"));
        System.out.println(user.getUsername());
        Transaction transaction = new Transaction();
        transaction.setId(Generators.timeBasedGenerator().generate());
        transaction.setTransactionDate(new DateTime().toDate());
        transaction.setUser(user);
        transaction.setUserEmail(user.getEmail());
        transaction.setUserMobile(user.getMobile());
        transaction.setUserName(user.getUsername());

        Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<DetailTransaction>>() {}.getType();
        List<DetailTransaction> detailTransactions = gson.fromJson(reqBody.getJSONArray("products").toString(),datasetListType);
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
        cartRepository.destroyUserCart(user.getId());
        ITransactionResponse savedTransaction = transactionRepository.getTransactionById(transaction.getId());
        List<DetailTransactionRepository.IDetailTransactions> savedDetailTransaction = detailTransactionRepository.
                getDetailTransactionsByTransactionId(transaction.getId());

        queueSender.send(jsonObject);

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

    List<TransactionResponse> getTransactionByUserId(UUID id){
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
