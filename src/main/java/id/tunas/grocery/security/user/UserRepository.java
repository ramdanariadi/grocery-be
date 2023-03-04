package id.tunas.grocery.security.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findUserByUsername(String username);
}
