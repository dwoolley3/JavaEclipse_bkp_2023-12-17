package week7.Project_Final.edu.devry.MekWeyWoo.GUI;

import week7.Project_Final.edu.devry.MekWeyWoo.Data.*;
import week7.Project_Final.edu.devry.MekWeyWoo.SocialNetworkApp;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A Graphical User Interface (GUI) client for the SocialNetworkApp.
 * <p>
 * This class extends JFrame and is used to facilitate user interaction once logged into the
 * SocialNetworkApp. This GUI makes calls to the SocialNetwork & Member data structures to
 * display information as well as process actions initiated by the user.
 *
 * @author Eduard Mekler
 * @since 2016-02-15
 * @version 0.0.1-beta
 * @see JFrame
 * @see SocialNetwork
 * @see Member
 */
final class ApplicationGUI extends JFrame {
    /* Object Attributes */

	private static final long serialVersionUID = 1L;
	/* Logic Attributes */
    private SocialNetwork network;          // The SocialNetwork data structure
    private Member sessionUser;             // Member currently logged into SocialNetworkApp
    private Member viewedUser;              // Member currently being viewed by SocialNetworkApp
    private ApplicationAction search;       // ApplicationGUI SEARCH GUIAction which can be disabled
    private ApplicationAction add;          // ApplicationGUI ADD GUIAction which can be disabled
    private ApplicationAction remove;       // ApplicationGUI REMOVE GUIAction which can be disabled

    /* GUI Attributes */
    private JTextField jtfFindProfile;      // JTextField containing profile search string
    @SuppressWarnings("rawtypes")
	private JList jltMyFriends;             // JList displaying sessionUser's friends
    private JTextField jtfProfileName;      // JTextField displaying viewedUser's profile name
    private JTextField jtfProfileStatus;    // JTextField displaying viewedUser's profile status
    @SuppressWarnings("rawtypes")
	private JList jltProfileFriends;        // JList displaying viewedUser's friends

    /* Constructors */
    /**
     * Instantiates an ApplicationGUI displaying profile of the logged in user.
     * <p>
     * Assumes the username string is a valid user due to passing the login process in LoginGUI.
     * @param network SocialNetwork object containing user data.
     * @param username String username of logged in user.
     */
    ApplicationGUI(SocialNetwork network, String username) {
        super("Social Network");
        this.network = network;
        sessionUser = network.findProfile(username);

        add(setupNavigationalPanel(), BorderLayout.NORTH);
        add(setupMainDisplay(), BorderLayout.CENTER);
        add(setupActionPanel(), BorderLayout.SOUTH);

        addWindowListener(new WindowCloseListener());

        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        navigateToHome();
    }

    /* Private Methods */

    /* Logic Methods */
    /**
     * Checks whether the user has created a profile and displays user's profile if it has been created.
     * Otherwise, prompts the user to create a profile.
     */
    @SuppressWarnings("unchecked")
	private void navigateToHome() {
        sessionUser = network.findProfile(sessionUser.getName());

        if(!sessionUser.hasProfile()) {
            setActionStatus(false, false, false);
            JOptionPane.showMessageDialog(null, "Please create a profile!");
            updateProfile();
        }
        else {
            viewedUser = sessionUser;
            jltMyFriends.setListData(sessionUser.getFriends());
            displayProfile();
            setActionStatus(true, false, false);
        }
    }

    /**
     * Prompts the user for a new status. If a status is entered then it is updated in the
     * user's profile in the network data structure.
     */
    private void updateProfile() {
        String statusInput;

        statusInput = JOptionPane.showInputDialog(this, "Enter your new status: ");

        if(statusInput != null) {
            network.updateProfile(statusInput, sessionUser);
            navigateToHome();
        }
    }

    /**
     * Deletes the user's profile on the network and exits the application.
     */
    private void leaveNetwork() {
        network.leaveNetwork(sessionUser);
        exitApplication();
    }

    /**
     * Searches for a user's profile and displays it if it is found on the network.
     */
    private void searchForProfile() {
        String searchName;

        searchName = jtfFindProfile.getText();
        viewedUser = network.findProfile(searchName);

        if (viewedUser == null) {
            JOptionPane.showMessageDialog(this, "Could not find the user you searched for.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            displayProfile();
        }
    }

    /**
     * Adds viewed user to logged in user's friends list and refreshes the profile display.
     */
    private void addViewedUser() {
        boolean added;
        added = network.addFriend(viewedUser, sessionUser);

        if(added) {
            JOptionPane.showMessageDialog(this, viewedUser.getName() + " has been added to friends!");
            refreshDisplay();
        } else {
            JOptionPane.showMessageDialog(this, viewedUser.getName() + " could not be added.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Removes viewed user fro logged in user's friends list and refreshes the profile display.
     */
    private void removeViewedUser() {
        boolean removed;
        removed = network.removeFriend(viewedUser, sessionUser);

        if (removed) {
            JOptionPane.showMessageDialog(this, viewedUser.getName() + " has been removed from friends.");
            refreshDisplay();
        } else {
            JOptionPane.showMessageDialog(this, viewedUser.getName() + " could not be removed.", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Sets the status of the search, add, and remove function based on the client's actions in the application.
     * <p>
     * Searching is only enabled after creating a profile. Once a profile is created it is always enabled.
     * Adding a friend is only enabled after a profile is found that is not currently on the user's friends list.
     * Removed a friend is only enabled after a profile is found that is currently on the user's friends list.
     * @param searchEnabled true if the search action should be enabled otherwise false.
     * @param addEnabled true if the add friend action should be enabled otherwise false.
     * @param removeEnabled true if the remove friend action should be enabled otherwise false.
     */
    private void setActionStatus(boolean searchEnabled, boolean addEnabled, boolean removeEnabled) {
        search.setEnabled(searchEnabled);
        add.setEnabled(addEnabled);
        remove.setEnabled(removeEnabled);
    }

    /**
     * Saves the current network data to a file and exits the application.
     */
    private void exitApplication() {
        SocialNetworkApp.saveToFile(network);
        this.dispose();
        System.exit(0);
    }

    /* GUI Methods */
    /**
     * Return a JPanel containing the application navigation elements for going home and finding a profile.
     * @return a JPanel containing the application navigation elements for going home and finding a profile.
     */
    private JPanel setupNavigationalPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        search = new ApplicationAction(GUIAction.SEARCH);

        panel.add(new JButton(new ApplicationAction(GUIAction.HOME)));
        panel.add(new JLabel("Find Profile: "));
        jtfFindProfile = new JTextField(20);
        panel.add(jtfFindProfile);
        panel.add(new JButton(search));

        return panel;
    }

    /**
     * Returns a JPanel containing the main display section of the GUI containing the currently viewed profile
     * and session user's friends list.
     * @return a JPanel containing the main display portion of the GUI.
     */
    @SuppressWarnings("rawtypes")
	private JPanel setupMainDisplay() {
        JPanel panel = new JPanel(new GridLayout(1,2));

        jltMyFriends = new JList();

        panel.add(setupProfilePanel());
        panel.add(setupFriendsPanel(jltMyFriends, "My Friends"));

        return panel;
    }

    /**
     * Returns a JPanel containing the GUI required to display the currently viewed profile.
     * @return a JPanel containing the GUI required to display the currently viewed profile.
     */
    @SuppressWarnings("rawtypes")
	private JPanel setupProfilePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        jltProfileFriends = new JList();

        jtfProfileName = new JTextField(20);
        jtfProfileName.setEditable(false);

        jtfProfileStatus = new JTextField(20);
        jtfProfileStatus.setEditable(false);

        // Setup Name Display
        JPanel superSubPanel = new JPanel(new GridLayout(2,1));
        JPanel subpanel = new JPanel(new FlowLayout());
        subpanel.add(new JLabel("Name: "));
        subpanel.add(jtfProfileName);
        superSubPanel.add(subpanel);

        // Setup Status Display
        subpanel = new JPanel(new FlowLayout());
        subpanel.add(new JLabel("Status: "));
        subpanel.add(jtfProfileStatus);
        superSubPanel.add(subpanel);
        panel.add(superSubPanel, BorderLayout.NORTH);

        // Setup Friends List Display
        subpanel = new JPanel();
        subpanel = setupFriendsPanel(jltProfileFriends, "Profile Friends List");
        panel.add(subpanel, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Returns a JPanel containing GUI elements required to display a friends list.
     * @return a JPanel containing GUI elements required to display a friends list.
     */
    @SuppressWarnings("rawtypes")
	private JPanel setupFriendsPanel(JList list, String listTitle) {
        JPanel panel = new JPanel(new BorderLayout());

        // Setup My Friends Title
        JPanel subpanel = new JPanel();
        subpanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,15,0,15), new LineBorder((Color.BLACK))));
        subpanel.add(new JLabel(listTitle));
        panel.add(subpanel, BorderLayout.NORTH);

        // Setup Friends JList
        subpanel = new JPanel();
        subpanel.add(new JScrollPane(list));

        // Configure JList Appearance
        list.setFixedCellWidth(250);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(subpanel, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Returns a JPanel containing the update, add, remove, and leave action buttons.
     * @return a JPanel containing the update, add, remove, and leave action buttons.
     */
    private JPanel setupActionPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        add = new ApplicationAction(GUIAction.ADD);
        remove = new ApplicationAction(GUIAction.REMOVE);

        panel.add(new JButton(new ApplicationAction(GUIAction.UPDATE)));
        panel.add(new JButton(add));
        panel.add(new JButton(remove));
        panel.add(new JButton(new ApplicationAction(GUIAction.LEAVE)));

        return panel;
    }

    /**
     * Displays the currently viewed user in the profile display area. If the user is a friend
     * of the session then all information is displayed and the remove friend action is enabled. Otherwise,
     * only public information is displayed and the add friend action is enabled.
     */
    @SuppressWarnings("unchecked")
	private void displayProfile() {
        if (sessionUser.hasFriend(viewedUser) || viewedUser.equals(sessionUser)) {
            jtfProfileName.setText(viewedUser.getName());
            jtfProfileStatus.setText(viewedUser.getStatus());
            jltProfileFriends.setListData(viewedUser.getFriends());
            if (viewedUser.equals(sessionUser)) {
                setActionStatus(true, false, false);
            } else {
                setActionStatus(true, false, true);
            }
        } else {
            String[] privateText = {"Private"};
            jtfProfileName.setText(viewedUser.getName());
            jtfProfileStatus.setText(privateText[0]);
            jltProfileFriends.setListData(privateText);
            setActionStatus(true, true, false);
        }
    }

    /**
     * Refreshes the display by syncing the sessionUser with the network stored sessionUser and redisplaying
     * the sessionUser friend's list and currently viewed profile.
     */
    @SuppressWarnings("unchecked")
	private void refreshDisplay() {
        sessionUser = network.findProfile(sessionUser.getName());
        jltMyFriends.setListData(sessionUser.getFriends());
        displayProfile();
    }

    /* Inner classes */
    /**
     * A private inner enumeration representing the actions that the user can perform through the Application GUI.
     */
    private enum GUIAction {HOME, UPDATE, LEAVE, SEARCH, ADD, REMOVE};

    /**
     * A private inner class that defines the actions performed when the GUI button events are fired.
     */
    @SuppressWarnings("serial")
	private class ApplicationAction extends AbstractAction {
        private String name;
        private GUIAction actionType;

        /**
         * Instantiates a new ApplicationAction object that performs the action provided to the constructor.
         * @param action GUIAction enum type indicating this ApplicationAction object's action.
         */
        private ApplicationAction(GUIAction action) {
            actionType = action;

            switch (actionType) {
                case HOME:
                    name = "Home";
                    break;
                case UPDATE:
                    name = "Update Profile";
                    break;
                case LEAVE:
                    name = "Leave Network";
                    break;
                case SEARCH:
                    name = "Search";
                    break;
                case ADD:
                    name = "Add Friend";
                    break;
                case REMOVE:
                    name = "Remove Friend";
                    break;
            }

            putValue(Action.NAME, name);
        }

        /**
         * Calls ApplicationGUI logic methods based on the actionType of this ApplicationAction object.
         * @param e ActionEvent fired when this ApplicationAction's registered GUI element is used.
         */
        public void actionPerformed(ActionEvent e) {
            switch (actionType) {
                case HOME:
                    navigateToHome();
                    break;
                case UPDATE:
                    updateProfile();
                    break;
                case LEAVE:
                    leaveNetwork();
                    break;
                case SEARCH:
                    searchForProfile();
                    break;
                case ADD:
                    addViewedUser();
                    break;
                case REMOVE:
                    removeViewedUser();
                    break;
            }
        }
    }

    /**
     * Private inner class which ensure that the application exits properly when the user closes the JFrame.
     */
    private class WindowCloseListener extends WindowAdapter {
        /**
         * Calls the exitApplication() method.
         * @param e WindowEvent fired when JFrame is closing.
         */
        public void windowClosing(WindowEvent e) {
            exitApplication();
        }
    }
}
