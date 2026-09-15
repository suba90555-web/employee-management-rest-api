package com.example.employeemanagement.service;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;
    public DepartmentService(DepartmentRepository repository){this.repository=repository;}
    public List<Department> getAll(){return repository.findAll();}
    public Department getById(Long id){return repository.findById(id).orElseThrow(()->new RuntimeException("Department not found: "+id));}
    public Department create(Department d){return repository.save(d);}
    public Department update(Long id,Department input){Department d=getById(id);d.setName(input.getName());return repository.save(d);}
    public void delete(Long id){repository.delete(getById(id));}
}
