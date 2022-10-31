package tunas.ecomerce.security.role;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tunas.ecomerce.exception.ApiRequestException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService{

    private final RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public Role save(Role s) {
        return roleRepository.save(s);
    }

    public Iterable<Role> saveAll(Iterable<Role> iterable) {
        return null;
    }

    public Optional<Role> findById(Long aLong) {
        Optional<Role> role = roleRepository.findById(aLong);
        if(role.isEmpty()){
            throw new ApiRequestException("BAD_REQUEST", HttpStatus.NO_CONTENT);
        }
        return roleRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return roleRepository.existsById(aLong);
    }

    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    public Iterable<Role> findAllById(Iterable<Long> iterable) {
        return roleRepository.findAllById(iterable);
    }

    public long count() {
        return roleRepository.count();
    }

    public void deleteById(Long aLong) {
        roleRepository.deleteById(aLong);
    }

    public void delete(Role role) {
        roleRepository.delete(role);
    }
}
