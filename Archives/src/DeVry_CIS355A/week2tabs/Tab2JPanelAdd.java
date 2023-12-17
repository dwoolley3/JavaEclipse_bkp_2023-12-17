/***********************************************************************
Program Name:        Tab1JPanelAdd.java
Programmer's Name:   Doug Woolley
Program Description: This program will test the MyMath class.
					 Within the actionPerformed method, the program will 
					 retrieve radius and height entered into a GUI.
					 Next, the program instantiates a cylinder object with the
					 radius and height. Next, the program calls a method to
					 compute the volume of the cylinder. 
 ***********************************************************************/
package week2tabs;

import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events

public class Tab2JPanelAdd extends JPanel { // start class

	// my attributes

	static final long serialVersionUID = 54321; // assign any number

	private String str1 = "   CIS355A, July/August 2013 by Doug Woolley ";
	private String str2 = "   Student - Devry University ";
	private String str3 = "    ";
	private String str4 = str1 + "\n" + str2 + "\n" + str3;

	// Declare variables for controls needed to create GUI
	private JPanel jpnl1;      // my JPanel 1 Tab 1
	private JPanel jpnl2;      // my JPanel 2 Tab 2

	// controls for jpnl1 in Tab 1
	private JPanel     jpnl1_1;           // jpnl1_1 for jpnl1
	private JPanel     jpnl1_1_center;    // JPanel in center
	private JLabel     jlbl_Num1;         // jLabel in center1
	private JTextField jtxf_Num1;         // jTextField in center1
	private JLabel     jlbl_Num2;         // jLabel in center2
	private JTextField jtxf_Num2;         // jTextField in center2
	private JLabel     jlbl_Num3;         // jLabel in center 3
	private JTextField jtxf_Num3;         // jTextField in center3
	private JButton    jbtn_Add;          // JButton in center
	private JButton    jbtn_ClearFields;  // clear jpnl1_1_center
	private JButton    jbtn_EndProgram;   // end program
	private JLabel     jlbl_Title;        // JLabel for Tab 1	
	private JPanel     jpnl1_2;           // jpnl1_2 not used

	public Tab2JPanelAdd()	{ // start constructor

		// begin working on Tab 1 *****************************
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(300, 300));  
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		// end working on Tab 1 *****************************

		// Create JPanels to add to jpnl1 on Tab 1
		jpnl1_1 = new JPanel();
		jpnl1_1.setPreferredSize(new Dimension(225, 225));
		jpnl1_1.setOpaque(true);
		jpnl1_1.setLayout(new BorderLayout());
		jpnl1_1.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		
		//jpnl1_2 not used
		jpnl1_2 = new JPanel();
		jpnl1_2.setPreferredSize(new Dimension(200, 200));
		jpnl1_2.setOpaque(true);

		// Create controls to add to jpnl1_1
		jlbl_Title = new JLabel("Add 2b numbers", SwingConstants.CENTER);
		jpnl1_1_center = new JPanel();
		jpnl1_1_center.setLayout(new GridLayout(4, 2, 5, 5));
		jlbl_Num1 = new JLabel("Enter # 1b -->", SwingConstants.CENTER);
		jtxf_Num1 = new JTextField(6);
		jlbl_Num2 = new JLabel("Enter # 2b -->", SwingConstants.CENTER);
		jtxf_Num2 = new JTextField(6);
		jlbl_Num3 = new JLabel("Addition is -->", SwingConstants.CENTER);
		jtxf_Num3 = new JTextField(6);
		jbtn_ClearFields = new JButton("Clear Fields");
		jbtn_EndProgram = new JButton("End Program");
		jbtn_Add = new JButton("Click to add both numbers");
		
		//Add controls to jpnl1_1_center
		jpnl1_1_center.add(jlbl_Num1);
		jpnl1_1_center.add(jtxf_Num1);
		jpnl1_1_center.add(jlbl_Num2);
		jpnl1_1_center.add(jtxf_Num2);
		jpnl1_1_center.add(jlbl_Num3);
		jpnl1_1_center.add(jtxf_Num3);
		jpnl1_1_center.add(jbtn_ClearFields);
		jpnl1_1_center.add(jbtn_EndProgram);

		// Add the controls to jpnl1_1
		jpnl1_1.add(jlbl_Title, BorderLayout.NORTH);
		jpnl1_1.add(jpnl1_1_center, BorderLayout.CENTER);		
		jpnl1_1.add(jbtn_Add, BorderLayout.SOUTH);
		
		// Add jpnl1_1 to jpnl1
		jpnl1.add(jpnl1_1);

		// Now add jpnl1 to Tab1JPanelAdd, i.e, this JPanel class
		add(jpnl1);
		jtxf_Num1.requestFocusInWindow();

		// my event handlers

		// start event handler for jbut1_1_center *****************************
		// Register an ActionListener with the Add button control
		// by using the addActionListener() method

		jbtn_Add.addActionListener
		( // start addActionListener()
				new ActionListener()
				{ // start anonymous inner class
					public void actionPerformed(ActionEvent event)
					{
						MyMath.myAdd(jtxf_Num1, jtxf_Num2, jtxf_Num3);
					}
				} // end anonymous inner class
		); // end addActionListener()

		// end event handler for jbut1_1_center *****************************

		// start event handler for jbut1_1_center_clear *********************
		// Register an ActionListener with the Clear button control 
		// by using the addActionListener() method. When the button is clicked,
		// the code inside the actionPerformed() is executed.

		jbtn_ClearFields.addActionListener
		( // start addActionListener()
				new ActionListener()
				{ // start anonymous inner class
					public void actionPerformed(ActionEvent event)
					{
						jtxf_Num1.setText("");
						jtxf_Num2.setText("");
						jtxf_Num3.setText("");
					}
				} // end anonymous inner class
		); // end addActionListener()

		// end event handler for jbut1_1_center_clear ***********************

		// start event handler for jbut1_1_center_end ***********************
		// Register an ActionListener with the End Program button control 
		// by using the addActionListener() method. When the button is clicked,
		// the code inside the actionPerformed() is executed.
		
		jbtn_EndProgram.addActionListener
		( // start addActionListener()
				new ActionListener()
				{ // start anonymous inner class
					public void actionPerformed(ActionEvent event)
					{
						JOptionPane.showMessageDialog(null, str4);
						System.exit(0);
					}
				} // end anonymous inner class
		); // end addActionListener()

		// end event handler for jbut1_1_center_end *************************

	} // end constructor
} // end class

