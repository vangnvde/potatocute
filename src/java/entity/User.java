/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Vang Nguyen
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private boolean isExpert;
    private boolean isAdmin;

    public User() {
    }

    public User(int id, String username, String password, String fullname, boolean isExpert, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.isExpert = isExpert;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }
     public char getFirstCharFullname() {
        return fullname.charAt(0);
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isIsExpert() {
        return isExpert;
    }

    public void setIsExpert(boolean isExpert) {
        this.isExpert = isExpert;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname + ", isExpert=" + isExpert + ", isAdmin=" + isAdmin + '}';
    }
    
    
    
}
