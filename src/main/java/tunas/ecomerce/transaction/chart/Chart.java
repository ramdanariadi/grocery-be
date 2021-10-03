package tunas.ecomerce.transaction.chart;

import tunas.ecomerce.customer.Customer;
import tunas.ecomerce.product.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Chart {
    @Id
    UUID id;
    private String name;
    private String imageUrl;
    private Long price;
    private Integer perUnit;
    private Integer weight;
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    Customer customer;

    @OneToOne
    Product product;

    public Chart() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getPerUnit() {
        return perUnit;
    }

    public void setPerUnit(Integer perUnit) {
        this.perUnit = perUnit;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setWeight(product.getWeight());
        this.setPerUnit(product.getPerUnit());
        this.setImageUrl(product.getImageUrl());
    }
}
