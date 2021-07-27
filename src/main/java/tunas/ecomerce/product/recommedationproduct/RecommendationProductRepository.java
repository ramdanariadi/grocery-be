package tunas.ecomerce.product.recommedationproduct;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface RecommendationProductRepository extends CrudRepository<RecommendationProduct, UUID> {
    @Query("select rp from RecommendationProduct rp")
    List<RecommendationProduct> getAllRecommendationProduct();
}
