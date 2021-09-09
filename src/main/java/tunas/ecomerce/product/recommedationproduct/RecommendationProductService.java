package tunas.ecomerce.product.recommedationproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecommendationProductService {

    private final RecommendationProductRepository recommendationProductRepository;

    @Autowired
    public RecommendationProductService(RecommendationProductRepository recommendationProductRepository){
        this.recommendationProductRepository = recommendationProductRepository;
    }

    List<RecommendationProduct> getAll(){
        return recommendationProductRepository.getAllRecommendationProduct();
    }

    Optional<RecommendationProduct> getById(UUID uuid){
        return recommendationProductRepository.findById(uuid);
    }
}
