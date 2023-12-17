/***********************************************************************
Program Name:        Tab1JPanelCompute.java
Programmer's Name:   Doug Woolley
Program Description: This program will test the Cylinder class.
					 Within the actionPerformed method, the program will 
					 retrieve radius and height entered into a GUI.
					 Next, the program instantiates a cylinder object with the
					 radius and height. Next, the program calls a method to
					 compute the volume of the cylinder. 
 ***********************************************************************/

package week3;

import javax.swing.*; //put this in for Swing

import java.awt.*; //put this in for awt
import java.awt.event.*; //put this in for events

public class Tab1JPanelCompute extends JPanel

{ // start class

	// my attributes

	static final long serialVersionUID = 54321;

	private String str1 = "   CIS355A, July 2013, program by Doug Woolley ";
	private String str2 = "   Devry University ";
	private String str3 = "";
	private String str4 = str1 + "\n" + str2 + "\n" + str3;

	private JPanel myJpan1; // my JPanel 1 Tab 1

	// controls for myJpan1 in Tab 1

	private JPanel myJpan1_1; // myJpan1_1 for myJpan1

	private JPanel myJpan1_1_center; // JPanel in center

	//Arrays for jLabel/jTextField for radius, height, and volume
	private JLabel jlab_radius[];
	private JTextField jtxtf_radius[];
	private JLabel jlab_height[];
	private JTextField jtxtf_height[];
	private JLabel jlab_volume[];
	private JTextField jtxtf_volume[];

	private JButton jbut1_1_center; // JButton in center

	private JButton jbut1_1_center_clear; // clear myJpan1_1_center

	private JButton jbut1_1_center_end; // end program

	private JPanel myJpan1_2; // myJpan1_2 for myJpan1

	private JLabel jlab1_1; // JLabel for Tab 1
	

	public Tab1JPanelCompute()

	{ // start constructor

		// begin working on Tab 1 *****************************

		// 5) create a JPanel 1 to put into Tab 1

		myJpan1 = new JPanel();

		// 6) give the JPanel 1 a preferred size

		myJpan1.setPreferredSize(new Dimension(300, 300));

		// 7) the JPanel 1 should not be transparent but opaque

		myJpan1.setOpaque(true);

		// 8) add a yellow border to JPanel 1

		myJpan1.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

		// 9) add JPanel 1 to Tab 1

		// iconTab1 = new ImageIcon("images/95_ball.gif");

		// myJtp1.addTab("Tab1", iconTab1, myJpan1, "This is Tab 1");

		// 10) end working on Tab 1 *****************************

		// 11) create JPanels to add to myJpan1 on Tab 1

		myJpan1_1 = new JPanel();

		myJpan1_2 = new JPanel();

		//Expand vertical width of panels for 3 cylinders (rather than 1)
		//myJpan1_1.setPreferredSize(new Dimension(225, 225));
		myJpan1_1.setPreferredSize(new Dimension(225, 275));

		myJpan1_2.setPreferredSize(new Dimension(200, 200)); 

		myJpan1_1.setOpaque(true);

		myJpan1_2.setOpaque(true);

		myJpan1_1.setLayout(new BorderLayout());

		myJpan1_1.setBorder(BorderFactory.createLineBorder(Color.RED));

		myJpan1_1.setBorder(BorderFactory.createLineBorder(Color.CYAN));

		// 12) create controls to add to myJpan1_1

		jlab1_1 = new JLabel("Compute Volume of Cylinder(s)", SwingConstants.CENTER);

		myJpan1_1_center = new JPanel();

		//Increase GridLayout for 3 cylinders instead of 1.
		//I had trouble increasing GridLayout to have 6 columns (instead of the original 2),
		//since it would go to only 5 columns and then wrap. Thus,
		//I chose to keep the columns at 2 and make more rows
		//myJpan1_1_center.setLayout(new GridLayout(4, 2, 5, 5));
		myJpan1_1_center.setLayout(new GridLayout(10, 2, 5, 5));
		
		//Construct labels to prompt user for inputs radius and height,
		//and for output of volume
		jlab_radius = new JLabel[3];
		jlab_height = new JLabel[3]; 
		jlab_volume = new JLabel[3]; 
		for (int i = 0; i < 3; i++) 
		{
			jlab_radius[i] = new JLabel(
					"Enter radius#" + (i+1) + " -->", SwingConstants.CENTER);
			jlab_height[i] = new JLabel(
					"Enter height#" + (i+1) + " -->", SwingConstants.CENTER);
			jlab_volume[i] = new JLabel(
					"Enter volume#" + (i+1) + " -->", SwingConstants.CENTER);
		}

		jtxtf_radius = new JTextField[3];
		jtxtf_height = new JTextField[3]; 
		jtxtf_volume = new JTextField[3]; 
		for (int i = 0; i < 3; i++)
		{
			jtxtf_radius[i] = new JTextField(6); 
			jtxtf_height[i] = new JTextField(6); 
			jtxtf_volume[i] = new JTextField(6); 
			jtxtf_volume[i].setEditable(false);
			jtxtf_volume[i].setBackground(Color.green);
		}		

		jbut1_1_center = new JButton("Click to compute volume");

		jbut1_1_center_clear = new JButton("Clear Fields");

		jbut1_1_center_end = new JButton("End Program");
		
		for (int i = 0; i < 3; i++)
		{
			myJpan1_1_center.add(jlab_radius[i]);
			myJpan1_1_center.add(jtxtf_radius[i]);
			myJpan1_1_center.add(jlab_height[i]);
			myJpan1_1_center.add(jtxtf_height[i]);
			myJpan1_1_center.add(jlab_volume[i]);
			myJpan1_1_center.add(jtxtf_volume[i]);
		}				

		myJpan1_1_center.add(jbut1_1_center_clear);

		myJpan1_1_center.add(jbut1_1_center_end);

		myJpan1_1.add(jbut1_1_center, BorderLayout.SOUTH);

		// 13) add the controls to myJpan1_1

		myJpan1_1.add(jlab1_1, BorderLayout.NORTH);

		myJpan1_1.add(myJpan1_1_center);

		// 14) add myJpan1_1 to myJpan1

		myJpan1.add(myJpan1_1);

		// 15) now add myJpan1 to Tab1JPanelAdd, i.e, this JPanel class

		add(myJpan1);

		//jtxf1_1_center1.requestFocusInWindow();
		jtxtf_radius[0].requestFocusInWindow();

		// my event handlers

		// start event handler for jbut1_1_center *****************************

		jbut1_1_center.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()
						
						Cylinder[] cylinder = new Cylinder[3];
						double r; // radius of cylinder
						double h; // height of cylinder		
						
						for (int i = 0; i < 3; i++)
						{
							//Retrieve radius and height to instantiate 1st cylinder object
							try { r = Double.parseDouble(jtxtf_radius[i].getText()); }
							catch (NumberFormatException ex) { r = 0; }
							try { h = Double.parseDouble(jtxtf_height[i].getText()); }
							catch (NumberFormatException ex) { h = 0; }
							cylinder[i] = new Cylinder(r, h);
							
							//Compute volume and round to 4th decimal place						
							double v = (int)(cylinder[i].volume() * 10000.0 + 0.5) / 10000.0;
							jtxtf_volume[i].setText("" + v);
						}										

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// end event handler for jbut1_1_center *****************************

		// start event handler for jbut1_1_center_clear
		// *****************************

		jbut1_1_center_clear.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()
						
						for (int i = 0; i < 3; i++)
						{
							jtxtf_radius[i].setText("");
							jtxtf_height[i].setText("");
							jtxtf_volume[i].setText("");
						}

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// end event handler for jbut1_1_center_clear
		// *****************************

		// start event handler for jbut1_1_center_end
		// *****************************

		jbut1_1_center_end.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()

						JOptionPane.showMessageDialog(null, str4);
						System.exit(0);

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// end event handler for jbut1_1_center_end
		// *****************************

	} // end constructor

} // end class

