package id.grocery.tunas.base;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseModel {
    protected UUID id;
    protected Date createdAt;
    protected Date updatedAt;
    protected Date deletedAt;

}
