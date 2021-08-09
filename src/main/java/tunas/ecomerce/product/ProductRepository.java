package tunas.ecomerce.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tunas.ecomerce.product.projections.ProductCustomSelect;

import java.util.List;
import java.util.UUID;

@Component
public interface ProductRepository extends CrudRepository<Product, UUID> {

    @Query("select p.id as id, p.name as name, p.price as price, p.category as category from Product p")
    List<CustomSelect> findCustomColumn();

    interface CustomSelect{
        String getName();
        Long getPrice();
        @Value("#{target.id}")
        UUID getId();
        @Value("#{target.category.id}")
        UUID getCategoryId();
    }

    Product findProductById(UUID id);
}
