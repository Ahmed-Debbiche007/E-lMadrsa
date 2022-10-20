/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.sql.Timestamp;


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author SBS
 */
public class post {
    public long postID;
    private String postTITLE;
    private String postCONTENT;
    public long userID;
    public long categoryID;
    private int postVOTE;
    private int postNBCOM;
    private Timestamp postDATE;

    public post() {
    }

    public post(long postID,String postTITLE, String postCONTENT) {
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
        this.postID = postID;
    }

    public post(long postID, String postTITLE, String postCONTENT, long userID) {
        this.postID = postID;
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
        this.userID = userID;
    }

    public post(String postTITLE, String postCONTENT) {
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
    }

   
  
    

    public post(long postID, String postTITLE, String postCONTENT, long userID, long categoryID, int postVOTE, int postNBCOM) {
        this.postID = postID;
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
        this.userID = userID;
        this.categoryID = categoryID;
        this.postVOTE = postVOTE;
        this.postNBCOM = postNBCOM;
    }

    public post(long postID, String postTITLE, String postCONTENT, long userID, long categoryID, int postVOTE, int postNBCOM, Timestamp postDATE) {
        this.postID = postID;
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
        this.userID = userID;
        this.categoryID = categoryID;
        this.postVOTE = postVOTE;
        this.postNBCOM = postNBCOM;
        this.postDATE = postDATE;
    }

    public post(String postTITLE, String postCONTENT, long userID, long categoryID, int postVOTE, int postNBCOM, Timestamp postDATE) {
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
        this.userID = userID;
        this.categoryID = categoryID;
        this.postVOTE = postVOTE;
        this.postNBCOM = postNBCOM;
        this.postDATE = postDATE;
    }



    public post(String postTITLE, String postCONTENT, long userID, long categoryID, int postVOTE, int postNBCOM) {
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
        this.userID = userID;
        this.categoryID = categoryID;
        this.postVOTE = postVOTE;
        this.postNBCOM = postNBCOM;
    }

    public post(String postTITLE, String postCONTENT, int postVOTE, int postNBCOM) {
        this.postTITLE = postTITLE;
        this.postCONTENT = postCONTENT;
        this.postVOTE = postVOTE;
        this.postNBCOM = postNBCOM;
    }

 

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public String getPostTITLE() {
        return postTITLE;
    }

    public void setPostTITLE(String postTITLE) {
        this.postTITLE = postTITLE;
    }

    public String getPostCONTENT() {
        return postCONTENT;
    }

    public void setPostCONTENT(String postCONTENT) {
        this.postCONTENT = postCONTENT;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public int getPostVOTE() {
        return postVOTE;
    }

    public void setPostVOTE(int postVOTE) {
        this.postVOTE = postVOTE;
    }

    public int getPostNBCOM() {
        return postNBCOM;
    }

    public void setPostNBCOM(int postNBCOM) {
        this.postNBCOM = postNBCOM;
    }

    public Timestamp getPostDATE() {
        return postDATE;
    }

    public void setPostDATE(Timestamp postDATE) {
        this.postDATE = postDATE;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.postID ^ (this.postID >>> 32));
        hash = 59 * hash + Objects.hashCode(this.postTITLE);
        hash = 59 * hash + Objects.hashCode(this.postCONTENT);
        hash = 59 * hash + (int) (this.userID ^ (this.userID >>> 32));
        hash = 59 * hash + (int) (this.categoryID ^ (this.categoryID >>> 32));
        hash = 59 * hash + this.postVOTE;
        hash = 59 * hash + this.postNBCOM;
        hash = 59 * hash + Objects.hashCode(this.postDATE);
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
        final post other = (post) obj;
        if (this.postID != other.postID) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        if (this.categoryID != other.categoryID) {
            return false;
        }
        if (this.postVOTE != other.postVOTE) {
            return false;
        }
        if (this.postNBCOM != other.postNBCOM) {
            return false;
        }
        if (!Objects.equals(this.postTITLE, other.postTITLE)) {
            return false;
        }
        if (!Objects.equals(this.postCONTENT, other.postCONTENT)) {
            return false;
        }
        return Objects.equals(this.postDATE, other.postDATE);
    }

    @Override
    public String toString() {
        return "post{" + "postID=" + postID + ", postTITLE=" + postTITLE + ", postCONTENT=" + postCONTENT + ", userID=" + userID + ", categoryID=" + categoryID + ", postVOTE=" + postVOTE + ", postNBCOM=" + postNBCOM + ", postDATE=" + postDATE + '}';
    }
    
    
    
    
}
