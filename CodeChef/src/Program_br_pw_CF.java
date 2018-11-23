//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

class Program_br_pw_CF //Name: 
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
		
		//*** Don't use br version; Giving Runtime Error(NZEC) in CC
		//*** NZEC stands for Non Zero Exit Code. For C users, this will be 
		//*** generated if your main method does not have a return 0; statement. 
		//*** Other languages like Java/C++ could generate this error if they 
		//*** throw an exception
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
        int T = Integer.parseInt(in.readLine());
        for (int t = 0; t < T; t++)
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
}
