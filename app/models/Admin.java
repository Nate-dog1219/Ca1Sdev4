package models;

import io.ebean.Finder;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "Admin")
public class Admin extends User{

    private static Finder<String, Admin> finder = new Finder<>(Admin.class);

    public Admin() {
    }

    public Admin(int idNum, String password, String role, String fname, String lname, String email, String phoneNumber) {
        super(idNum, password, role, fname, lname, email, phoneNumber);
    }

    public static Admin get(String id) {
        return finder.ref(id);
    }

}
