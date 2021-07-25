package tunas.ecomerce.product.topproduct;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TopProductRepository extends CrudRepository<TopProduct, UUID> {
    @Query("select tp from TopProduct tp")
    List<TopProduct> getAll();
}
