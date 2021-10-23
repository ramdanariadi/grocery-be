package tunas.ecomerce.transaction.cart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface CartRepository extends CrudRepository<Cart, UUID> {

    @Query("select c.id as id, c.name as name, c.price as price, c.weight as weight, c.category as category, " +
            "c.perUnit as perUnit, c.imageUrl as imageUrl, c.total as total, c.product as product " +
            "from Cart c where c.customer.id = :id")
    List<ICharts> findChartsByCustomerId(@Param("id") UUID id);

    interface ICharts{
        String getImageUrl();
        Integer getWeight();
        String getName();
        Long getPrice();
        Integer getPerUnit();
        Integer getTotal();
        @Value("#{target.product.id}")
        UUID getProduct();
        String getCategory();
        @Value("#{target.id}")
        UUID getId();
    }

    Optional<Cart> findChartByCustomerIdAndProductId(@Param("customerId") UUID customerId, @Param("productId") UUID productId);

    @Transactional
    @Modifying
    @Query("delete from Cart c where c.customer.id = :customerId and c.product.id = :productId")
    int removeFromChart(@Param("customerId") UUID customerId, @Param("productId") UUID productId);

    @Transactional
    @Modifying
    @Query("update Cart c set c.total = (c.total + 1) where c.customer.id = :customerId and c.product.id = :productId")
    int incrementProductTotalInChart(@Param("customerId") UUID customerId, @Param("productId") UUID productId);

    @Transactional
    @Modifying
    @Query("delete from Cart c where c.customer.id = :customerId")
    int destroyCustomerCart(@Param("customerId") UUID customerId);
}
