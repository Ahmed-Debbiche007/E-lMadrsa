/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import outils.CodeGenerator;

/**
 *
 * @author Nour
 */
public class Recup {

    private long id;
    private long idUser;
    private String code;

    public Recup() {

    }


    public Recup(long id, long idUser, String code) {
        this.id = id;
        this.idUser = idUser;
        this.code = code;
    }
    
    public Recup(long idUser, String code) {
        this.id = id;
        this.idUser = idUser;
        this.code = code;
    }

    public Recup(long idUser) {
        CodeGenerator g = new CodeGenerator();
        this.idUser = idUser;
        this.code = g.generate();
    }

    
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "recup{" + "id=" + id + ", idUser=" + idUser + ", code=" + code + '}';
    }


}
