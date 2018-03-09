package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity

public class Department extends Model {

    public static Finder<String, Department> find = new Finder<>(Department.class);

    @Id
    private String Id;
    private String name;

    public Department() {
    }

    public Department(String id, String name) {
        Id = id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Department> getAll() {
        return Department.find.all();
    }
    public static Department get(String Id) {
        return find.ref(Id);
    }
}
