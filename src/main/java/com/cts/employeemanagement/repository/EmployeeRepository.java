package com.cts.employeemanagement.repository;

import com.cts.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Employee repository.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //getAll()
    //deleteById
    //UpdateById
    //getById
    //addEmployee
}