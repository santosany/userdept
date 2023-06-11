package com.anystudent.userdept.service;

import com.anystudent.userdept.entities.Department;
import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Optional<Department> departmentFindById(Long id){
        return departmentRepository.findById(id);
    }

    public Department mergeDepartment(Department newDepartment) {

        if (newDepartment.getId() == null) {
            Department department = departmentRepository.save(newDepartment);
            return department;
        } else {
            Optional<Department> findDepartment = departmentFindById(newDepartment.getId());
            if(findDepartment.isPresent()){
                Department departmentSave = departmentRepository.save(newDepartment);
                return departmentSave;
            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Department Id", null);
            }
        }
    }

    public void deleteUserById(Long id){
        Optional<Department> department = departmentFindById(id);

        if(department.isPresent()){
            departmentRepository.delete(department.get());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User Id", null);
        }
    }
}
