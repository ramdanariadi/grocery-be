package tunas.ecomerce.security.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;
import tunas.ecomerce.security.filter.TokenGenerationAlgorithm;
import tunas.ecomerce.security.role.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ObjectResponse register(@RequestBody User user){
        userService.saveUser(user);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("", HttpStatus.CREATED);
    }

    @PutMapping()
    public ObjectResponse update(@RequestBody User user){
        userService.updateUser(user);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ListResponse getAllUser(){
        CustomResponse<User> customResponse = new CustomResponse<>();
        return customResponse.sendResponse((List<User>) userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ObjectResponse getUserById(@PathVariable Long id){
        CustomResponse<User> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(userService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/role/{userid}/{roleid}")
    public ObjectResponse grantRole(@PathVariable("userid") Long userId, @PathVariable("roleid") Long roleId){
        userService.grantRole(userId, roleId);
        return CustomResponse.getModifyingObjectResponse(1);
    }

    @DeleteMapping("/role/{userid}/{roleid}")
    public ObjectResponse revokeRole(@PathVariable("userid") Long userId, @PathVariable("roleid") Long roleId){
        userService.revokeRole(userId, roleId);
        return CustomResponse.getModifyingObjectResponse(1);
    }

    @GetMapping("/token")
    public void token(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authorization = request.getHeader(AUTHORIZATION);
        if(authorization != null && authorization.startsWith("Bearer ")){
            try {
                String refresh_token = authorization.substring("Bearer ".length());
                Algorithm algorithm = TokenGenerationAlgorithm.algorithm;
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUserByUsername(username);
                String access_token = JWT.create()
                        .withSubject(username)
                        .withClaim("roles",user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1440 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .sign(algorithm);
                response.setContentType(APPLICATION_JSON_VALUE);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token",access_token);
                tokens.put("refresh_token",refresh_token);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }catch (Exception e){
                response.setStatus(FORBIDDEN.value());
                new ObjectMapper().writeValue(response.getOutputStream(),e.getMessage());
            }
        }else{
            new ObjectMapper().writeValue(response.getOutputStream(),"error : Token is missing");
        }
    }
}
