/* package com.authentication.springsecurity.controller;

import com.authentication.springsecurity.model.User;
import com.authentication.springsecurity.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/login")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    public List<User> getAllUsers(Authentication authentication) {

        return userService.findAllUsers();

    }
    @PostMapping("/users")
    public ResponseEntity<User> saveusers(@RequestBody User newUser, Authentication auth) {
        System.out.println(newUser.getUserName()+"  "+auth.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body((userService.saveUser(newUser)));

    }

    @PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") int userId, Authentication authentication) {
        System.out.println("Inside getuserbyid method");
        return ResponseEntity.ok().body(userService.findUserById(userId).get());

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") int UserId,@RequestBody User newUser) {
        return ResponseEntity.ok().body(userService.updateUser(UserId,newUser));

    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") int UserId) {
        userService.deleteUser(UserId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/users/search")
    @PostAuthorize("returnObject.body.userName==authenticated.user")
    public ResponseEntity<User> userDetails(Authentication authentication, @RequestParam("cname") String cName) throws Exception {
        System.out.println(authentication.getName().toString());
        User User=userService.findByUserName(cName);
        if(User==null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok().body(User);

    }


}
 */