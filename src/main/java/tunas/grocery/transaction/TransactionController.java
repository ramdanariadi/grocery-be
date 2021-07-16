package tunas.grocery.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tunas.grocery.cutomresponse.CustomResponse;
import tunas.grocery.cutomresponse.ListResponse;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ListResponse addTransaction(@RequestBody String jsonBody){
        CustomResponse<DetailTransaction> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(transactionService.makeTransaction(jsonBody),200);
    }
}
