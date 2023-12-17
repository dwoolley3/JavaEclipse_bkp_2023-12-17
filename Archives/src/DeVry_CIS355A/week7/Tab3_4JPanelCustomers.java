/***********************************************************************
Program Name:        Tab3_4JPanelCustomers.java
Programmer's Name:   Doug Woolley
Program Description: This program will function as Tabs 3 & 4 for 
 	"Customers" and "Contractors", distinguishing between the two 
 	by passing a parameter of "Customer" or "Contractor" as Person.
 	User can select one of three buttons: Exit, Add, Refresh. The first
 	time that the user clicks "Add" or "Refresh", the program prompts
 	the user with a JFileChooser to select a file name for which to
 	open or create. The user can click the Add button to proceed to a
 	new JFrame window to enter Name, Address, and Phone to add to the
 	chosen file. A user could also Delete the file, if desired.
 	Upon closing the "Add" window, the main tab appears. Clicking 
 	"Refresh" button will display the contents of the file to the screen.
 ***********************************************************************/

package week7;

import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events
import java.io.*;        // for io

public class Tab3_4JPanelCustomers extends JPanel // instead of JFrame
{
	static final long serialVersionUID = 54321; // assign any number
	
	// Declare variables for controls needed to create GUI
	private JPanel jpnl1;
	private JButton btnExit;
	private JButton btnAddPerson;
	private JButton btnRefresh;
	private JTextArea jtxtaCustomerDisplay;
	private JTextArea jtxtaMessageArea;

	private JFileChooser jfcChooser;  // JFilechooser to read/write data
	FileInputStream fileStream;
	private File FileChosen = null;   // jfc selected file
	private String Person = "Customer";   //"Customer" or "Contractor"

	// constructor
	public Tab3_4JPanelCustomers() {	}
	public Tab3_4JPanelCustomers(String person) 
	{
		jpnl1 = new JPanel(); // Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(320, 310));
		jpnl1.setOpaque(true); // Set to opaque, not transparent
		
		//Assign class "Person" variable to the parameter value of person
		if (person == "Customer" || person == "Contractor")
			Person = person;  // "Customer" or "Contractor"

		btnExit = new JButton("Exit");
		btnAddPerson= new JButton("Add " + Person);
		btnRefresh = new JButton("Refresh");
		jtxtaCustomerDisplay = new JTextArea(13, 25);
		jtxtaCustomerDisplay.setEditable(false); // Display only
		jtxtaCustomerDisplay.setWrapStyleWord(true);
		jtxtaCustomerDisplay.setLineWrap(true);
		jtxtaMessageArea = new JTextArea(2,25);
		jtxtaMessageArea.setEditable(false);
		jtxtaMessageArea.setLineWrap(true);
		jtxtaMessageArea.setWrapStyleWord(true);

		jpnl1.setLayout(new FlowLayout());

		JScrollPane scrollV = new JScrollPane (jtxtaCustomerDisplay);
		scrollV.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jpnl1.add(scrollV);		
		//jpnl1.add(jtxtaCustomerDisplay);
		
		jpnl1.add(btnExit);
		jpnl1.add(btnAddPerson);
		jpnl1.add(btnRefresh);
		jpnl1.add(jtxtaMessageArea);

		//jpnl1.setBackground(Color.yellow); // Set Tab/Panel color

		//Set the mnemonic for each button
		btnExit.setMnemonic('X');
		btnAddPerson.setMnemonic('A');
		btnRefresh.setMnemonic('R');

		//Add action listener to each button
		btnExitHandler ehandler = new btnExitHandler();
		btnExit.addActionListener(ehandler);
		
		btnAddPersonHandler ahandler = new btnAddPersonHandler();
		btnAddPerson.addActionListener(ahandler);
		
		btnRefreshHandler rhandler = new btnRefreshHandler();
		btnRefresh.addActionListener(rhandler);
		
		jtxtaCustomerDisplay.setText(
				"Select Add " + Person + " to add " + Person + "s. "
				+ "Select Refresh to refresh this pane.");
		
		jtxtaMessageArea.setText("If file " + Person
				+ " does not exist yet - "
				+ "it will be created when you add " + Person + "s!");
		
		// Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}

	public void getFile()
	{	
		jfcChooser = new JFileChooser();

		jfcChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		// suggest name of "Customer.txt" or "Contractor.txt";
		jfcChooser.setSelectedFile(new File(Person + ".txt")); 
		//int intReturnFromJFC = jfcChooser.showSaveDialog(null);
		int intReturnFromJFC = jfcChooser.showOpenDialog(null);

		if (intReturnFromJFC == JFileChooser.APPROVE_OPTION)
		{
			FileChosen = jfcChooser.getSelectedFile();
			jtxtaMessageArea.setText("You chose " + FileChosen);

			// If file does not exist, write message
			if (FileChosen.exists())
				jtxtaMessageArea.setText("File "+ FileChosen
						+ "exists and can be read from!");
			else
				jtxtaMessageArea.setText("File " + FileChosen
					+ " does not exist yet - will be created"
					+ " when you add customers!");					
		}
		else if (intReturnFromJFC == JFileChooser.CANCEL_OPTION
			  || intReturnFromJFC == JFileChooser.ERROR_OPTION)
		{
			jtxtaMessageArea.setText("You either cancelled "
					+ "or had an error, "
					+ "with a JFileChooser");
		} 
	}
	
	public void readFromFile()
	{
		try 
		{			
			if (FileChosen == null)
				getFile();
			fileStream = new FileInputStream(FileChosen);
			
			DataInputStream in = new DataInputStream(fileStream);
			BufferedReader bufrRead = new BufferedReader(
					new InputStreamReader(in));
			
			// Read and display the lines from the file
			jtxtaCustomerDisplay.setText("");
			String line = bufrRead.readLine();
			while (line != null)
			{
				jtxtaCustomerDisplay.append(line + '\n');
				line = bufrRead.readLine();
			}
			bufrRead.close();
			}
		catch (NullPointerException | IOException ioEx)
		{
			jtxtaMessageArea.append("\nError reading file.");
		}
	} // end readFromFile()
	
	/**
	 * This class implements the ActionListner interface
	 * and handles the action of the Exit button
	 */	
	class btnExitHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	} 
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * AddPerson button. The required method actionPerformed
	 * is created to open a new JFrame window to allow the user
	 * to enter person data (for Customer or Contractor).
	 * The File Chosen will be passed to the new program too.
	 */

	class btnAddPersonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			//Open AddPerson in new window for Customer/Contractor,
			//and pass the FileChosen
			if (FileChosen == null)
				getFile();
			new AddPerson(Person, FileChosen);
		}
	}
	
	/**
	 * This class implements the interface ActionListener.
	 * It is a class that will handle the action on the
	 * button Refresh. The required method actionPerformed
	 * is created to read the contents of the chosen file
	 * and display the results in the text area.
	 */

	class btnRefreshHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{			
			if (FileChosen == null)
				getFile();
			if (FileChosen.exists())
			{
				readFromFile();	 //Read file and place contents in display
				jtxtaMessageArea.setText("File exists and can be read from!");
			}
			else
			{
				jtxtaMessageArea.setText("File " + FileChosen
					+ " does not exist yet - will be created"
					+ " when you add " + Person + "s!");	
				jtxtaCustomerDisplay.setText("");
			}
		}
	}
}