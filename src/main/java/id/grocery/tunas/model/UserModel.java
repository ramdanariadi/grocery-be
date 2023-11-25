package id.grocery.tunas.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class UserModel extends BaseModel {
    @Column(unique = true)
    private String username;
    private String password;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleModel> roleModels;

}
