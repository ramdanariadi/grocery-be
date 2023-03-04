package id.tunas.grocery.security.user;

import id.tunas.grocery.security.role.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

}
