package id.grocery.tunas.controller;

import java.util.Optional;
import java.util.UUID;

import id.grocery.tunas.model.UserModel;
import id.grocery.tunas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vertx.core.json.JsonObject;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService.UserDetailService userDetailService;

    @Autowired
    public UserController(UserService.UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserModel userModel){
        userDetailService.saveUser(userModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody UserModel userModel){
        userDetailService.updateUser(userModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUser(){
        JsonObject result = new JsonObject();
        result.put("data", userDetailService.findAll());
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") UUID id){
        JsonObject result = new JsonObject();
        Optional<UserModel> user = userDetailService.findById(id);
        user.ifPresent(value -> result.put("data", value));
        return ResponseEntity.ok(result.getMap());
    }

    @PostMapping("/role/{userId}/{roleId}")
    public ResponseEntity<Object> grantRole(@PathVariable("userId") UUID userId, @PathVariable("roleId") UUID roleId){
        userDetailService.grantRole(userId, roleId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/role/{userId}/{roleId}")
    public ResponseEntity<Object> revokeRole(@PathVariable("userId") UUID userId, @PathVariable("roleId") UUID roleId){
        userDetailService.revokeRole(userId, roleId);
        return ResponseEntity.ok().build();
    }

}
