package tunas.ecomerce.transaction;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.product.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class DetailTransaction {
    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    private String name;
    private String imageUrl;
    private Long price;
    private Integer perUnit;
    private Integer weight;
    private Integer total;

    @ManyToOne(fetch = FetchType.LAZY)
    Transaction transaction;

    public void setProduct(Product product) {
        this.product = product;
        this.setImageUrl(product.getImageUrl());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setPerUnit(product.getPerUnit());
        this.setWeight(product.getWeight());
    }
}
