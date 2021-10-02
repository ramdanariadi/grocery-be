package tunas.ecomerce.product.liked;

import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunas.ecomerce.customer.Customer;
import tunas.ecomerce.customer.CustomerRepository;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LikedProductService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final LikedProductRepository likedProductRepository;

    @Autowired
    public LikedProductService(ProductRepository productRepository, CustomerRepository customerRepository, LikedProductRepository likedProductRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.likedProductRepository = likedProductRepository;
    }

    public Liked storeToChart(UUID customerId, UUID productId){
        Product product = productRepository.findProductById(productId);
        Customer customer = customerRepository.findCustomersById(customerId);
        Liked liked = new Liked();
        liked.setId(Generators.timeBasedGenerator().generate());
        liked.setTotal(1);
        liked.setProduct(product);
        liked.setCustomer(customer);
        return likedProductRepository.save(liked);
    }

    public int removeFromChart(UUID customerId, UUID productId){
        return likedProductRepository.removeWishlist(customerId, productId);
    }

    public List<LikedProductRepository.ICharts> chartList(UUID customerId){
        List<LikedProductRepository.ICharts> charts = likedProductRepository.findChartsByCustomerId(customerId);
        return charts;
    }
}
