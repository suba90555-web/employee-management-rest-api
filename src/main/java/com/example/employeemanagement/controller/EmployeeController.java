package com.example.employeemanagement.controller;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service){this.service=service;}
    @GetMapping public List<Employee> getAll(){return service.getAll();}
    @GetMapping("/{id}") public Employee getById(@PathVariable Long id){return service.getById(id);}
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@Valid @RequestBody Employee e){return service.create(e);}
    @PutMapping("/{id}") public Employee update(@PathVariable Long id,@Valid @RequestBody Employee e){return service.update(id,e);}
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){service.delete(id);}
    @GetMapping("/search") public List<Employee> search(@RequestParam String name){return service.searchByName(name);}
    @GetMapping("/department/{name}") public List<Employee> byDepartment(@PathVariable String name){return service.byDepartment(name);}
    @GetMapping("/role/{role}") public List<Employee> byRole(@PathVariable String role){return service.byRole(role);}
}
