package tunas.ecomerce.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ProductRepository extends CrudRepository<Product, UUID> {
    @Query(value = "select p.id, p.category_id as categoryId, p.name AS name, p.price as price from product p",nativeQuery = true)
    List<CustomSelect> findTableColumn();


    Product findProductById(UUID id);

    interface CustomSelect{
        String getName();
        Long getPrice();
        Integer getId();
        Integer getCategoryId();
    }
}
