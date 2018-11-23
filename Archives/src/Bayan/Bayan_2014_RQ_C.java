package Bayan;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Bayan_2014_RQ_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Bayan_2014_RQ_C().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/C-in-ex.txt"));
		in = new FastReader(new File("src/C-in.txt"));
		try {
			//out = new PrintWriter(new File("src/C-out-ex.txt"));
			out = new PrintWriter(new File("src/C-out.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			String f = in.next();
			String u = in.next();
			String d = in.next();
			String l = in.next();
			String r = in.next();
			String b = in.next();
			int n = in.nextInt();
			for (int i = 0; i < n; i++)
			{
				String xyz = in.next();
				int m = in.nextInt();
				m = m % 4;
				String temp;
				for (int j = 0; j < m; j++)
					if (xyz.equals("X"))
					{
						temp = u; u = f; f = d; d = b; b = temp; 
					}
					else if (xyz.equals("Y"))
					{
						temp = u; u = l; l = d; d = r; r = temp; 
					}
					else if (xyz.equals("Z"))
					{
						temp = f; f = l; l = b; b = r; r = temp; 
					}
			}
			String ans = f + " " + u + " " + d + " " + l + " " + r + " " + b;
			System.out.println(ans);
			out.println(ans);
		}
	}

	//-----------------------------------------------------

	
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
