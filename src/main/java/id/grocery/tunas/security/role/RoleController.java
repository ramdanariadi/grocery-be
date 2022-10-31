package id.grocery.tunas.security.role;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/role")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity saveRole(@RequestBody Role role){
        roleService.saveRole(role);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity getAllRole(){
        JsonObject result = new JsonObject();
        result.put("data", roleService.findAll());
        return ResponseEntity.ok(result.getMap());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoleById(@PathVariable("id") Long id){
        Optional<Role> role = roleService.findById(id);
        JsonObject result = new JsonObject();
        result.put("data", result);
        return ResponseEntity.ok(result.getMap());
    }
}
