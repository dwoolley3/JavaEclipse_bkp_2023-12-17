/***********************************************************************
Program Name:        Tab1JPanelAdd.java
Programmer's Name:   Doug Woolley
Program Description: This program will test the Date class.
					 Within the actionPerformed method, the program will 
					 retrieve month, day, year entered into a GUI.
					 Next, the program instantiates a myDate object with the
					 month, day, year. Next, the program iterates 40 times
					 and increments the date by 1 day and displays the new
					 date.
 ***********************************************************************/

package week3Date;

import javax.swing.*; //put this in for Swing

import week3.Cylinder;

import java.awt.*; //put this in for awt
import java.awt.event.*; //put this in for events

public class Tab1JPanelAdd extends JPanel

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

	private JLabel jlab1_1_center1; // jLabel in center1

	private JTextField jtxf1_1_center1; // jTextField in center1

	private JLabel jlab1_1_center2; // jLabel in center2

	private JTextField jtxf1_1_center2; // jTextField in center2

	private JLabel jlab1_1_center3; // jLabel in center 3

	private JTextField jtxf1_1_center3; // jTextField in center3

	private JButton jbut1_1_center; // JButton in center

	private JButton jbut1_1_center_clear; // clear myJpan1_1_center

	private JButton jbut1_1_center_end; // end program

	private JPanel myJpan1_2; // myJpan1_2 for myJpan1

	private JLabel jlab1_1; // JLabel for Tab 1
	
	private JLabel jlab1_1_center4; // jLabel in center 4

	private JTextArea jtxa1_1_center4; // jTextArea in center4

	public Tab1JPanelAdd()

	{ // start constructor

		// begin working on Tab 1 *****************************

		// 5) create a JPanel 1 to put into Tab 1

		myJpan1 = new JPanel();

		// 6) give the JPanel 1 a preferred size

		//myJpan1.setPreferredSize(new Dimension(300, 300));
		myJpan1.setPreferredSize(new Dimension(500, 600));

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

		//myJpan1_1.setPreferredSize(new Dimension(225, 225));
		myJpan1_1.setPreferredSize(new Dimension(400, 550));

		myJpan1_2.setPreferredSize(new Dimension(400, 200));

		myJpan1_1.setOpaque(true);

		myJpan1_2.setOpaque(true);

		myJpan1_1.setLayout(new BorderLayout());

		myJpan1_1.setBorder(BorderFactory.createLineBorder(Color.RED));

		myJpan1_1.setBorder(BorderFactory.createLineBorder(Color.CYAN));

		// 12) create controls to add to myJpan1_1

		jlab1_1 = new JLabel("Increment a Date 40 times", SwingConstants.CENTER);

		myJpan1_1_center = new JPanel();

		//myJpan1_1_center.setLayout(new GridLayout(4, 2, 5, 5));
		myJpan1_1_center.setLayout(new GridLayout(5, 2, 5, 5));

		jlab1_1_center1 = new JLabel("Enter month -->", SwingConstants.CENTER);

		jtxf1_1_center1 = new JTextField(6);

		jlab1_1_center2 = new JLabel("Enter day -->", SwingConstants.CENTER);

		jtxf1_1_center2 = new JTextField(6);

		jlab1_1_center3 = new JLabel("Enter year -->", SwingConstants.CENTER);

		jtxf1_1_center3 = new JTextField(6);
		
		jlab1_1_center4 = new JLabel("40 Incremented Dates -->", SwingConstants.CENTER);

		jtxa1_1_center4 = new JTextArea(43,20); //43 rows, 20 columns
		jtxa1_1_center4.setEditable(false);     //Read only, to display results
		Color lightGreen = new Color(140, 215, 40);
		jtxa1_1_center4.setBackground(lightGreen);
		JScrollPane scrollV = new JScrollPane (jtxa1_1_center4);
		scrollV.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		

		jbut1_1_center = new JButton("Click to increment date");

		jbut1_1_center_clear = new JButton("Clear Fields");

		jbut1_1_center_end = new JButton("End Program");

		myJpan1_1_center.add(jlab1_1_center1);

		myJpan1_1_center.add(jtxf1_1_center1);

		myJpan1_1_center.add(jlab1_1_center2);

		myJpan1_1_center.add(jtxf1_1_center2);

		myJpan1_1_center.add(jlab1_1_center3);

		myJpan1_1_center.add(jtxf1_1_center3);
		
		myJpan1_1_center.add(jbut1_1_center_clear);

		myJpan1_1_center.add(jbut1_1_center_end);
		
		myJpan1_1_center.add(jlab1_1_center4);

		//myJpan1_1_center.add(jtxa1_1_center4);
		myJpan1_1_center.add(scrollV);

		myJpan1_1.add(jbut1_1_center, BorderLayout.SOUTH);
		

		// 13) add the controls to myJpan1_1

		myJpan1_1.add(jlab1_1, BorderLayout.NORTH);

		myJpan1_1.add(myJpan1_1_center);

		// 14) add myJpan1_1 to myJpan1

		myJpan1.add(myJpan1_1);

		// 15) now add myJpan1 to Tab1JPanelAdd, i.e, this JPanel class

		add(myJpan1);

		jtxf1_1_center1.requestFocusInWindow();

		// my event handlers

		// start event handler for jbut1_1_center *****************************

		jbut1_1_center.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()

						int m; // month	
						int d; // day
						int y; // year															
						
						//Retrieve month, day, and year to instantiate myDate object
						try { m = Integer.parseInt(jtxf1_1_center1.getText()); }
						catch (NumberFormatException ex) { m = 1; }
						try { d = Integer.parseInt(jtxf1_1_center2.getText()); }
						catch (NumberFormatException ex) { d = 1; }
						try { y = Integer.parseInt(jtxf1_1_center3.getText()); }
						catch (NumberFormatException ex) { y = 2013; }
						
						Date myDate = new Date(m, d, y);
						String dateString = "", allDates = "";
						for (int i = 0; i < 40; i++)
						{
							dateString = myDate.nextDay();
							allDates += dateString + "\n\r";
						}
						jtxa1_1_center4.setText(allDates);

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

						jtxf1_1_center1.setText("");
						jtxf1_1_center2.setText("");
						jtxf1_1_center3.setText("");
						jtxa1_1_center4.setText("");					

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

						// new AePlayWave("sounds/alarm.wav").start();

						JOptionPane.showMessageDialog(null, str4);
						System.exit(0);

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// end event handler for jbut1_1_center_end
		// *****************************

	} // end constructor

} // end class

