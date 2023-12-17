/***********************************************************************
Program Name:        MyLab.java
Programmer's Name:   Doug Woolley
Program Description: This class will build the GUI and provide the event
                     handling for the controls on the GUI. This class
                     extends Frame, thus the class has a GUI for its 
                     input and output. The architecture is built with
                     JFrame containing JTabbedPane containing tab(s)
                     of Tab1JPanelAdd controls,
                     made from containers (JPanel controls).
                     Layout managers are used to place the controls 
                     within the containers.
 ***********************************************************************/
package week2tabs;

import javax.swing.*; // for Swing
import java.awt.*;    // for awt

public class MyLab extends JFrame {

	// my attributes

	static final long serialVersionUID = 12345;  // assign any number
	private Toolkit tkMy;           // has info about the environment
	private Dimension dimJfrmSize;  // has info about the screen size
	private JFrame myJfrm1;         // my JFrame
	private JTabbedPane myJtp1;     // my JTabbedPane
	private Tab1JPanelAdd myJpan1;  // Tab 1
	private Tab2JPanelAdd myJpan2;  // Tab 2

	/**
	 * Constructor for MyLab() to build the GUI with tab(s).
	 * JFrame is the outermost container. Add JTabbedPane to the JFrame.
	 * The JTabbedPane has tabs and these tabs can have containers (JPanel).
	 */
	public MyLab() {
		// Instantiate the JFrame
		myJfrm1 = new JFrame("CIS355A - Doug Woolley - July/August 2013");
		myJfrm1.setSize(400, 200);  // Set frame to an initial size

		// Make program dies when closing the JFrame
		myJfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instantiate the JTabbedPane and the tabs (Tab1JpanelAdd controls)
		myJtp1 = new JTabbedPane();
		myJpan1 = new Tab1JPanelAdd();
		myJpan2 = new Tab2JPanelAdd();

		// Add tab(s) to JTabbedPane; Add a JPanel (myJpan1) to Tab1
		// Add a container to Tab1 of a JTabbed Pane container (myJtp1).
		myJtp1.addTab("Add", myJpan1); // this is where you add extra tabs
		myJtp1.addTab("Add2", myJpan2); // this is where you add extra tabs

		// add the JTabbedPane to the content pane of the JFrame
		myJfrm1.getContentPane().add(myJtp1);

		// display JFrame in the center of screen, and make smaller than screen
		tkMy = myJfrm1.getToolkit();         // get info about environment
		dimJfrmSize = tkMy.getScreenSize();  // get the size of the screen
		//myJfrm1.setBounds(dimJfrmSize.width / 4, dimJfrmSize.height / 4,
		//		dimJfrmSize.width / 2, dimJfrmSize.height / 3);
		//Set x,y position; Set length, width of frame
		myJfrm1.setBounds(200,200, 300,300);
		myJfrm1.setVisible(true);

	} // end constructor
} // end class

