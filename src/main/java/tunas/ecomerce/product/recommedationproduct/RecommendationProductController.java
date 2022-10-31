package tunas.ecomerce.product.recommedationproduct;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/recommendation")
@AllArgsConstructor
public class RecommendationProductController {

    private final RecommendationProductService recommendationProductService;

    @GetMapping("{id}")
    public ResponseEntity getRecommendationProductById(@PathVariable UUID id){
        Optional<RecommendationProduct> recommendationProduct = recommendationProductService.getById(id);
        JsonObject result = new JsonObject();
        recommendationProduct.ifPresent(product -> result.put("data", product));
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroyRecommendationProduct(@PathVariable UUID id){
        int nModified = recommendationProductService.destroy(id);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("")
    public ResponseEntity getAll(){
        JsonObject result = new JsonObject();
        result.put("data", recommendationProductService.getAll());
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping("/{id}")
    public ResponseEntity addRecommendationProduct(@PathVariable UUID id){
        recommendationProductService.addRecommendationProduct(id);
        return ResponseEntity.ok().build();
    }
}
