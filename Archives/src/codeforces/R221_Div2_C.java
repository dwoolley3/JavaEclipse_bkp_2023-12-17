package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R221_Div2_C
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
		String s = in.next();
		int n = s.length();	
		int[] d = new int[10];
		int[] d2 = new int[10];
		for (int i = 0; i < n; i++)
			d[s.charAt(i) - '0']++;
	
		d[1]--; d[6]--; d[8]--; d[9]--;
		for (int i = 0; i < 10; i++) d2[i] = d[i];	

		int[] nums = {1869, 1689, 8691, 8196, 1968, 6891, 1986}; //, 1869, 1689, 8691};
		
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 10; j++) d[j] = d2[j];		
			int sum = nums[i] % 7, inc = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n-4; j++)
			{
				while (d[inc] == 0) inc++;
				sb.append(inc);
				sum = (sum * 10) + inc;
				sum %= 7;	
				d[inc]--;
			}
			if (sum == 0)
			{
				out.print(nums[i]);
				out.println(sb.toString());
				return;
			}				
		}
		
		out.println(0);
	}
}
