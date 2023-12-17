/***********************************************************************
Program Name:        Tab2JPanelTextFileIO.java
Programmer's Name:   Doug Woolley
Program Description: This program will create a tab for a Text File IO. 
     This program will interact with a user who may click 1 of 2 buttons:
       1) Write & Display Even Numbers (which creates a file)
       2) Append & Display Odd Numbers (which appends to the file)
     to accomplish the following:
       1) Allow user to choose a file (default = numbers.txt) to create in
          a directory, using JFileChooser.
       2) Write the even numbers from 1 to 100 in the file.
       3) Display the file's contents (even numbers) to the screen.
       4) Append the odd numbers from 1 to 100 to the file.
       5) Display file's contents (even numbers and odd numbers) to the screen.
 ***********************************************************************/

package week5;


import javax.swing.*;    // for Swing
import java.awt.*;       // for awt
import java.awt.event.*; // for events
import java.io.*;        // for io

public class Tab2JPanelTextFileIO extends JPanel // instead of JFrame
{
	static final long serialVersionUID = 54321; // assign any number
	
	// Declare variables for controls needed to create GUI
	private JPanel jpnl1;

	// private JFrame mainFrame;
	private JButton btnOdd;
	private JButton btnEven;
	private JTextArea jtxtaKindOfDay;

	private JFileChooser jfcWrite;  // JFilechooser to write data
	private JTextArea jtxtaMessage; // output area for file
	private File fileNameOfRead;    // jfc read selected file
	private File fileNameOfWrite;   // jfc write selected file

	// constructor
	public Tab2JPanelTextFileIO() {
		// mainFrame = new JFrame("Messages");

		jpnl1 = new JPanel(); // Create JPanel to put into Tab
		jpnl1.setPreferredSize(new Dimension(300, 350));
		jpnl1.setOpaque(true); // Set to opaque, not transparent

		btnEven = new JButton("Write & Display Even Numbers");
		btnOdd = new JButton("Append & Display Odd Numbers");
		btnEven.setBackground(Color.green);
		btnOdd.setBackground(Color.red);
		jtxtaKindOfDay = new JTextArea(10, 24);
		jtxtaKindOfDay.setEditable(false); // Display only
		jtxtaKindOfDay.setWrapStyleWord(true);
		jtxtaKindOfDay.setLineWrap(true);
		jtxtaMessage = new JTextArea(7, 24);
		jtxtaMessage.setEditable(false);

		jpnl1.setLayout(new FlowLayout());
		jpnl1.add(btnEven);
		jpnl1.add(btnOdd);
		jpnl1.add(jtxtaKindOfDay);
		jpnl1.add(jtxtaMessage);
		jpnl1.setBackground(Color.yellow); // Set Tab/Panel color

		//btnEven.setMnemonic('E');
		//btnOdd.setMnemonic('O');

		ButtonsHandler bhandler = new ButtonsHandler();
		btnEven.addActionListener(bhandler);
		btnOdd.addActionListener(bhandler);

		// Add jpnl1 to Tab, i.e, this JPanel class
		add(jpnl1);
	}

	public void writeEvenNumbersToFile()
	{ // start writeEvenNumbersToFile()
		jfcWrite = new JFileChooser();

		jfcWrite.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfcWrite.setSelectedFile(new File("numbers.txt")); // suggested name
		int intReturnFromJFCWrite = jfcWrite.showSaveDialog(null);

		if (intReturnFromJFCWrite == JFileChooser.APPROVE_OPTION)
			try { // start approve try
					fileNameOfWrite = jfcWrite.getSelectedFile();
					jtxtaMessage.setText("You chose " + fileNameOfWrite);

					// Write to a text file using File, FileOutputStream,
					// and a PrintWriter
					// true means append to the FileOutputStream     (for odd)
					// false means to overwrite the FileOutputStream (for even)
					
					FileOutputStream fosOut = new FileOutputStream(
							fileNameOfWrite, false);
					PrintWriter pwOut = new PrintWriter(fosOut);
			
					// Produce even numbers, from 2 to 100
					for (int i = 2; i <= 100; i += 2) {
						if (i == 2)
							pwOut.print(i);
						else
							pwOut.print("," + i);
					}

					pwOut.close();
					
					jtxtaMessage.append("\nYour file has been written with even numbers.");

				} // end approve try
			catch (IOException ioEx)
				{ // start approve catch
					jtxtaMessage.append("\nApprove JFC is Bad");
				} // end approve catch

		if (intReturnFromJFCWrite == JFileChooser.CANCEL_OPTION
				|| intReturnFromJFCWrite == JFileChooser.ERROR_OPTION)
		{
			jtxtaMessage.setText("You either cancelled " + "or had an error, "
					+ "\nwith a Save JFileChooser");
		} 
	} // end writeEvenNumbersToFile()

	public void appendOddNumbersToFile()
	{
		try
		{
			// Write to a text file using File, FileOutputStream,
			// and a PrintWriter
			// true means append to the FileOutputStream     (for odd)
			// false means to overwrite the FileOutputStream (for even)
			FileOutputStream fosOut = new FileOutputStream(
					fileNameOfWrite, true);
			PrintWriter pwOut = new PrintWriter(fosOut);
							
			// Produce odd numbers, from 1 to 99
			for (int i = 1; i <= 100; i += 2) {
				pwOut.print("," + i);
			}
			pwOut.close();
		}
		catch (NullPointerException | IOException ioEx)
		{
			jtxtaMessage.append("\nError appending file.");
		}
		
		jtxtaMessage.append("\nYour file has been appended with odd numbers.");
	}
	
	public void readFromFile()
	{ // start readFromFile()
		try 
		{				
			fileNameOfRead = fileNameOfWrite;
			jtxtaMessage.append("\nReading file " + fileNameOfRead);

			FileInputStream fileStream = new FileInputStream(
					fileNameOfRead);
			DataInputStream in = new DataInputStream(fileStream);
			BufferedReader bufrRead = new BufferedReader(
					new InputStreamReader(in));
			// Read and display the single line from the file
			jtxtaKindOfDay.setText(bufrRead.readLine());
			bufrRead.close();
			
			jtxtaMessage.append("\nYour file has been read and displayed");
		}
		catch (NullPointerException | IOException ioEx)
		{
			jtxtaMessage.append("\nError reading file.");
		}
	} // end readFromFile()

	class ButtonsHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnEven) {
				//Prompt user for output file name and write even numbers to file					
				writeEvenNumbersToFile();
				readFromFile();
			}
			if (e.getSource() == btnOdd) {								
				appendOddNumbersToFile();
				readFromFile();
			}
		}
	}
}