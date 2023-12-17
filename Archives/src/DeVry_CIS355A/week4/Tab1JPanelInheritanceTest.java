/***********************************************************************
Program Name:        Tab1JPanelInheritanceTest.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for an Inheritance Test.
					 The GUI accepts as input x, y, and sideLength.
					 After clicking a button, the actionPerformed method
					 will retrieve the entered x, y, and sideLength, and
					 then instantiate objects for Point, Square, and Cube.
					 Output of the objects methods are shown in a text area.
 ***********************************************************************/
package week4;

import javax.swing.*;    // for Swing

import java.awt.*;       // for awt
import java.awt.event.*; // for events

public class Tab1JPanelInheritanceTest extends JPanel { // start class

	// my attributes
	static final long serialVersionUID = 54321; // assign any number

	// Declare variables for controls needed to create GUI
	private JPanel jpnl1;      // my JPanel 1 Tab 1

	// controls for jpnl1 in Tab 1
	private JPanel     jpnl1_1;           // jpnl1_1 for jpnl1
	private JPanel     jpnl1_1_center;    // JPanel in center
	private JLabel     jlbl_Num1;         // jLabel in center1
	private JTextField jtxf_Num1;         // jTextField in center1
	private JLabel     jlbl_Num2;         // jLabel in center2
	private JTextField jtxf_Num2;         // jTextField in center2
	private JLabel     jlbl_Num3;         // jLabel in center 3
	private JTextField jtxf_Num3;         // jTextField in center3
	private JButton    jbtn_Test;         // JButton in center
	private JPanel     jpnl1_2;           // jpnl1_2 
	private JTextArea  jtxta_Output;	  // JTextArea for output

	public Tab1JPanelInheritanceTest()	{ // start constructor

		// begin working on Tab 1 *****************************
		jpnl1 = new JPanel();   //Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(300, 400));  
		jpnl1.setOpaque(true);  //Set to opaque, not transparent
		// end working on Tab 1 *****************************

		// Create JPanels to add to jpnl1 on Tab 1
		jpnl1_1 = new JPanel();
		jpnl1_1.setPreferredSize(new Dimension(225, 375));
		jpnl1_1.setOpaque(true);
		jpnl1_1.setLayout(new BorderLayout());
		jpnl1_1.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		
		jpnl1_2 = new JPanel();
		jpnl1_2.setPreferredSize(new Dimension(225, 225));
		jpnl1_2.setLayout(new BorderLayout());
		jpnl1_2.setOpaque(true);

		// Create controls to add to jpnl1_1
		jpnl1_1_center = new JPanel();
		jpnl1_1_center.setLayout(new GridLayout(3, 2, 5, 5));
		jlbl_Num1 = new JLabel("X-Coordinate -->", SwingConstants.CENTER);
		jtxf_Num1 = new JTextField(6);
		jlbl_Num2 = new JLabel("Y-Coordinate -->", SwingConstants.CENTER);
		jtxf_Num2 = new JTextField(6);
		jlbl_Num3 = new JLabel("Side Length -->", SwingConstants.CENTER);
		jtxf_Num3 = new JTextField(6);
		jbtn_Test = new JButton("Click to Test Inheritance");
		
		jtxta_Output = new JTextArea(16,10); //16 rows, 10 columns
		jtxta_Output.setEditable(false);     //Read only, to display results
		JScrollPane scrollV = new JScrollPane (jtxta_Output);
		scrollV.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Add controls to jpnl1_1_center
		jpnl1_1_center.add(jlbl_Num1);
		jpnl1_1_center.add(jtxf_Num1);
		jpnl1_1_center.add(jlbl_Num2);
		jpnl1_1_center.add(jtxf_Num2);
		jpnl1_1_center.add(jlbl_Num3);
		jpnl1_1_center.add(jtxf_Num3);
		
		jpnl1_2.add(scrollV);

		// Add the controls to jpnl1_1
		jpnl1_1.add(jpnl1_1_center, BorderLayout.NORTH);		
		jpnl1_1.add(jpnl1_2, BorderLayout.CENTER);
		jpnl1_1.add(jbtn_Test, BorderLayout.SOUTH);
		
		// Add jpnl1_1 to jpnl1
		jpnl1.add(jpnl1_1);
		
		//Set Tab/Panel color
		jpnl1.setBackground(Color.cyan); 

		// Now add jpnl1 to Tab1JPanelAdd, i.e, this JPanel class
		add(jpnl1);
		jtxf_Num1.requestFocusInWindow();

		// my event handlers

		// start event handler for jbut1_1_center *****************************
		// Register an ActionListener with the Add button control
		// by using the addActionListener() method

		jbtn_Test.addActionListener
		( // start addActionListener()
				new ActionListener()
				{ // start anonymous inner class
					public void actionPerformed(ActionEvent event)
					{
						int x;            // x-coordinate	
						int y;            // y-coordinate
						int sideLength;   // sideLength	
						String strOutput; // Store concatenation of output
						
						//Retrieve x, y, and sideLength to instantiate objects
						try { x = Integer.parseInt(jtxf_Num1.getText()); }
						catch (NumberFormatException ex) { x = 0; }
						try { y = Integer.parseInt(jtxf_Num2.getText()); }
						catch (NumberFormatException ex) { y = 0; }
						try { sideLength = Integer.parseInt(jtxf_Num3.getText()); }
						catch (NumberFormatException ex) { sideLength = 0; }
						
						Point p = new Point(x, y);
						Square s = new Square(x, y, sideLength);
						Cube c = new Cube(x, y, sideLength);
						
						strOutput = "Point:\n" + p.toString()
							+ "\n\nSquare:\n" + s.toString()
							+ "\n\nCube:\n" + c.toString();
						
						jtxta_Output.setText(strOutput);		
						
						//System.out.println("Point:\n" + p.toString());
						//System.out.println("\nSquare:\n" + s.toString());
						//System.out.println("\nCube:\n" + c.toString());

					}
				} // end anonymous inner class
		); // end addActionListener()
	} // end constructor
} // end class

