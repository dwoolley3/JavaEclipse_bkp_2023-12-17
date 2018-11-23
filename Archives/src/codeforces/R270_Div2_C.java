package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R270_Div2_C //Name: Design Tutorial: Make it Nondeterministic
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R270_Div2_C().run();
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

		String[] f = new String[n];
		String[] l = new String[n];
		String h="";
		for (int i = 0; i < n; i++)
		{
			f[i] = in.next();
			l[i] = in.next();
		}
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = in.nextInt() - 1;
		
		String use = "";
		for (int i = 0; i < n; i++)
		{
			if (f[p[i]].compareTo(l[p[i]]) < 0)
				if (i == 0 || f[p[i]].compareTo(h) > 0)
					use = f[p[i]];
				else
					use = l[p[i]];			
			else
				if (i == 0 || l[p[i]].compareTo(h) > 0)
					use = l[p[i]];
				else
					use = f[p[i]];	

			if (i > 0 && use.compareTo(h) < 0)
			{
				out.println("NO");
				return;
			}
			h = use;
		}
		out.println("YES");
		return;	
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
