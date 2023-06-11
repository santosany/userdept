package com.anystudent.userdept.controllers;

import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.UserRepository;
import com.anystudent.userdept.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping
    public ResponseEntity<?> userFindAll(){
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
        Optional<User> userById = userService.userFindById(id);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody User newUser){
        User user = userService.mergeUser(newUser);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User putUser){
        User user = userService.mergeUser(putUser);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
       userService.deleteUserById(id);

       return ResponseEntity.ok("Successfully deleted user");
    }
}
