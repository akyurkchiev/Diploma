package com.nbu.register;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Atanas
 */
@ManagedBean(name = "register")
@SessionScoped

public class UserRegister {
     public UserRegister() {
  
    }

    /* ---------------------- Class Variables ---------------------- */
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    DatabaseClass obj=new DatabaseClass();
    
    /* ---------------------- Getters and Setters ---------------------- */

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
    /* ---------------------- Method call on Register Button ---------------------- */
    
    public String register()
    {
        System.out.println("----------- register Method Called ---------");
        try {
            obj.dbRegister(firstname,lastname, password, email);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n-------------Cannot update database------------\n");
        }
        return "user?faces-redirect=true";
    }
}
