/***********************************************************************
Program Name:        Tab3JPanelThreeArrayLists.java
Programmer's Name:   Doug Woolley
Program Description: This program will declare three ArrayList objects and
 	populate two of the ArrayLists: priceList and quantityList.
 	When the user clicks the button, the program will call method extend()
 	to calculate the product of the corresponding element in priceList and
 	quantityList and place it in the amountList ArrayList. The program
 	then calls method display() to display the results of all three lists.
 ***********************************************************************/

package week6;

import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events
import java.util.ArrayList;  //for ArrayLists

public class Tab3JPanelThreeArrayLists extends JPanel // instead of JFrame
{
	static final long serialVersionUID = 54321; // assign any number
	
	// Declare variables for controls needed to create GUI
	private JPanel jpnl1;
	private JButton btnDisplay;
	private JTextArea jtxtaResults;

	ArrayList<Double> priceList;
	ArrayList<Double> quantityList;
	ArrayList<Double> amountList;
	
	double[] PRICE_ARRAY = { 10.62, 14.89, 13.21, 16.55, 18.62, 9.47, 6.58, 18.32, 12.15, 3.98 }; 
	double[] QUANTITY_ARRAY = { 4.0, 8.5, 6.0, 7.35, 9.0, 15.3, 3.0, 5.4, 2.9, 4.8 };
	
	// constructor
	public Tab3JPanelThreeArrayLists() {
		// mainFrame = new JFrame("Messages");

		jpnl1 = new JPanel(); // Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(300, 350));
		jpnl1.setOpaque(true); // Set to opaque, not transparent

		btnDisplay = new JButton("Display Results");
		btnDisplay.setBackground(Color.green);
		jtxtaResults = new JTextArea(11, 14);
		jtxtaResults.setEditable(false); // Display only

		jpnl1.setLayout(new FlowLayout());
		jpnl1.add(btnDisplay);
		jpnl1.add(jtxtaResults);
		jpnl1.setBackground(Color.orange); // Set Tab/Panel color

		btnDisplay.setMnemonic('D');

		ButtonsHandler bhandler = new ButtonsHandler();
		btnDisplay.addActionListener(bhandler);

		// Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
				
		//Initialize priceList and quantitytList
		priceList = new ArrayList<Double>();
		quantityList = new ArrayList<Double>();
		amountList = new ArrayList<Double>();
		for (int i = 0; i < 10; i++)
		{
			priceList.add(PRICE_ARRAY[i]);
			quantityList.add(QUANTITY_ARRAY[i]);
		}
	}
	
	//Receive object references in the three ArrayList objects,
	//The method will calculate elements in the amountList ArrayList,
	//as the product of the corresponding elements in the priceList
	//and quantityList ArrayList.
	public void extend()
	{ 
		for (int i = 0; i < priceList.size(); i++)
			amountList.add(priceList.get(i) * quantityList.get(i));		
	}

	//method display() displays the results of all three lists.
	public void display()
	{		
		jtxtaResults.setText("");
		for (int i = 0; i < priceList.size(); i++) {
			jtxtaResults.append(
				String.format("%d) %.2f * %.2f = %.2f \n", i+1,
				priceList.get(i), quantityList.get(i), amountList.get(i) ));
		}	
		
		//Alternate method to display multiple lines:
		//String s = "";
		//for (int i = 0; i < priceList.size(); i++) {
		//	 s += String.format("%d) %.2f * %.2f = %.2f \n", i+1,
		//	 priceList.get(i), quantityList.get(i), amountList.get(i) );
		//}		
		//jtxtaResults.setText(s);	
	}
		
	class ButtonsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnDisplay) {
				//method extend() puts values into amountList ArrayList object;
				//method display() displays the results of all three lists.			
				extend();
				display();
			}
		}
	}
}