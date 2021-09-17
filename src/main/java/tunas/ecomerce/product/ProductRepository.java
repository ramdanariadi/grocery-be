package tunas.ecomerce.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.product.projections.ProductCustomSelect;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Component
public interface ProductRepository extends CrudRepository<Product, UUID> {

    @Query("select p.id as id, p.name as name, p.price as price,p.imageUrl as imageUrl, p.category as category from Product p where p.deleted = false")
    List<CustomSelect> findCustomColumn();

    interface CustomSelect{
        String getImageUrl();
        String getName();
        Long getPrice();
        @Value("#{target.id}")
        UUID getId();
        @Value("#{target.category.id}")
        UUID getCategoryId();
    }

    Product findProductById(UUID id);

    @Modifying
    @Transactional
    @Query("update Product p set p.name = :name, p.price = :price where p.id = :id")
    int updateProduct(@Param("id") UUID id,@Param("name") String name, @Param("price") Long price);

    @Modifying
    @Transactional
    @Query("update Product p set p.deleted = true where p.id = :id")
    int destroyProduct(@Param("id") UUID id);
}
