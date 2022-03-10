package tunas.ecomerce.transaction.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{userId}/{productId}/{total}")
    public ObjectResponse addToChart(@PathVariable UUID userId,@PathVariable UUID productId, @PathVariable Integer total){
        boolean saved = cartService.storeToChart(userId,productId,total);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(saved){
            return customResponse.sendResponse("", HttpStatus.CREATED);
        }
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{cartId}")
    public ObjectResponse removeFromChart(@PathVariable UUID userId,@PathVariable UUID cartId){
        return CustomResponse.getModifyingObjectResponse(cartService.removeFromChart(userId,cartId));
    }

    @GetMapping("/{userId}")
    public ListResponse userChart(@PathVariable UUID userId){
        List<CartRepository.ICharts> charts = cartService.chartList(userId);
        CustomResponse<CartRepository.ICharts> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(charts,HttpStatus.OK);
    }
}
