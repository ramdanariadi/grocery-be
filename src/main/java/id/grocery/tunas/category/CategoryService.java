package id.grocery.tunas.category;

import com.google.common.base.Strings;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.grpc.*;
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
public class CategoryService {

    private final CategoryServiceGrpc.CategoryServiceBlockingStub categoryServiceBlockingStub;

    @Autowired
    public CategoryService(ManagedChannel managedChannel){
        this.categoryServiceBlockingStub = CategoryServiceGrpc.newBlockingStub(managedChannel);
    }

    public JsonObject findById(UUID id){
        CategoryId categoryId = CategoryId.newBuilder().setId(id.toString()).build();
        CategoryResponse response = categoryServiceBlockingStub.findById(categoryId);

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        id.grocery.tunas.grpc.Category category = response.getData();
        JsonObject data = new JsonObject();
        data.put("id", category.getId());
        data.put("category", category.getCategory());
        data.put("imageUrl", category.getImageUrl());
        return data;
    }

    public List<Map<String, Object>> findAllCategory(){
        MultipleCategoryResponse response = categoryServiceBlockingStub.findAll(EmptyCategory.newBuilder().build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        List<id.grocery.tunas.grpc.Category> categoryList = response.getDataList();
        List<Map<String, Object>> collect = categoryList.stream().map(category -> {
            Map<String, Object> data = new HashMap<>();
            data.put("id", category.getId());
            data.put("category", category.getCategory());
            data.put("imageUrl", category.getImageUrl());
            return data;
        }).collect(Collectors.toList());

        return collect;
    }

    public void addCategory(Category category){
        if(Strings.isNullOrEmpty(category.getCategory())){
            throw new ApiRequestException("CATEGORY_CANNOT_EMPTY");
        }
        id.grocery.tunas.grpc.Category categorySave = id.grocery.tunas.grpc.Category.newBuilder()
                .setCategory(category.getCategory())
                .setImageUrl(category.getImageUrl())
                .build();

        Response response = categoryServiceBlockingStub.save(categorySave);
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public void updateCategory(Category category){
        if(null == category.getId()){
            throw new ApiRequestException("category id is empty");
        }
        id.grocery.tunas.grpc.Category categorySave = id.grocery.tunas.grpc.Category.newBuilder()
                .setCategory(category.getCategory())
                .setId(category.getId().toString())
                .setImageUrl(Strings.nullToEmpty(category.getImageUrl()))
                .build();
        Response response = categoryServiceBlockingStub.update(categorySave);
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public void destroyCategory(UUID id){
        CategoryId categoryId = CategoryId.newBuilder().setId(id.toString()).build();
        Response response = categoryServiceBlockingStub.delete(categoryId);
        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }
}
