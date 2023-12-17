/***********************************************************************
Program Name:        AddPerson.java
Programmer's Name:   Doug Woolley
Program Description: This program is called by both tab 3 and 4,
	"Customers" and "Contractors." Parameters of Person (Customer vs.
	Contractor) and of FileChosen are passed to this program.
	The program provides the user with an option to click the Add button
	(after entering Name, Address, and Phone) to add to the data to the
 	chosen file. A user could also choose to Delete the file, if desired.
 	Upon closing this "Add" window, the main tab still appears.
 ***********************************************************************/
package week7;

import java.awt.*;
import java.awt.event.*;
import java.io.*;        // for io
import javax.swing.*;

public class AddPerson extends JFrame 
{
	//Global objects to be used in inner classes, if necessary
	private JFrame mainFrame;
	private JLabel jlblPersonName;
	private JLabel jlblAddress;
	private JLabel jlblState;
	private JLabel jlblCity;
	private JLabel jlblZip;
	private JLabel jlblPhone;
	
	private JTextField jtxtfPersonName;
	private JTextField jtxtfAddress;
	private JTextField jtxtfCity;
	private JComboBox<String> jcbState;
	private JTextField jtxtfZip;
	private JTextField jtxtfPhone;
	
	private JButton btnAdd;
	private JButton btnClose;
	private JButton btnDelete;
	
	private JTextArea jtxtaMessageArea;
	private FileOutputStream fosOut;
	private String Person;
	private File FileChosen = null;  

	//private String person;   //Customer or Contractor
	
	//Class constructor methods
	public AddPerson() {}
	public AddPerson(String person, File fileChosen)
	{
		//Define objects in constructor
		//person = "Customer";
		Person = person;
		FileChosen = fileChosen;
		mainFrame = new JFrame(person + "s");
		
		String[] states = {"AK","AL","AR","AS","AZ","CA",
			"CO","CT","DE","FL","GA","GU","HI","IA","ID","IL",
			"IN","KS","KY","LA","MA","MD","ME","MH","MI","MN",
			"MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV",
			"NY","OH","OK","OR","PA","PR","PW","RI","SC","SD",
			"TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};

		jlblPersonName = new JLabel(person + " Name");
		jlblAddress = new JLabel("Address");
		jlblCity = new JLabel("City");
		jlblState = new JLabel("State");
		jlblZip = new JLabel("ZIP");
		jlblPhone = new JLabel("Phone");
		
		jtxtfPersonName = new JTextField(19);
		jtxtfAddress = new JTextField(24);
		jtxtfCity = new JTextField(26);
		jcbState = new JComboBox<String>(states);
		jtxtfZip = new JTextField(5);
		jtxtfPhone = new JTextField(9);
		jtxtaMessageArea = new JTextArea(2,29);
		jtxtaMessageArea.setEditable(false);
		jtxtaMessageArea.setLineWrap(true);
		jtxtaMessageArea.setWrapStyleWord(true);
		
		btnAdd = new JButton("Add " + person);
		btnClose = new JButton("Close");
		btnDelete = new JButton("Delete File");
		
		//Get a container for the frame
		Container c = mainFrame.getContentPane();
		//Set the layout of the container
		c.setLayout(new FlowLayout());
		
		//Add components to the container
		c.add(jlblPersonName);
		c.add(jtxtfPersonName);
		c.add(jlblAddress);
		c.add(jtxtfAddress);
		c.add(jlblCity);
		c.add(jtxtfCity);
		c.add(jlblState);
		c.add(jcbState);
		c.add(jlblZip);
		c.add(jtxtfZip);
		c.add(jlblPhone);
		c.add(jtxtfPhone);
		
		c.add(btnAdd);
		c.add(btnClose);
		c.add(btnDelete);
		
		c.add(jtxtaMessageArea);
		
		//Set the mnemonic for each button
		btnAdd.setMnemonic('A');
		btnClose.setMnemonic('C');
		btnDelete.setMnemonic('D');
		
		//Set the size of the GUI frame
		mainFrame.setSize(350, 300);
		mainFrame.setResizable(false);
		
		//Terminate the opened JFrame window, but keep parent program open
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
				mainFrame.dispose();
				//mainFrame.setVisible(false);
			}
		} );
		
		//Add action listener to each button
		AddButtonHandler ahandler = new AddButtonHandler();
		btnAdd.addActionListener(ahandler);
		
		CloseButtonHandler chandler = new CloseButtonHandler();
		btnClose.addActionListener(chandler);
		
		DeleteButtonHandler dhandler = new DeleteButtonHandler();
		btnDelete.addActionListener(dhandler);
		
		//Set the GUI frame visible
		mainFrame.setVisible(true);
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * Add button. The required method actionPerformed
	 * is created to add a new person (customer/contractor)
	 * to the text file.
	 */

	class AddButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			appendToFile();
		}
	}
	
	public void appendToFile()
	{
		try
		{
			// Write to a text file using File, FileOutputStream,
			// and a PrintWriter. 2nd parm is boolean FileChosen.exists():
			// true means append to the FileOutputStream     
			// false means to overwrite the FileOutputStream			
			fosOut = new FileOutputStream(FileChosen, FileChosen.exists());
			PrintWriter pwOut = new PrintWriter(fosOut);
			String s = "";
			s += "Name: "    + jtxtfPersonName.getText() + "\n";
			s += "Address: " + jtxtfAddress.getText()    + "\n";
			s += "City: "    + jtxtfCity.getText()       + "\n";
			s += "State: "   + jcbState.getSelectedItem() + "\n";
			s += "Zip: "     + jtxtfZip.getText()        + "\n";
			s += "Phone: "   + jtxtfPhone.getText()      + "\n";
			s += "\n";
			pwOut.print(s);
			pwOut.close();
			jtxtaMessageArea.setText(Person + " added!");			
		}
		catch (NullPointerException | IOException ioEx)
		{
			jtxtaMessageArea.setText("Error appending " + Person + " to file.");
		}
	}
	
	/**
	 * This class implements the ActionListner interface
	 * and handles the action of the Delete button.
	 */	
	class DeleteButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FileChosen.delete();
			jtxtaMessageArea.setText("Your file has been deleted: "
					+ FileChosen);		
		}
	}
	
	/**
	 * This class implements the ActionListner interface
	 * and handles the action of the Close button.
	 * Terminate the opened JFrame window, but keep parent program open.
	 */	
	class CloseButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.exit(0);
			mainFrame.dispose();
			//mainFrame.setVisible(false);
		}
	} 
			
	public static void main(String[] args)
	{
		new AddPerson("No-One-Yet", null);
	}
}
