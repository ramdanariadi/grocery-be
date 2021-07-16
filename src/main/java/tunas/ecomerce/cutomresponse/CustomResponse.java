package tunas.ecomerce.cutomresponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomResponse<T> {
    private static Map<Integer, String> httpResponseMessage = new HashMap<>();
    static {
        httpResponseMessage.put(100,"Continue");
        httpResponseMessage.put(101,"Switching Protocols");
        httpResponseMessage.put(102,"Processing");
        httpResponseMessage.put(103,"Checkpoint");
        httpResponseMessage.put(200,"OK");
        httpResponseMessage.put(201,"Created");
        httpResponseMessage.put(202,"Accepted");
        httpResponseMessage.put(203,"Non-Authoritative Information");
        httpResponseMessage.put(204,"No Content");
        httpResponseMessage.put(205,"Reset Content");
        httpResponseMessage.put(206,"Partial Content");
        httpResponseMessage.put(207,"Multi-Status");
        httpResponseMessage.put(300,"Multiple Choices");
        httpResponseMessage.put(301,"Moved Permanently");
        httpResponseMessage.put(302,"Found");
        httpResponseMessage.put(303,"See Other");
        httpResponseMessage.put(304,"Not Modified");
        httpResponseMessage.put(305,"Use Proxy");
        httpResponseMessage.put(306,"Switch Proxy");
        httpResponseMessage.put(307,"Temporary Redirect");
        httpResponseMessage.put(400,"Bad Request");
        httpResponseMessage.put(401,"Unauthorized");
        httpResponseMessage.put(402,"Payment Required");
        httpResponseMessage.put(403,"Forbidden");
        httpResponseMessage.put(404,"Not Found");
        httpResponseMessage.put(405,"Method Not Allowed");
        httpResponseMessage.put(406,"Not Acceptable");
        httpResponseMessage.put(407,"Proxy Authentication Required");
        httpResponseMessage.put(408,"Request Timeout");
        httpResponseMessage.put(409,"Conflict");
        httpResponseMessage.put(410,"Gone");
        httpResponseMessage.put(411,"Length Required");
        httpResponseMessage.put(412,"Precondition Failed");
        httpResponseMessage.put(413,"Request Entity Too Large");
        httpResponseMessage.put(414,"Request-URI Too Long");
        httpResponseMessage.put(415,"Unsupported Media Type");
        httpResponseMessage.put(416,"Requested Range Not Satisfiable");
        httpResponseMessage.put(417,"Expectation Failed");
        httpResponseMessage.put(418,"I'm a teapot");
        httpResponseMessage.put(422,"Unprocessable Entity");
        httpResponseMessage.put(423,"Locked");
        httpResponseMessage.put(424,"Failed Dependency");
        httpResponseMessage.put(425,"Unordered Collection");
        httpResponseMessage.put(426,"Upgrade Required");
        httpResponseMessage.put(449,"Retry With");
        httpResponseMessage.put(450,"Blocked by Windows Parental Controls");
        httpResponseMessage.put(500,"Internal Server Error");
        httpResponseMessage.put(501,"Not Implemented");
        httpResponseMessage.put(502,"Bad Gateway");
        httpResponseMessage.put(503,"Service Unavailable");
        httpResponseMessage.put(504,"Gateway Timeout");
        httpResponseMessage.put(505,"HTTP Version Not Supported");
        httpResponseMessage.put(506,"Variant Also Negotiates");
        httpResponseMessage.put(507,"Insufficient Storage");
        httpResponseMessage.put(509,"Bandwidth Limit Exceeded");
        httpResponseMessage.put(510,"Not Extende");
    }

    public ObjectResponse sendResponse(T object, Integer httpResponseCode){
        MessageBody messageBody = new MessageBody(httpResponseCode,httpResponseMessage.get(httpResponseCode));
        return new ObjectResponse<>(object,messageBody);
    }

    public ObjectResponse sendResponse(T object, Integer httpResponseCode, String customMessage){
        MessageBody messageBody = new MessageBody(httpResponseCode,customMessage);
        return new ObjectResponse<>(object,messageBody);
    }

    public ListResponse sendResponse(List<T> listOfObject, Integer httpResponseCode){
        MessageBody messageBody = new MessageBody(httpResponseCode,httpResponseMessage.get(httpResponseCode));
        return new ListResponse(listOfObject,messageBody);
    }

    public ListResponse sendResponse(List<T> listOfObject, Integer httpResponseCode, String customMessage){
        MessageBody messageBody = new MessageBody(httpResponseCode,customMessage);
        return new ListResponse(listOfObject,messageBody);
    }
}
