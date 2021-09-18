package tunas.ecomerce.product.recommedationproduct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tunas.ecomerce.product.topproduct.TopProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface RecommendationProductRepository extends CrudRepository<RecommendationProduct, UUID> {

    @Query("select rp.id as id, rp.name as name, " +
            "rp.weight as weight, rp.price as price," +
            " rp.perUnit as perUnit, rp.imageUrl as imageUrl," +
            " rp.description as description, rp.category as category" +
            " from RecommendationProduct rp where rp.deleted = false")
    List<RecommendationProductRepository.iCustomSelect> getAll();

    interface iCustomSelect{
        String getImageUrl();
        Integer getWeight();
        Integer getPerUnit();
        String getDescription();
        String getName();
        Long getPrice();
        String getCategory();
        @Value("#{target.id}")
        UUID getId();
    }

    @Modifying
    @Transactional
    @Query("update RecommendationProduct p set p.name = :name, p.price = :price, " +
            "p.imageUrl = :imageUrl, p.category = :category " +
            "where p.id = :id")
    int update(@Param("id") UUID id,
               @Param("name") String name,
               @Param("price") Long price,
               @Param("imageUrl") String imageUrl,
               @Param("category") String category);
}
