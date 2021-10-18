package tunas.ecomerce.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

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
        int nModified = transactionService.destroyTransaction(id);
        CustomResponse<String> response = new CustomResponse<>();
        if(nModified < 1){
            return response.sendResponse("",HttpStatus.NOT_MODIFIED);
        }
        return response.sendResponse("",HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ListResponse<TransactionResponse> getCustomerTransactions(@PathVariable UUID id){
        CustomResponse<TransactionResponse> customResponse = new CustomResponse<>();
        List<TransactionResponse> transactions = transactionService.getTransactionByCustomerId(id);
        return customResponse.sendResponse(transactions,HttpStatus.OK);
    }
}
