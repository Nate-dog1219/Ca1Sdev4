package models;


import io.ebean.Finder;

import javax.persistence.*;
import java.util.List;

@DiscriminatorValue(value = "employee")
public class Employee extends User{


    @OneToOne
    private Address address;

    @OneToMany
    private Department department;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Project> projects;

    private static Finder<String, Employee> finder = new Finder<>(Employee.class);


    public Employee() {

    }

    public Employee(int idNum, String password, String role, String fname, String lname, String email, String phoneNumber, Address address, Department department, List<Project> projects) {
        super(idNum, password, role, fname, lname, email, phoneNumber);
        this.address = address;
        this.department = department;
        this.projects = projects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public static Employee get(String id) {
        return finder.ref(id);
    }



}
