package tunas.ecomerce.cutomresponse;

public class MessageBody {
    private Integer code;
    private String message;

    public MessageBody(Integer httpResponseCode, String message) {
        this.code = httpResponseCode;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
