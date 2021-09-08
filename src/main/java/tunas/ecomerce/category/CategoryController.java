package tunas.ecomerce.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/all")
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

    @PostMapping
    public ObjectResponse<String> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("",HttpStatus.CREATED);
    }
}
