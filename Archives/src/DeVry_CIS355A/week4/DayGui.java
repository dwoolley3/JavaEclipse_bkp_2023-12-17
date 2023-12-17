/***********************************************************************
Program Name:        DayGui.java
Programmer's Name:   Doug Woolley
Program Description: 
 ***********************************************************************/

package week4;

import java.awt.*;
import java.awt.event.*;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

public class DayGui extends JFrame
{
	private JFrame mainFrame;
	private JButton cmdGood;
	private JButton cmdBad;
	
	//constructor
	public DayGui()
	{
		mainFrame = new JFrame("Messages");
		
		cmdGood = new JButton("Good");
		cmdBad = new JButton("Bad");
		
		Container c = mainFrame.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(cmdGood);
		c.add(cmdBad);
		
		cmdGood.setMnemonic('G');
		cmdBad.setMnemonic('B');
		
		mainFrame.setSize(300, 100);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		} );
		
		ButtonsHandler bhandler = new ButtonsHandler();
		cmdGood.addActionListener(bhandler);
		cmdBad.addActionListener(bhandler);
		
		mainFrame.setVisible(true);
	}
	
	class ButtonsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == cmdGood)
				JOptionPane.showMessageDialog(null,  "Today is a good day!",
						"Event Handler Message",
						JOptionPane.INFORMATION_MESSAGE);
			
			if (e.getSource() == cmdBad)
				JOptionPane.showMessageDialog(null,  "Today is a bad day!",
						"Event Handler Message",
						JOptionPane.INFORMATION_MESSAGE);
		}		
	}

	public static void main(String[] args) 
	{
		DayGui app = new DayGui();
	}
}