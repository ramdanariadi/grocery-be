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

    List<RecommendationProduct> getAll(){
        return recommendationProductRepository.getAllRecommendationProduct();
    }

    Optional<RecommendationProduct> getById(UUID uuid){
        return recommendationProductRepository.findById(uuid);
    }

    void addRecommendationProduct(UUID id){
        Product product = productRepository.findProductById(id);
        if(product == null){
            throw new ApiRequestException("Product not found", HttpStatus.PRECONDITION_FAILED);
        }
        Optional<RecommendationProduct> optionalRecommendationProduct = recommendationProductRepository.findById(id);
        if(optionalRecommendationProduct.isPresent()){
            throw new ApiRequestException("Product was added into recommendation product list",HttpStatus.PRECONDITION_FAILED);
        }
        RecommendationProduct recommendationProduct = new RecommendationProduct(product);
        recommendationProductRepository.save(recommendationProduct);
    }
}
