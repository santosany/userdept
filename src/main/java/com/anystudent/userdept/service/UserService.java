package com.anystudent.userdept.service;

import com.anystudent.userdept.dto.UserDTO;
import com.anystudent.userdept.dto.UserMapperDTO;
import com.anystudent.userdept.entities.Department;
import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.DepartmentRepository;
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
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    private UserMapperDTO userMapperDTO;

    public List<User> findAll(){

        return userRepository.findAll();
    }

    public Optional<User> userFindById(Long id){

        return userRepository.findById(id);

    }

    public User saveUser(UserDTO newUser) {

        User user = userMapperDTO.userDtoToUser(newUser);
        Optional<Department> byId = departmentRepository.findById(user.getUserDepartment());
        if (!byId.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departamento não encontrado.", null);
        }

         userRepository.save(user);

        return user;

    }

    public User updateUser(long id, UserDTO updatedUser) {
        Optional<User> findUser = userFindById(id);

        User user;

        if (findUser.isPresent()) {
            user = UserMapperDTO.userDtoToUser(updatedUser);
            user.setUserId(id);

            userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User Id", null);
        }

        return user;

    }

    public void deleteUserById(Long id){
        Optional<User> user = userFindById(id);

        if(user.isPresent()){
            userRepository.delete(user.get());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User Id", null);
        }
    }

}
