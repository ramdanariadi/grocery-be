package id.grocery.tunas.category;

import com.fasterxml.uuid.Generators;
import com.google.common.base.Strings;
import id.grocery.tunas.category.dto.CategoryDTO;
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
        return categoryRepository.findAllCategories();
    }

    public void addCategory(CategoryDTO categoryDto){
        if(Strings.isNullOrEmpty(categoryDto.getCategory())){
            throw new ApiRequestException("BAD_REQUEST");
        }
        Category category = new Category();
        category.setImageUrl(categoryDto.getImageUrl());
        category.setId(Generators.timeBasedGenerator().generate());
        categoryRepository.save(category);
    }

    public int updateCategory(UUID id, CategoryDTO category){
        return categoryRepository.updateCategory(id, category.getCategory(), category.getImageUrl());
    }

    public int destroyCategory(UUID id){
        return categoryRepository.destroyCategoryById(id);
    }
}
