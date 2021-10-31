package tunas.ecomerce.product.topproduct;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import tunas.ecomerce.product.Product;
import tunas.ecomerce.product.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TopProductService {

    private final TopProductRepository topProductRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TopProductService(TopProductRepository topProductRepository, ProductRepository productRepository){
        this.topProductRepository = topProductRepository;
        this.productRepository = productRepository;
    }

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
