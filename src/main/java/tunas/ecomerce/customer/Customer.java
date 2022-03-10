package tunas.ecomerce.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
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
//
//    @OneToMany(mappedBy = "customer")
//    private List<Cart> cart;
//
//    @OneToMany(mappedBy = "customer")
//    private List<Liked> wishList;
}
