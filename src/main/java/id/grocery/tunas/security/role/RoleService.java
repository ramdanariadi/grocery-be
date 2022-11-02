package id.grocery.tunas.security.role;

import com.fasterxml.uuid.Generators;
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

    public void saveRole(Role role){
        role.setId(Generators.timeBasedGenerator().generate());
        roleRepository.save(role);
    }

    public Role save(Role s) {
        return roleRepository.save(s);
    }

    public Iterable<Role> saveAll(Iterable<Role> iterable) {
        return null;
    }

    public Optional<Role> findById(UUID aLong) {
        Optional<Role> role = roleRepository.findById(aLong);
        if(role.isEmpty()){
            throw new ApiRequestException("BAD_REQUEST", HttpStatus.NO_CONTENT);
        }
        return roleRepository.findById(aLong);
    }

    public boolean existsById(UUID aLong) {
        return roleRepository.existsById(aLong);
    }

    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    public Iterable<Role> findAllById(Iterable<UUID> iterable) {
        return roleRepository.findAllById(iterable);
    }

    public long count() {
        return roleRepository.count();
    }

    public void deleteById(UUID aLong) {
        roleRepository.deleteById(aLong);
    }

    public void delete(Role role) {
        roleRepository.delete(role);
    }
}
