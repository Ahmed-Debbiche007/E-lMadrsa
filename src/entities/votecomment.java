/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author SBS
 */
public class votecomment {
    private long votecommentID,userID,commentID;
    private int votenb;

    public votecomment() {
    }

    public votecomment(long userID, long commentID) {
        this.userID = userID;
        this.commentID = commentID;
    }

    public votecomment(long userID, long commentID, int votenb) {
        this.userID = userID;
        this.commentID = commentID;
        this.votenb = votenb;
    }
    
    
    
    
    
    
    
    

    public long getVotecommentID() {
        return votecommentID;
    }

    public void setVotecommentID(long votecommentID) {
        this.votecommentID = votecommentID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getCommentID() {
        return commentID;
    }

    public void setCommentID(long commentID) {
        this.commentID = commentID;
    }

    public int getVotenb() {
        return votenb;
    }

    public void setVotenb(int votenb) {
        this.votenb = votenb;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
