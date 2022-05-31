package com.cts.employeemanagement.controller;

import com.cts.employeemanagement.model.Employee;
import com.cts.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:4200")//resolve blockage due to CORS policy
@RestController
@RequestMapping(path = "api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping(path = "/employees")
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(id, employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(employee1.getId()).toUri();
        return ResponseEntity.noContent().location(uri).build();
    }

    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee1.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteById(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }
}
