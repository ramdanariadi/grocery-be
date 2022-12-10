package id.grocery.tunas.product.topproduct;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/top")
@AllArgsConstructor
public class TopProductController {

    private final TopProductService topProductService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable UUID id){
        Optional<TopProduct> topProduct = topProductService.getById(id);
        JsonObject result = new JsonObject();
        topProduct.ifPresent(topProduct1 -> result.put("data", result));
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroyTopProduct(@PathVariable UUID id){
        int nModified = topProductService.destroy(id);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping
    public ResponseEntity<Object> getAllProducts(){
        JsonObject result = new JsonObject();
        result.put("data", topProductService.getAll());
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> addTopProduct(@PathVariable UUID id){
        topProductService.addTopProduct(id);
        return ResponseEntity.ok().build();
    }
}
