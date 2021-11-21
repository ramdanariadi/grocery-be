package tunas.ecomerce.product;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<ProductRepository.ICustomSelect> getAll(){
        return productRepository.findCustomColumn();
    }

    public Product findProductById(UUID id){
        return productRepository.findProductById(id);
    }

    public List<ProductRepository.ICustomSelect> getAllBYCategory(UUID categoryId){
        return productRepository.findProductsByCategory(categoryId);
    }

    public void saveProduct(Product product){
        if(product.getCategory() == null){
            throw new ApiRequestException("Category not found", HttpStatus.PRECONDITION_FAILED);
        }
        if(product.getPrice() == null || product.getPrice() < 1L)
            throw new ApiRequestException("Price cannot lower than 1", HttpStatus.PRECONDITION_FAILED);
        productRepository.save(product);
    }

    public int updateProduct(Product product){
        if(product.getName() == null || product.getName().trim().equals("")){
            throw new ApiRequestException("Product name cannot empty",HttpStatus.PRECONDITION_FAILED);
        }
        return productRepository.updateProduct(product.getId(),product.getName(),product.getPrice(),product.getImageUrl());
    }

    public int destroyProduct(UUID id){
        return productRepository.destroyProduct(id);
    }
}
