package id.grocery.tunas.product;

import id.grocery.tunas.category.CategoryService;
import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getProducts(){
        List<Map<String, Object>> products = productService.getAll();
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> getProduct(@PathVariable UUID id){
        JsonObject product = productService.findProductById(id);
        JsonObject result = new JsonObject();
        result.put("data", product.getMap());
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public ResponseEntity<Object> getProductByCategory(@PathVariable UUID id){
        List<Map<String, Object>> products = productService.getAllByCategory(id);
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody String jsonBody){
        productService.saveProduct(new JsonObject(jsonBody));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody String jsonBody){
        productService.updateProduct(new JsonObject(jsonBody));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroyProduct(@PathVariable UUID id){
        productService.destroyProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recommended")
    public ResponseEntity<Object> recommended(){
        List<Map<String, Object>> products = productService.recommended();
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/top")
    public ResponseEntity<Object> top(){
        List<Map<String, Object>> products = productService.top();
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }
}
