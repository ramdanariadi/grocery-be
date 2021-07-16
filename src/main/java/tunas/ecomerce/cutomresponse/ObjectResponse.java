package tunas.ecomerce.cutomresponse;

public class ObjectResponse<T> {
    private T response;
    private MessageBody metaData;

    public ObjectResponse(T response, MessageBody messageBody) {
        this.response = response;
        this.metaData = messageBody;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public MessageBody getMetaData() {
        return metaData;
    }

    public void setMetaData(MessageBody metaData) {
        this.metaData = metaData;
    }
}
