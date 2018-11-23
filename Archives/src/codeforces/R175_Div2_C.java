package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R175_Div2_C //Name: Building Permutation
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
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
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
