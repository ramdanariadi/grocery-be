package tunas.ecomerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductRepository.CustomSelect> getAll(){
        return productRepository.findCustomColumn();
    }

    public Product findProductById(UUID id){
        return productRepository.findProductById(id);
    }

    public void saveProduct(Product product){
        if(product.getPrice() == null || product.getPrice() < 1L)
            throw new ApiRequestException("Price cannot lower than 1", HttpStatus.PRECONDITION_FAILED);
        productRepository.save(product);
    }

    public int updateProduct(Product product){
        if(product.getName() == null || product.getName().trim().equals("")){
            throw new ApiRequestException("Product name cannot empty",HttpStatus.PRECONDITION_FAILED);
        }
        return productRepository.updateProduct(product.getId(),product.getName(),product.getPrice());
    }

    public int destroyProduct(UUID id){
        return productRepository.destroyProduct(id);
    }
}
