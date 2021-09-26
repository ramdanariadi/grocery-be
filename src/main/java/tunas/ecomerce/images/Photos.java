package tunas.ecomerce.images;

import tunas.ecomerce.product.Product;

import javax.persistence.*;

@Entity
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String url;
    String location;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Photos() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
