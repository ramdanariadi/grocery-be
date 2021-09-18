package tunas.ecomerce.product.recommedationproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecommendationProductService {

    private final RecommendationProductRepository recommendationProductRepository;
    private final ProductRepository productRepository;

    @Autowired
    public RecommendationProductService(RecommendationProductRepository recommendationProductRepository, ProductRepository productRepository){
        this.recommendationProductRepository = recommendationProductRepository;
        this.productRepository = productRepository;
    }

    List<RecommendationProductRepository.iCustomSelect> getAll(){
        return recommendationProductRepository.getAll();
    }

    Optional<RecommendationProduct> getById(UUID uuid){
        return recommendationProductRepository.findById(uuid);
    }

    Boolean addRecommendationProduct(UUID id){
        Product product = productRepository.findProductById(id);
        if(product == null){
            throw new ApiRequestException("Product not found", HttpStatus.PRECONDITION_FAILED);
        }
        Optional<RecommendationProduct> optionalRecommendationProduct = recommendationProductRepository.findById(id);
        if(optionalRecommendationProduct.isPresent()){
            int nModified = recommendationProductRepository.update(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getImageUrl()
            );
            return nModified > 0;
        }
        RecommendationProduct recommendationProduct = new RecommendationProduct(product);
        return recommendationProductRepository.save(recommendationProduct) != null;
    }
}
