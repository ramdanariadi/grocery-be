package id.grocery.tunas.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.config.security.filter.TokenGenerationAlgorithm;
import id.grocery.tunas.model.RoleModel;
import id.grocery.tunas.model.UserModel;
import id.grocery.tunas.repository.RoleRepository;
import id.grocery.tunas.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserService userService;

    @Autowired
    public UserService(UserService userService){
        this.userService = userService;
    }

    public Map<String, Object> token(String authorization){

        if(null == authorization || !authorization.startsWith("Bearer ")) throw new ApiRequestException("TOKEN_IS_MISSING", HttpStatus.UNAUTHORIZED);

        try {
            String refresh_token = authorization.substring("Bearer ".length());
            Algorithm algorithm = TokenGenerationAlgorithm.algorithm;
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
            String username = decodedJWT.getSubject();
            UserModel userModel = userService.getUserByUsername(username);
            String access_token = JWT.create()
                    .withSubject(username)
                    .withClaim("roles", userModel.getRoleModels().stream().map(RoleModel::getName).collect(Collectors.toList()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1440 * 60 * 1000))
                    .sign(algorithm);
            Map<String, Object> tokens = new HashMap<>();
            tokens.put("access_token",access_token);
            tokens.put("refresh_token",refresh_token);
            return tokens;
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @Service
    @AllArgsConstructor
    public static class UserService implements UserDetailsService {
        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final PasswordEncoder passwordEncoder;

        public UserModel saveUser(UserModel userModel){
            if(null != userRepository.findUserByUsername(userModel.getUsername())){
                    throw new ApiRequestException("USER_TAKEN");
            }
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
            return userRepository.save(userModel);
        }

        public void updateUser(UserModel userModel){
            if(null == userModel.getId()){
                throw new ApiRequestException("USER_NOT_FOUND");
            }
            Optional<UserModel> userTmp = userRepository.findById(userModel.getId());
            if(userTmp.isEmpty()){
                throw new ApiRequestException("USER_NOT_FOUND");
            }
            UserModel existUserModel = userRepository.findUserByUsername(userModel.getUsername());
            if(null != existUserModel && !Objects.equals(existUserModel.getId(), userModel.getId())){
                throw new ApiRequestException("USERNAME_TAKEN");
            }
            UserModel userModelContext = userTmp.get();
            userModelContext.setName(userModel.getName());
            userModelContext.setUsername(userModel.getUsername());
            userRepository.save(userModelContext);
        }

        public void grantRole(UUID userId, UUID roleId){
            Map<String, Object> entities = this.validateUserAndRole(userId, roleId);
            UserModel userModel = (UserModel) entities.get("userModel");
            RoleModel roleModel = (RoleModel) entities.get("roleModel");
            userModel.getRoleModels().add(roleModel);
            userRepository.save(userModel);
        }

        public void revokeRole(UUID userId, UUID roleId){
            Map<String, Object> entities = this.validateUserAndRole(userId, roleId);
            UserModel userModel = (UserModel) entities.get("userModel");
            RoleModel roleModel = (RoleModel) entities.get("roleModel");
            userModel.setRoleModels(userModel.getRoleModels().stream().filter(roleItem -> !roleItem.getName().equals(roleModel.getName())).collect(Collectors.toList()));
            userRepository.save(userModel);
        }

        private Map<String, Object> validateUserAndRole(UUID userId, UUID roleId){
            Optional<UserModel> userContext = userRepository.findById(userId);
            if(userContext.isEmpty()){
                throw new ApiRequestException("USER_NOT_FOUND");
            }
            Optional<RoleModel> roleContext = roleRepository.findById(roleId);
            if(roleContext.isEmpty()){
                throw new ApiRequestException("ROLE_NOT_FOUND");
            }
            UserModel userModel = userContext.get();
            RoleModel roleModel = roleContext.get();
            Map<String, Object> entities = new HashMap<>();
            entities.put("user", userModel);
            entities.put("role", roleModel);
            return entities;
        }

        public UserModel getUserByUsername(String username){
            return userRepository.findUserByUsername(username);
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserModel userModel = userRepository.findUserByUsername(username);
            if(null == userModel){
                throw new UsernameNotFoundException("USER_NOT_FOUND");
            }
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            userModel.getRoleModels().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(userModel.getUsername(), userModel.getPassword(),authorities);
        }

        public Iterable<UserModel> saveAll(Iterable<UserModel> iterable) {
            return userRepository.saveAll(iterable);
        }

        public Optional<UserModel> findById(UUID id) {
            Optional<UserModel> user = userRepository.findById(id);
            if(user.isEmpty()){
                throw new ApiRequestException("BAD_REQUEST");
            }
            return user;
        }

        public boolean existsById(UUID id) {
            return userRepository.existsById(id);
        }

        public Iterable<UserModel> findAll() {
            return userRepository.findAll();
        }

        public Iterable<UserModel> findAllById(Iterable<UUID> iterable) {
            return userRepository.findAllById(iterable);
        }

        public long count() {
            return userRepository.count();
        }

        public void deleteById(UUID id) {
            userRepository.deleteById(id);
        }

        public void delete(UserModel userModel) {
            userRepository.delete(userModel);
        }
    }
}
