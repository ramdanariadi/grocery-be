package tunas.ecomerce.exception.handler;

import io.vertx.core.json.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import tunas.ecomerce.exception.ApiRequestException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        JsonObject body = new JsonObject();
        body.put("message", ex.getMessage());
        return ResponseEntity.internalServerError().body(body);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({ApiRequestException.class})
    public ResponseEntity<Object> handleCustomException(ApiRequestException ex){
        JsonObject body = new JsonObject();
        body.put("message", ex.getMessage());
        if(null != ex.getHttpStatus()) ResponseEntity.status(ex.getHttpStatus()).body(body);
        return ResponseEntity.badRequest().body(body.getMap());
    }

}
