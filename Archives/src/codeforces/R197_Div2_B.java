package codeforces;
//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R197_Div2_B  //Name: Xenia and Ringroad
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//Reading 100,000 numbers on a line takes 3 times longer with Scanner
		//Scanner = 436ms; BufferedReader w/split = 186ms; w/o split = 124ms
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
//		int n = in.nextInt();	
//		int m = in.nextInt();
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		long cnt = 0;

        int a;
        int pos = 1;
    	s = in.readLine().split(" ");
        for (int i = 0; i < m; i++)
        {
        	a = Integer.parseInt(s[i]);
            //a = in.nextInt();
            if (a >= pos)
                cnt += (a - pos);
            else
                cnt += (n - (pos - a));
            pos = a;
        }          
		
		out.println(cnt);		
	}
}
