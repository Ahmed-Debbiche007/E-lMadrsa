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
public class comment {
    public long commentID;
    private String commentCONTENT;
    public long userID;
    public long postID;
    private int commentVOTE;
    private Timestamp commentDATE;

    public comment() {
    }

    public comment(long commentID, String commentCONTENT, long userID, long postID, int commentVOTE, Timestamp commentDATE) {
        this.commentID = commentID;
        this.commentCONTENT = commentCONTENT;
        this.userID = userID;
        this.postID = postID;
        this.commentVOTE = commentVOTE;
        this.commentDATE = commentDATE;
    }

    

    public comment(String commentCONTENT, long userID, long postID, int commentVOTE, Timestamp commentDATE) {
        this.commentCONTENT = commentCONTENT;
        this.userID = userID;
        this.postID = postID;
        this.commentVOTE = commentVOTE;
        this.commentDATE = commentDATE;
    }

    public comment(String commentCONTENT, long userID, long postID, int commentVOTE) {
        this.commentCONTENT = commentCONTENT;
        this.userID = userID;
        this.postID = postID;
        this.commentVOTE = commentVOTE;
    }

    public comment(String commentCONTENT) {
        this.commentCONTENT = commentCONTENT;
    }

    public comment(long commentID, String commentCONTENT) {
        this.commentID = commentID;
        this.commentCONTENT = commentCONTENT;
    }
    
    
    public long getCommentID() {
        return commentID;
    }

    public void setCommentID(long commentID) {
        this.commentID = commentID;
    }

    public String getCommentCONTENT() {
        return commentCONTENT;
    }

    public void setCommentCONTENT(String commentCONTENT) {
        this.commentCONTENT = commentCONTENT;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public int getCommentVOTE() {
        return commentVOTE;
    }

    public void setCommentVOTE(int commentVOTE) {
        this.commentVOTE = commentVOTE;
    }

    public Timestamp getCommentDATE() {
        return commentDATE;
    }

    public void setCommentDATE(Timestamp commentDATE) {
        this.commentDATE = commentDATE;
    }

  
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.commentID ^ (this.commentID >>> 32));
        hash = 97 * hash + Objects.hashCode(this.commentCONTENT);
        hash = 97 * hash + (int) (this.userID ^ (this.userID >>> 32));
        hash = 97 * hash + (int) (this.postID ^ (this.postID >>> 32));
        hash = 97 * hash + this.commentVOTE;
        hash = 97 * hash + Objects.hashCode(this.commentDATE);
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
        final comment other = (comment) obj;
        if (this.commentID != other.commentID) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        if (this.postID != other.postID) {
            return false;
        }
        if (this.commentVOTE != other.commentVOTE) {
            return false;
        }
        if (!Objects.equals(this.commentCONTENT, other.commentCONTENT)) {
            return false;
        }
        return Objects.equals(this.commentDATE, other.commentDATE);
    }

    @Override
    public String toString() {
        return "comment{" + "commentID=" + commentID + ", commentCONTENT=" + commentCONTENT + ", userID=" + userID + ", postID=" + postID + ", commentVOTE=" + commentVOTE + ", commentDATE=" + commentDATE + '}';
    }
    
    
    
    
    
}
