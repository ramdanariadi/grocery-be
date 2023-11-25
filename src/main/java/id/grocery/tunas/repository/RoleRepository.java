package id.grocery.tunas.repository;

import id.grocery.tunas.model.RoleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<RoleModel, UUID> {
}
