package tunas.ecomerce.transaction;

import lombok.Data;
import lombok.NoArgsConstructor;
import tunas.ecomerce.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private Customer customer;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
}
