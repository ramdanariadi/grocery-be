package tunas.ecomerce.product;

import com.fasterxml.uuid.Generators;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    @ResponseBody
    public ListResponse getProducts(){
        List<ProductResponseModel> products = productService.getAll();
        CustomResponse<ProductResponseModel> customResponse = new CustomResponse<>();
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
    public ObjectResponse<List<ProductResponseModel>> getProductByCategory(@PathVariable UUID id){
        LOGGER.info("category id {}", id.toString());
        List<ProductResponseModel> products = productService.getAllByCategory(id);
        CustomResponse<List<ProductResponseModel>> customResponse = new CustomResponse<>();
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
        product.setImageUrl(jsonObject.isNull("imageUrl") ? null : jsonObject.getString("imageUrl") );

        Category category = categoryService.findById(UUID.fromString(jsonObject.get("category").toString()));
        product.setCategory(category);

        var saved = productService.saveProduct(product);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("",saved ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }

    @PutMapping
    public ObjectResponse<String> updateProduct(@RequestBody Product product){
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(productService.updateProduct(product)){
            return customResponse.sendResponse("",HttpStatus.OK);
        }
        return customResponse.sendResponse("",HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ObjectResponse<String> destroyProduct(@PathVariable UUID id){
        return CustomResponse.getModifyingObjectResponse(productService.destroyProduct(id) ? 1 : 0);
    }
}
