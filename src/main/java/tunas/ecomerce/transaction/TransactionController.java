package tunas.ecomerce.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;
import tunas.ecomerce.messaging.QueueSender;

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

    @Autowired
    private QueueSender queueSender;

    @GetMapping
    public String tesRMQ(){
        queueSender.send("tes send rmq");
        return "OK DONE";
    }

    @PostMapping
    public ObjectResponse addTransaction(@RequestBody String jsonBody){
        CustomResponse<String> customResponse = new CustomResponse<>();
        transactionService.makeTransaction(jsonBody);
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ObjectResponse getTransactions(@PathVariable UUID id){
        CustomResponse<TransactionResponse> customResponse = new CustomResponse<>();
        TransactionResponse transaction = transactionService.getTransactionById(id);
        return customResponse.sendResponse(transaction,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ObjectResponse deleteTransaction(@PathVariable UUID id){
        return CustomResponse.getModifyingObjectResponse(transactionService.destroyTransaction(id));
    }

    @GetMapping("/user/{id}")
    public ListResponse<TransactionResponse> getUserTransactions(@PathVariable UUID id){
        CustomResponse<TransactionResponse> customResponse = new CustomResponse<>();
        List<TransactionResponse> transactions = transactionService.getTransactionByUserId(id);
        return customResponse.sendResponse(transactions,HttpStatus.OK);
    }
}
