package tunas.ecomerce.customer;

import tunas.ecomerce.product.liked.Liked;
import tunas.ecomerce.transaction.Chart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    private UUID id;
    private String name;
    private String mobile;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Chart> chart;

    @OneToMany(mappedBy = "customer")
    private List<Liked> wishList;

    public Customer() {
    }

    public List<Chart> getChart() {
        return chart;
    }

    public void setChart(List<Chart> chart) {
        this.chart = chart;
    }

    public List<Liked> getWishList() {
        return wishList;
    }

    public void setWishList(List<Liked> wishList) {
        this.wishList = wishList;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
