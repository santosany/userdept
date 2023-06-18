package com.anystudent.userdept.controllers;

import com.anystudent.userdept.dto.UserDTO;
import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseBody
    @GetMapping
    public ResponseEntity<?> userFindAll(){
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
        Optional<User> userById = userService.userFindById(id);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody UserDTO newUser) {
        User user = userService.saveUser(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDTO newUser) {
        User user = userService.updateUser(Long.parseLong(id), newUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
       userService.deleteUserById(id);

       return ResponseEntity.ok("Successfully deleted user");
    }
}
