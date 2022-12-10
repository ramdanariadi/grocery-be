package id.grocery.tunas.category;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/category")
@Validated
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> allCategories(){
        List<Category> categories = categoryService.findAllCategory();
        JsonObject result = new JsonObject();
        result.put("data", categories);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> categoryById(@PathVariable UUID id){
        Category category = categoryService.findById(id);
        JsonObject result = new JsonObject();
        result.put("data", category);
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> destroyCategory(@PathVariable UUID id){
        int nModified = categoryService.destroyCategory(id);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @PutMapping
    public ResponseEntity<Object> updateCategory(@RequestBody Category category){
        int nModified = categoryService.updateCategory(category);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @PostMapping
    public ResponseEntity<Object> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok().build();
    }
}
