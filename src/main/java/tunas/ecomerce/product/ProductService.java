package tunas.ecomerce.product;

import com.proto.product.ProductId;
import com.proto.product.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub productServiceStub;

    public List<ProductRepository.ICustomSelect> getAll(){
        return productRepository.findCustomColumn();
    }

    public Product findProductById(UUID id){
        return productRepository.findProductById(id);
    }

    public Product findProductByIdGRPC(UUID id){
        ProductId productId = ProductId.newBuilder().setId(id.toString()).build();
        var responseWithData = productServiceStub.findById(productId);
        Product product = new Product();

        if(responseWithData.getStatus()){
            com.proto.product.Product data = responseWithData.getData();
//
//            Category category = new Category();
//            category.setId(UUID.fromString(data.getCategoryId()));
//            category.setCategory(data.getCategory());

            product.setName(data.getName());
//            product.setCategory(category);
            product.setPrice((long) data.getPrice());
            product.setDeleted(false);
            product.setWeight(data.getWeight());
            product.setImageUrl(data.getImageUrl());
        }

        return product;
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
