package codeforces;
//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter
import java.util.Arrays;

public class R175_Div2_C_br //Name: 
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
		
		String[] s = in.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(s[i]);
		
        //Randomize array to avoid QuickSort worst-case O(n^2) scenario for 300,000 items
        int r, temp;
        for (int i = 0; i < n; i++)
        {
            r = (int)Math.random()*n;
            temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        
        Arrays.sort(a);
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.abs(a[i] - (i + 1));
		
		out.println(sum);			
	}
}
