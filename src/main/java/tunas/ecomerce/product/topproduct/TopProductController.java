package tunas.ecomerce.product.topproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.UUID;

@RequestMapping("/top/product")
public class TopProductController {
    @Autowired
    TopProductService topProductService;

     @GetMapping("/{id}")
    ObjectResponse<TopProduct> getProductById(@RequestParam UUID id){
        CustomResponse customResponse = new CustomResponse();
        return customResponse.sendResponse(topProductService.getById(id).get(),200);
    }

    @GetMapping("/")
    ListResponse<TopProduct> getAllProduct(){
         CustomResponse customResponse = new CustomResponse();
         return customResponse.sendResponse(topProductService.getAll(),200);
    }

    @PostMapping("/")
    ObjectResponse<String> addTopProduct(@RequestBody TopProduct product){
         topProductService.addTopProduct(product);
         CustomResponse customResponse = new CustomResponse();
         return  customResponse.sendResponse("",200);
    }
}
