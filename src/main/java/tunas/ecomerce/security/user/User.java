package tunas.ecomerce.security.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.security.role.Role;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

}
