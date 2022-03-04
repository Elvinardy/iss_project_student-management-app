package com.student_management_app.controllers;

import com.student_management_app.model.User;
import com.student_management_app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

/*     @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;
 */
    @PostMapping(path="/registerUser")
    public User registerNewUser(@RequestBody User user) {
       return userService.registerNewUser(user);
    }

    @GetMapping(path="/admin")
    public String forAdmin() {
        return "This URL is only accessible to admin";
    }

    @GetMapping(path="/user")
    public String forUser() {
        return "This URL is accessible to all user";
    }

/*     public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleRepo.save(adminRole);

        User userRole = new User();
        userRole.setUserName("User");
        userRole.setUserDescription("New User role");
        userRepo.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName

    } */
}
