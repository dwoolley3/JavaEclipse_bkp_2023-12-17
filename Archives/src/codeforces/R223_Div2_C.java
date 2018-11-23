package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter

public class R223_Div2_C //Name: Sereja and Prefixes
{
	//TLE on Test #10
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
		int m = Integer.parseInt(in.readLine());		
		int[] typ = new int[m];
		int[] x   = new int[m];
		int[] len = new int[m];
		int[] cop = new int[m];
		for (int i = 0; i < m; i++) 
		{
			String[] s = in.readLine().split(" ");
			typ[i] = Integer.parseInt(s[0]);
			if (typ[i] == 1)
			{
				x[i] = Integer.parseInt(s[1]);
			}
			else //typ[i] == 2
			{
				len[i] = Integer.parseInt(s[1]);
				cop[i] = Integer.parseInt(s[2]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int[] a = new int[100_001];
		int query = 0, indA = 0;
		long curInd = 0;
		
		int n = Integer.parseInt(in.readLine());
		String[] s = in.readLine().split(" ");		
		
		long[] indToPrint = new long[n];
		for (int i = 0; i < n; i++) 
			indToPrint[i] = Long.parseLong(s[i]);
		
		int prnt = 0;
		while (prnt < n) 
		{
			boolean printed = false;
			while (query < m && !printed)
			{
				if (typ[query] == 1)
				{
					if (indA < 100_000)
					{
						a[++indA] = x[query];
					}
					curInd++;
					if (indToPrint[prnt] == curInd)
					{
						sb.append(x[query] + " ");
						prnt++;
						printed = true;
					}
				} 
				else //typ[query] == 2
				{
					long stInd = curInd;
					if (indA < 100_000)
					{						
						curInd = indA + cop[query]*len[query];			
						for (int j = 0; j < cop[query] && indA < 100_000; j++)
							for (int k = 1; k <= len[query] && indA < 100_000; k++)
								a[++indA] = a[k];						
					}
					
					while (prnt < n && indToPrint[prnt] <= indA)
					{
						sb.append(a[(int)indToPrint[prnt]] + " ");
						prnt++;
						printed = true;
					}
					while (prnt < n && indToPrint[prnt] <= curInd)
					{
						int dif = (int)(indToPrint[prnt] - stInd);
						int indd = dif % len[query];
						if (indd == 0) indd = len[query];
						sb.append(a[indd] + " ");
						prnt++;
						printed = true;
					}
				}
				query++;
			}
		}	
	
		out.println(sb);		
	}
}
