package Week4Michael;

/****************************************************************************
 Program Name: TabbedPane of DayGui and OfficeAreaCalculator programs
 Programmers Name: Michael Sparling
 Program Description: This program is a tabbed pane that runs two different
 programs- DayGui and OfficeAreaCalculator.
 *****************************************************************************/

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JPanel;

public class Wk4FINAL extends JFrame {

	private static final long serialVersionUID = 1L;

	public Wk4FINAL() {
	}

	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Tabbed Programs");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JTabbedPane tabbedPane = new JTabbedPane();                //moved here
	    tabbedPane.addTab("DayGui", new Tab3JPanelDayGui());                  //moved here
	    tabbedPane.addTab("OfficeCalc", new Tab2JPanelOfficeAreaCalculator());  //moved here
		myFrame.getContentPane().add(tabbedPane); 
		myFrame.pack();
		myFrame.setVisible(true);
	}

} // added - Doug
