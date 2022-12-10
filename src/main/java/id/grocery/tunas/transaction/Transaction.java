package id.grocery.tunas.transaction;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import id.grocery.tunas.security.user.User;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Transaction{
    @Id
    private UUID id;
    private Long totalPrice;
    private Date transactionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
