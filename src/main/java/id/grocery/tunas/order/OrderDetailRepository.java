package id.grocery.tunas.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface OrderDetailRepository extends CrudRepository<OrderItem, UUID> {

    @Query("select oi.id as id, oi.name as name, oi.price as price, oi.weight as weight, " +
            "oi.imageUrl as imageUrl, oi.product as product, oi.order as transaction, " +
            "oi.perUnit as perUnit, oi.total as total "+
            "from OrderItem oi " +
            "where oi.order.id = :id")
    List<IOrderItems> getOrderItemsByOrderId(@Param("id") UUID id);

    @Query("select oi.id as id, oi.name as name, oi.price as price, oi.weight as weight, " +
            "oi.imageUrl as imageUrl, oi.product as product, oi.order as order, " +
            "oi.perUnit as perUnit, oi.total as total "+
            "from OrderItem oi " +
            "where oi.order.user.id = :id")
    List<IOrderItems> getOrderItemsByUserId(@Param("id") UUID id);

    interface IOrderItems {
        String getImageUrl();
        Integer getWeight();
        String getName();
        Long getPrice();
        Integer getPerUnit();
        Integer getTotal();
        @Value("#{target.product.id}")
        String getProduct();
        @Value("#{target.id}")
        UUID getId();
        @Value("#{target.order.id}")
        UUID getOrderId();
    }
}
