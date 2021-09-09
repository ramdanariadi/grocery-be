package tunas.ecomerce.cutomresponse;

import org.springframework.http.HttpStatus;

public class ApiRequestExceptionBody {
    private String message;
    private HttpStatus httpStatus;

    public ApiRequestExceptionBody(String message, HttpStatus httpStatus){
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
