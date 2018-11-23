package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R218_Div2_B //Name: Fox Dividng Cheese
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
		int a = in.nextInt();	
		int b = in.nextInt();
		
		int cnt = 0;
		
		int a2=0,a3=0,a5=0, b2=0,b3=0,b5=0;		

		while (a % 2 == 0) {a2++; a /= 2;}
		while (a % 3 == 0) {a3++; a /= 3;}
		while (a % 5 == 0) {a5++; a /= 5;}
		while (b % 2 == 0) {b2++; b /= 2;}
		while (b % 3 == 0) {b3++; b /= 3;}
		while (b % 5 == 0) {b5++; b /= 5;}
		
		if (a != b) 
			cnt = -1;
		else
			cnt = Math.abs(a2-b2) + Math.abs(a3-b3) + Math.abs(a5-b5);
		
		out.println(cnt);		
	}
}
