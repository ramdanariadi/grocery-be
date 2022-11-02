<<<<<<<< HEAD:src/main/java/id/grocery/tunas/product/recommedationproduct/RecommendationProductService.java
package id.grocery.tunas.product.recommedationproduct;
========
package tunas.ecomerce.product.recommendationproduct;
>>>>>>>> f8208d6d0d4fbd1adfc3c8e3c91ab72a08783d41:src/main/java/id/grocery/tunas/product/recommendationproduct/RecommendationProductService.java

import id.grocery.tunas.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecommendationProductService {

    private final RecommendationProductRepository recommendationProductRepository;
    private final ProductRepository productRepository;

    List<RecommendationProductRepository.iCustomSelect> getAll(){
        return recommendationProductRepository.getAll();
    }

    Optional<RecommendationProduct> getById(UUID uuid){
        return recommendationProductRepository.findById(uuid);
    }

    Boolean addRecommendationProduct(UUID id){
        Product product = productRepository.findProductById(id);
        if(null == product){
            throw new ApiRequestException("Product not found", HttpStatus.PRECONDITION_FAILED);
        }
        Optional<RecommendationProduct> optionalRecommendationProduct = recommendationProductRepository.findById(id);
        if(optionalRecommendationProduct.isPresent()){
            int nModified = recommendationProductRepository.update(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getImageUrl(),
                    product.getCategory().getCategory()
            );
            return nModified > 0;
        }
        RecommendationProduct recommendationProduct = new RecommendationProduct(product);
        recommendationProductRepository.save(recommendationProduct);
        return true;
    }

    int destroy(UUID id){
        return recommendationProductRepository.destroy(id);
    }

}
