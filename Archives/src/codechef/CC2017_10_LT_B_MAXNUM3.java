package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_10_LT_B_MAXNUM3
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_10_LT_B_MAXNUM3().run();
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
		//Divisible by 6 if number is divisible by 2 and by 3
		//for 2 - is last digit even
		//for 3 - if sum of its digits is divisible by 3
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
        	String s = in.next();
        	int n = s.length();
        	int sum = 0;
        	for (int i = 0; i < n; i++)
        		sum += s.charAt(i) - '0';
        		
        	int	lastdig = s.charAt(n-1) - '0';
        	int maxi = -1;
        	for (int i = 0; i < n; i++)
        	{
        		if (i==n-1) lastdig = s.charAt(n-2) - '0';
        		int dig = s.charAt(i) - '0';

        		if ((sum - dig) % 3 == 0 && lastdig % 2 == 0)
        		{
    				if (i < n-1 && s.charAt(i) < s.charAt(i+1))
					{
    					maxi = i;
    					break;
					}
    				else
    				{
    					maxi = i;
					}     				     			
        		}
        	}

        	if (maxi == -1)
        		out.println(-1);
        	else
        		out.println(s.substring(0, maxi) + s.substring(maxi+1));	
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
