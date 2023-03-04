package id.tunas.grocery.transaction;

import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
        Map<String, Object> transaction = transactionService.getTransactionById(id);
        JsonObject result = new JsonObject();
        result.put("data", transaction);
        return ResponseEntity.ok(result.getMap());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTransaction(@PathVariable UUID id){
        transactionService.destroyTransaction(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserTransactions(@PathVariable UUID id){
        List<Map<String, Object>> transactions = transactionService.getTransactionByUserId(id);
        JsonObject result = new JsonObject();
        result.put("data", transactions);
        return ResponseEntity.ok(result.getMap());
    }
}
