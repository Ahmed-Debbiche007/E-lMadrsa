/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Msi
 */
public class User {
    private int id ; 
    private String FirstName ; 
    private String LastName ; 
    private int age ; 

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", age=" + age + '}';
    }

    public User(int id, String FirstName, String LastName, int age) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.age = age;
    }   
    public User( String FirstName, String LastName, int age) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.age = age;
    }
    

    
}
  