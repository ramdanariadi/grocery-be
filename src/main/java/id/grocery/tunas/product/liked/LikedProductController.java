package id.grocery.tunas.product.liked;

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
public class LikedProductController {

    private final LikedProductService likedProductService;

    @PostMapping("/{userId}/{productId}")
    public ResponseEntity<Object> addToWishlist(@PathVariable UUID userId, @PathVariable UUID productId){
        likedProductService.addWishlist(userId,productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/{likedId}")
    public ResponseEntity<Object> destroyFromWishlist(@PathVariable UUID userId,@PathVariable UUID likedId){
        likedProductService.destroyWishlist(userId, likedId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getWishlist(@PathVariable UUID userId){
        List<Map<String, Object>> likedProductList = likedProductService.getWishlist(userId);
        JsonObject result = new JsonObject();
        result.put("data", likedProductList);
        return ResponseEntity.ok(result.getMap());
    }
}
