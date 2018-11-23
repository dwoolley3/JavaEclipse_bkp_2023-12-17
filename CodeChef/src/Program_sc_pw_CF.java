import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

class Program_sc_pw_CF //Name: 
{
	public static void main(String[] args) throws Exception {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
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
}
