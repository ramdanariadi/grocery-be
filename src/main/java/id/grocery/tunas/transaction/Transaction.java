package id.grocery.tunas.transaction;

import id.grocery.tunas.base.BaseModel;
import id.grocery.tunas.security.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "transactions")
@NoArgsConstructor
public class Transaction extends BaseModel {

    @Column(name = "price_total", nullable = false, columnDefinition = "numeric(19,2) default 0")
    private BigDecimal totalPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
