package id.grocery.tunas.transaction.cart;

import com.fasterxml.uuid.Generators;
import id.grocery.tunas.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.grocery.tunas.product.ProductRepository;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserRepository;

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

    public boolean storeToChart(String userId,UUID productId,Integer total){
        Optional<Cart> optionalChart = cartRepository.findChartByUserIdAndProductId(userId,productId);
        if(optionalChart.isPresent()){
            return cartRepository.incrementProductTotalInChart(userId,productId) > 0;
        }
        Product product = productRepository.findProductById(productId);
        Optional<User> user = userRepository.findById(userId);
        Cart cart = new Cart();
        cart.setId(Generators.timeBasedGenerator().generate());
        cart.setTotal(total);
        cart.setProduct(product);
        cart.setUser(user.get());
        return cartRepository.save(cart) != null;
    }

    public List<CartRepository.ICharts> chartList(String userId){
        return cartRepository.findChartsByUserId(userId);
    }

    public Integer removeFromChart(String userId, UUID productId) {
        return cartRepository.removeFromChart(userId,productId);
    }
}
