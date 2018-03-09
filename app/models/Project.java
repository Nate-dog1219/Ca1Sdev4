package models;


import io.ebean.Finder;
import io.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project extends Model {

    @Id
    private String id;
    private String name;
    private DateTime startTime, endTime;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    private static final Finder<String, Project> finder = new Finder<>(Project.class);

    public Project() {
    }

    public Project(String id, String name, DateTime startTime, DateTime endTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public static Finder<String, Project> getFinder(){
        return finder;
    }

    public static List<Project> getAll() {
        return Project.finder.all();
    }

    public static Project get(String id) {
        return finder.ref(id);
    }


}
