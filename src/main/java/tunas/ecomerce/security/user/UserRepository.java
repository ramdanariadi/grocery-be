package tunas.ecomerce.security.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
