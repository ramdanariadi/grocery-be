package id.grocery.tunas.transaction;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {

    @Query("select t.id as id, t.totalPrice as totalPrice, t.createdAt as transactionDate " +
            "from Transaction t where t.id = :id")
    ITransactionData getTransactionById(@Param("id") UUID id);

    @Query("select t.id as id, t.totalPrice as totalPrice, t.createdAt as transactionDate " +
            "from Transaction t where t.user.id = :id")
    List<ITransactionData> getTransactionsByUserId(@Param("id") UUID id);

    interface ITransactionData{
        UUID getId();
        Long getTotalPrice();
        Date getTransactionDate();
    }

    @Transactional
    @Modifying
    @Query("delete from Transaction t where t.id = :id")
    int destroyTransaction(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query("delete from DetailTransaction t where t.transaction.id = :id")
    int destroyTransactionDetail(@Param("id") UUID id);
}
