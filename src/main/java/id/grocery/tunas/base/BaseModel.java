package id.grocery.tunas.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseModel {
    @Id
    @Getter(AccessLevel.PUBLIC)
    protected UUID id;
    @CreationTimestamp
    @Getter(AccessLevel.PUBLIC)
    protected Date createdAt;

    @UpdateTimestamp
    @Getter(AccessLevel.PUBLIC)
    protected Date updatedAt;

    @Getter(AccessLevel.PUBLIC)
    protected Date deletedAt;

}
