package id.grocery.tunas.product.liked;

import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.grpc.*;
import id.grocery.tunas.product.ProductService;
import id.grocery.tunas.security.user.User;
import id.grocery.tunas.security.user.UserService;
import io.grpc.ManagedChannel;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LikedProductService {
    private final WishlistServiceGrpc.WishlistServiceBlockingStub wishlistServiceBlockingStub;
    private final ProductService productService;
    private final UserService userService;

    private final String STATUS_FAILED = "FAILED";
    private final String STATUS_SUCCESS = "SUCCESS";

    @Autowired
    public LikedProductService(ManagedChannel managedChannel, ProductService productService, UserService userService) {
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

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }

    public void destroyWishlist(UUID userId, UUID wishlistId){
        Response response = wishlistServiceBlockingStub.delete(UserAndWishlistId.newBuilder()
                        .setUserId(userId.toString())
                        .setWishlistId(wishlistId.toString()).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            throw new RuntimeException(response.getMessage());
        }
    }

    public List<Map<String, Object>> getWishlist(UUID userId){
        MultipleWishlistResponse response = wishlistServiceBlockingStub.findByUserId(WishlistUserId.newBuilder()
                .setId(userId.toString()).build());

        if(STATUS_FAILED.equalsIgnoreCase(response.getStatus())){
            return List.of();
        }

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
}
