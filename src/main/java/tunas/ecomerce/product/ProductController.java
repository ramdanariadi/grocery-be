package tunas.ecomerce.product;

import com.fasterxml.uuid.Generators;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.category.CategoryService;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

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
    public ListResponse getProducts(){
        List<ProductRepository.ICustomSelect> products = productService.getAll();
        CustomResponse<ProductRepository.ICustomSelect> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ObjectResponse<Product> getProduct(@PathVariable UUID id){
        Product product = productService.findProductById(id);
        CustomResponse<Product> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(product,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public ObjectResponse<List<ProductRepository.ICustomSelect>> getProductByCategory(@PathVariable UUID id){
        List<ProductRepository.ICustomSelect> products = productService.getAllBYCategory(id);
        CustomResponse<List<ProductRepository.ICustomSelect>> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(products,HttpStatus.OK);
    }

    @PostMapping
    public ObjectResponse<String> addProduct(@RequestBody String jsonBody){
        JSONObject jsonObject = new JSONObject(jsonBody);
        Product product = new Product();
        product.setId(Generators.timeBasedGenerator().generate());
        product.setName(jsonObject.get("name").toString());
        product.setDescription(jsonObject.get("description").toString());
        product.setPrice(jsonObject.getLong("price"));
        product.setPerUnit(jsonObject.getInt("perUnit"));
        product.setWeight(jsonObject.getInt("weight"));
        product.setImageUrl(jsonObject.get("imageUrl").toString());

        Category category = categoryService.findById(UUID.fromString(jsonObject.get("category").toString()));
        product.setCategory(category);

        productService.saveProduct(product);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("",HttpStatus.CREATED);
    }

    @PutMapping
    public ObjectResponse<String> updateProduct(@RequestBody Product product){
        int nModified = productService.updateProduct(product);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(nModified > 0){
            return customResponse.sendResponse("",HttpStatus.OK);
        }
        return customResponse.sendResponse("",HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ObjectResponse<String> destroyProduct(@PathVariable UUID id){
        return CustomResponse.getModifyingObjectResponse(productService.destroyProduct(id));
    }
}
