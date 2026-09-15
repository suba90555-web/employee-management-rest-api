package com.example.employeemanagement.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name="departments")
public class Department {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull @Size(min=2,max=50)
    @Column(nullable=false,unique=true)
    private String name;

    @OneToMany(mappedBy="department", cascade=CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Department() {}
    public Department(String name){this.name=name;}
    public Long getId(){return id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public List<Employee> getEmployees(){return employees;}
    public void setEmployees(List<Employee> employees){this.employees=employees;}
}
