package com.example.employeemanagement.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull @Size(min=2,max=100)
    @Column(nullable=false)
    private String name;

    @NotNull @Email
    @Column(nullable=false)
    private String email;

    @NotNull @Size(min=2,max=50)
    @Column(nullable=false)
    private String role;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="department_id")
    private Department department;

    public Employee(){}
    public Employee(String name,String email,String role,Department department){
        this.name=name; this.email=email; this.role=role; this.department=department;
    }
    public Long getId(){return id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getRole(){return role;}
    public void setRole(String role){this.role=role;}
    public Department getDepartment(){return department;}
    public void setDepartment(Department department){this.department=department;}
}
