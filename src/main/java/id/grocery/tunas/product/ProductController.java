package id.grocery.tunas.product;

import com.fasterxml.uuid.Generators;
import com.google.common.base.Strings;
import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import id.grocery.tunas.category.Category;
import id.grocery.tunas.category.CategoryService;

import java.util.List;
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
        List<ProductRepository.ICustomSelect> products = productService.getAll();
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> getProduct(@PathVariable UUID id){
        Product product = productService.findProductById(id);
        JsonObject result = new JsonObject();
        result.put("data", product);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public ResponseEntity<Object> getProductByCategory(@PathVariable UUID id){
        List<ProductRepository.ICustomSelect> products = productService.getAllBYCategory(id);
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody String jsonBody){
        JsonObject jsonObject = new JsonObject(jsonBody);
        Product product = new Product();
        product.setId(Generators.timeBasedGenerator().generate());
        product.setName(jsonObject.getString("name"));
        product.setDescription(jsonObject.getString("description"));
        product.setPrice(jsonObject.getLong("price"));
        product.setPerUnit(jsonObject.getInteger("perUnit"));
        product.setWeight(jsonObject.getInteger("weight"));
        product.setImageUrl(Strings.emptyToNull(jsonObject.getString("imageUrl")));

        Category category = categoryService.findById(UUID.fromString(jsonObject.getString("category")));
        product.setCategory(category);

        productService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        int nModified = productService.updateProduct(product);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroyProduct(@PathVariable UUID id){
        int nModified = productService.destroyProduct(id);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }
}
