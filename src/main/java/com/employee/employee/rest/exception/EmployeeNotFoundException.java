package com.employee.employee.rest.exception;

public class EmployeeNotFoundException extends Exception {
    
  public EmployeeNotFoundException(Long id) {
    super(String.format("Cannot find Participant with %d", id));
  }
    
}
