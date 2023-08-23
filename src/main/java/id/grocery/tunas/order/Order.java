package id.grocery.tunas.order;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
public class Order extends BaseModel {

    @Column(name = "price_total", nullable = false, columnDefinition = "numeric(19,2) default 0")
    private BigDecimal totalPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
