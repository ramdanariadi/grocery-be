package id.grocery.tunas.product.topproduct;

import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import id.grocery.tunas.product.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TopProductService {

    private final TopProductRepository topProductRepository;
    private final ProductRepository productRepository;

    @Transactional
    Boolean addTopProduct(UUID id){
        Product product = productRepository.findProductById(id);
        if(product == null){
            throw new ApiRequestException("Product not found", HttpStatus.PRECONDITION_FAILED);
        }
        Optional<TopProduct> optionalTopProduct = topProductRepository.findById(product.getId());
        if(optionalTopProduct.isPresent()){
            int nModified = topProductRepository.update(product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getImageUrl(),
                    product.getCategory().getCategory());
            return nModified > 0;
        }
        TopProduct topProduct = new TopProduct(product);
        return topProductRepository.save(topProduct) != null;
    }

    List<TopProductRepository.iCustomSelect> getAll(){
        return topProductRepository.getAll();
    }

    Optional<TopProduct> getById(UUID id){
        return topProductRepository.findById(id);
    }

    int destroy(UUID id){
        return topProductRepository.destroy(id);
    }

}
