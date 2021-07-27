package tunas.ecomerce.product.recommedationproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecommendationProductService {
    @Autowired
    RecommendationProductRepository recommendationProductRepository;

    List<RecommendationProduct> getAll(){
        return recommendationProductRepository.getAllRecommendationProduct();
    }

    RecommendationProduct getById(UUID uuid){
        return recommendationProductRepository.findById(uuid).get();
    }
}
