/***********************************************************************
Program Name: ShowEscapeSequencesGUI.java
Programmer's Name: Doug Woolley
Program Description: GUI version of ShowEscapeSequence.java
***********************************************************************/ 

package week1;

import javax.swing.*;

// Declaring class
public class ShowEscapeSequencesGUI extends JFrame {
    //serialization runtime
    private static final long serialVersionUID = 1L;
    
    //Constructor to initialize class
    public ShowEscapeSequencesGUI(){
        
        //Variables
        //Window Size: 475x200
        //Window Title: Show Escape Sequences
        this.setSize(475,200);
        this.setTitle("Show Escape Sequences");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Calling object Label from swing
        //I used html tags for layout -- it is a short cut to layout design
        JLabel text = new JLabel();
        text.setText("<html>I really like"
                     + "<br>CIS355A"
                     + "<br>&emsp\"Business Application Programming with Lab using JAVA\"</html>");
        this.add(text);
    }
    
    public static void main(String[] args){ 
        
        //create an instance of ShowEscapeSequences
        //make window visible
    	ShowEscapeSequencesGUI initApp = new ShowEscapeSequencesGUI();
        initApp.setVisible(true);
    }
}

