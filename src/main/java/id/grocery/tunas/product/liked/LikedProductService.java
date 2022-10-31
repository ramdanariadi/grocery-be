package id.grocery.tunas.product.liked;

import com.fasterxml.uuid.Generators;
import id.grocery.tunas.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import id.grocery.tunas.customer.Customer;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.Product;
import id.grocery.tunas.product.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LikedProductService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final LikedProductRepository likedProductRepository;

    public Liked storeToWishlist(UUID customerId, UUID productId){
        Product product = productRepository.findProductById(productId);
        Customer customer = customerRepository.findCustomersById(customerId);
        Liked liked = new Liked();
        liked.setId(Generators.timeBasedGenerator().generate());
        liked.setProduct(product);
        liked.setCustomer(customer);
        return likedProductRepository.save(liked);
    }

    public LikedProductRepository.IWishProductNative findProductFromWishlist(UUID customerId, UUID productId){
        LikedProductRepository.IWishProductNative lovedProduct = likedProductRepository.findProductFromWishLIst(customerId,productId);
        if(null == lovedProduct){
            throw new ApiRequestException("", HttpStatus.NO_CONTENT);
        }
        return lovedProduct;
    }

    public int removeFromWishList(UUID customerId, UUID productId){
        return likedProductRepository.removeWishlist(customerId, productId);
    }

    public List<LikedProductRepository.IWishProduct> wishList(UUID customerId){
        List<LikedProductRepository.IWishProduct> wishlist = likedProductRepository.findWishListByCustomerId(customerId);
        return wishlist;
    }
}
