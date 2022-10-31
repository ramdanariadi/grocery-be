package id.grocery.tunas.transaction.cart;

import com.fasterxml.uuid.Generators;
import id.grocery.tunas.customer.Customer;
import id.grocery.tunas.customer.CustomerRepository;
import id.grocery.tunas.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.grocery.tunas.product.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CartService(ProductRepository productRepository, CustomerRepository customerRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    public boolean storeToChart(UUID customerId,UUID productId,Integer total){
        Optional<Cart> optionalChart = cartRepository.findChartByCustomerIdAndProductId(customerId,productId);
        if(optionalChart.isPresent()){
            return cartRepository.incrementProductTotalInChart(customerId,productId) > 0;
        }
        Product product = productRepository.findProductById(productId);
        Customer customer = customerRepository.findCustomersById(customerId);
        Cart cart = new Cart();
        cart.setId(Generators.timeBasedGenerator().generate());
        cart.setTotal(total);
        cart.setProduct(product);
        cart.setCustomer(customer);
        return cartRepository.save(cart) != null;
    }

    public List<CartRepository.ICharts> chartList(UUID customerId){
        return cartRepository.findChartsByCustomerId(customerId);
    }

    public Integer removeFromChart(UUID customerId, UUID productId) {
        return cartRepository.removeFromChart(customerId,productId);
    }
}
