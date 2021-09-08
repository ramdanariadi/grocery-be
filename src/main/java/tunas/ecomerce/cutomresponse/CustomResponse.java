package tunas.ecomerce.cutomresponse;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomResponse<T> {

    public ObjectResponse sendResponse(T object, HttpStatus httpResponseCode){
        MessageBody messageBody = new MessageBody(httpResponseCode.value(), httpResponseCode.getReasonPhrase());
        return new ObjectResponse<>(object,messageBody);
    }

    public ObjectResponse sendResponse(T object, HttpStatus httpResponseCode, String customMessage){
        MessageBody messageBody = new MessageBody(httpResponseCode.value(),httpResponseCode.getReasonPhrase());
        return new ObjectResponse<>(object,messageBody);
    }

    public ListResponse sendResponse(List<T> listOfObject, HttpStatus httpResponseCode){
        MessageBody messageBody = new MessageBody(httpResponseCode.value(), httpResponseCode.getReasonPhrase());
        return new ListResponse(listOfObject,messageBody);
    }

    public ListResponse sendResponse(List<T> listOfObject, HttpStatus httpResponseCode, String customMessage){
        MessageBody messageBody = new MessageBody(httpResponseCode.value(), httpResponseCode.getReasonPhrase());
        return new ListResponse(listOfObject,messageBody);
    }
}
