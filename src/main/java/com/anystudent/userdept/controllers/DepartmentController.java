package com.anystudent.userdept.controllers;

import com.anystudent.userdept.dto.DepartmentDTO;
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseBody
    @GetMapping
    public ResponseEntity<?> findAllDepartments() {
        List<Department> departmentList = departmentService.findAll();
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Optional<Department>> findById(@PathVariable Long id){
        Optional<Department> userById = departmentService.departmentFindById(id);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Department> newDepartment(@RequestBody DepartmentDTO newDepartment){
        Department department = departmentService.saveDepartment(newDepartment);
        return new ResponseEntity<>(department,HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody DepartmentDTO putDepartment){
        Department department = departmentService.updateDepartment(Long.parseLong(id), putDepartment);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        departmentService.deleteUserById(id);

        return ResponseEntity.ok("Successfully deleted user");
    }

}
