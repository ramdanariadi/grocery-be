package tunas.grocery.cutomresponse;

import java.util.List;

public class ListResponse<T> {
    private List<T> response;
    private MessageBody metaData;

    public ListResponse(List<T> response, MessageBody metaData) {
        this.response = response;
        this.metaData = metaData;
    }

    public List<T> getResponse() {
        return response;
    }

    public void setResponse(List<T> response) {
        this.response = response;
    }

    public MessageBody getMetaData() {
        return metaData;
    }

    public void setMetaData(MessageBody metaData) {
        this.metaData = metaData;
    }
}
