package tunas.ecomerce.security.role;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}
