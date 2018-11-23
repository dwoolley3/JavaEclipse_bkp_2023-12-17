package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R269_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R269_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{
		int n = in.nextInt();
		
		int[] h = new int[n];
		int[] p = new int[n];
		int[] a = new int[2001];
		int f = -1, s = -1;
		for (int i = 0; i < n; i++)
		{
			h[i] = in.nextInt();
			p[i] = i+1;
			a[h[i]]++;
			if (a[h[i]] > 2)
				s = h[i];
			else if (a[h[i]] == 2)
			{
				if (f == -1) f = h[i];
				else s = h[i];
			}			
		}
		
		if (s == -1)
			out.println("NO");
		else 
		{
			out.println("YES");
			int t;
			for (int i = 0; i < n-1; i++)
				for (int j = i+1; j < n; j++)
					if (h[i] > h[j])
					{
						t = p[j]; p[j] = p[i]; p[i] = t;
						t = h[j]; h[j] = h[i]; h[i] = t;
					}
			for (int i = 0; i < n; i++)
				out.print(p[i] + " ");			
			out.println();
			
			boolean swapped = false;
			for (int i = 0; i < n; i++)
				if (h[i] == f && !swapped)
				{
					out.print(p[i+1] + " ");	
					out.print(p[i] + " ");	
					i++;
					swapped = true;
				}
				else
					out.print(p[i] + " ");
			out.println();
			
			swapped = false;
			boolean pass1 = false;			
			if (f == s) pass1 = true;
			
			for (int i = 0; i < n; i++)
				if (h[i] == s && !pass1 && !swapped)
				{
					out.print(p[i+1] + " ");	
					out.print(p[i] + " ");	
					i++;
					swapped = true;
				}
				else if (h[i] == s && pass1)
				{	
					pass1 = false;
					out.print(p[i] + " ");	
				}
				else
					out.print(p[i] + " ");
			out.println();	
		}
	}

	//-----------------------------------------------------
	void runWithFiles() {
		in = new FastReader(new File("input.txt"));
		try {
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
		public FastReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
				tokenizer = null;
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    private String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens())
	            try {
	            	tokenizer = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        return tokenizer.nextToken();
	    }
		public String nextLine() {
			try	{
				return br.readLine();
			}
			catch(Exception e) {
				throw(new RuntimeException());
			}
		}

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }	    
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	    BigDecimal nextBigDecimal() {
	        return new BigDecimal(next());
	    }
	}
}
