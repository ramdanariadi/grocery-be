package id.tunas.grocery.wishlist;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wishlist")
@AllArgsConstructor
public class WishlistController {

    private final WishlistProductService wishlistProductService;

    @PostMapping("/{userId}/{productId}")
    public ResponseEntity<Object> addToWishlist(@PathVariable UUID userId, @PathVariable UUID productId){
        wishlistProductService.addWishlist(userId,productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getWishlist(@PathVariable UUID userId){
        List<Map<String, Object>> likedProductList = wishlistProductService.getWishlist(userId);
        JsonObject result = new JsonObject();
        result.put("data", likedProductList);
        return ResponseEntity.ok(result.getMap());
    }


    @GetMapping("/{userId}/{productId}")
    public ResponseEntity<Object> getCartByUserAndProductId(@PathVariable UUID userId, @PathVariable UUID productId){
        Map<String, Object> liked = wishlistProductService.getWishlistByUserAndProductId(userId, productId);
        JsonObject result = new JsonObject();
        result.put("data", liked);
        return ResponseEntity.ok(result.getMap());
    }


    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Object> destroyFromWishlist(@PathVariable UUID userId,@PathVariable UUID productId){
        wishlistProductService.destroyWishlist(userId, productId);
        return ResponseEntity.ok().build();
    }

}
