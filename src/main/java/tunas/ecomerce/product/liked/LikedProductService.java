package tunas.ecomerce.product.liked;

import com.fasterxml.uuid.Generators;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;
import tunas.ecomerce.security.user.User;
import tunas.ecomerce.security.user.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LikedProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final LikedProductRepository likedProductRepository;

    public Liked storeToWishlist(UUID userId, UUID productId){
        Product product = productRepository.findProductById(productId);
        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()){
            throw new ApiRequestException("User not found",HttpStatus.PRECONDITION_FAILED);
        }

        Liked liked = new Liked();
        liked.setId(Generators.timeBasedGenerator().generate());
        liked.setProduct(product);
        liked.setUser(user.get());
        return likedProductRepository.save(liked);
    }

    public LikedProductRepository.IWishProductNative findProductFromWishlist(UUID userId, UUID productId){
        LikedProductRepository.IWishProductNative lovedProduct = likedProductRepository.findProductFromWishLIst(userId,productId);
        if(lovedProduct == null){
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
