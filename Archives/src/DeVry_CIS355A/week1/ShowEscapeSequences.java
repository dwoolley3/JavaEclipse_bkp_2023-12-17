/***********************************************************************
Program Name:        ShowEscapeSequences.java
Programmer's Name:   Doug Woolley
Program Description: This program will display three lines. Each new line
                     is generated using an escape sequence for a new line.
                     Further, Escape sequences are used for a tab and double quotes.
***********************************************************************/ 

package week1;

public class ShowEscapeSequences {

	public static void main(String[] args) {
		System.out.print("I really like\n"
				+ "CIS355A\n"
				+ "\t\"Business Application Programming with Lab using JAVA\"\n");
	}

}
