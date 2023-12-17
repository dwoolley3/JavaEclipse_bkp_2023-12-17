/***********************************************************************
Program Name:        MyLab3.java
Programmer's Name:   Doug Woolley
Program Description: This class will display the GUI and do input and
 					 output processing using the methods in the
 					 separate class Date.java.
 ***********************************************************************/

package week3Date;

import javax.swing.*; //put this in for Swing
import java.awt.*; //put this in for awt

public class MyLab3 extends JFrame { // start class

	// my attributes

	static final long serialVersionUID = 12345;

	Toolkit tkMy; // has info about the environment

	Dimension dimJfrmSize; // has info about the screen size

	private JFrame myJfrm1; // my JFrame

	private JTabbedPane myJtp1; // my JTabbedPane

	private Tab1JPanelAdd myJpan1;

	// private Icon iconTab1; // Tab1 icon

	// private Icon iconTab2; // Tab1 icon

	/**
	 * 
	 */
	public MyLab3() { // start constructor
		// TODO Auto-generated constructor stub

		// 1) instantiate the JFrame

		myJfrm1 = new JFrame("CIS355A - Doug Woolley - July 2013");

		// 2) if you want to you can give the frame an initial size

		myJfrm1.setSize(400, 200);

		// 3) make sure the program dies when you close the JFrame

		myJfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 4) instantiate the JTabbedPane

		myJtp1 = new JTabbedPane();

		myJpan1 = new Tab1JPanelAdd();

		myJtp1.addTab("Tab1", myJpan1); // this is where you add extra tabs

		// add the JTabbed pane to the content pane of the JFrame

		myJfrm1.getContentPane().add(myJtp1);

		// display my JFrame in the center of the screen

		tkMy = myJfrm1.getToolkit(); // get info about environment

		dimJfrmSize = tkMy.getScreenSize(); // get the size of the screen

		// center the JFrame on screen and size to 1/2 of screen

		//myJfrm1.setBounds(dimJfrmSize.width / 4, dimJfrmSize.height / 4,
		//		dimJfrmSize.width / 2, dimJfrmSize.height / 3);
		
		myJfrm1.setBounds(dimJfrmSize.width / 4, dimJfrmSize.height / 2 - 300,
						dimJfrmSize.width / 3, dimJfrmSize.height / 2 + 150);
				
		myJfrm1.setVisible(true);

	} // end constructor

} // end class

