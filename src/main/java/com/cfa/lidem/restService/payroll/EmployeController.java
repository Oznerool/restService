package com.cfa.lidem.restService.payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeController {
    private final EmployeRepository repository;

    public EmployeController(EmployeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employe> all(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employe newEmploye(@RequestBody Employe newEmploye){
        return repository.save(newEmploye);
    }

    @GetMapping("/employees/{id}")
    Employe one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new EmployeNotFoundException(id));
    }

    @PutMapping("/employee/{id}")
    Employe replaceEmploye(@RequestBody Employe up,@PathVariable Long id){
        return repository.findById(id).map( emp -> {
            emp.setNom(up.getNom());
            emp.setRole(up.getRole());
            return repository.save(emp);
        }).orElseGet(() ->{
            up.setId(id);
            return repository.save(up);
        });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmp(@PathVariable Long id){
        repository.deleteById(id);
    }
}
