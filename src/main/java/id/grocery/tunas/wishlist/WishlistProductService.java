package id.grocery.tunas.wishlist;

import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.grpc.*;
import id.grocery.tunas.product.ProductService;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserService;
import id.grocery.tunas.utils.GrpcResponseUtil;
import io.grpc.ManagedChannel;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WishlistProductService {
    private final WishlistServiceGrpc.WishlistServiceBlockingStub wishlistServiceBlockingStub;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public WishlistProductService(ManagedChannel managedChannel, ProductService productService, UserService userService) {
        this.wishlistServiceBlockingStub = WishlistServiceGrpc.newBlockingStub(managedChannel);
        this.productService = productService;
        this.userService = userService;
    }

    public void addWishlist(UUID userId, UUID productId){
        Optional<User> user = userService.findById(userId.toString());

        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        JsonObject product = productService.findProductById(productId);
        Response response = wishlistServiceBlockingStub.save(Wishlist.newBuilder()
                        .setUserId(userId.toString())
                        .setProductId(product.getString("id")).build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }

    public List<Map<String, Object>> getWishlist(UUID userId){
        Optional<User> user = userService.findById(userId.toString());

        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        MultipleWishlistResponse response = wishlistServiceBlockingStub.findByUserId(WishlistUserId.newBuilder()
                .setId(userId.toString()).build());

        return response.getDataList().stream().map(wishlistDetail -> {
            Map<String, Object> wishlist = new HashMap<>();
            wishlist.put("id", wishlistDetail.getId());
            wishlist.put("productId", wishlistDetail.getProductId());
            wishlist.put("name", wishlistDetail.getName());
            wishlist.put("category", wishlistDetail.getCategory());
            wishlist.put("price", wishlistDetail.getPrice());
            wishlist.put("perUnit", wishlistDetail.getPerUnit());
            wishlist.put("imageUrl", wishlistDetail.getImageUrl());
            return wishlist;
        }).collect(Collectors.toList());
    }

    public Map<String, Object> getWishlistByUserAndProductId(UUID userId, UUID productId){
        Optional<User> user = userService.findById(userId.toString());

        if(user.isEmpty()){
            throw new ApiRequestException("INVALID_USER");
        }

        WishlistResponse response = wishlistServiceBlockingStub.findWishlistByProductId(UserAndProductId.newBuilder()
                .setUserId(userId.toString())
                .setProductId(productId.toString())
                .build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());

        WishlistDetail wishlistDetail = response.getData();
        Map<String, Object> wishlist = new HashMap<>();
        wishlist.put("id", wishlistDetail.getId());
        wishlist.put("productId", wishlistDetail.getProductId());
        wishlist.put("name", wishlistDetail.getName());
        wishlist.put("category", wishlistDetail.getCategory());
        wishlist.put("price", wishlistDetail.getPrice());
        wishlist.put("perUnit", wishlistDetail.getPerUnit());
        wishlist.put("imageUrl", wishlistDetail.getImageUrl());
        return wishlist;
    }

    public void destroyWishlist(UUID userId, UUID productId){
        Response response = wishlistServiceBlockingStub.delete(UserAndProductId.newBuilder()
                .setUserId(userId.toString())
                .setProductId(productId.toString()).build());

        GrpcResponseUtil.throwIfFailed(response.getStatus(), response.getMessage());
    }
}
