package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R227_Div2_C
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
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append(s.charAt(0));
		int j = 0;
		if (j+1 < n && s.charAt(j+1) == '0')
			while (j+1 < n && s.charAt(j+1) == '0')
				sb1.append(s.charAt(++j));
		
		StringBuilder sb2;
		int cnt=1;
		for (int i = j+1; i < n; i++)
		{
			sb2 = new StringBuilder();
			sb2.append(s.charAt(i));
			if (i+1 < n && s.charAt(i+1) == '0')
				while (i+1 < n && s.charAt(i+1) == '0')
					sb2.append(s.charAt(++i));
			

			if (sb1.length() > sb2.length())
				cnt++;
			else if (sb1.length() == sb2.length())
				{
					String s1 = sb1.toString();
					String s2 = sb2.toString();
					if (s1.compareTo(s2) >= 0)				
						cnt++;	
					else if (s.charAt(i)=='0')
						cnt = 1;
				}
			else if (s.charAt(i)=='0')
				cnt = 1;	
			sb1.append(sb2);	
		}
		
		out.println(cnt);		
	}
}
