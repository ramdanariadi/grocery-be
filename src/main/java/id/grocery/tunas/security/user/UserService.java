package id.grocery.tunas.security.user;

import id.grocery.tunas.security.role.Role;
import id.grocery.tunas.security.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import id.grocery.tunas.exception.ApiRequestException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        if(null != userRepository.findUserByUsername(user.getUsername())){
                throw new ApiRequestException("USER_TAKEN");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void updateUser(User user){
        if(null == user.getId()){
            throw new ApiRequestException("USER_NOT_FOUND");
        }
        Optional<User> userTmp = userRepository.findById(user.getId());
        if(userTmp.isEmpty()){
            throw new ApiRequestException("USER_NOT_FOUND");
        }
        User existUser = userRepository.findUserByUsername(user.getUsername());
        if(null != existUser && !Objects.equals(existUser.getId(), user.getId())){
            throw new ApiRequestException("USERNAME_TAKEN");
        }
        User userContext = userTmp.get();
        userContext.setName(user.getName());
        userContext.setUsername(user.getUsername());
        userRepository.save(userContext);
    }

    public void grantRole(String userId, UUID roleId){
        Map<String, Object> entities = this.validateUserAndRole(userId, roleId);
        User user = (User) entities.get("user");
        Role role = (Role) entities.get("role");
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public void revokeRole(String userId, UUID roleId){
        Map<String, Object> entities = this.validateUserAndRole(userId, roleId);
        User user = (User) entities.get("user");
        Role role = (Role) entities.get("role");
        user.setRoles(user.getRoles().stream().filter(roleItem -> !roleItem.getName().equals(role.getName())).collect(Collectors.toList()));
        userRepository.save(user);
    }

    private Map<String, Object> validateUserAndRole(String userId, UUID roleId){
        Optional<User> userContext = userRepository.findById(userId);
        if(userContext.isEmpty()){
            throw new ApiRequestException("USER_NOT_FOUND");
        }
        Optional<Role> roleContext = roleRepository.findById(roleId);
        if(roleContext.isEmpty()){
            throw new ApiRequestException("ROLE_NOT_FOUND");
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
        if(null == user){
            throw new UsernameNotFoundException("USER_NOT_FOUND");
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

    public Optional<User> findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new ApiRequestException("BAD_REQUEST");
        }
        return user;
    }

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<String> iterable) {
        return userRepository.findAllById(iterable);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
