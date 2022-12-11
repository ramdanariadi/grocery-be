package id.grocery.tunas.transaction;

import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Object> addTransaction(@RequestBody String jsonBody){
        transactionService.makeTransaction(jsonBody);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTransactions(@PathVariable UUID id){
        TransactionData transaction = transactionService.getTransactionById(id);
        JsonObject result = new JsonObject();
        result.put("data", transaction);
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTransaction(@PathVariable UUID id){
        int nModified = transactionService.destroyTransaction(id);
        if(nModified > 0) return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getCustomerTransactions(@PathVariable UUID id){
        List<TransactionData> transactions = transactionService.getTransactionByCustomerId(id);
        JsonObject result = new JsonObject();
        result.put("data", transactions);
        return ResponseEntity.ok(result.getMap());
    }
}
