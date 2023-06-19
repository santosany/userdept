package com.anystudent.userdept.service;

import com.anystudent.userdept.dto.DepartmentDTO;
import com.anystudent.userdept.entities.Department;
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

    private DepartmentDTO departmentDTO;

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Optional<Department> departmentFindById(Long id){
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(DepartmentDTO newDepartment) {
        Department department = new Department();
        department.setName(newDepartment.getName());

        departmentRepository.save(department);

        return  department;
    }

    public Department updateDepartment(long id, DepartmentDTO updatedDepartment) {
        Optional<Department> findDepartment = departmentFindById(id);

        Department department = new Department();
        department.setId(updatedDepartment.getId());
        department.setName(updatedDepartment.getName());

        if (findDepartment.isPresent()) {
            department.setId(id);


            departmentRepository.save(department);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User Id", null);
        }

        return department;

    }

    public void deleteDepartmentById(Long id){
        Optional<Department> department = departmentFindById(id);

        if(department.isPresent()){
            departmentRepository.delete(department.get());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct User Id", null);
        }
    }
}
