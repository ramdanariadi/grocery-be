package tunas.ecomerce.transaction;

import com.fasterxml.uuid.Generators;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunas.ecomerce.customer.Customer;
import tunas.ecomerce.customer.CustomerService;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    CustomerService customerService;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DetailTransactionRepository detailTransactionRepository;

    public List<DetailTransaction> makeTransaction(String jsonObject){
        JSONObject reqBody = new JSONObject(jsonObject);
        Customer customer = customerService.getCustomer(UUID.fromString(reqBody.getString("userId")));
        Transaction transaction = new Transaction();
        transaction.setId(Generators.timeBasedGenerator().generate());
        transaction.setTransactionDate(new DateTime().toDate());
        transaction.setCustomer(customer);
        transaction.setCustomerName(customer.getName());
        transaction.setCustomerEmail(customer.getEmail());
        transaction.setCustomerMobile(customer.getMobile());

        Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<DetailTransaction>>() {}.getType();
        List<DetailTransaction> detailTransactions = gson.fromJson(reqBody.getJSONArray("products").toString(),datasetListType);
        Long totalPrice = 0L;
        for (DetailTransaction d: detailTransactions){
            totalPrice += d.getPrice() * d.getTotal();
            Product product = productRepository.findProductById(d.getId());
            d.setProduct(product);
            d.setId(Generators.timeBasedGenerator().generate());
            d.setTransaction(transaction);
        }
        transaction.setTotalPrice(totalPrice);
        transactionRepository.save(transaction);
        detailTransactionRepository.saveAll(detailTransactions);
        return detailTransactions;
    }
}
