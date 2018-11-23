package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R426_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R426_Div2_C().run();
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
		
		for (int i = 0; i < n; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			
			//int n = 999999961;  // 2*3*5*7*11*13*17*23;
			Map<Integer,Integer> pfa = getPrimeFactorization(a);			
			Map<Integer,Integer> pfb = getPrimeFactorization(b);
			boolean ok = true;
			if (pfa.size() != pfb.size()) 
				ok = false;
			else
			{
				for (Map.Entry<Integer, Integer> entry : pfa.entrySet())
				{
					int pfaPrime = entry.getKey(); 
					int pfaNum = entry.getValue();
					//out.println(pfaPrime + " x " + pfaNum);
					if (pfb.containsKey(pfaPrime))
					{
						int pfbPrime = pfaPrime;
						int pfbNum = pfb.get(pfbPrime);
						//out.println(pfbPrime + " x " + pfbNum);
						
						int aScore = 0, bScore = 0;
						ok = false;
						for (int j = 0; j < 31; j++)
						{
							if (aScore > pfaNum || bScore > pfbNum) 
								break;
							if ((pfaNum - aScore) * 2 == (pfbNum - bScore)
							|| (pfaNum - aScore) == (pfbNum - bScore) * 2)
							{
								ok = true;
								break;
							}
							aScore += 2; bScore++;
						}
					}
					else
					{
						ok = false;
						break;
					}					
				}			
			}
			
			out.println(ok ? "Yes" : "No");		
		}
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
//				 if (pf.get(i) != null)
//					 pf.put(i, pf.get(i)+1);
//				 else
//					 pf.put(i, 1);				 
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
