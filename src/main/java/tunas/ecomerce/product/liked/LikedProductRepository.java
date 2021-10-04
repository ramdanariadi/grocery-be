package tunas.ecomerce.product.liked;

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

    @Query("select c.id as id, c.name as name, c.price as price, c.weight as weight, c.category as category, " +
            "c.perUnit as perUnit, c.imageUrl as imageUrl, c.product as product " +
            "from Liked c where c.customer.id = :id")
    List<IWishProduct> findWishListByCustomerId(@Param("id") UUID id);

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

    @Query(value = "select cast(c.id AS varchar) as id, c.name as name, c.price as price, c.weight as weight, " +
            "c.category as category, " +
            "c.per_unit as perUnit, c.image_url as imageUrl, cast(product_id AS varchar) as productId " +
            "from liked c where customer_id = :customerId and product_id = :productId limit 1",nativeQuery = true)
    IWishProductNative findProductFromWishLIst(@Param("customerId") UUID customerId, @Param("productId") UUID productId);

    @Modifying
    @Transactional
    @Query("delete from Liked L where L.customer.id = :customerId and L.product.id = :productId")
    int removeWishlist(@Param("customerId") UUID customerId, @Param("productId") UUID productId);
}
