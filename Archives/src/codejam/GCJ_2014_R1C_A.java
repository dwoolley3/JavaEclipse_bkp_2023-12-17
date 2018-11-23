package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2014_R1C_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2014_R1C_A().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/A-ex.in"));
		//in = new FastReader(new File("src/A-small-attempt2.in"));
		in = new FastReader(new File("src/A-small-practice.in"));
		//in = new FastReader(new File("src/A-large.in"));
		try {
			//out = new PrintWriter(new File("src/A-ex.out"));
			//out = new PrintWriter(new File("src/A-small-attempt2.out"));
			out = new PrintWriter(new File("src/A-small-practice.out"));
			//out = new PrintWriter(new File("src/A-large.out"));
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
		//in.nextLine(); //use after a nextInt() and prior to reading another in.nextLine()

		for (int tc = 1; tc <= T; tc++)
		{
			String[] s = in.next().split("/");
			long p = Long.parseLong(s[0]);
			long q = Long.parseLong(s[1]);
			long cf = GCD(p,q);
			p /= cf;
			q /= cf;
			
			long g = log2(q);
			String ans = "";
			if (g == -1) 
				ans = "impossible";
			else
			{
				int cnt = 0;
				while (p < q) 
				{
					p *= 2; cnt++;
				}
				ans = cnt + "";
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
    long GCD(long a, long b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
    
    long log2(long a)
    {
        long pow = 1, cnt = 0;
        while (pow < a) 
        {
        	pow *= 2;
        	cnt++;
        }
        if (pow == a) return cnt;
        return -1;
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
