package week7.Project_Final.edu.devry.MekWeyWoo.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Data Structure to represent a member with or without a profile and friends.
 * @author Robert Weymouth
 */
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name, password, currentStatus;
	private ArrayList<String> friends;	// arraylist to store the friends "names"    
	
	/**
	 * Member constructor to initialize arraylist to hold friends
	 * and set the name and initial password of the member. 
	 * 
	 * @param name of member
	 * @param password of member
	 */
	public Member(String name, String password) {
		friends = new ArrayList<String>();
		this.name = name;
		this.password = password;
	}
	
	/**
	 * Sets the users current status.
	 * 
	 * @param status of user
	 */
	public void setStatus(String status) {
	    currentStatus = status;
	}

    /**
     * Adds the member friend to the end of the friends list,
     * if the friend does not already exist in the friends list.
     *
     * @param friend to be added to the friends list
     * @return true if friend was added or false if friend was not added
     */
    public boolean addFriend(Member friend) {  
    	if (friends.contains(friend.getName())) return false;
	   	friends.add(friend.getName());
	   	return true;
    }

    /**
     * Removes the member friend from the friends list,
     * if the friend exists in the friends list.
     *
     * @param friend to be removed to the friends list
     * @return true if friend was removed or false if friend was not removed
     */
    public boolean removeFriend(Member friend) {
    	if (!friends.contains(friend.getName())) return false;
	   	friends.remove(friend.getName());
	   	return true;
    }
    
    /**
     * Verifies if member has a specific friend in the friends
     * list and returns true or false.
     * 
     * @param friend to be verified as existing in the friends list
     * @return true if person's name is in friends list; false otherwise
     */
    public boolean hasFriend(Member friend) {
		return friends.contains(friend.getName());        
    }
	
	/**
	 * Gets the user's current name.
	 * 
	 * @return name of user
	 */
	public String getName() {
	   return name;
	}
	
	/**
	 * Gets the user's current password.
	 * 
	 * @return password of user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Gets the user's current status.
	 * 
	 * @return current Status of user
	 */
	public String getStatus() {
	    return currentStatus;
	}
		
	/**
     * Converts friends arraylist to an array and returns the array
     * 
     * @return array of friends
     */
	 public String[] getFriends(){
		 String[] friendsArray = new String[friends.size()];		 
		 return friendsArray = friends.toArray(friendsArray);
	 }
	 	    
    /**
     * Verifies whether member of the network has created a user profile
     * by checking whether the currentStatus has been populated.
	 *
     * @return true if member has created a profile; false if not
     */		
	public boolean hasProfile() {
		return currentStatus != null;	   
	}
	
    /**
     * Overloaded method to compare given member to other members.
	 *
     * @return true if member is equal to another member; false otherwise.
     */			
	public boolean equals(Object obj)
	{
		Member member = (Member)obj;

		return this.getName().equals(member.getName());
	}
	
	/**
	 * Sets the user's password.
	 * 
	 * @param newPassword new Password of user
	 */
	public void setPassword(String newPassword) {
	    password = newPassword;
	}
	
}