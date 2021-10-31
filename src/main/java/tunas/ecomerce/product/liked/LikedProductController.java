package tunas.ecomerce.product.liked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wishlist")
public class LikedProductController {

    private final LikedProductService likedProductService;

    @Autowired
    public LikedProductController(LikedProductService likedProductService) {
        this.likedProductService = likedProductService;
    }

    @PostMapping("/{customerId}/{productId}")
    public ObjectResponse addToWishList(@PathVariable UUID customerId,@PathVariable UUID productId){
        Liked saved = likedProductService.storeToWishlist(customerId,productId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(saved != null){
            return customResponse.sendResponse("", HttpStatus.CREATED);
        }
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @GetMapping("/{customerId}/{productId}")
    public ObjectResponse findProductFromWishList(@PathVariable UUID customerId,@PathVariable UUID productId){
        LikedProductRepository.IWishProductNative lovedProduct = likedProductService.findProductFromWishlist(customerId,productId);
        CustomResponse<LikedProductRepository.IWishProductNative> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(lovedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}/{productId}")
    public ObjectResponse removeFromWishList(@PathVariable UUID customerId,@PathVariable UUID productId){
        return CustomResponse.getModifyingObjectResponse(likedProductService.removeFromWishList(customerId, productId));
    }

    @GetMapping("/{customerId}")
    public ListResponse customerWishList(@PathVariable UUID customerId){
        List<LikedProductRepository.IWishProduct> likedProductList = likedProductService.wishList(customerId);
        CustomResponse<LikedProductRepository.IWishProduct> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(likedProductList,HttpStatus.OK);
    }
}
