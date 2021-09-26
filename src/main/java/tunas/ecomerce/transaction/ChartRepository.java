package tunas.ecomerce.transaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ChartRepository extends CrudRepository<Chart, UUID> {

    @Query("select c.id as id, c.name as name, c.price as price, c.weight as weight, " +
            "c.perUnit as perUnit, c.imageUrl as imageUrl, c.total as total, c.product as product " +
            "from Chart c where c.customer.id = :id")
    List<ICharts> findChartsByCustomerId(@Param("id") UUID id);

    interface ICharts{
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
    }
}
