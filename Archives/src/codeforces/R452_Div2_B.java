package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R452_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R452_Div2_B().run();
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
		int[] m = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};				
		int n = in.nextInt();
		
		int m29 = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (a[i] == 29) m29++;
		}
		if (m29 > 1) {
			out.println("NO");	
			return;
		}
		
		for (int st = 0; st < n; st++) {
			for (int mind = 0; mind < 12; mind++) {
				if (m[mind] == a[st] || (m[mind] == 28 && a[st] == 29))
				{			
					boolean ok = true;
					for (int j = 1; j < n && ok;  j++)
					{
						int i = (st + j) % n;
						int k = (mind + j) % 12;
						if (m[k] == a[i] || (m[k] == 28 && a[i] == 29))
						{

						}
						else ok = false;
					}
					if (ok) {
						out.println("YES");
						return;
					}
				}
			}
		}
		
		out.println("NO");		
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
