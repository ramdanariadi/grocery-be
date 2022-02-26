package tunas.ecomerce.security.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.security.role.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {
    @Id
    private UUID id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

}
