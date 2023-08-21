package id.grocery.tunas.export;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.security.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "export_request")
@Data
public class ExportRequest extends BaseModel {

    public static final String EXPORT_STATUS_SUCCESS = "SUCCESS";
    public static final String EXPORT_STATUS_NEW = "NEW";
    public static final String EXPORT_STATUS_FAILED = "FAILED";

    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @Column(name = "file_name")
    private String fileName;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
