package tunas.ecomerce.category;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/category")
@Validated
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ListResponse<Category> allCategories(){
        List<Category> categories = categoryService.findAllCategory();
        CustomResponse<Category> categoryCustomResponse = new CustomResponse<>();
        return categoryCustomResponse.sendResponse(categories,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ObjectResponse<Category> categoryById(@PathVariable UUID id){
        Category category = categoryService.findById(id);
        CustomResponse<Category> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(category, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ObjectResponse<String> destroyCategory(@PathVariable UUID id){
        return CustomResponse.getModifyingObjectResponse(categoryService.destroyCategory(id));
    }

    @PutMapping
    public ObjectResponse<String> updateCategory(@RequestBody Category category){
        return CustomResponse.getModifyingObjectResponse(categoryService.updateCategory(category));
    }

    @PostMapping
    public ObjectResponse<String> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("",HttpStatus.CREATED);
    }
}
