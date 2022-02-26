package tunas.ecomerce.security.user;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    User findUserByUsername(String username);
}
