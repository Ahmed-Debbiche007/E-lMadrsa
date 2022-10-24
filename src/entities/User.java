/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ahmed
 */
public class User {

    private int id, age;
    private String nom, prenom, username, password, mail;
    private UserStatus status;
    private Role role;
    

    public User() {
    }

    public User(int id, int age, String nom, String prenom, String username, String password, UserStatus status, Role role, String mail) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
        this.mail=mail;
    }

    public User(int age, String mail, String nom, String prenom, String username, String password, UserStatus status, Role role) {
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
        this.mail=mail;
    }

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = 33;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public Role getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        boolean bb = false;
        for (UserStatus t : UserStatus.values()) {
            if (t.name().equals(status)) {
                this.status = t;
                bb = true;
            }
        }
        if (bb == false) {
            System.out.println("erroRoler");
        }
    }

    public void setRole(String role) {
        boolean c = false;
        for (Role t : Role.values()) {
            if (t.name().equals(role)) {
                this.role = t;
                c = true;
            }
        }
        if (!c) {
            System.out.println("erroRoler");
        }
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", password=" + password + ", status=" + status + ", role=" + role + '}';
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    

}
