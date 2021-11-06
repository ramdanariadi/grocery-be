package tunas.ecomerce.security.role;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

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
}
