package id.grocery.tunas.transaction;

import id.grocery.tunas.base.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import id.grocery.tunas.security.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Transaction extends BaseModel {
    private Long totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
