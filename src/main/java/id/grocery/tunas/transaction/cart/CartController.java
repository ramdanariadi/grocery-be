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

    @PostMapping("/{customerId}/{productId}/{total}")
    public ResponseEntity addToChart(@PathVariable UUID customerId, @PathVariable UUID productId, @PathVariable Integer total){
        cartService.storeToChart(customerId,productId,total);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{customerId}/{cartId}")
    public ResponseEntity removeFromChart(@PathVariable UUID customerId,@PathVariable UUID cartId){
        Integer nModified = cartService.removeFromChart(customerId, cartId);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity customerChart(@PathVariable UUID customerId){
        List<CartRepository.ICharts> charts = cartService.chartList(customerId);
        JsonObject result = new JsonObject();
        result.put("data", charts);
        return ResponseEntity.ok(result.getMap());
    }
}
