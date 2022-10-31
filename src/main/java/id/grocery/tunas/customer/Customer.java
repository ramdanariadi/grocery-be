package id.grocery.tunas.customer;

import id.grocery.tunas.product.liked.Liked;
import lombok.Data;
import lombok.NoArgsConstructor;
import id.grocery.tunas.transaction.cart.Cart;

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
