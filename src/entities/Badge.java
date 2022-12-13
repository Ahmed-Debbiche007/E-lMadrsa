/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;

/**
 *
 * @author ahmed
 */
public class Badge {
    private int id;
    private String badgetype;
    private String badgeimage;
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBadgetype() {
        return badgetype;
    }

    public void setBadgetype(String badgetype) {
        this.badgetype = badgetype;
    }

    public String getBadgeimage() {
        return badgeimage;
    }

    public void setBadgeimage(String badgeimage) {
        this.badgeimage = badgeimage;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Badge(int id, String badgetype, String badgeimage, int userid) {
        this.id = id;
        this.badgetype = badgetype;
        this.badgeimage = badgeimage;
        this.userid = userid;
    }

    public Badge() {
    }

    public Badge(String badgetype, String badgeimage, int userid) {
        this.badgetype = badgetype;
        this.badgeimage = badgeimage;
        this.userid = userid;
    }

    public Badge(String badgetype, String badgeimage) {
        this.badgetype = badgetype;
        this.badgeimage = badgeimage;
    }

    @Override
    public String toString() {
        return "Badge{" + "id=" + id + ", badgetype=" + badgetype + ", badgeimage=" + badgeimage + ", userid=" + userid + '}';
    }
    
    
    
}
