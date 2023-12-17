package week7.Project_Final.edu.devry.MekWeyWoo;

import week7.Project_Final.edu.devry.MekWeyWoo.Data.*;
import week7.Project_Final.edu.devry.MekWeyWoo.GUI.LoginGUI;

import javax.swing.*;
import java.io.*;

/**
 * DeVry ECET-370-13052 Course Project.
 * Team Members: Eduard Mekler, Robert Weymouth, Douglas Woolley
 * <p>
 * This project creates a small GUI application which simulates a SocialNetwork.
 *
 * @author Eduard Mekler
 * @since 2016-02-11
 * @version v1.0.0
 */
public final class SocialNetworkApp {
    private final static File networkFile = new File("socialNetwork.dat");  // File to store SocialNetwork data.

    /**
     * Application Entry Point.
     * @param args Not used.
     */
    public static void main(String[] args) {
        SocialNetwork network = loadFromFile();
        @SuppressWarnings("unused")
		LoginGUI login = new LoginGUI(network);
    }

    /**
     * Loads the saved SocialNetwork data structure from a binary data file if the file exists. Otherwise,
     * creates a new SocialNetwork data structure.
     * @return The SocialNetwork data structure loaded from the file.
     */
    public static SocialNetwork loadFromFile() {
        SocialNetwork network = null;

        if(!networkFile.exists()) {
            network = new SocialNetwork();
            return network;
        } else {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(networkFile));
                network = (SocialNetwork)in.readObject();

                in.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "The following exception occurred: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            return network;
        }
    }

    /**
     * Saves the SocialNetwork data structure to a binary data file so that user information
     * can persist between launches of the application.
     * @param network The SocialNetwork data structure to be saved.
     */
    public static void saveToFile(SocialNetwork network) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(networkFile));

            out.writeObject(network);

            out.close();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "The following exception occurred: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


    /**
     * This function is used for testing purposes only.
     * <p>
     * This function loads users into the socialNetwork manually to be able to verify the functionality
     * of the program. This was used before the save / load functions were completed. With the save / load
     * functions you can test the system organically by creating new users and logging into the various users.
     * @return A SocialNetwork data structure with pre-defined users.
     */
    public static SocialNetwork manualLoad() {
        // Test for having data in network manually //
        SocialNetwork mySocialNetwork = new SocialNetwork();

        //Add individuals to the Social Network
        String username = "Doug Woolley", password="password000";
        mySocialNetwork.joinNetwork(username, password);
        Member doug = mySocialNetwork.findProfile(username);
        mySocialNetwork.updateProfile("This is my first status post!", doug);

        username = "Ed Mekler";
        password="password123";
        mySocialNetwork.joinNetwork(username, password);
        Member ed = mySocialNetwork.findProfile(username);
        mySocialNetwork.updateProfile("This is my initial status post!", ed);
        mySocialNetwork.addFriend(doug, ed);

        username = "Bob Weymouth";
        password="password345";
        mySocialNetwork.joinNetwork(username, password);
        Member bob = mySocialNetwork.findProfile(username);
        mySocialNetwork.updateProfile("This is my starter status post!", bob);
        mySocialNetwork.addFriend(doug, bob);
        mySocialNetwork.addFriend(ed, bob);

        return mySocialNetwork;
    }
}
