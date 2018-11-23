package codeforces;

import java.util.*; //Scanner, Calendar
import java.io.PrintWriter; //PrintWriter
import java.text.*;   //SimpleDateFormat

public class R183_Div2_B
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
        String d1 = in.nextLine(); //yyyy:MM:dd
        String d2 = in.nextLine(); //yyyy:MM:dd
        SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));  //optional
        try {
            Date date1 = format.parse(d1);
            Date date2 = format.parse(d2);

    		long diff = Math.abs(date2.getTime() - date1.getTime()); //milliseconds
    		long diffDays = diff / (24 * 60 * 60 * 1000);            
    		out.println(diffDays);	    	
    		
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}
}
