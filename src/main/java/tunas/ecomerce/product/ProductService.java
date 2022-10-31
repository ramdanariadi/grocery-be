package tunas.ecomerce.product;

import com.google.common.base.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.exception.ApiRequestException;
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
        if(null == product.getCategory()){
            throw new ApiRequestException("CATEGORY_NOT_FOUND");
        }
        if(null == product.getPrice() || product.getPrice() < 1L)
            throw new ApiRequestException("PRICE_CANNOT_LOWER_THAN_0");
        productRepository.save(product);
    }

    public int updateProduct(Product product){
        if(Strings.isNullOrEmpty(product.getName())){
            throw new ApiRequestException("PRODUCT_NAME_CANNOT_EMPTY");
        }
        return productRepository.updateProduct(product.getId(),product.getName(),product.getPrice(),product.getImageUrl());
    }

    public int destroyProduct(UUID id){
        return productRepository.destroyProduct(id);
    }
}
