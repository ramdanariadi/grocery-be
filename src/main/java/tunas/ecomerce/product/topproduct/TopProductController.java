package tunas.ecomerce.product.topproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/top")
public class TopProductController {

    private final TopProductService topProductService;

    @Autowired
    TopProductController(TopProductService topProductService){
        this.topProductService = topProductService;
    }

    @GetMapping("/{id}")
    ObjectResponse<TopProduct> getProductById(@PathVariable UUID id){
        CustomResponse customResponse = new CustomResponse();
        return customResponse.sendResponse(topProductService.getById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ObjectResponse destroyTopProduct(@PathVariable UUID id){
        return CustomResponse.getModifyingObjectResponse(topProductService.destroy(id));
    }

    @GetMapping
    ListResponse<TopProductRepository.iCustomSelect> getAllProducts(){
         CustomResponse<TopProductRepository.iCustomSelect> customResponse = new CustomResponse();
         return customResponse.sendResponse(topProductService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/{id}")
    ObjectResponse<String> addTopProduct(@PathVariable UUID id){
        Boolean saved = topProductService.addTopProduct(id);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(saved){
            return customResponse.sendResponse("",HttpStatus.CREATED);
        }
        return customResponse.sendResponse("",HttpStatus.OK);
    }
}
