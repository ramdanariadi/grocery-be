package tunas.grocery.transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {
    Transaction findTransactionById(UUID id);
}
