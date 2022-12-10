package id.grocery.tunas.transaction.cart;

import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity addToChart(@PathVariable String userId, @PathVariable UUID productId, @PathVariable Integer total){
        cartService.storeToChart(userId,productId,total);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/{cartId}")
    public ResponseEntity removeFromChart(@PathVariable String userId,@PathVariable UUID cartId){
        Integer nModified = cartService.removeFromChart(userId, cartId);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity customerChart(@PathVariable String userId){
        List<CartRepository.ICharts> charts = cartService.chartList(userId);
        JsonObject result = new JsonObject();
        result.put("data", charts);
        return ResponseEntity.ok(result.getMap());
    }
}
