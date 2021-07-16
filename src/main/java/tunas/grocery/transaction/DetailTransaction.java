package tunas.grocery.transaction;

import tunas.grocery.product.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class DetailTransaction {
    @Id
    UUID id;

    @ManyToOne
    Product product;
    String name;
    Long price;
    Integer total;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @ManyToOne
    Transaction transaction;

    public DetailTransaction() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
