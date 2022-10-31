package id.grocery.tunas.security.user;

import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity getAllUser(){
        JsonObject result = new JsonObject();
        result.put("data", userService.findAll());
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        JsonObject result = new JsonObject();
        Optional<User> user = userService.findById(id);
        user.ifPresent(value -> result.put("data", value));
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping("/role/{userid}/{roleid}")
    public ResponseEntity grantRole(@PathVariable("userid") Long userId, @PathVariable("roleid") Long roleId){
        userService.grantRole(userId, roleId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/role/{userid}/{roleid}")
    public ResponseEntity revokeRole(@PathVariable("userid") Long userId, @PathVariable("roleid") Long roleId){
        userService.revokeRole(userId, roleId);
        return ResponseEntity.ok().build();
    }

}
