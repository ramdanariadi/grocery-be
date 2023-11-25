package id.grocery.tunas.repository;

import id.grocery.tunas.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserModel, UUID> {

    @Query("SELECT u FROM UserModel u WHERE u.username = :username")
    UserModel findUserByUsername(@Param("username") String username);
}
