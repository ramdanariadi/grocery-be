package tunas.ecomerce.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ListResponse addTransaction(@RequestBody String jsonBody){
        CustomResponse<DetailTransaction> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(transactionService.makeTransaction(jsonBody), HttpStatus.OK);
    }
}
