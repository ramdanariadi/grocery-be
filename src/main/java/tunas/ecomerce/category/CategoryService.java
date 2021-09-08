package tunas.ecomerce.category;

import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category findById(UUID id){
        return categoryRepository.findCategoryById(id);

    }

    public List<Category> findAllCategory(){
        return (List<Category>) categoryRepository.findAll();
    }

    public void addCategory(Category category){
        String categoryStr = category.getCategory();
        if(categoryStr == null || categoryStr.trim().equals("")){
            throw new ApiRequestException("category empty not allowed", HttpStatus.PRECONDITION_FAILED);
        }
        category.setId(Generators.timeBasedGenerator().generate());
        categoryRepository.save(category);
    }
}
