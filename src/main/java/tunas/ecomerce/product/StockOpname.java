package tunas.ecomerce.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StockOpname {
    @Id
    Integer id;
    Integer stock;
    Integer lastStock;

    @ManyToOne
    Product product;

    public StockOpname() {
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLastStock() {
        return lastStock;
    }

    public void setLastStock(Integer lastStock) {
        this.lastStock = lastStock;
    }
}
