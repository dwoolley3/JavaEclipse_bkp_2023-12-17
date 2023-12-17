/***********************************************************************
Program Name:        Date.java
Programmer's Name:   Doug Woolley
Program Description: This class contains three integer instance
 					 variables named month, day, and year.
                     This class contains a constructor that initializes
                     the month, day, and year variables.
                     This class contains a method named nextDay() that 
                     increments the date by 1 day.
 ***********************************************************************/

package week3Date;

import javax.swing.JTextField;

public class Date

{ // start class
	
	// instance variables
	private int month;
	private int day;
	private int year;
	
	//Parameterized constructor to initialize month, day, and year variables
	public Date(int m, int d, int y)
	{
		month = m;
		day = d;
		year = y;
	}
	
	// class methods
	
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }	

	public String nextDay() {
		//Method nextDay() to increment the day by one. 
		//The Date object should always remain in a consistent state.
		//Return a string value with a phrase and the next day's date.
		
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (year % 400 == 0)
			daysInMonth[1]++;   //leap year; add 1 to February
		else if (year % 4 == 0 && year % 100 != 0)
			daysInMonth[1]++;   //leap year; add 1 to February
		
		int d, m, y;
		d = day + 1;  //Increment day by one
		m = month;
		String s = "";		
		if (d > daysInMonth[m-1])
		{
			s = "Day " + d + " invalid. Set to day 1" + "\n\r";
			d = 1;
			m++;
			if (m > 12)
			{
				m = 1;
				year++;
			}
		}
		month = m;
		day = d;
		
		s += "Incremented Date: " + month + "/" + day + "/" + year;
		return s;
	} 

} // end class
