package hackerRank;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HR_2014_Addepar_Moderate_Special_Numbers
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new HR_2014_Addepar_Moderate_Special_Numbers().run();
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
        int[] a = new int[100000];
        int sum = 1;
        a[1] = 1;        
        for (int i = 2; i <= n; i++)
        {        	
        	//int n = 3000;  // 2*3*5*7*11*13*17*23;
        	Map<Integer,Integer> pf = getPrimeFactorization(i);
        	//count number of factors. 2^3 has (3+1) factors. 2^3 * 3^3 has (3+1)*(3+1)
        	int cnt = 1;
        	for (int j : pf.values())	{
        		cnt *= (j+1);
    		}
        	
        	if (a[cnt] == 0)
        	{
        		sum += i;
        		a[cnt] = 1;
        	}
        }
		
		out.println(sum);	
	}


	private static TreeMap<Integer, Integer> getPrimeFactorization(int n)
	{
		// 3000 = 2x3 * 3x1 * 5x3
		TreeMap<Integer,Integer> pf = new TreeMap<Integer,Integer>();
		for (int i = 2; i * i <= n; i++)
		{
			 int cnt = 0;
			 while (n % i == 0)
			 {
				 cnt++;
				 n /= i;
	//			 if (pf.get(i) != null)
	//				 pf.put(i, pf.get(i)+1);
	//			 else
	//				 pf.put(i, 1);				 
			 }
			 if (cnt > 0) pf.put(i, cnt);
		}
		if (n > 1) pf.put(n, 1);
		return pf;
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
