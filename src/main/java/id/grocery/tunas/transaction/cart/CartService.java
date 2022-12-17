package id.grocery.tunas.transaction.cart;

import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.product.ProductService;
import id.grocery.tunas.grpc.Cart;
import id.grocery.tunas.grpc.CartServiceGrpc;
import id.grocery.tunas.grpc.CartUserId;
import id.grocery.tunas.grpc.MultipleCartResponse;
import id.grocery.tunas.grpc.Response;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserService;
import io.grpc.ManagedChannel;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartService {
    private final CartServiceGrpc.CartServiceBlockingStub cartServiceBlockingStub;
    private final UserService userService;
    private final ProductService productService;

    private final String STATUS_FAILED = "FAILED";
    private final String STATUS_SUCCESS = "SUCCESS";

    @Autowired
    public CartService(ManagedChannel managedChannel, UserService userService, ProductService productService) {
        this.cartServiceBlockingStub = CartServiceGrpc.newBlockingStub(managedChannel);
        this.userService = userService;
        this.productService = productService;
    }

    public void storeToChart(UUID userId,UUID productId,Integer total){
        Optional<User> user = userService.findById(userId.toString());

        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        JsonObject product = productService.findProductById(productId);
        Response response = cartServiceBlockingStub.save(Cart.newBuilder()
                        .setUserId(userId.toString())
                        .setProductId(product.getString("id"))
                        .setTotal(total).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }

    public List<Map<String , Object>> chartList(UUID userId){
        Optional<User> user = userService.findById(userId.toString());
        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        MultipleCartResponse response = cartServiceBlockingStub.findByUserId(CartUserId.newBuilder().setId(userId.toString()).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            return List.of();
        }

        return response.getDataList().stream().map(cartDetail -> {
            Map<String, Object> data = new HashMap<>();
            data.put("id", cartDetail.getId());
            data.put("productId", cartDetail.getProductId());
            data.put("name", cartDetail.getName());
            data.put("imageUrl", cartDetail.getImageUrl());
            data.put("price", cartDetail.getPrice());
            data.put("perUnit", cartDetail.getPerUnit());
            data.put("weight", cartDetail.getWeight());
            data.put("total", cartDetail.getTotal());
            data.put("category", cartDetail.getCategory());
            return data;
        }).collect(Collectors.toList());
    }

    public void removeFromChart(UUID userId, UUID cartId) {
        Optional<User> user = userService.findById(userId.toString());
        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        Response response = cartServiceBlockingStub.delete(id.grocery.tunas.grpc.CartAndUserId.newBuilder()
                        .setUserId(userId.toString())
                        .setId(cartId.toString()).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }
}
