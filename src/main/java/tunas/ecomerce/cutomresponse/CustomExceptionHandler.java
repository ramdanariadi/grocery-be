package tunas.ecomerce.cutomresponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomResponse<String> customResponse = new CustomResponse();
        return new ResponseEntity<>(customResponse.sendResponse(ex.getMessage(),status),status);
    }

    @ExceptionHandler({ApiRequestException.class})
    public ResponseEntity<Object> handleCustomException(ApiRequestException e){
        CustomResponse<String> customResponse = new CustomResponse<>();
        return new ResponseEntity<>(customResponse.sendResponse(e.getMessage(),e.getHttpStatus()),HttpStatus.PRECONDITION_FAILED);
    }

}
