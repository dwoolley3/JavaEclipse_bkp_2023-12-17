

//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class Program_br_pw_CF //Name: 
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		int n = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		
		String[] s = in.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(s[i]);
		
		String st = in.readLine();
		
		StringBuilder sb = new StringBuilder(st + k);
		sb.append("\r\n");
		
		out.println(sb);		
	}
}
