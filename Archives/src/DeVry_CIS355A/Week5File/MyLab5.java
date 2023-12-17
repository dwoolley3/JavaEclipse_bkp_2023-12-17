package Week5File;

//written by Bohdan Stryk - Senior Professor - Devry University - Phoenix, AZ
//email: bstryk@phx.devry.edu
//CIS355A – 61747-Aug 2013

import javax.swing.*; //put this in for Swing
import java.awt.*; //put this in for awt
import java.awt.event.*; //put this in for events
import java.io.*; //put this in for files

public class MyLab5 extends JFrame

{ // start of class MyLab5

	// attributes

	private JButton jbutClear;

	private JButton jbutEnd;

	private JPanel jpanTop; // top jpanel

	private JPanel jpanMiddle; // middle jpanel

	private JPanel jpanBottom; // bottom panel

	// top panel

	private JTextArea jtxaTop; // jtextarea for top jpanel

	private JButton jbutRead; // read the data from a file

	private JButton jbutWrite; // write the data to a file

	private FlowLayout flLt1; // flow layout for top jpanel

	private JFileChooser jfcWrite; // JFilechooser to write data

	private JFileChooser jfcRead; // JFilechooser to read data

	private JButton jbutCheckAcct; // button for checking account

	private JButton jbutMortgage; // button for mortgage

	private boolean isCheckAcct = false; // is it a checking acct???

	private boolean isMortgage = false; // is it a mortgage???

	// middle panel

	private JButton jbutName; // button for name - Account class

	private JTextField jtxfName; // text field for first name - Account class

	private JButton jbutAddress; // button for address - Account class

	private JTextField jtxfAddress; // text field for address - Account class

	private JButton jbutCSZ; // button for city, state, zip - Account class

	private JTextField jtxfCSZ; // text field for city, stat, zip - Account
								// class

	private JButton jbutCheckAcctNum; // button for number - CheckAcct class

	private JTextField jtxfCheckAcctNum; // text field for number - CheckAcct
											// class

	private JButton jbutCheckAcctType; // button for type - CheckAcct class

	private JTextField jtxfCheckAcctType; // text field for type - CheckAcct
											// class

	private JButton jbutCheckAcctDep; // button for deposit - CheckAcct class

	private JTextField jtxfCheckAcctDep; // text field for deposit - CheckAcct
											// class

	private JButton jbutCheckAcctBal; // button for balance - CheckAcct class

	private JTextField jtxfCheckAcctBal; // text field for balance - CheckAcct
											// class

	private JButton jbutMortNum; // button for number - Mortgage class

	private JTextField jtxfMortNum; // text field for number - Mortgage class

	private JButton jbutMortAmt; // button for amount - Mortgage class

	private JTextField jtxfMortAmt; // text field for amount - Mortgage class

	private JButton jbutMortTerm; // button for term - Mortgage class

	private JTextField jtxfMortTerm; // text field for term - Mortgage class

	private JButton jbutMortIntRate; // button for int rate - Mortgage class

	private JTextField jtxfMortIntRate; // text field - int rate - Mortgage
										// class

	private GridLayout grLt1; // grid layout for middle jpanel

	private File fileNameOfWrite; // jfc write selected file

	private File fileNameOfRead; // jfc read selected file

	// bottom panel

	private JTextArea jtxaBottom; // output area for file

	private JScrollPane jscpBottom; // scroll pane for bottom output area

	private String str1 = "   Wk 5, CIS355A-61747 Aug 2013, Soln by Bohdan Stryk ";
	private String str2 = "   Senior Professor - Devry University - Phoenix Campus ";
	private String str3 = " \temail = bstryk@phx.devry.edu ";
	private String str4 = str1 + "\n" + str2 + "\n";

	private String str5 = "You hit the clear button";

	// my other classes

	Account acctMy;

	CheckAcct caMy;

	Mortgage mortMy;

	public MyLab5()

	{ // start of constructor

		super("Week 5 CIS335A-61035-Apr-2013"); // tile of the JFrame

		final Container theWindow = getContentPane(); // get ref to the JFrame

		jbutClear = new JButton("Clear Everything");

		jbutEnd = new JButton("End the Program");

		jbutEnd.setToolTipText("This button ends the program");

		// add the clear button to the west and the end button to the east

		theWindow.add(jbutClear, BorderLayout.WEST);

		theWindow.add(jbutEnd, BorderLayout.EAST);

		// create a new jtextarea for the top jpanel

		jtxaTop = new JTextArea(2, 30);

		jtxaTop.setEditable(false);

		jtxaTop.append(str4);

		// do the top jpanel

		jpanTop = new JPanel();

		jbutRead = new JButton("Read Data from File");

		jbutWrite = new JButton("Write Data to file");

		jbutCheckAcct = new JButton("CK Acct");

		jbutMortgage = new JButton("Mortgage");

		flLt1 = new FlowLayout();

		jpanTop.setLayout(flLt1);

		jpanTop.add(jbutCheckAcct);

		jpanTop.add(jbutMortgage);

		jpanTop.add(jtxaTop);

		jpanTop.add(jbutRead);

		jpanTop.add(jbutWrite);

		theWindow.add(jpanTop, BorderLayout.NORTH);

		// do the middle jpanel

		jpanMiddle = new JPanel(); // create middle jpanel

		jbutName = new JButton(" First, Last Name");

		jtxfName = new JTextField(10);

		jbutAddress = new JButton("Address");

		jtxfAddress = new JTextField(10);

		jbutCSZ = new JButton("City, State, Zip");

		jtxfCSZ = new JTextField(10);

		jbutCheckAcctNum = new JButton("Check Acct Num");

		jtxfCheckAcctNum = new JTextField(10);

		jbutCheckAcctType = new JButton("Checking Account Type");

		jtxfCheckAcctType = new JTextField(10);

		jbutCheckAcctDep = new JButton("Checking Account Deposit ");

		jtxfCheckAcctDep = new JTextField(10);

		jbutCheckAcctBal = new JButton("Checking Account Balance");

		jtxfCheckAcctBal = new JTextField(10);

		jbutMortNum = new JButton("Mortgage Number");

		jtxfMortNum = new JTextField(15);

		jbutMortAmt = new JButton("Mortgage Amt");

		jtxfMortAmt = new JTextField(15);

		jbutMortTerm = new JButton("Mortgage Term");

		jtxfMortTerm = new JTextField(15);

		jbutMortIntRate = new JButton("Mortgage Interest Rate");

		jtxfMortIntRate = new JTextField(15);

		grLt1 = new GridLayout(10, 2);

		jpanMiddle.setLayout(grLt1);

		theWindow.add(jpanMiddle, BorderLayout.CENTER);

		// theWindow.add(jpanMiddle, BorderLayout.CENTER);

		// do the bottom panel

		jpanBottom = new JPanel();

		jtxaBottom = new JTextArea(20, 60);

		jscpBottom = new JScrollPane(jtxaBottom); // attach scroll pane to
													// jtxaBottom

		jpanBottom.add(jtxaBottom);

		theWindow.add(jpanBottom, BorderLayout.SOUTH);

		// event handler for jbutCheckAcct

		jbutCheckAcct.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()

						isCheckAcct = true; // this is a check acct

						isMortgage = false; // not a mortgage

						jpanMiddle.removeAll();

						jpanMiddle.repaint();

						jpanMiddle.setLayout(grLt1);

						jpanMiddle.add(jbutName);

						jpanMiddle.add(jtxfName);

						jpanMiddle.add(jbutAddress);

						jpanMiddle.add(jtxfAddress);

						jpanMiddle.add(jbutCSZ);

						jpanMiddle.add(jtxfCSZ);

						jpanMiddle.add(jbutCheckAcctNum);

						jpanMiddle.add(jtxfCheckAcctNum);

						jpanMiddle.add(jbutCheckAcctType);

						jpanMiddle.add(jtxfCheckAcctType);

						jpanMiddle.add(jbutCheckAcctDep);

						jpanMiddle.add(jtxfCheckAcctDep);

						jpanMiddle.add(jbutCheckAcctBal);

						jpanMiddle.add(jtxfCheckAcctBal);

						theWindow.add(jpanMiddle, BorderLayout.CENTER);

						jpanMiddle.validate();

						jpanMiddle.repaint();

						jtxfName.grabFocus();

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// event handler for jbutMort

		jbutMortgage.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()

						isCheckAcct = false;

						isMortgage = true;

						jpanMiddle.removeAll();

						jpanMiddle.repaint();

						jpanMiddle.setLayout(grLt1);

						jpanMiddle.add(jbutName);

						jpanMiddle.add(jtxfName);

						jpanMiddle.add(jbutAddress);

						jpanMiddle.add(jtxfAddress);

						jpanMiddle.add(jbutCSZ);

						jpanMiddle.add(jtxfCSZ);

						jpanMiddle.add(jbutMortNum);

						jpanMiddle.add(jtxfMortNum);

						jpanMiddle.add(jbutMortAmt);

						jpanMiddle.add(jtxfMortAmt);

						jpanMiddle.add(jbutMortTerm);

						jpanMiddle.add(jtxfMortTerm);

						jpanMiddle.add(jbutMortIntRate);

						jpanMiddle.add(jtxfMortIntRate);

						theWindow.add(jpanMiddle, BorderLayout.CENTER);

						jpanMiddle.validate();

						jpanMiddle.repaint();

						jtxfName.grabFocus();

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// event handler for jbutClear

		jbutClear.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()

						jtxfName.setText("");

						jtxfAddress.setText("");

						jtxfCSZ.setText("");

						jtxfCheckAcctNum.setText("");

						jtxfCheckAcctType.setText("");

						jtxfCheckAcctDep.setText("");

						jtxfCheckAcctBal.setText("");

						jtxfMortNum.setText("");

						jtxfMortAmt.setText("");

						jtxfMortTerm.setText("");

						jtxfMortIntRate.setText("");

						jtxaBottom.setText("");

						jtxfName.grabFocus();

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// event handler for jbutEnd

		jbutEnd.addActionListener

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

		// event handler for jbutRead

		jbutRead.addActionListener

		( // start addActionListener()

		new ActionListener()

		{ // start anonymous inner class

			public void actionPerformed(ActionEvent event)

			{ // start actionPerformed()

				if (isCheckAcct)

				{ // start if

					readFromFile();
				} // end if

				if (isMortgage)

				{ // start if

				} // end if

			} // end actionPerformed()

		} // end anonymous inner class

		); // end addActionListener()

		// event handler for jbutWrite

		jbutWrite.addActionListener

		( // start addActionListener()

				new ActionListener()

				{ // start anonymous inner class

					public void actionPerformed(ActionEvent event)

					{ // start actionPerformed()

						if (isCheckAcct)

						{ // start if

							writeToFile();
						} // end if

						if (isMortgage)

						{ // start if

						} // end if

					} // end actionPerformed()

				} // end anonymous inner class

				); // end addActionListener()

		// start using WindowAdapter() to close the JFrame

		addWindowListener

		( // start addWindowListener()

		new WindowAdapter()

		{ // start WindowAdapter anonymous inner class

			public void windowClosing(WindowEvent e)

			{ // start windowClosing()

				System.exit(0);

			} // end windowClosing()

		} // end WAdapter anonymous inner class

		); // end addWindowListener()

		setSize(1100, 800);
		setVisible(true);

		// *******************************************************************

		// end using WindowAdapter() to close the JFrame

		// *******************************************************************

	} // end of constructor

	public void readFromFile()

	{ // start readFromFile()

		jfcRead = new JFileChooser();

		jfcRead.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int intReturnFromJFCRead = jfcRead.showOpenDialog(null);

		if (intReturnFromJFCRead == JFileChooser.APPROVE_OPTION)

			try { // start approve try

				{ // start if

					fileNameOfRead = jfcRead.getSelectedFile();

					jtxaBottom.setText("You chose " + fileNameOfRead);

					// we are going to read from a text file
					// we will use a File, FileReader,
					// and a BufferedReader

					String strBufRIn;

					FileReader filerRead = new FileReader(fileNameOfRead);

					BufferedReader bufrRead = new BufferedReader(filerRead);

					jtxaBottom
							.append("\nYour file has the following raw data::");

					while ((strBufRIn = bufrRead.readLine()) != null)

					{ // start while

						jtxaBottom.append("\n" + strBufRIn);

						breakUpInputData(strBufRIn);

					} // end while

				} // end if

			} // end approve try

			catch (IOException ioEx)

			{ // start approve catch

				JOptionPane.showMessageDialog(null, "Approve JFC is Bad");

			} // end approve catch

		if (intReturnFromJFCRead == JFileChooser.CANCEL_OPTION
				|| intReturnFromJFCRead == JFileChooser.ERROR_OPTION)

		{ // start if

			jtxaBottom.setText("You either cancelled " + "or had an error, "
					+ "\nwith an Open JFileChooser");

		} // end if

	} // end readFromFile()

	public void writeToFile()

	{ // start writeToFile()

		jfcWrite = new JFileChooser();

		jfcWrite.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int intReturnFromJFCWrite = jfcWrite.showSaveDialog(null);

		if (intReturnFromJFCWrite == JFileChooser.APPROVE_OPTION)

			try { // start approve try

				{ // start if

					fileNameOfWrite = jfcWrite.getSelectedFile();

					jtxaBottom.setText("You chose " + fileNameOfWrite);

					// we are going to write to a text file
					// we will use a File, FileOutputStream
					// and a PrintWriter

					// set up polymorphic behavior

					caMy = new CheckAcct();

					acctMy = caMy;

					// true means append to the FileOutputStream

					FileOutputStream fosOut = new FileOutputStream(
							fileNameOfWrite, true);

					PrintWriter pwOut = new PrintWriter(fosOut);

					pwOut.print(jtxfName.getText());

					pwOut.print("~~");

					pwOut.print(jtxfAddress.getText());

					pwOut.print("~~");

					pwOut.print(jtxfCSZ.getText());

					pwOut.print("~~");

					pwOut.print(jtxfCheckAcctNum.getText());

					pwOut.print("~~");

					pwOut.print(jtxfCheckAcctType.getText());

					pwOut.print("~~");

					pwOut.print(jtxfCheckAcctDep.getText());

					pwOut.print("~~");

					pwOut.print(jtxfCheckAcctBal.getText());

					pwOut.println("~~");

					jtxaBottom
							.append("\n\nYou are saving the following fields:"
									+ "\n" + jtxfName.getText() + "\n"
									+ jtxfAddress.getText() + "\n"
									+ jtxfCSZ.getText() + "\n"
									+ jtxfCheckAcctNum.getText() + "\n"
									+ jtxfCheckAcctType.getText() + "\n"
									+ jtxfCheckAcctDep.getText() + "\n"
									+ jtxfCheckAcctBal.getText() + "\n"
									+ "Here is the polymorphic message" + "\n"
									+ acctMy.openCost());

					pwOut.close();

				} // end if

			} // end approve try

			catch (IOException ioEx)

			{ // start approve catch

				JOptionPane.showMessageDialog(null, "Approve JFC is Bad");

			} // end approve catch

		if (intReturnFromJFCWrite == JFileChooser.CANCEL_OPTION
				|| intReturnFromJFCWrite == JFileChooser.ERROR_OPTION)

		{ // start if

			jtxaBottom.setText("You either cancelled " + "or had an error, "
					+ "\nwith a Save JFileChooser");

		} // end if

	} // end writeToFile()

	public void breakUpInputData(String strInData)

	{ // start breakUpInputData()

		String strInOutput = "";
		int intCountFields = 0;

		char charOneChar = 'a';

		String strInName = "";
		String strInAddress = "";
		String strInCSZ = "";
		String strInCheckAcctNum = "";
		String strInCheckAcctType = "";
		String strInCheckAcctDep = "";
		String strInCheckAcctBal = "";

		jtxaBottom.append("\n" + "\n" + "Your parsed data is");

		for (int intStrNum = 0; intStrNum <= strInData.length() - 1; intStrNum++)

		{ // start for

			charOneChar = strInData.charAt(intStrNum);

			if (charOneChar != 126)

			{ // start if

				strInOutput += charOneChar;

				// JOptionPane.showMessageDialog(null, "The char is " +
				// charOneChar );

			} // end if

			else

			{ // start else

				++intCountFields;

				if (intCountFields == 1)

				{ // start inner if field 1

					strInName = strInOutput;

					jtxaBottom.append("\n" + "The Name is " + strInName);

					strInOutput = "";

					++intStrNum;

				} // end inner if field 1

				if (intCountFields == 2)

				{ // start inner if field 2

					strInAddress = strInOutput;

					jtxaBottom.append("\n" + "The Address is " + strInAddress);

					strInOutput = "";

					++intStrNum;

				} // end inner if field 2

				if (intCountFields == 3)

				{ // start inner if field 3

					strInCSZ = strInOutput;

					jtxaBottom.append("\n" + "The City, State, Zip are "
							+ strInCSZ);

					strInOutput = "";

					++intStrNum;

				} // end inner if field 3

				if (intCountFields == 4)

				{ // start inner if field 4

					strInCheckAcctNum = strInOutput;

					jtxaBottom.append("\n" + "The Checking Acct Number is "
							+ strInCheckAcctNum);

					strInOutput = "";

					++intStrNum;

				} // end inner if field 4

				if (intCountFields == 5)

				{ // start inner if field 5

					strInCheckAcctType = strInOutput;

					jtxaBottom.append("\n" + "The Checking Acct Type is is "
							+ strInCheckAcctType);

					strInOutput = "";

					++intStrNum;

				} // end inner if field 5

				if (intCountFields == 6)

				{ // start inner if field 6

					strInCheckAcctDep = strInOutput;

					jtxaBottom.append("\n" + "The Checking Acct Deposit is "
							+ strInCheckAcctDep);

					strInOutput = "";

					++intStrNum;

				} // end inner if field 6

				if (intCountFields == 7)

				{ // start inner if field 7

					strInCheckAcctBal = strInOutput;

					jtxaBottom.append("\n" + "The Checking Acct Bal is "
							+ strInCheckAcctBal);
					strInOutput = "";
					++intStrNum;
				} // end inner if field 7

			} // end else

		} // end for

	} // end breakUpInputData()

} // end of class MyLab5

