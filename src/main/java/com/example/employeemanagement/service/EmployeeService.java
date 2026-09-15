package com.example.employeemanagement.service;
import com.example.employeemanagement.entity.*;
import com.example.employeemanagement.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository){
        this.employeeRepository=employeeRepository; this.departmentRepository=departmentRepository;
    }
    public List<Employee> getAll(){return employeeRepository.findAll();}
    public Employee getById(Long id){return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found: "+id));}

    public Employee create(Employee e){
        if(e.getDepartment()!=null && e.getDepartment().getId()!=null){
            Department d=departmentRepository.findById(e.getDepartment().getId()).orElseThrow(()->new RuntimeException("Department not found"));
            e.setDepartment(d);
        }
        return employeeRepository.save(e);
    }

    public Employee update(Long id,Employee input){
        Employee e=getById(id);
        e.setName(input.getName()); e.setEmail(input.getEmail()); e.setRole(input.getRole());
        if(input.getDepartment()!=null && input.getDepartment().getId()!=null){
            Department d=departmentRepository.findById(input.getDepartment().getId()).orElseThrow(()->new RuntimeException("Department not found"));
            e.setDepartment(d);
        }
        return employeeRepository.save(e);
    }

    public void delete(Long id){employeeRepository.delete(getById(id));}
    public List<Employee> searchByName(String name){return employeeRepository.findByNameContainingIgnoreCase(name);}
    public List<Employee> byDepartment(String name){return employeeRepository.findByDepartmentNameIgnoreCase(name);}
    public List<Employee> byRole(String role){return employeeRepository.findByRole(role);}
}
