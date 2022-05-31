package com.cts.employeemanagement.services;

import com.cts.employeemanagement.model.Employee;
import com.cts.employeemanagement.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.internal.CoreLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * The type Employee service.
 */
@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    /**
     * Get all employees list.
     *
     * @return the list
     */
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    /**
     * Get employee by id employee.
     *
     * @param id the id
     * @return the employee
     */
    public Employee getEmployeeById(int id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with "+id+" not found"));
    }

    /**
     * Update employee employee.
     *
     * @param id       the id
     * @param employee the employee
     * @return the employee
     */
    public Employee updateEmployee(int id, Employee employee){
        Optional<Employee> empList = repository.findById(id);
        log.info("Update :{}", employee);
        if(empList.isEmpty())
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with "+id+" not found");

        Employee employee1 = empList.get();

        if(employee.getName()!=null)
            employee1.setName(employee.getName());
        if(employee.getAge()!=0)
            employee1.setAge(employee.getAge());
        if(employee.getGender()!=null)
            employee1.setGender(employee.getGender());
        if(employee.getSalary()!=0)
            employee1.setSalary(employee.getSalary());

        repository.save(employee1);
        return employee1;
    }

    /**
     * Add employee employee.
     *
     * @param employee the employee
     * @return the employee
     */

    public Employee addEmployee(Employee employee){
        log.info("Employee:{}",employee);
        repository.save(employee);
        return employee;
    }

    /**
     * Delete employee by id employee.
     *
     * @param id the id
     * @return the employee
     */
    public Employee deleteEmployeeById(int id){
        Optional<Employee> employee = repository.findById(id);
        if(!employee.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee emp "+id+" not present");
            //throw new RuntimeException();
        Employee employee1 = employee.get();
        repository.delete(employee1);
        return employee1;
    }
}
