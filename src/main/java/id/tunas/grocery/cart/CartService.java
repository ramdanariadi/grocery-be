package id.tunas.grocery.cart;

import id.tunas.grocery.exception.ApiRequestException;
import id.tunas.grocery.grpc.*;
import id.grocery.tunas.grpc.*;
import id.tunas.grocery.product.ProductService;
import id.tunas.grocery.security.user.User;
import id.tunas.grocery.security.user.UserService;
import id.tunas.grocery.utils.GrpcResponseUtil;
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

    @Autowired
    public CartService(ManagedChannel managedChannel, UserService userService, ProductService productService) {
        this.cartServiceBlockingStub = CartServiceGrpc.newBlockingStub(managedChannel);
        this.userService = userService;
        this.productService = productService;
    }

    public void storeToCart(UUID userId, UUID productId, Integer total){
        Optional<User> user = userService.findById(userId.toString());

        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        JsonObject product = productService.findProductById(productId);
        Response response = cartServiceBlockingStub.save(Cart.newBuilder()
                        .setUserId(userId.toString())
                        .setProductId(product.getString("id"))
                        .setTotal(total).build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public List<Map<String , Object>> userCartList(UUID userId){
        Optional<User> user = userService.findById(userId.toString());
        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        MultipleCartResponse response = cartServiceBlockingStub.findByUserId(CartUserId.newBuilder().setId(userId.toString()).build());
        
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

    public void removeFromCart(UUID userId, UUID cartId) {
        Optional<User> user = userService.findById(userId.toString());
        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        Response response = cartServiceBlockingStub.delete(CartAndUserId.newBuilder()
                        .setUserId(userId.toString())
                        .setId(cartId.toString()).build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }
}
