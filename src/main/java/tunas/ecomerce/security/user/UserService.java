package tunas.ecomerce.security.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tunas.ecomerce.cutomresponse.ApiRequestException;
import tunas.ecomerce.security.role.Role;
import tunas.ecomerce.security.role.RoleRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        if(userRepository.findUserByUsername(user.getUsername()) != null){
            throw new ApiRequestException("username taken", HttpStatus.PRECONDITION_FAILED);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void updateUser(User user){
        if(user.getId() == null){
            throw new ApiRequestException("user not found", HttpStatus.NO_CONTENT);
        }
        Optional<User> userTmp = userRepository.findById(user.getId());
        if(!userTmp.isPresent()){
            throw new ApiRequestException("user not found", HttpStatus.NO_CONTENT);
        }
        User existUser = userRepository.findUserByUsername(user.getUsername());
        if(existUser != null && existUser.getId() != user.getId()){
            throw new ApiRequestException("username taken", HttpStatus.PRECONDITION_FAILED);
        }
        User userContext = userTmp.get();
        userContext.setName(user.getName());
        userContext.setUsername(user.getUsername());
        userRepository.save(userContext);
    }

    public void grantRole(Long userId, Long roleId){
        Map<String, Object> entities = this.validateUserAndRole(userId, roleId);
        User user = (User) entities.get("user");
        Role role = (Role) entities.get("role");
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public void revokeRole(Long userId, Long roleId){
        Map<String, Object> entities = this.validateUserAndRole(userId, roleId);
        User user = (User) entities.get("user");
        Role role = (Role) entities.get("role");
        user.setRoles(user.getRoles().stream().filter(roleItem -> !roleItem.equals(role.getName())).collect(Collectors.toList()));
        userRepository.save(user);
    }

    private Map<String, Object> validateUserAndRole(Long userId, Long roleId){
        Optional<User> userContext = userRepository.findById(userId);
        if(!userContext.isPresent()){
            throw new ApiRequestException("user not found", HttpStatus.NO_CONTENT);
        }
        Optional<Role> roleContext = roleRepository.findById(roleId);
        if(!roleContext.isPresent()){
            throw new ApiRequestException("role not found", HttpStatus.NO_CONTENT);
        }
        User user = userContext.get();
        Role role = roleContext.get();
        Map<String, Object> entities = new HashMap<>();
        entities.put("user", user);
        entities.put("role", role);
        return entities;
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
    }

    public Iterable<User> saveAll(Iterable<User> iterable) {
        return userRepository.saveAll(iterable);
    }

    public Optional<User> findById(Long aLong) {
        Optional<User> user = userRepository.findById(aLong);
        if(!user.isPresent()){
            throw new ApiRequestException(null, HttpStatus.PRECONDITION_FAILED);
        }
        return user;
    }

    public boolean existsById(Long aLong) {
        return userRepository.existsById(aLong);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<Long> iterable) {
        return userRepository.findAllById(iterable);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
