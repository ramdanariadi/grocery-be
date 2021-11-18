package tunas.ecomerce.category;

import com.fasterxml.uuid.Generators;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findById(UUID id){
        return categoryRepository.findCategoryById(id);
    }

    public List<Category> findAllCategory(){
        return (List<Category>) categoryRepository.findAllCategories();
    }

    public void addCategory(Category category){
        String categoryStr = category.getCategory();
        if(categoryStr == null || categoryStr.trim().equals("")){
            throw new ApiRequestException("category empty not allowed", HttpStatus.PRECONDITION_FAILED);
        }
        category.setId(Generators.timeBasedGenerator().generate());
        categoryRepository.save(category);
    }

    public int updateCategory(Category category){
        if(category.getId() == null){
            throw new ApiRequestException("category id is empty", HttpStatus.PRECONDITION_FAILED);
        }
        return categoryRepository.updateCategory(category.getId(), category.getCategory(), category.getImageUrl());
    }

    public int destroyCategory(UUID id){
        return categoryRepository.destroyCategoryById(id);
    }
}
