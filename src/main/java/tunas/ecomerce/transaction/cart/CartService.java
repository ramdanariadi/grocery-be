package tunas.ecomerce.transaction.cart;

import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import tunas.ecomerce.security.user.User;
import tunas.ecomerce.security.user.UserRepository;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CartService(ProductRepository productRepository, UserRepository userRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    public boolean storeToChart(UUID userId,UUID productId,Integer total){
        Optional<Cart> optionalChart = cartRepository.findChartByUserIdAndProductId(userId,productId);
        if(optionalChart.isPresent()){
            return cartRepository.incrementProductTotalInChart(userId,productId) > 0;
        }
        Product product = productRepository.findProductById(productId);
        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()){
            throw new ApiRequestException("user not found", HttpStatus.PRECONDITION_FAILED);
        }

        Cart cart = new Cart();
        cart.setId(Generators.timeBasedGenerator().generate());
        cart.setTotal(total);
        cart.setProduct(product);
        cart.setUser(user.get());
        return cartRepository.save(cart) != null;
    }

    public List<CartRepository.ICharts> chartList(UUID userId){
        return cartRepository.findChartsByUserId(userId);
    }

    public Integer removeFromChart(UUID userId, UUID productId) {
        return cartRepository.removeFromChart(userId,productId);
    }
}
