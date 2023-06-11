package com.anystudent.userdept.controllers;

import com.anystudent.userdept.entities.Department;
import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @GetMapping
    public ResponseEntity<?> findAllDepartments() {
        List<Department> departmentList = departmentService.findAll();
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Optional<Department>> findById(@PathVariable Long id){
        Optional<Department> userById = departmentService.departmentFindById(id);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> newDepartment(@RequestBody Department newDepartment){
        Department department = departmentService.mergeDepartment(newDepartment);
        return new ResponseEntity<>(department,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody Department putDepartment){
        Department department = departmentService.mergeDepartment(putDepartment);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        departmentService.deleteUserById(id);

        return ResponseEntity.ok("Successfully deleted user");
    }

}
