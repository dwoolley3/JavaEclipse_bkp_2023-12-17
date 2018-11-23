package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_12_LT_C_ABX02
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_12_LT_C_ABX02().run();
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
        	int p = in.nextInt();
			int q = in.nextInt();  // n <= p+q, and p,q <= 50
			int n = in.nextInt();  // 1<=n<=15
			
			int b1 = in.nextInt();
			int b2 = in.nextInt();
			
			int s1 = in.nextInt();
			int s2 = in.nextInt();
				
			int good = 0;
			for (int i = 0; i < (1 << n); i++)
			{
				int[] a = new int[n];
				
				int ptot = 0, qtot = 0;
				for (int j = 0; j < n; j++)	{		
					a[n-1-j] = (i & (1 << j)) == 0 ? 1 : 2;
					if (a[n-1-j] == 1) ptot++; else qtot++;
				}
					
				//for (int j = 0; j < n; j++)
				//	out.print(a[j]);
				
				boolean bad = (ptot > p || qtot > q);
				int box1Opened = 0, box2Opened = 0, eaten = 1;			
	
				for (int j = 1; j <= n && !bad; j++)
					if (j < n && a[j] == a[j-1])
						eaten++;
					else {
						if (a[j-1] == 1)
							if (eaten > s1) bad = true;
							else
							{
								box1Opened++;
								if (box1Opened > b1) bad = true;								
							}
						else if (a[j-1] == 2)
							if (eaten > s2) bad = true;
							else
							{
								box2Opened++;
								if (box2Opened > b2) bad = true;
							}
						eaten = 1;
					}		
				if (!bad)
					good++;				
				//out.println(!bad ? " Good" : "");
			}
			
			out.println(good);	
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
