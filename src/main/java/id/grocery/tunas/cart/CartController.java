package id.grocery.tunas.cart;

import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{userId}/{productId}/{total}")
    public ResponseEntity<Object> addToCart(@PathVariable UUID userId, @PathVariable UUID productId, @PathVariable Integer total){
        cartService.storeToCart(userId,productId,total);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getCartByUserId(@PathVariable UUID userId){
        List<Map<String, Object>> charts = cartService.userCartList(userId);
        JsonObject result = new JsonObject();
        result.put("data", charts);
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping("/{userId}/{cartId}")
    public ResponseEntity<Object> removeFromCart(@PathVariable UUID userId,@PathVariable UUID cartId){
        cartService.removeFromCart(userId, cartId);
        return ResponseEntity.ok().build();
    }
}
