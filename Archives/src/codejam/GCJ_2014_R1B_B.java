package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2014_R1B_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2014_R1B_B().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		in = new FastReader(new File("src/B-ex.in"));
		//in = new FastReader(new File("src/B-small-attempt0.in"));
		//in = new FastReader(new File("src/B-large.in"));
		try {
			out = new PrintWriter(new File("src/B-ex.out"));
			//out = new PrintWriter(new File("src/B-small-attempt0.out"));
			//out = new PrintWriter(new File("src/B-large.out"));
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
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			
			long cnt = 0, cnt2 = 0;
			for (int i = 0; i < a; i++)
				for (int j = 0; j < b; j++)
				{
					int ab = i & j;
					if (ab < k) cnt++;
				}
						
			int min = Math.min(a,k);
			cnt2 += min * b;
			for (int i = min; i < a; i++)
			{
				int bit = Integer.highestOneBit(i);
				System.out.println(bit);
				int pow = (int)Math.pow(2, bit+1);
				cnt2 += (b - (b-1)/pow);
			}
			//cnt2 += Math.min(b, k);
			
			cnt2 =  Math.min(a, k) * b;
			cnt2 += Math.min(b, k) * a;
			cnt2 -= Math.min(a, k) * Math.min(b, k);
			
			String ans = cnt + "";
			String ans2 = cnt2 + "";
			
			System.out.println("Case #" + tc + ": " + ans);
			System.out.println("Case #" + tc + ": " + ans2);
			out.println("Case #" + tc + ": " + ans);
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
