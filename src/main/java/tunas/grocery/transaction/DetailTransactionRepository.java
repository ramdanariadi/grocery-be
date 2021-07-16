package tunas.grocery.transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface DetailTransactionRepository extends CrudRepository<DetailTransaction, UUID> {
    DetailTransaction findDetailTransactionByTransaction(Transaction transaction);
}
