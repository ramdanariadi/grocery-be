package id.grocery.tunas.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class StockOpname {
    @Id
    Integer id;
    Integer stock;
    Integer lastStock;

    @ManyToOne
    Product product;
}
