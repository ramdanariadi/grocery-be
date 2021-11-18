package tunas.ecomerce.images;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.product.Product;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String url;
    String location;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
