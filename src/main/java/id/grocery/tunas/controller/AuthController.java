package id.grocery.tunas.controller;

import id.grocery.tunas.service.UserService;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/token")
    public ResponseEntity<Object> token(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
        Map<String, Object> token = userService.token(authorization);
        JsonObject result = new JsonObject();
        result.put("data", token);
        return ResponseEntity.ok(result.getMap());
    }
}
