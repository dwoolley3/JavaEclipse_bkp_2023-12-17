/***********************************************************************
Program Name:        MyProject.java
Programmer's Name:   Doug Woolley
Program Description: Landscape Engineering Calculator (LEC):
	This program contains multiple tabs to calculate a variety of 
	engineering specifications and to store/retrieve customer/contractor
	information. This class will build the GUI and provide the event
	handling for the controls on the GUI. This class extends Frame, 
	thus the class has a GUI for its input and output. The architecture
	is built with JFrame containing JTabbedPane containing tab(s)
	of Tab1JPanelAdd controls, made from containers (JPanel controls).
	Layout managers are used to place the controls within the containers.
	Program has 8 tabs:  1) General, 2) Options, 3) Customers, 
	4) Contractors, 5) Pools, 6) Hot Tubs, 7) Temp Calc, 8) Length Calc.
 ***********************************************************************/
package week7;

import javax.swing.*; // for Swing
import java.awt.*;    // for awt
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyProject extends JFrame implements ChangeListener { 

	// my attributes
	static final long serialVersionUID = 12345;  // assign any number
	private Toolkit tkMy;           // has info about the environment
	private Dimension dimJfrmSize;  // has info about the screen size
	private JFrame myJfrm1;         // my JFrame
	private JTabbedPane myJtp1;     // my JTabbedPane
	//Tabs 1 through 8
	private Tab1JPanelGeneral myJpan1;  
	private Tab2JPanelOptions myJpan2; 
	private Tab3_4JPanelCustomers myJpan3; 
	private Tab3_4JPanelCustomers myJpan4; //Utilize same code, different parm
	//private Tab4JPanelContractors myJpan4;
	private Tab5JPanelPools myJpan5;
	private Tab6JPanelHotTubs myJpan6;
	private Tab7JPanelTempCalc myJpan7;
	private Tab8JPanelLengthCalc myJpan8;	

	/**
	 * Constructor for MyLab() to build the GUI with tab(s).
	 * JFrame is the outermost container. Add JTabbedPane to the JFrame.
	 * The JTabbedPane has tabs and these tabs can have containers (JPanel).
	 */
	public MyProject() {
		// Instantiate the JFrame
		//myJfrm1 = new JFrame("CIS355A - Doug Woolley - July/August 2013");
		myJfrm1 = new JFrame("Enter a company name in the Options tab");
		myJfrm1.setSize(350, 400);  // Set frame to an initial size
		myJfrm1.setResizable(false);

		// Make program die when closing the JFrame
		myJfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instantiate the JTabbedPane and the tabs (Tab1JpanelAdd controls)
		myJtp1 = new JTabbedPane();
		myJpan1 = new Tab1JPanelGeneral();
		myJpan2 = new Tab2JPanelOptions();
		//myJpan3 = new Tab3JPanelCustomers();
		myJpan3 = new Tab3_4JPanelCustomers("Customer");
		myJpan4 = new Tab3_4JPanelCustomers("Contractor");
		//myJpan4 = new Tab4JPanelContractors();
		myJpan5 = new Tab5JPanelPools();
		myJpan6 = new Tab6JPanelHotTubs();
		myJpan7 = new Tab7JPanelTempCalc();
		myJpan8 = new Tab8JPanelLengthCalc();
		myJpan1.setBackground(Color.cyan); //Set Tab 1 color
		myJpan2.setBackground(Color.cyan); //Set Tab 2 color
		myJpan3.setBackground(Color.cyan); 
		myJpan4.setBackground(Color.cyan); 
		myJpan5.setBackground(Color.cyan); 
		myJpan6.setBackground(Color.cyan); 
		myJpan7.setBackground(Color.cyan); 
		myJpan8.setBackground(Color.cyan); 

		// Add tab(s) to JTabbedPane; Add a JPanel (myJpan1) to Tab1
		// Add a container to Tab1 of a JTabbed Pane container (myJtp1).
		// This is where you add extra tabs		
		myJtp1.addTab("General", myJpan1); 
		myJtp1.addTab("Options", myJpan2);
		myJtp1.addTab("Customers", myJpan3);
		myJtp1.addTab("Contractors", myJpan4);
		myJtp1.addTab("Pools", myJpan5);
		myJtp1.addTab("Hot Tubs", myJpan6);
		myJtp1.addTab("Temp Calc", myJpan7);
		myJtp1.addTab("Length Calc", myJpan8);
		
		// add the JTabbedPane to the content pane of the JFrame
		myJfrm1.getContentPane().add(myJtp1);

		// display JFrame in the center of screen, and make smaller than screen
		tkMy = myJfrm1.getToolkit();         // get info about environment
		dimJfrmSize = tkMy.getScreenSize();  // get the size of the screen
		//myJfrm1.setBounds(dimJfrmSize.width / 4, dimJfrmSize.height / 4,
		//		dimJfrmSize.width / 2, dimJfrmSize.height / 3);
		//Set x,y position; Set length, width of frame
		myJfrm1.setBounds(200,200, 350,400);
		myJfrm1.setVisible(true);
		
		//Add Change listener to JTabbedPane	
		myJtp1.addChangeListener(this);
	} // end constructor
	
	public void stateChanged(ChangeEvent e) { 
		JTabbedPane pane = (JTabbedPane) e.getSource(); 
		int selectedIndex = pane.getSelectedIndex(); 
		if (selectedIndex == 2 || selectedIndex == 3)
		{
			//Customers or Contractors tab selected
			//System.out.println("selectedIndex = " + selectedIndex);    
		}
	}
} // end class

