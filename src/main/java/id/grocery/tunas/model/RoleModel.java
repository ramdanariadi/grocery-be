package id.grocery.tunas.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
public class RoleModel extends BaseModel {
    private String name;
}
