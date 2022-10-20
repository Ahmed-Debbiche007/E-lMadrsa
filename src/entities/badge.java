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
public class badge {
    public long badgeID;
    private String badgeTYPE;
    private String badgeIMAGE;

    public badge() {
    }

    public badge(long badgeID, String badgeTYPE, String badgeIMAGE) {
        this.badgeID = badgeID;
        this.badgeTYPE = badgeTYPE;
        this.badgeIMAGE = badgeIMAGE;
    }

    public badge(String badgeTYPE, String badgeIMAGE) {
        this.badgeTYPE = badgeTYPE;
        this.badgeIMAGE = badgeIMAGE;
    }

    public long getBadgeID() {
        return badgeID;
    }

    public void setBadgeID(long badgeID) {
        this.badgeID = badgeID;
    }

    public String getBadgeTYPE() {
        return badgeTYPE;
    }

    public void setBadgeTYPE(String badgeTYPE) {
        this.badgeTYPE = badgeTYPE;
    }

    public String getBadgeIMAGE() {
        return badgeIMAGE;
    }

    public void setBadgeIMAGE(String badgeIMAGE) {
        this.badgeIMAGE = badgeIMAGE;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.badgeID ^ (this.badgeID >>> 32));
        hash = 43 * hash + Objects.hashCode(this.badgeTYPE);
        hash = 43 * hash + Objects.hashCode(this.badgeIMAGE);
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
        final badge other = (badge) obj;
        if (this.badgeID != other.badgeID) {
            return false;
        }
        if (!Objects.equals(this.badgeTYPE, other.badgeTYPE)) {
            return false;
        }
        return Objects.equals(this.badgeIMAGE, other.badgeIMAGE);
    }

    @Override
    public String toString() {
        return "badge{" + "badgeID=" + badgeID + ", badgeTYPE=" + badgeTYPE + ", badgeIMAGE=" + badgeIMAGE + '}';
    }
    
    
    
    
    
    
}
