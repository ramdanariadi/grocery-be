package tunas.ecomerce.category;

import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(UUID id){
        return categoryRepository.findCategoryById(id);
    }

    public List<Category> findAllCategory(){
        return (List<Category>) categoryRepository.findAll();
    }

    public void addCategory(Category category){
        category.setId(Generators.timeBasedGenerator().generate());
        categoryRepository.save(category);
    }
}
