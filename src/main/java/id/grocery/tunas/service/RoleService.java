package id.grocery.tunas.service;

import com.fasterxml.uuid.Generators;
import id.grocery.tunas.model.RoleModel;
import id.grocery.tunas.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import id.grocery.tunas.exception.ApiRequestException;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleService{

    private final RoleRepository roleRepository;

    public void saveRole(RoleModel roleModel){
        roleModel.setId(Generators.timeBasedGenerator().generate());
        roleRepository.save(roleModel);
    }

    public RoleModel save(RoleModel s) {
        return roleRepository.save(s);
    }

    public Iterable<RoleModel> saveAll(Iterable<RoleModel> iterable) {
        return null;
    }

    public RoleModel findById(UUID aLong) {
        Optional<RoleModel> role = roleRepository.findById(aLong);
        if(role.isEmpty()){
            throw new ApiRequestException("BAD_REQUEST", HttpStatus.NO_CONTENT);
        }
        return role.get();
    }

    public boolean existsById(UUID aLong) {
        return roleRepository.existsById(aLong);
    }

    public Iterable<RoleModel> findAll() {
        return roleRepository.findAll();
    }

    public Iterable<RoleModel> findAllById(Iterable<UUID> iterable) {
        return roleRepository.findAllById(iterable);
    }

    public long count() {
        return roleRepository.count();
    }

    public void deleteById(UUID aLong) {
        roleRepository.deleteById(aLong);
    }

    public void delete(RoleModel roleModel) {
        roleRepository.delete(roleModel);
    }
}
