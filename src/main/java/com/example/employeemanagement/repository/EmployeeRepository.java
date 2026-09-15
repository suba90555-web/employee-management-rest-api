package com.example.employeemanagement.repository;
import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findByDepartmentNameIgnoreCase(String departmentName);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.role)=LOWER(:role)")
    List<Employee> findByRole(String role);
}
