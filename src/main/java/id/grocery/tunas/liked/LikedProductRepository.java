package id.grocery.tunas.liked;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public interface LikedProductRepository extends CrudRepository<Liked, UUID> {

    @Query("select l.id as id, l.name as name, l.price as price, l.weight as weight, l.category as category, " +
            "l.perUnit as perUnit, l.imageUrl as imageUrl, l.product as product " +
            "from Liked l where l.user.id = :id")
    List<IWishProduct> findWishListByuserId(@Param("id") UUID id);

    interface IWishProduct {
        String getImageUrl();
        Integer getWeight();
        String getName();
        Long getPrice();
        Integer getPerUnit();
        String getCategory();
        @Value("#{target.product.id}")
        String getProduct();
        @Value("#{target.id}")
        UUID getId();
    }

    interface IWishProductNative {
        String getImageUrl();
        Integer getWeight();
        String getName();
        Long getPrice();
        Integer getPerUnit();
        String getCategory();
        String getProductId();
        UUID getId();
    }

    @Query(value = "select cast(l.id AS varchar) as id, l.name as name, l.price as price, l.weight as weight, " +
            "l.category as category, " +
            "l.per_unit as perUnit, l.image_url as imageUrl, cast(product_id AS varchar) as productId " +
            "from liked l where user_id = :userId and product_id = :productId limit 1",nativeQuery = true)
    IWishProductNative findProductFromWishLIst(@Param("userId") UUID userId, @Param("productId") UUID productId);

    @Modifying
    @Transactional
    @Query("delete from Liked L where L.user.id = :userId and L.product.id = :productId")
    int removeWishlist(@Param("userId") UUID userId, @Param("productId") UUID productId);
}
