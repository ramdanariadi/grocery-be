package id.grocery.tunas.category;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/category")
@Validated
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> allCategories(){
        List<Map<String, Object>> categories = categoryService.findAllCategory();
        JsonObject result = new JsonObject();
        result.put("data", categories);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> categoryById(@PathVariable UUID id){
        JsonObject data = categoryService.findById(id);
        JsonObject result = new JsonObject();
        result.put("data", data.getMap());
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> destroyCategory(@PathVariable UUID id){
        categoryService.destroyCategory(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Object> updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Object> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok().build();
    }
}
