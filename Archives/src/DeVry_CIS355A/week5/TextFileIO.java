package week5;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFileIO extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton displayResult;
	JTextArea displayArea;

	public TextFileIO() {
		super("TextFileIO");
		setSize(700, 400);
		displayResult = new JButton("Display Results");
		displayArea = new JTextArea(50, 30);
		getContentPane();

		setLayout(new FlowLayout());
		add(displayResult);
		add(displayArea);

		displayButtonHandler dhandler = new displayButtonHandler();
		displayResult.addActionListener(dhandler);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	class displayButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			displayArea.setText("Doug");
			File fileOne = new File("numbers.dat");
			fileOne.delete();
			File newFile = new File("numbers.dat");
			//1newFile.createNewFile();
			// Create writer object
			//2PrintWriter writer = new PrintWriter(new FileWriter("numbers.dat"));
			// Loop from 1 to 100
			for (int i = 1; i <= 100; i++) {
				// If number is even, write to file
				if (i % 2 == 0) {
			//3		writer.print(i + ",");
				}
			}
			// Loop from 1 to 100
			for (int i = 1; i <= 100; i++) {
				// If number is odd, write to file
				if (i % 2 == 1) {
			//4		writer.print(i + ",");
				}
			}
			//5writer.close();
			// Read from file
			//6FileInputStream fileStream = new FileInputStream("numbers.dat");
			//7DataInputStream in = new DataInputStream(fileStream);
			//8BufferedReader reader = new BufferedReader(
			//9		new InputStreamReader(in));
			// Print line
			//10 displayArea.setText(reader.readLine());
			//10reader.close();
			displayArea.setText("Doug");
		}
	}

	public static void main(String[] args) {
		TextFileIO textFile = new TextFileIO();
		textFile.setVisible(true);
	}
}
