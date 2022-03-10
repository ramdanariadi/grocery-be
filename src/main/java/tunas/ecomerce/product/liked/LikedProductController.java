package tunas.ecomerce.product.liked;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wishlist")
@AllArgsConstructor
public class LikedProductController {

    private final LikedProductService likedProductService;

    @PostMapping("/{userId}/{productId}")
    public ObjectResponse addToWishList(@PathVariable UUID userId,@PathVariable UUID productId){
        Liked saved = likedProductService.storeToWishlist(userId,productId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(saved != null){
            return customResponse.sendResponse("", HttpStatus.CREATED);
        }
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @GetMapping("/{userId}/{productId}")
    public ObjectResponse findProductFromWishList(@PathVariable UUID userId,@PathVariable UUID productId){
        LikedProductRepository.IWishProductNative lovedProduct = likedProductService.findProductFromWishlist(userId,productId);
        CustomResponse<LikedProductRepository.IWishProductNative> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(lovedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{productId}")
    public ObjectResponse removeFromWishList(@PathVariable UUID userId,@PathVariable UUID productId){
        return CustomResponse.getModifyingObjectResponse(likedProductService.removeFromWishList(userId, productId));
    }

    @GetMapping("/{userId}")
    public ListResponse userWishList(@PathVariable UUID userId){
        List<LikedProductRepository.IWishProduct> likedProductList = likedProductService.wishList(userId);
        CustomResponse<LikedProductRepository.IWishProduct> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(likedProductList,HttpStatus.OK);
    }
}
