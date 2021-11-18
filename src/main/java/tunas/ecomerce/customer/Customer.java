package tunas.ecomerce.customer;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.product.liked.Liked;
import tunas.ecomerce.transaction.cart.Cart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Customer {
    @Id
    private UUID id;
    private String name;
    private String mobile;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Cart> cart;

    @OneToMany(mappedBy = "customer")
    private List<Liked> wishList;
}
