package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R226_Div2_B //Name: Bear and Strings
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
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n-3; i++) 
			if (s.substring(i,i+4).equals("bear"))
				a.add(i);		

		int cnt = 0, subcnt = 0, lastind = 0, lastStartInd = -1;
		for (int ind : a)
		{
			lastind = ind+3;
			subcnt = (ind - lastStartInd) * (n-lastind);
			cnt += subcnt;
			lastStartInd = ind;
		}		
		out.println(cnt);		
	}
}
