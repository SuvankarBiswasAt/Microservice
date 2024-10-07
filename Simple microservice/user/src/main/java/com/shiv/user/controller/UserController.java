package com.shiv.user.controller;

import com.shiv.user.model.User;
import com.shiv.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    private User getUserById(@PathVariable("id") Long id){
        User user = this.userService.getUserById(id);
        return user;
    }

    @GetMapping("/getAll")
    private List<User> getAllUsers(){
        List<User> users = this.userService.getAllUser();
        return users;
    }

    @PostMapping("/addUser")
    private Boolean saveUser(@RequestBody User user){
        user = this.userService.saveUser(user);
        return user.getId() > 0;
    }

    @PutMapping("/updateUser")
    private Boolean updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    private Boolean deleteUser(@RequestBody User user){
        return this.userService.deleteUser(user);
    }

}
