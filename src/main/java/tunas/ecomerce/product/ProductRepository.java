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

    @Query("select p.id as id, p.name as name, p.price as price, p.weight as weight, p.imageUrl as imageUrl, p.category as category from Product p where p.deleted = false")
    List<iCustomSelect> findCustomColumn();

    interface iCustomSelect{
        String getImageUrl();
        Integer getWeight();
        String getName();
        Long getPrice();
        @Value("#{target.category.category}")
        String getCategory();
        @Value("#{target.id}")
        UUID getId();
        @Value("#{target.category.id}")
        UUID getCategoryId();
    }

    Product findProductById(UUID id);

    @Modifying
    @Transactional
    @Query("update Product p set p.name = :name, p.price = :price, p.imageUrl = :imageUrl where p.id = :id")
    int updateProduct(@Param("id") UUID id,
                      @Param("name") String name,
                      @Param("price") Long price,
                      @Param("imageUrl") String imageUrl);

    @Modifying
    @Transactional
    @Query("update Product p set p.deleted = true where p.id = :id")
    int destroyProduct(@Param("id") UUID id);
}
