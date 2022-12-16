package id.grocery.tunas.category;

import com.google.common.base.Strings;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.proto.CategoryId;
import id.grocery.tunas.proto.CategoryServiceGrpc.CategoryServiceBlockingStub;
import id.grocery.tunas.proto.Response;
import io.grpc.ManagedChannel;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryServiceBlockingStub stub;
    private final String STATUS_FAILED = "FAILED";
    private final String STATUS_SUCCESS = "SUCCESS";

    @Autowired
    public CategoryService(ManagedChannel managedChannel){
        this.stub = id.grocery.tunas.proto.CategoryServiceGrpc.newBlockingStub(managedChannel);
    }

    public JsonObject findById(UUID id){
        CategoryId categoryId = CategoryId.newBuilder().setId(id.toString()).build();
        id.grocery.tunas.proto.CategoryResponse response = stub.findById(categoryId);

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }

        id.grocery.tunas.proto.Category category = response.getData();
        JsonObject data = new JsonObject();
        data.put("id", category.getId());
        data.put("category", category.getCategory());
        data.put("imageUrl", category.getImageUrl());
        return data;
    }

    public List<Map<String, Object>> findAllCategory(){
        id.grocery.tunas.proto.MultipleCategoryResponse response = stub.findAll(id.grocery.tunas.proto.EmptyCategory.newBuilder().build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }

        List<id.grocery.tunas.proto.Category> categoryList = response.getDataList();
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
        id.grocery.tunas.proto.Category categorySave = id.grocery.tunas.proto.Category.newBuilder()
                .setCategory(category.getCategory())
                .setImageUrl(category.getImageUrl())
                .build();

        Response response = stub.save(categorySave);
        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }

    public void updateCategory(Category category){
        if(null == category.getId()){
            throw new ApiRequestException("category id is empty");
        }
        id.grocery.tunas.proto.Category categorySave = id.grocery.tunas.proto.Category.newBuilder()
                .setCategory(category.getCategory())
                .setId(category.getId().toString())
                .setImageUrl(Strings.nullToEmpty(category.getImageUrl()))
                .build();
        Response response = stub.update(categorySave);
        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }

    public void destroyCategory(UUID id){
        CategoryId categoryId = CategoryId.newBuilder().setId(id.toString()).build();
        Response response = stub.delete(categoryId);
        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }
}
