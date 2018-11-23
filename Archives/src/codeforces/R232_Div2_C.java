package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R232_Div2_C //Name: On Number of Decompositions into Multipliers
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R232_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
    
    static final int MOD = (int) (1e9 + 7);
    
	void solve()
	{
		int n = in.nextInt();
		HashMap<Integer, Integer> primePowers = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < n; i++)		
		{
			//Generate prime factorization for "a"
			int a = in.nextInt();
	        for (int factor = 2;  factor * factor <= a; factor++)
	        {
	            while (a % factor == 0)
	            {
	            	a /= factor;
	            	Integer priorPow = primePowers.get(factor);
	            	if (priorPow == null)
	            		primePowers.put(factor, 1);
	            	else
	            		primePowers.put(factor, priorPow + 1);  
	            }
	        }
	        if (a > 1)
	        {
	        	int factor = a;
            	Integer priorPow = primePowers.get(factor);
            	if (priorPow == null)
            		primePowers.put(factor, 1);
            	else
            		primePowers.put(factor, priorPow + 1);  
	        }
		}

        //Multiply pCq for each prime|power p*(p-1)*(p-2)*...(p-q+1) / q!
		int pTot = 1, qTot = 1;
		for (int pow : primePowers.values())  //only power value is relevant, not prime#   
		{
			int p = pow + n - 1;   //Key knowledge is here!
			int q = pow;
			for (int i = 0; i < q; i++)
			{
				pTot = (int) (pTot * (long) (p - i) % MOD);
				qTot = (int) (qTot * (long) (i + 1) % MOD);
			}
		}
		//Divide pTot by qTot
		int ans = (int) (pTot *	BigInteger.valueOf(qTot).modInverse(BigInteger.valueOf(MOD)).longValue()
	        	% MOD);
		out.println(ans);				
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
