/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author SBS
 */
public class user {
    public long userID;
    private String userNAME;
    public long badgeID;
    private int karmaCOUNT;
    private String userIMAGE;

    public user() {
    }

    public user(long userID, String userNAME, long badgeID, int karmaCOUNT, String userIMAGE) {
        this.userID = userID;
        this.userNAME = userNAME;
        this.badgeID = badgeID;
        this.karmaCOUNT = karmaCOUNT;
        this.userIMAGE = userIMAGE;
    }

    public user(String userNAME, long badgeID, int karmaCOUNT, String userIMAGE) {
        this.userNAME = userNAME;
        this.badgeID = badgeID;
        this.karmaCOUNT = karmaCOUNT;
        this.userIMAGE = userIMAGE;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserNAME() {
        return userNAME;
    }

    public void setUserNAME(String userNAME) {
        this.userNAME = userNAME;
    }

    public long getBadgeID() {
        return badgeID;
    }

    public void setBadgeID(long badgeID) {
        this.badgeID = badgeID;
    }

    public int getKarmaCOUNT() {
        return karmaCOUNT;
    }

    public void setKarmaCOUNT(int karmaCOUNT) {
        this.karmaCOUNT = karmaCOUNT;
    }

    public String getUserIMAGE() {
        return userIMAGE;
    }

    public void setUserIMAGE(String userIMAGE) {
        this.userIMAGE = userIMAGE;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.userID ^ (this.userID >>> 32));
        hash = 97 * hash + Objects.hashCode(this.userNAME);
        hash = 97 * hash + (int) (this.badgeID ^ (this.badgeID >>> 32));
        hash = 97 * hash + this.karmaCOUNT;
        hash = 97 * hash + Objects.hashCode(this.userIMAGE);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final user other = (user) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (this.badgeID != other.badgeID) {
            return false;
        }
        if (this.karmaCOUNT != other.karmaCOUNT) {
            return false;
        }
        if (!Objects.equals(this.userNAME, other.userNAME)) {
            return false;
        }
        return Objects.equals(this.userIMAGE, other.userIMAGE);
    }

    @Override
    public String toString() {
        return "user{" + "userID=" + userID + ", userNAME=" + userNAME + ", badgeID=" + badgeID + ", karmaCOUNT=" + karmaCOUNT + ", userIMAGE=" + userIMAGE + '}';
    }
    
    
    
    
}
