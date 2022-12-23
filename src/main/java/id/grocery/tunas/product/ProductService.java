package id.grocery.tunas.product;

import com.google.common.base.Strings;
import id.grocery.tunas.category.CategoryService;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.grpc.*;
import id.grocery.tunas.grpc.Product;
import id.grocery.tunas.utils.GrpcResponseUtil;
import io.grpc.ManagedChannel;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;
    private final CategoryService categoryService;

    @Autowired
    public ProductService(ManagedChannel managedChannel, CategoryService categoryService){
        this.categoryService = categoryService;
        this.productServiceBlockingStub = ProductServiceGrpc.newBlockingStub(managedChannel);
    }

    public List<Map<String, Object>> getAll(){
        MultipleProductResponse response = productServiceBlockingStub.findAll(ProductEmpty.newBuilder().build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        return response.getDataList().stream().map(product -> {
            Map<String, Object> data = new HashMap<>();
            data.put("id", product.getId());
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("perUnit", product.getPerUnit());
            data.put("description", product.getDescription());
            data.put("weight", product.getWeight());
            data.put("imageUrl", product.getImageUrl());
            data.put("category", product.getCategory());
            return data;
        }).collect(Collectors.toList());
    }

    public JsonObject findProductById(UUID id){
        ProductResponse response = productServiceBlockingStub.findById(ProductId.newBuilder()
                .setId(id.toString()).build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        Product product = response.getData();
        JsonObject data = new JsonObject();
        data.put("id", product.getId());
        data.put("name", product.getName());
        data.put("price", product.getPrice());
        data.put("perUnit", product.getPerUnit());
        data.put("description", product.getDescription());
        data.put("weight", product.getWeight());
        data.put("imageUrl", product.getImageUrl());
        data.put("category", product.getCategory());

        return data;
    }

    public List<Map<String, Object>> getAllByCategory(UUID categoryId){
        MultipleProductResponse response = productServiceBlockingStub.findProductsByCategory(CategoryId.newBuilder()
                .setId(categoryId.toString()).build());

        return response.getDataList().stream().map(product -> {
            Map<String, Object> data = new HashMap<>();
            data.put("id", product.getId());
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("perUnit", product.getPerUnit());
            data.put("description", product.getDescription());
            data.put("weight", product.getWeight());
            data.put("imageUrl", product.getImageUrl());
            data.put("category", product.getCategory());
            return data;
        }).collect(Collectors.toList());
    }

    public void saveProduct(JsonObject product){
        if(Strings.isNullOrEmpty(product.getString("categoryId"))){
            throw new ApiRequestException("CATEGORY_NOT_FOUND");
        }

        if(null == product.getLong("price") || product.getLong("price") < 1L
        || null == product.getLong("perUnit") || product.getLong("perUnit") < 1L
        || null == product.getInteger("weight") || product.getInteger("weight") < 1L)
            throw new ApiRequestException("PRICE_PER_UNIT_WEIGHT_CANNOT_LOWER_THAN_ZERO");

        if(Strings.isNullOrEmpty(product.getString("name")))
            throw new ApiRequestException("NAME_CANNOT_EMPTY");

        JsonObject category = categoryService.findById(UUID.fromString(product.getString("categoryId")));

        Product productSave = Product.newBuilder()
                .setName(product.getString("name"))
                .setPrice(product.getLong("price"))
                .setPerUnit(product.getLong("perUnit"))
                .setWeight(product.getInteger("weight"))
                .setDescription(product.getString("description"))
                .setImageUrl(Strings.nullToEmpty(product.getString("imageUrl")))
                .setCategoryId(category.getString("id"))
                .build();
        Response response = productServiceBlockingStub.save(productSave);

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public void updateProduct(JsonObject product){
        if(Strings.isNullOrEmpty(product.getString("categoryId"))
        || Strings.isNullOrEmpty(product.getString("id"))){
            throw new ApiRequestException("ID_OR_CATEGORY_ID_NOT_FOUND");
        }

        if(null == product.getLong("price") || product.getLong("price") < 1L
                || null == product.getLong("perUnit") || product.getLong("perUnit") < 1L
                || null == product.getInteger("weight") || product.getInteger("weight") < 1L)
            throw new ApiRequestException("PRICE_PER_UNIT_WEIGHT_CANNOT_LOWER_THAN_ZERO");

        if(Strings.isNullOrEmpty(product.getString("name")))
            throw new ApiRequestException("NAME_CANNOT_EMPTY");

        JsonObject category = categoryService.findById(UUID.fromString(product.getString("categoryId")));

        Product productSave = Product.newBuilder()
                .setId(product.getString("id"))
                .setName(product.getString("name"))
                .setPrice(product.getLong("price"))
                .setPerUnit(product.getLong("perUnit"))
                .setWeight(product.getInteger("weight"))
                .setDescription(product.getString("description"))
                .setImageUrl(Strings.nullToEmpty(product.getString("imageUrl")))
                .setCategoryId(category.getString("id"))
                .build();

        Response response = productServiceBlockingStub.update(productSave);
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public void destroyProduct(UUID id){
        this.findProductById(id);
        Response response = productServiceBlockingStub.delete(
                ProductId.newBuilder().setId(id.toString()).build());
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public List<Map<String, Object>> recommended(){
        MultipleProductResponse response = productServiceBlockingStub.findRecommendedProduct(ProductEmpty.newBuilder().build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        return response.getDataList().stream().map(product -> {
            Map<String, Object> data = new HashMap<>();
            data.put("id", product.getId());
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("perUnit", product.getPerUnit());
            data.put("description", product.getDescription());
            data.put("weight", product.getWeight());
            data.put("imageUrl", product.getImageUrl());
            data.put("category", product.getCategory());
            return data;
        }).collect(Collectors.toList());
    }

    public List<Map<String, Object>> top(){
        MultipleProductResponse response = productServiceBlockingStub.findTopProducts(ProductEmpty.newBuilder().build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        return response.getDataList().stream().map(product -> {
            Map<String, Object> data = new HashMap<>();
            data.put("id", product.getId());
            data.put("name", product.getName());
            data.put("price", product.getPrice());
            data.put("perUnit", product.getPerUnit());
            data.put("description", product.getDescription());
            data.put("weight", product.getWeight());
            data.put("imageUrl", product.getImageUrl());
            data.put("category", product.getCategory());
            return data;
        }).collect(Collectors.toList());
    }
}
