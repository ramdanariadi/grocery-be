package id.grocery.tunas.category;

import com.fasterxml.uuid.Generators;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import id.grocery.tunas.exception.ApiRequestException;

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
        if(Strings.isNullOrEmpty(category.getCategory())){
            throw new ApiRequestException("CATEGORY_CANNOT_EMPTY");
        }
        category.setId(Generators.timeBasedGenerator().generate());
        categoryRepository.save(category);
    }

    public int updateCategory(Category category){
        if(null == category.getId()){
            throw new ApiRequestException("category id is empty");
        }
        return categoryRepository.updateCategory(category.getId(), category.getCategory(), category.getImageUrl());
    }

    public int destroyCategory(UUID id){
        return categoryRepository.destroyCategoryById(id);
    }
}
