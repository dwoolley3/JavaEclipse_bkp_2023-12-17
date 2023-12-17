/***********************************************************************
Program Name:        Tab3JPanelDayGui.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for a Day GUI. 
     This program will display 2 buttons for displaying
     the kind of day a user is having: Good or Bad. If the Good button
     is clicked, then screen shows message: "Today is a good day!"
     If Bad button is clicked, screen shows "Today is a bad day!"
     This program was changed from extending JFrame to extending JPanel.
     Thus, we can place this JPanel into an individual tab on the JFrame.
 ***********************************************************************/

package Week4Michael;

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events

public class Tab3JPanelDayGui extends JPanel  // instead of JFrame
{
	// Declare variables for controls needed to create GUI
	private JPanel jpnl1;   
		
	//private JFrame mainFrame;
	private JButton btnGood;
	private JButton btnBad;
	private JTextField jtxtfKindOfDay;
	
	//constructor
	public Tab3JPanelDayGui()
	{
		//mainFrame = new JFrame("Messages");
		
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(200, 100));
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		
		btnGood = new JButton("Good");
		btnBad = new JButton("Bad");
		btnGood.setBackground(Color.green);
		btnBad.setBackground(Color.red);
		jtxtfKindOfDay = new JTextField(11);
		jtxtfKindOfDay.setEditable(false);  //Display only
		
		//Container c = mainFrame.getContentPane();
		//c.setLayout(new FlowLayout());		
		//c.add(cmdGood);
		//c.add(cmdBad);
		jpnl1.setLayout(new FlowLayout());		
		jpnl1.add(btnGood);
		jpnl1.add(btnBad);
		jpnl1.add(jtxtfKindOfDay);
		jpnl1.setBackground(Color.yellow);  //Set Tab/Panel color
		
		btnGood.setMnemonic('G');
		btnBad.setMnemonic('B');
		
		//mainFrame.setSize(300, 100);
		
		//mainFrame.addWindowListener(new WindowAdapter() {
		//	public void windowClosing(WindowEvent e) {
		//		System.exit(0);
		//	}
		//} );
		
		ButtonsHandler bhandler = new ButtonsHandler();
		btnGood.addActionListener(bhandler);
		btnBad.addActionListener(bhandler);
		
		//mainFrame.setVisible(true);
		
		//Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}
	
	class ButtonsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnGood)
			{
				jtxtfKindOfDay.setText("Today is a good day!");
				//JOptionPane.showMessageDialog(null,  "Today is a good day!",
				//		"Event Handler Message",
				//		JOptionPane.INFORMATION_MESSAGE);
			}
			
			if (e.getSource() == btnBad)
			{
				jtxtfKindOfDay.setText("Today is a bad day!");
				//JOptionPane.showMessageDialog(null,  "Today is a bad day!",
				//		"Event Handler Message",
				//		JOptionPane.INFORMATION_MESSAGE);
			}
		}		
	}

	//public static void main(String[] args) 
	//{
	//	Tab3JPanelDayGui app = new Tab3JPanelDayGui();
	//}
}