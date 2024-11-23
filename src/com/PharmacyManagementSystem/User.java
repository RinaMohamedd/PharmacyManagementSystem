package com.PharmacyManagementSystem;

//not sure if we need to have it as abstract, but we'll see
public abstract class User {
    protected String id = "0";
    protected String name;
    protected Role role;
    protected String email;
    protected String password;

    public enum Role {
        ADMIN,
        CASHIER,
        CUSTOMER,
        SUPPLIER;
    }


    public User() {}
    public User(String name, Role role, String email, String password) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
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


    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
