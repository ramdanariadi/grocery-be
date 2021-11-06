package tunas.ecomerce.security.role;


import com.fasterxml.uuid.Generators;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService{

    private final RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.save(role);
    }
}
