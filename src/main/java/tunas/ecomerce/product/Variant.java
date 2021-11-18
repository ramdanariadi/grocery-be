package tunas.ecomerce.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Variant {

    @Id
    private UUID id;
    private String variant;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
