package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2018_01_CO_C_MAGA
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2018_01_CO_C_MAGA().run();
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
			//n = 100_000;
				
			int[] a = new int[n];
			int[] a2 = new int[n];
			for (int i = 0; i < n; i++) {
				//a[i] = i; //(int)Math.random()*1_000_000_000 + 1;
				a[i] = in.nextInt();
				a2[i] = a[i];
			}
			
			int mid = n/2 - 1;
			int ans = Integer.MAX_VALUE;
			if (a[mid] != a[mid+1])
				for (int bl = 0; bl <= 1; bl++) {
					int swap = 0;
					if (bl == 1) {
						for (int i = 0; i < n; i++) a[i] = a2[i];
						int te = a[mid]; a[mid] = a[n-1-mid]; a[n-1-mid] = te;
						swap++;
					}
					boolean lessthan = (a[mid] < a[mid+1]);		
					boolean ok = true;

					for (int i = mid - 1; i >= 0 && ok; i--) {
						if (lessthan) {
							if (a[i] > a[i +1] && a[n-1 - i - 1] > a[n-1 - i])
								{}
							else //try swap
							{
								int te = a[i]; a[i] = a[n-1-i]; a[n-1-i] = te;
								swap++;
								if (a[i] > a[i +1] && a[n-1 - i - 1] > a[n-1 - i])
								{}
								else //no good
									ok = false;
							}
						}
						else { //greaterthan
							if (a[i] < a[i +1] && a[n-1 - i - 1] < a[n-1 - i])
									{}
							else //try swap
							{
								int te = a[i]; a[i] = a[n-1-i]; a[n-1-i] = te;
								swap++;
								if (a[i] < a[i +1] && a[n-1 - i - 1] < a[n-1 - i])
								{}
								else //no good
									ok = false;
							}							
						}
						lessthan = !lessthan;
					}
					if (ok) ans = Math.min(ans, swap);
				}
					
			out.println(ans == Integer.MAX_VALUE ? -1 : ans);	
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
