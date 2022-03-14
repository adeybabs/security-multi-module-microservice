package controller;

import com.example.reportms.models.Role;
import com.example.reportms.models.SchoolUser;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.UserService;

import java.net.URI;
import java.util.*;


@RestController @RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    //List of all users
    @GetMapping("/users")
    public ResponseEntity<List<SchoolUser>>getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    //create a user
    //Adding post Authorize to role admin
    @PostMapping("/user/save")
    public ResponseEntity<SchoolUser>saveUser(@RequestBody SchoolUser user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    //create a role
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    //add a role to a user
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;

}
