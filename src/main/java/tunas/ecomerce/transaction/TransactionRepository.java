package tunas.ecomerce.transaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import tunas.ecomerce.customer.Customer;

import java.util.Date;
import java.util.UUID;

@Component
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {

    @Query("select t.id as id, t.totalPrice as totalPrice, t.transactionDate as transactionDate, " +
            "t.customerName as customerName, t.customerMobile as customerMobile, " +
            "t.customerEmail as customerEmail "+
            "from Transaction t where t.id = :id")
    ITransactionResponse getTransactionById(@Param("id") UUID id);

    interface ITransactionResponse{
        UUID getId();
        Long getTotalPrice();
        Date getTransactionDate();
        String getCustomerName();
        String getCustomerMobile();
        String getCustomerEmail();
    }
}
