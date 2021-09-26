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
@RequestMapping("/api/v1/chart")
public class ChartController {

    private final ChartService chartService;

    @Autowired
    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @PostMapping("/{customerId}/{productId}")
    public ObjectResponse addToChart(@PathVariable UUID customerId,@PathVariable UUID productId){
        Chart saved = chartService.storeToChart(customerId,productId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        if(saved != null){
            return customResponse.sendResponse("", HttpStatus.CREATED);
        }
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ListResponse customerChart(@PathVariable UUID customerId){
        List<ChartRepository.ICharts> charts = chartService.chartList(customerId);
        CustomResponse<ChartRepository.ICharts> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(charts,HttpStatus.OK);
    }
}
