package tunas.ecomerce.cutomresponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler{

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        CustomResponse<String> customResponse = new CustomResponse<>();
        return new ResponseEntity<>(customResponse.sendResponse(ex.getMessage(),HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        CustomResponse<String> customResponse = new CustomResponse<>();
        return new ResponseEntity<>(customResponse.sendResponse(e.getMessage(),e.getHttpStatus()),HttpStatus.PRECONDITION_FAILED);
    }

}
