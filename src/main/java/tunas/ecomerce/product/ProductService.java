package tunas.ecomerce.product;

import com.proto.product.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.category.Category;
import tunas.ecomerce.cutomresponse.ApiRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub productServiceStub;

    public List<ProductResponseModel> getAll(){
        MultipleDataResponse all = productServiceStub.findAll(ProductEmpty.newBuilder().build());
        List<ProductResponseModel> responseModelList = new ArrayList<>();

        if(all.getStatus()){
            responseModelList = all.getDataList().stream().map((product) -> new ProductResponseModel(
                    product.getImageUrl(),
                    product.getWeight(),
                    product.getName(),
                    product.getPrice(),
                    product.getCategory(),
                    UUID.fromString(product.getId()),
                    UUID.fromString(product.getCategoryId())
            )).collect(Collectors.toList());
        }

        return responseModelList;
    }

    public Product findProductById(UUID id){
        ProductId productId = ProductId.newBuilder().setId(id.toString()).build();
        var responseWithData = productServiceStub.findById(productId);
        Product product = new Product();

        if(responseWithData.getStatus()){
            com.proto.product.Product data = responseWithData.getData();

            Category category = new Category();
            category.setId(UUID.fromString(data.getCategoryId()));
            category.setCategory(data.getCategory());

            product.setName(data.getName());
            product.setCategory(category);
            product.setPrice(data.getPrice());
            product.setDeleted(false);
            product.setWeight(data.getWeight());
            product.setImageUrl(data.getImageUrl());
        }

        return product;
    }

    public List<ProductResponseModel> getAllByCategory(UUID categoryId){
        MultipleDataResponse productsByCategory = productServiceStub.findProductsByCategory(CategoryId.newBuilder().setId(categoryId.toString()).build());
        List<ProductResponseModel> products = new ArrayList<>();
        if(productsByCategory.getStatus()){
            products = productsByCategory.getDataList().stream().map(product -> new ProductResponseModel(
                    product.getImageUrl(),
                    product.getWeight(),
                    product.getName(),
                    product.getPrice(),
                    product.getCategory(),
                    UUID.fromString(product.getId()),
                    UUID.fromString(product.getCategoryId()))).collect(Collectors.toList());
        }
        return products;
    }

    public boolean saveProduct(Product product){
        if(product.getCategory() == null){
            throw new ApiRequestException("Category not found", HttpStatus.PRECONDITION_FAILED);
        }
        if(product.getPrice() == null || product.getPrice() < 1L)
            throw new ApiRequestException("Price cannot lower than 1", HttpStatus.PRECONDITION_FAILED);
//        productRepository.save(product);

        com.proto.product.Product saveProduct = com.proto.product.Product.newBuilder().
                setId(product.getId().toString()).
                setName(product.getName()).
                setImageUrl(product.getImageUrl() == null ? "" : product.getImageUrl()).
                setPrice(product.getPrice()).
                setCategoryId(product.getCategory().getId().toString()).
                setCategory(product.getCategory().getCategory()).
                setWeight(product.getWeight()).
                setPerUnit(product.getPerUnit()).
                setDescription(product.getDescription()).
                build();

        Response response = productServiceStub.save(saveProduct);
        return response.getStatus();
    }

    public boolean updateProduct(Product product){
        if(product.getName() == null || product.getName().trim().equals("")){
            throw new ApiRequestException("Product name cannot empty",HttpStatus.PRECONDITION_FAILED);
        }

        com.proto.product.Product updateProduct = com.proto.product.Product.newBuilder().
                setId(product.getId().toString()).
                setName(product.getName()).
                setImageUrl(product.getImageUrl()).
                setPrice(product.getPrice()).
                setCategoryId(product.getCategory().getId().toString()).
                setCategory(product.getCategory().getCategory()).
                setWeight(product.getWeight()).
                build();
        Response update = productServiceStub.update(updateProduct);
        return update.getStatus();
    }

    public boolean destroyProduct(UUID id){
        ProductId productId = ProductId.newBuilder().setId(id.toString()).build();
        Response response = productServiceStub.delete(productId);
        return response.getStatus();
    }
}
