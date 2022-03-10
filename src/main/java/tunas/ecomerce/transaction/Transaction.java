package tunas.ecomerce.transaction;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.security.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Transaction{
    @Id
    private UUID id;

    private Long totalPrice;
    private Date transactionDate;

    @ManyToOne
    private User user;
    private String userName;
    private String userMobile;
    private String userEmail;

}
