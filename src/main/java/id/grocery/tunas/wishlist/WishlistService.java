package id.grocery.tunas.wishlist;

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
public class WishlistService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final WishlistRepository wishlistRepository;

    public Wishlist storeToWishlist(UUID userId, UUID productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new ApiRequestException("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new ApiRequestException(ApiRequestException.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
        }
        Wishlist wishlist = new Wishlist();
        wishlist.setId(Generators.timeBasedGenerator().generate());
        wishlist.setProduct(productOptional.get());
        wishlist.setUser(user.get());
        return wishlistRepository.save(wishlist);
    }

    public WishlistRepository.IWishProductNative findProductFromWishlist(UUID userId, UUID productId){
        WishlistRepository.IWishProductNative lovedProduct = wishlistRepository.findProductFromWishLIst(userId,productId);
        if(null == lovedProduct){
            throw new ApiRequestException("", HttpStatus.NO_CONTENT);
        }
        return lovedProduct;
    }

    public int removeFromWishList(UUID userId, UUID productId){
        return wishlistRepository.removeWishlist(userId, productId);
    }

    public List<WishlistRepository.IWishProduct> wishList(UUID userId){
        List<WishlistRepository.IWishProduct> wishlist = wishlistRepository.findWishListByuserId(userId);
        return wishlist;
    }
}
