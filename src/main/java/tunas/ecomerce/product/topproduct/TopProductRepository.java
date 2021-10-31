package tunas.ecomerce.product.topproduct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface TopProductRepository extends CrudRepository<TopProduct, UUID> {
    @Query("select tp.id as id, tp.name as name, " +
            "tp.weight as weight, tp.price as price," +
            " tp.perUnit as perUnit, tp.imageUrl as imageUrl," +
            " tp.description as description, tp.category as category" +
            " from TopProduct tp where tp.deleted = false")
    List<iCustomSelect> getAll();

    interface iCustomSelect{
        String getImageUrl();
        Integer getWeight();
        Integer getPerUnit();
        String getDescription();
        String getCategory();
        String getName();
        Long getPrice();
        @Value("#{target.id}")
        UUID getId();
    }

    @Modifying
    @Transactional
    @Query("update TopProduct p set p.name = :name, p.price = :price, " +
            "p.imageUrl = :imageUrl, p.category = :category " +
            "where p.id = :id")
    int update(@Param("id") UUID id,
               @Param("name") String name,
               @Param("price") Long price,
               @Param("imageUrl") String imageUrl,
               @Param("category") String category);

    @Modifying
    @Transactional
    @Query("delete from TopProduct tp where tp.id = :id")
    int destroy(@Param("id") UUID id);
}
