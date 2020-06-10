package com.employee.employee.rest;

import enums.Gender;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.employee.employee.model.Employee;
import com.employee.employee.repository.EmployeeRepository;

import com.employee.employee.rest.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeRepository repository;
    
    @Autowired
    public EmployeeController(EmployeeRepository repository){
      this.repository=repository;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAll(){
      return ResponseEntity.ok().body(this.repository.findAll());
    }
    /*
    @GetMapping("/id")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){
      Optional<Employee> employee = repository.findById(id);
      if(!employee.isPresent()){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
      }
      return ResponseEntity.ok(employee.get());
    }*/

}
