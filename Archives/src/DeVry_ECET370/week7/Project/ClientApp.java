package week7.Project;

//import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.HashMap;


public final class ClientApp {
	
	final static String FILE_NAME = "C:\\Temp\\socialNetwork.txt";
	
	//private BufferedOutputStream out;  // the output stream
	  	  
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		
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
        
        // save Social Network data
        
        System.out.println("Saving file ...");
        saveToFile(mySocialNetwork);
        
		// load Social Network data
        System.out.println("Loading file ...");
		SocialNetwork loadedNetwork = loadFromFile();
        //HashMap<String, Member> hm = loadFromFile();
        //SocialNetwork loadedNetwork = new SocialNetwork();
		//LoginGUI login = new LoginGUI(network);
		
		System.out.println("--- Saved and Reloaded network; Now try displaying contents --- ");
		
        //Display profiles of individuals previously added
        bob = loadedNetwork.findProfile("Bob");       
        System.out.println(bob.getName());
        System.out.println(bob.getPassword());
        System.out.println(bob.getStatus());
        System.out.print("Friends: ");
        for (String friend : bob.getFriends())
        	System.out.print(friend + ", ");
        System.out.println();
        System.out.println();
        
        ed = loadedNetwork.findProfile("Ed");       
        System.out.println(ed.getName());
        System.out.println(ed.getPassword());
        System.out.println(ed.getStatus());
        System.out.print("Friends: ");
        for (String friend : ed.getFriends())
        	System.out.print(friend + ", ");
        System.out.println();
        System.out.println();
                
        doug = loadedNetwork.findProfile("Doug Woolley");       
        System.out.println(doug.getName());
        System.out.println(doug.getPassword());
        System.out.println(doug.getStatus());
        System.out.print("Friends: ");
        for (String friend : doug.getFriends())
        	System.out.print(friend + ", ");
        System.out.println();
        System.out.println();
	}
	
	//Network.dat, a binary data file
	/**
	 * 
	 * @return SocialNetwork that was previously saved on File
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */

	public static SocialNetwork loadFromFile()  {
	//public static HashMap<String, Member> loadFromFile() {
//        File toRead=new File(FILE_NAME);
//        FileInputStream fis=new FileInputStream(toRead);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(FILE_NAME);
        }
        catch (IOException e) {
            System.out.println("1");
        }
        
        try {
            ois=new ObjectInputStream(fis);
        }
        catch(FileNotFoundException e) {
            System.out.println("2");
        }
        catch(IOException e) {
            System.out.println("4");
        }

        SocialNetwork sn = null;
        //HashMap<String, Member> users = null;
        try {
           // HashMap<String, Member> hm = (HashMap) ois.readObject();
        	//users = (HashMap<String, Member>) ois.readObject();
        	//sn.setUsers(users);
        	sn = (SocialNetwork) ois.readObject();
        }
        catch (ClassNotFoundException e) {
            System.out.println("5");
        }
        catch (IOException e) {
            System.out.println("6");
        }

        try {
            ois.close();
            fis.close();
        }
        catch (IOException e) {
            System.out.println("3");
        }
        
        //HashMap<String,String> mapInFile=(HashMap<String,String>)ois.readObject();
       // HashMap<String,Member> hm = (HashMap) ois.readObject();

        //ois.close();
        //fis.close();
        
//	    File file = new File(FILE_NAME);
//	    FileInputStream f = new FileInputStream(file);
//	    ObjectInputStream s = new ObjectInputStream(f);
//	    //HashMap<String, Object> fileObj2 = (HashMap<String, Object>) s.readObject();
//    
//		SocialNetwork sn = (SocialNetwork) s.readObject();
//	    s.close();
        
		return sn;
	}
	
	/**
	 * 
	 * @param network to save to File, to be loaded later as Social Network
	 * @throws IOException 
	 */
	public static void saveToFile(SocialNetwork network) throws IOException {
	    try{
	    	//HashMap<String, Member> users = network.getUsers();
	    	//users = (HashMap<String, Member>) network;
	    	
	        File fileOne=new File(FILE_NAME);
	        FileOutputStream fos=new FileOutputStream(fileOne);
	            ObjectOutputStream oos=new ObjectOutputStream(fos);

	            //oos.writeObject(users);
	            oos.writeObject(network);
	            oos.flush();
	            oos.close();
	            fos.close();
	            //Serialized HsahMap data is saved
	        }catch(Exception e){}
	    
	    
//        File file = new File(OUTPUT_FILE_NAME);
//        FileOutputStream f = new FileOutputStream(file);
//        ObjectOutputStream s = new ObjectOutputStream(f);
//        s.writeObject(network);
//        s.close();
	}
}
