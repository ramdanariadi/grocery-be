package tunas.ecomerce.security.role;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/role")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ObjectResponse saveRole(@RequestBody Role role){
        roleService.saveRole(role);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ListResponse getAllRole(){
        CustomResponse<Role> customResponse = new CustomResponse<>();
        return customResponse.sendResponse((List<Role>) roleService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ObjectResponse getRoleById(@PathVariable("id") UUID id){
        CustomResponse<Role> customResponse = new CustomResponse<>();
        Optional<Role> role = roleService.findById(id);
        return customResponse.sendResponse(role.get(),HttpStatus.OK);
    }
}
