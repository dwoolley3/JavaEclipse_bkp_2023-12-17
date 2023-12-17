package week7.Project;

/**************************************
*  Week 7-8 Course Project            *
***************************************/

/**
 * Class testing the Social Network.
 */
public class Main
{

    public static void main(String[] args)
    {
        SocialNetwork mySocialNetwork = new SocialNetwork();
        
        //Add individuals to the Social Network
        String username = "Doug Woolley", password="password000";
        mySocialNetwork.joinNetwork(username, password);        
        mySocialNetwork.login(username, password);
        mySocialNetwork.createProfile("This is my first status post!");        
        
        username = "Ed";
        password="password123";
        mySocialNetwork.joinNetwork(username, password);        
        mySocialNetwork.login(username, password);
        mySocialNetwork.createProfile("This is my initial status post!");        
        mySocialNetwork.addFriend("Doug Woolley");
        
        username = "Bob";
        password="password345";
        mySocialNetwork.joinNetwork(username, password);        
        mySocialNetwork.login(username, password);
        mySocialNetwork.createProfile("This is my starter status post!");        
        mySocialNetwork.addFriend("Doug Woolley");
        mySocialNetwork.addFriend("Ed");

        //Display profiles of individuals previously added
        Member bob = mySocialNetwork.findProfile("Bob");       
        System.out.println(bob.getName());
        System.out.println(bob.getPassword());
        System.out.println(bob.getStatus());
        System.out.print("Friends: ");
        for (String friend : bob.getFriends())
        	System.out.print(friend + ", ");
        System.out.println();
        System.out.println();
        
        Member ed = mySocialNetwork.findProfile("Ed");       
        System.out.println(ed.getName());
        System.out.println(ed.getPassword());
        System.out.println(ed.getStatus());
        System.out.print("Friends: ");
        for (String friend : ed.getFriends())
        	System.out.print(friend + ", ");
        System.out.println();
        System.out.println();
                
        Member doug = mySocialNetwork.findProfile("Doug Woolley");       
        System.out.println(doug.getName());
        System.out.println(doug.getPassword());
        System.out.println(doug.getStatus());
        System.out.print("Friends: ");
        for (String friend : doug.getFriends())
        	System.out.print(friend + ", ");
        System.out.println();
        System.out.println();

    }
}
