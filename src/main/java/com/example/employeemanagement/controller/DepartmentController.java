package com.example.employeemanagement.controller;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService service;
    public DepartmentController(DepartmentService service){this.service=service;}
    @GetMapping public List<Department> getAll(){return service.getAll();}
    @GetMapping("/{id}") public Department getById(@PathVariable Long id){return service.getById(id);}
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Department create(@Valid @RequestBody Department d){return service.create(d);}
    @PutMapping("/{id}") public Department update(@PathVariable Long id,@Valid @RequestBody Department d){return service.update(id,d);}
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){service.delete(id);}
}
