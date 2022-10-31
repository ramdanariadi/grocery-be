package tunas.ecomerce.product;

import com.fasterxml.uuid.Generators;
import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.category.CategoryService;

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
    public ResponseEntity getProducts(){
        List<ProductRepository.ICustomSelect> products = productService.getAll();
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getProduct(@PathVariable UUID id){
        Product product = productService.findProductById(id);
        JsonObject result = new JsonObject();
        result.put("data", product);
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public ResponseEntity getProductByCategory(@PathVariable UUID id){
        List<ProductRepository.ICustomSelect> products = productService.getAllBYCategory(id);
        JsonObject result = new JsonObject();
        result.put("data", products);
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody String jsonBody){
        JSONObject jsonObject = new JSONObject(jsonBody);
        Product product = new Product();
        product.setId(Generators.timeBasedGenerator().generate());
        product.setName(jsonObject.get("name").toString());
        product.setDescription(jsonObject.get("description").toString());
        product.setPrice(jsonObject.getLong("price"));
        product.setPerUnit(jsonObject.getInt("perUnit"));
        product.setWeight(jsonObject.getInt("weight"));
        product.setImageUrl(jsonObject.isNull("imageUrl") ? null : jsonObject.getString("imageUrl") );

        Category category = categoryService.findById(UUID.fromString(jsonObject.get("category").toString()));
        product.setCategory(category);

        productService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody Product product){
        int nModified = productService.updateProduct(product);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroyProduct(@PathVariable UUID id){
        int nModified = productService.destroyProduct(id);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }
}
