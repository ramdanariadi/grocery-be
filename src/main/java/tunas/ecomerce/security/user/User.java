package tunas.ecomerce.security.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.product.liked.Liked;
import tunas.ecomerce.security.role.Role;
import tunas.ecomerce.transaction.cart.Cart;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
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
    private String mobile;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Cart> cart;

    @OneToMany(mappedBy = "user")
    private List<Liked> wishList;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

}
