import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class Program_sc_pw_CF //Name: 
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
		int k = in.nextInt();
		//in.nextLine();  //Read end of line after int and before a real .nextLine()
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		String s = in.next();
		
		StringBuilder sb = new StringBuilder(s + k);
		sb.append("\r\n");
		
		out.println(sb);		
	}
}
