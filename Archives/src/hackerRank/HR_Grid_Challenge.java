package hackerRank;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HR_Grid_Challenge
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new HR_Grid_Challenge().run();
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
        int T = in.nextInt();
        
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();
			
			char[][] a = new char[n][n];
			for (int i = 0; i < n; i++) { 
				String s = in.next();
				for (int j = 0; j < n; j++)
					a[i][j] = s.charAt(j);
			}
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					for (int k = j+1; k < n; k++)
						if (a[i][j] > a[i][k])
						{
							char temp = a[i][j]; a[i][j] = a[i][k];
							a[i][k] = temp;
						}
			
			boolean ok = true;
			for (int i = 0; i < n && ok; i++)
				for (int j = 0; j < n-1 && ok; j++)
				{
					if (a[j][i] > a[j+1][i]) ok = false;
				}
			
			out.println(ok ? "YES" : "NO");	
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
