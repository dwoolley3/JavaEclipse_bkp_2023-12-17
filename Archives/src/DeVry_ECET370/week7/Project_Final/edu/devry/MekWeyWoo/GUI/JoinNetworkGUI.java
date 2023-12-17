package week7.Project_Final.edu.devry.MekWeyWoo.GUI;

import week7.Project_Final.edu.devry.MekWeyWoo.Data.SocialNetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A Graphical User Interface (GUI) used to prompt the user to create a new account.
 * <p>
 * This class extends JFrame and is used to prompt the user for a username and
 * password. This GUI makes calls to the SocialNetwork data structure to validate
 * account creation.
 *
 * @author Eduard Mekler
 * @since 2016-02-11
 * @version 0.0.1-beta
 * @see SocialNetwork
 * @see LoginGUI
 * @see JFrame
 */
@SuppressWarnings("serial")
final class JoinNetworkGUI extends JFrame {
    /* Object Attributes */
    private SocialNetwork network;          // Reference to the SocialNetwork data structure
    private JTextField jtfUsername;         // Text field to enter username
    private JTextField jtfPassword;         // Text field to enter password
    private JTextField jtfRepeatPassword;   // Text field to confirm password
    private LoginGUI loginGUI;              // Reference to LoginGUI object which creates this JoinNetworkGUI object
    private JFrame self;                    // Reference to this JoinNetworkGUI object

    /* Object Constructors */
    /**
     * Creates a JoinNetwork GUI screen.
     * @param network SocialNetwork object containing user data.
     * @param sourceGUI LoginGUI object which instantiates this JoinNetworkGUI.
     */
    JoinNetworkGUI(SocialNetwork network, LoginGUI sourceGUI) {
        super("Sign Up");
        self = this;
        this.network = network;
        loginGUI = sourceGUI;

        add(setupInputFields(), BorderLayout.CENTER);
        add(setupButtons(), BorderLayout.SOUTH);

        addWindowListener(new ClosingListener());

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
	
	/* Private Functions */
    /**
     * Returns a JPanel containing the username, password, & password validation labels & fields.
     * @return JPanel containing the username, password, & password validation labels & fields.
     */
	private JPanel setupInputFields() {
		JPanel panel = new JPanel(new GridLayout(3,1));
        JPanel subPanel;

        jtfUsername = new JTextField(15);
        jtfPassword = new JTextField(15);
        jtfRepeatPassword = new JTextField(15);

        String[] labels = {"Username: ", "Password: ", "Confirm Password: "};
        JTextField[] fields = {jtfUsername, jtfPassword, jtfRepeatPassword};

        for(int i = 0; i < labels.length; i++) {
            subPanel = new JPanel(new FlowLayout());
            subPanel.add(new JLabel(labels[i]));
            subPanel.add(fields[i]);
            panel.add(subPanel);
        }

        return panel;
	}

    /**
     * Returns a JPanel containing the OK & Cancel buttons.
     * @return JPanel containing the OK & Cancel buttons.
     */
    private JPanel setupButtons() {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(new JButton(new OKAction()));
        panel.add(new JButton(new CancelAction()));

        return panel;
    }

    /**
     * Disposes the window and returns to the LoginGUI which creates this JoinNetworkGUI.
     */
    private void disposeWindow() {
		loginGUI.setVisible(true);
        self.dispose();
    }

    /**
     * Attempts to create a new user on the network. If successful the user is automatically
     * logged into the application. If unsuccessful then feedback is provided via JOptionPanes.
     * @param username String containing new user's username.
     * @param password String containing new user's password.
     */
    private void joinNetwork(String username, String password) {
        int response = network.joinNetwork(username, password);

        switch (response) {
            case SocialNetwork.USER_ALREADY_EXISTS:
                JOptionPane.showMessageDialog(null, "This user already exists: " + username, "Warning",
                        JOptionPane.WARNING_MESSAGE);
                break;
            case SocialNetwork.SUCCESS:
                disposeWindow();
                loginGUI.login(username, password);
                break;
            default:
                JOptionPane.showMessageDialog(null, "An error has occurred during user creation.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
        }
    }

    /* Inner Classes */
    /**
     * A private inner class which defines the OK Button behavior.
     * @author Eduard Mekler
     */
    private class OKAction extends AbstractAction {
        private OKAction() {super("OK");}

        /**
         * Validtes the user's username and password inputs. If valid, calls the joinNetwork() method.
         * @param e ActionEvent created when button is clicked.
         */
        public void actionPerformed(ActionEvent e) {
            String username, password, password2;

            username = jtfUsername.getText();
            password = jtfPassword.getText();
            password2 = jtfRepeatPassword.getText();

            if(username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a username.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a password.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if(!password.equals(password2)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                joinNetwork(username, password);
            }
        }
    }

    /**
     * A private inner class which defines the Cancel Button behavior.
     * @author Eduard Mekler
     */
    private class CancelAction extends AbstractAction {
        private CancelAction() { super("Cancel"); }
        
        /**
         * Disposes window which causes a return to the originating LoginGUI.
         * @param e ActionEvent created when button is clicked.
         */
        public void actionPerformed(ActionEvent e) {
            disposeWindow();
        }
    }
    /**
     * A private inner class which defines the window closing behavior.
     * @author Eduard Mekler
     */
    private class ClosingListener extends WindowAdapter {
        /**
         * Displays originating LoginGUI and disposes of this JoinNetworkGUI.
         * @param e WindowEvent created when JointNetworkGUI is closing.
         */
        public void windowClosing(WindowEvent e) {
			disposeWindow();
        }
    }
}
