package id.tunas.grocery.security.role;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/role")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Object> saveRole(@RequestBody Role role){
        roleService.saveRole(role);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllRole(){
        JsonObject result = new JsonObject();
        result.put("data", roleService.findAll());
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoleById(@PathVariable("id") UUID id){
        Role role = roleService.findById(id);
        JsonObject result = new JsonObject();
        result.put("data", role);
        return ResponseEntity.ok(result.getMap());
    }
}
