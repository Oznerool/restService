package com.cfa.lidem.restService.payroll;

public class EmployeNotFoundException extends RuntimeException{
    public EmployeNotFoundException(Long id){
        super("Could not find employe whith" + id);
    }
}
