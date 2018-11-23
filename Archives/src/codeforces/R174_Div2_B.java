package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R174_Div2_B //Name: Cows and Poker Game
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
		int n = in.nextInt();	
		String s = in.next();
		
		int[] a = new int[26];
		for (int i = 0; i < n; i++) 
			a[s.charAt(i) - 'A']++;

	    int cnt = 0;
	    if (a['I' - 'A'] == 1)
	        cnt = 1;
	    else if (a['I' - 'A'] > 1)
	        cnt = 0;
	    else
	        cnt = (a['A' - 'A']);
		
		out.println(cnt);		
	}
}
