package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R197_Div2_A //Name: Helpful Maths
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
        String st = in.next();
        String[] s = st.split("[+]");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.valueOf(s[i]);
        Arrays.sort(a);
        for (int i = 0; i < n; i++)
            if (i > 0)
                out.print("+" + a[i]);
            else
            	out.print(a[i]);
        
		out.println();		
	}

}
