package id.grocery.tunas.product.liked;

import com.fasterxml.uuid.Generators;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.product.ProductRepository;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LikedProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final LikedProductRepository likedProductRepository;

    public Liked storeToWishlist(String userId, UUID productId){
        Product product = productRepository.findProductById(productId);
        Optional<User> user = userRepository.findById(userId);
        Liked liked = new Liked();
        liked.setId(Generators.timeBasedGenerator().generate());
        liked.setProduct(product);
        liked.setUser(user.get());
        return likedProductRepository.save(liked);
    }

    public LikedProductRepository.IWishProductNative findProductFromWishlist(UUID userId, UUID productId){
        LikedProductRepository.IWishProductNative lovedProduct = likedProductRepository.findProductFromWishLIst(userId,productId);
        if(null == lovedProduct){
            throw new ApiRequestException("", HttpStatus.NO_CONTENT);
        }
        return lovedProduct;
    }

    public int removeFromWishList(UUID userId, UUID productId){
        return likedProductRepository.removeWishlist(userId, productId);
    }

    public List<LikedProductRepository.IWishProduct> wishList(UUID userId){
        List<LikedProductRepository.IWishProduct> wishlist = likedProductRepository.findWishListByuserId(userId);
        return wishlist;
    }
}
