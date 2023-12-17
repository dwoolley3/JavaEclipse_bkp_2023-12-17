package week7.Project_Final.edu.devry.MekWeyWoo.GUI;

import week7.Project_Final.edu.devry.MekWeyWoo.Data.SocialNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A Graphical User Interface (GUI) used to prompt a login or initiate account creation.
 * <p>
 * This class extends JFrame and is used to prompt the user for a username
 * and password. It also initiates the join network process by constructing
 * a JoinNetworkGUI. This GUI makes calls to the SocialNetwork data structure to validate
 * login the user.
 *
 * @author Eduard Mekler
 * @since 2016-02-10
 * @version 0.0.1-beta
 * @see SocialNetwork
 * @see JoinNetworkGUI
 * @see JFrame
 */
@SuppressWarnings("serial")
public final class LoginGUI extends JFrame {
    /* Object Attributes */
    private SocialNetwork network;          // Reference to the SocialNetwork data structure
    private JTextField jtfUsername;         // Text field to enter login username
    private JTextField jtfPassword;         // Text field to enter login password
    private LoginGUI self;                  // Reference to this LoginGUI object

    /* Object Constructors */
    /**
     * Creates a Login GUI screen.
     * @param network SocialNetwork object containing user data.
     */
    public LoginGUI(SocialNetwork network) {
        super("Login");
        this.network = network;
        self = this;

        add(setupInputFields(), BorderLayout.CENTER);
        add(setupButtons(), BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
	
	/* Protected Object Methods */

    /**
     * Attempts to login to the network. If success the application is launched. If unsuccessful
     * then feedback is provided via JOptionPane.
     * @param username
     * @param password
     */
	void login(String username, String password) {
		int response = network.login(username, password);

        switch(response) {
            case SocialNetwork.NO_SUCH_USER:
                JOptionPane.showMessageDialog(null,"There is no user registered to: " + username, "Warning",
                        JOptionPane.WARNING_MESSAGE);
                break;

            case SocialNetwork.WRONG_PASSWORD:
                JOptionPane.showMessageDialog(null, "The password you have entered is incorrect.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                break;

            case SocialNetwork.SUCCESS:
                this.dispose();
                new ApplicationGUI(network, username);
                break;

            default:
                JOptionPane.showMessageDialog(null, "An unexpected error has occurred during login.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
            }
	}

    /* Private Object Methods */
    /**
     * Returns a JPanel containing the username & password labels & fields.
     * @return  JPanel containing the username & password labels & fields.
     */
    private JPanel setupInputFields() {
        JPanel panel = new JPanel(new GridLayout(2,1));

        // Setup Username Input Field
        JPanel subPanel = new JPanel(new FlowLayout());
        subPanel.add(new JLabel("Username: "));
        jtfUsername = new JTextField(15);
        subPanel.add(jtfUsername);
        panel.add(subPanel);

        // Setup Password Input Field
        subPanel = new JPanel(new FlowLayout());
        subPanel.add(new JLabel("Password: "));
        jtfPassword = new JTextField(15);
        subPanel.add(jtfPassword);
        panel.add(subPanel);

        return panel;
    }

    /**
     * Returns a JPanel containing the Login & Join Network buttons.
     * @return JPanel containing the Login & Join Network buttons.
     */
    private JPanel setupButtons() {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(new JButton(new LoginAction()));
        panel.add(new JButton(new JoinAction()));

        return panel;
    }

    /* Inner Classes */
    /**
     * A private inner class which defines the Login Button behavior.
     * @author Eduard Mekler
     */
    private class LoginAction extends AbstractAction {
        private LoginAction() {
            super("Login");
        }

        /**
         * Validates the user's username and password inputs. If valid, calls the login() method.
         * @param e ActionEvent created when button is clicked.
         */
        public void actionPerformed(ActionEvent e) {
            String username, password;

            username = jtfUsername.getText();
            password = jtfPassword.getText();

            if(username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a username.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a password.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                login(username, password);
            }
        }
    }

    /**
     * A private inner class which defines the Join Network Button behavior.
     * @author Eduard Mekler
     */
    private class JoinAction extends AbstractAction {
        private JoinAction() {
            super("Join Network");
        }

        /**
         * Hides Login GUI Screen and instantiates a Join Network GUI Screen.
         * @param e ActionEvent created when button is clicked.
         */
        public void actionPerformed(ActionEvent e) {
            self.setVisible(false);
            new JoinNetworkGUI(network, self);
        }
    }
}
