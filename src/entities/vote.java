/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author aymen
 */
public class vote {
    
    private long voteID,userID,postID;
    private int votenb;

    public vote(long voteID, long userID, long postID, int votenb) {
        this.voteID = voteID;
        this.userID = userID;
        this.postID = postID;
        this.votenb = votenb;
    }

    public vote(long userID, long postID, int votenb) {
        this.userID = userID;
        this.postID = postID;
        this.votenb = votenb;
    }

    public vote(long userID, long postID) {
        this.userID = userID;
        this.postID = postID;
        
    }
    
  

    

    public vote() {
    }
    

    public long getVoteID() {
        return voteID;
    }

    public void setVoteID(long voteID) {
        this.voteID = voteID;
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

  
    public int getVotenb() {
        return votenb;
    }

    public void setVote(int votenb) {
        this.votenb = votenb;
    }

    @Override
    public String toString() {
        return "vote{" + "voteID=" + voteID + ", userID=" + userID + ", postID=" + postID + ", votenb=" + votenb + '}';
    }

    
    
}
