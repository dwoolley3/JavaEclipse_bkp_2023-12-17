package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R285_Div2_B_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R285_Div2_B_orig().run();
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
		
		String[] a = new String[n];
		String[] b = new String[n];
		boolean[] used = new boolean[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.next();
			b[i] = in.next();
		}
		
		ArrayList<String> alOld = new ArrayList<String>();
		ArrayList<String> alNew = new ArrayList<String>();
		
		for (int i = 0; i < n; i++)
		{
			if (!used[i])
			{
				String old = a[i], ne = b[i];
				for (int j = i+1; j < n; j++)
				{
					if (!used[j] && ne.equals(a[j]))
					{
						ne = b[j];
						used[j] = true;
					}
				}
				
				alOld.add(old);
				alNew.add(ne);
			}
		}
		
		out.println(alOld.size());
		
		for (int i = 0; i < alOld.size(); i++)
			out.println(alOld.get(i) + " " + alNew.get(i));	
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
