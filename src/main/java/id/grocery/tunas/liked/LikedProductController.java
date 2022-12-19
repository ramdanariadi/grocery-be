package id.grocery.tunas.liked;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wishlist")
@AllArgsConstructor
public class LikedProductController {

    private final LikedProductService likedProductService;

    @PostMapping("/{customerId}/{productId}")
    public ResponseEntity<Object> addToWishList(@PathVariable String customerId, @PathVariable UUID productId){
        likedProductService.storeToWishlist(customerId,productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{customerId}/{productId}")
    public ResponseEntity<Object> findProductFromWishList(@PathVariable UUID customerId,@PathVariable UUID productId){
        LikedProductRepository.IWishProductNative lovedProduct = likedProductService.findProductFromWishlist(customerId,productId);
        JsonObject result = new JsonObject();
        result.put("data", lovedProduct);
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping("/{customerId}/{productId}")
    public ResponseEntity<Object> removeFromWishList(@PathVariable UUID customerId,@PathVariable UUID productId){
        int nModified = likedProductService.removeFromWishList(customerId, productId);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> customerWishList(@PathVariable UUID customerId){
        List<LikedProductRepository.IWishProduct> likedProductList = likedProductService.wishList(customerId);
        JsonObject result = new JsonObject();
        result.put("data", likedProductList);
        return ResponseEntity.ok(result.getMap());
    }
}
