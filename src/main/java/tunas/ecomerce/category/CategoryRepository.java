package tunas.ecomerce.category;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {
    Category findCategoryById(UUID id);
    Category findCategoryByCategory(String category);
}
