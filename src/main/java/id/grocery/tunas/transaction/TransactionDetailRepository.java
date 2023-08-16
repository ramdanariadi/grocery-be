package id.grocery.tunas.transaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface TransactionDetailRepository extends CrudRepository<TransactionDetail, UUID> {

    @Query("select d.id as id, d.name as name, d.price as price, d.weight as weight, " +
            "d.imageUrl as imageUrl, d.product as product, d.transaction as transaction, " +
            "d.perUnit as perUnit, d.total as total "+
            "from TransactionDetail d " +
            "where d.transaction.id = :id")
    List<IDetailTransactions> getDetailTransactionsByTransactionId(@Param("id") UUID id);

    @Query("select d.id as id, d.name as name, d.price as price, d.weight as weight, " +
            "d.imageUrl as imageUrl, d.product as product, d.transaction as transaction, " +
            "d.perUnit as perUnit, d.total as total "+
            "from TransactionDetail d " +
            "where d.transaction.userId = :id")
    List<IDetailTransactions> getDetailTransactionsByUserId(@Param("id") UUID id);

    interface IDetailTransactions{
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
        @Value("#{target.transaction.id}")
        UUID getTransactionId();
    }
}
