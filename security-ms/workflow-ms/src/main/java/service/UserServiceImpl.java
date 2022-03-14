package service;

import com.example.reportms.models.Role;
import com.example.reportms.models.SchoolUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.RoleRepo;
import repository.SchoolUserRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final SchoolUserRepo schoolUserRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SchoolUser user = schoolUserRepo.findByUsername(username);
        if (user == null){
            log.error("User not found in the database!");
            throw new UsernameNotFoundException("User not found in the database!");
        } else {
            log.info("User found in the database: {}",username);
        }
        //Define authorities
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //loop through and add simple granted authority
        user.getRoles().forEach(role -> { authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public SchoolUser saveUser(SchoolUser user) {
        log.info("Saving new user {} into the db", user.getName());
        //Encoding user password for saving user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return schoolUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} into the db", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to a user {}", roleName, username);
        //Find a user by their username
        SchoolUser user = schoolUserRepo.findByUsername(username);
        //find a role
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public SchoolUser getUser(String username) {
        log.info("fetching a user {}", username);
        return schoolUserRepo.findByUsername(username);
    }

    @Override
    public List<SchoolUser> getAllUsers() {
        log.info("fetching all users");
        return schoolUserRepo.findAll();
    }


}
