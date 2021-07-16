package tunas.ecomerce.product;

import com.fasterxml.uuid.Generators;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    private static CustomResponse<Product> customResponse;
    static {
        customResponse = new CustomResponse<>();
    }

    @GetMapping("/all")
    @ResponseBody
    public ListResponse getProducts(){
        List<ProductRepository.CustomSelect> products = productService.getAll();
        System.out.println(products);
        CustomResponse<ProductRepository.CustomSelect> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(products,200);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ObjectResponse<Product> getProduct(@PathVariable UUID id){
        Product product = productService.findProductById(id);
        return customResponse.sendResponse(product,200);
    }

    @PostMapping
    public ObjectResponse<String> addProduct(@RequestBody String jsonBody){
        JSONObject jsonObject = new JSONObject(jsonBody);
        Product product = new Product();
        product.setId(Generators.timeBasedGenerator().generate());
        product.setName(jsonObject.get("name").toString());
        product.setDescription(jsonObject.get("description").toString());
        product.setPrice(Long.parseLong(jsonObject.get("price").toString()));
        Category category = categoryService.findById(UUID.fromString(jsonObject.get("category").toString()));

        if(category != null){
            product.setCategory(category);
        }
        productService.saveProduct(product);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("",201);
    }
}
