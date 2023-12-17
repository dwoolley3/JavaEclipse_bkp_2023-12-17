 /***********************************************************************
 Program Name:        Tab4JPanelContractors.java
 Programmer's Name:   Doug Woolley
 Program Description: This program is not used or needed since tab 3 and
  	tab 4 are combined in Tab3_4JPanelCustomers.java.  	
 ***********************************************************************/

 package week7;

 import javax.swing.*;    // for Swing
 import java.awt.*;       // for awt
 import java.awt.event.*; // for events
 import java.io.*;        // for io

 public class Tab4JPanelContractors extends JPanel // instead of JFrame
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
 	private File fileNameChosen;      // jfc selected file
 	
 	private String person;   //"Customer" or "Contractor"

 	// constructor
 	public Tab4JPanelContractors() {

 		jpnl1 = new JPanel(); // Create JPanel to put into Tab
 		jpnl1.setPreferredSize(new Dimension(300, 300));
 		jpnl1.setOpaque(true); // Set to opaque, not transparent
 		
 		person = "Contractor";  //"Customer" or "Contractor"

 		btnExit = new JButton("Exit");
 		btnAddPerson= new JButton("Add " + person);
 		btnRefresh = new JButton("Refresh");
 		jtxtaCustomerDisplay = new JTextArea(10, 25);
 		jtxtaCustomerDisplay.setEditable(false); // Display only
 		jtxtaCustomerDisplay.setWrapStyleWord(true);
 		jtxtaCustomerDisplay.setLineWrap(true);
 		jtxtaMessageArea = new JTextArea(2,25);
 		jtxtaMessageArea.setEditable(false);
 		jtxtaMessageArea.setLineWrap(true);
 		jtxtaMessageArea.setWrapStyleWord(true);

 		jpnl1.setLayout(new FlowLayout());
 		jpnl1.add(jtxtaCustomerDisplay);
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
 				"Select Add " + person + " to add " + person + "s. "
 				+ "Select Refresh to refresh this pane.");

 		//getFileName();
 		
 		// Add jpnl1 to Tab, i.e, this JPanel class
 		add(jpnl1);
 	}

 	public void getFileName()
 	{
 		jfcChooser = new JFileChooser();

 		jfcChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
 		jfcChooser.setSelectedFile(new File("customer.txt")); // suggested name "customer.txt"
 		int intReturnFromJFC = jfcChooser.showSaveDialog(null);

 		if (intReturnFromJFC == JFileChooser.APPROVE_OPTION)
 		{
 			fileNameChosen = jfcChooser.getSelectedFile();
 			jtxtaMessageArea.setText("You chose " + fileNameChosen);

 			// If file does not exist, write message
 			jtxtaMessageArea.setText("File " + fileNameChosen
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

 	public void appendOddNumbersToFile()
 	{
 		try
 		{
 			// Write to a text file using File, FileOutputStream,
 			// and a PrintWriter
 			// true means append to the FileOutputStream     (for odd)
 			// false means to overwrite the FileOutputStream (for even)
 			FileOutputStream fosOut = new FileOutputStream(
 					fileNameChosen, true);
 			PrintWriter pwOut = new PrintWriter(fosOut);
 							
 			// Produce odd numbers, from 1 to 99
 			for (int i = 1; i <= 100; i += 2) {
 				pwOut.print("," + i);
 			}
 			pwOut.close();
 		}
 		catch (NullPointerException | IOException ioEx)
 		{
 			jtxtaMessageArea.append("\nError appending file.");
 		}
 		
 		jtxtaMessageArea.append("\nYour file has been appended with odd numbers.");
 	}
 	
 	public void readFromFile()
 	{ // start readFromFile()
 		try 
 		{				
 			FileInputStream fileStream = new FileInputStream(
 					fileNameChosen);
 			DataInputStream in = new DataInputStream(fileStream);
 			BufferedReader bufrRead = new BufferedReader(
 					new InputStreamReader(in));
 			// Read and display the single line from the file
 			jtxtaCustomerDisplay.setText(bufrRead.readLine());
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
 	 * is created to read the input values of the input fields
 	 * and calculate the area of an office given the dimensions.
 	 */

 	class btnAddPersonHandler implements ActionListener
 	{
 		public void actionPerformed(ActionEvent e)
 		{			
 			//Open AddPerson in new window for Customer/Contractor
 			new AddPerson(person, null);
 			//new AddCustomer("Contractor");

 			//jtxtfMessage.setText("\nCompany Name changed to " + companyName);
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
 			String companyName;			
 			//companyName = jtxtfCompanyName.getText();

 			//jtxtfMessage.setText("\nCompany Name changed to " + companyName);
 		}
 	}
 }