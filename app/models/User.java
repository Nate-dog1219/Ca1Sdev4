package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@MappedSuperclass
public class User extends Model {

    @Id
    private int IdNum;
    private String password;
    private String role;
    private String fname, lname;
    private String email, phoneNumber;

    public static Finder<String, User> find = new Finder<String, User>(User.class);

    public User() {
    }

    public User(int idNum, String password, String role, String fname, String lname, String email, String phoneNumber) {
        IdNum = idNum;
        this.password = password;
        this.role = role;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getIdNum() {
        return IdNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static User aethenticate(String email, String password){
        return find.query().where().eq("email", email).eq("password", password).findUnique();

    }
    public static List<User> finAll() {
        return User.find.all();
    }


    public static User getWithId(String IdNum) {
        return find.byId(IdNum);
    }
}
