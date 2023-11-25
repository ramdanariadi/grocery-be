package id.grocery.tunas.role;

import id.grocery.tunas.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
public class Role extends BaseModel {
    private String name;
}
