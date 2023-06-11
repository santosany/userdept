package com.anystudent.userdept.service;

import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public Optional<User> userFindById(Long id){
        return repository.findById(id);
    }

    public User mergeUser(User newUser) {

        if (newUser.getUserId() == null) {
            User user = repository.save(newUser);
            return user;
        } else {
            Optional<User> findUser = userFindById(newUser.getUserId());
            if(findUser.isPresent()){
                User userSave = repository.save(newUser);
                return userSave;
            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User Id", null);
            }
        }
    }

    public void deleteUserById(Long id){
        Optional<User> user = userFindById(id);

        if(user.isPresent()){
            repository.delete(user.get());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User Id", null);
        }
    }

}
