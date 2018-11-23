package readers;

//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class Program_br_pw_CF //Name: R214_Div2_#
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		//Reading 100,000 numbers on a line takes 3 times longer with Scanner
		//Scanner = 436ms; BufferedReader w/split = 186ms; w/o split = 124ms
		//For 200,000 numbers on a line: Scanner = 810ms; BR w/split = 280ms.
		//Thus, use BufferedReader instead of Scanner if time is critical.
		// Fast Reader - uses Buffered Reader and special Input Reader class;
		// It is 25% faster than just using Buffered Reader, which itself is 
		// 100% faster than using Scanner.  2000+ms to 1028ms to 810ms!
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		int n = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		
		//String[] s = in.readLine().split(" ");
        String[] s = in.readLine().split("\\s+");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(s[i]);
		
		String st = in.readLine();
		
		StringBuilder sb = new StringBuilder(st + k);
		sb.append("\r\n");
		
		out.println(sb);		
	}
}
