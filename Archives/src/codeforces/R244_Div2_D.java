package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R244_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R244_Div2_D().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//*** TLE - Time Limit Exceeded on Test case 17
	void solve()
	{
		String s1 = in.next();
		String s2 = in.next();		
		int ns1 = s1.length(), ns2 = s2.length();
		int mins = Math.min(ns1, ns2);
		
		for (int len = 1; len <= mins; len++)
		{
			HashMap<String,Integer> hm1 = new HashMap<String,Integer>(); 
			for (int j = 0; j < ns1+1 - len; j++)
			{
				String s = s1.substring(j,j+len);			
				if (hm1.containsKey(s))
					hm1.put(s,  hm1.get(s)+1);
				else
					hm1.put(s,  1);
			}
			HashMap<String,Integer> hm2 = new HashMap<String,Integer>(); 
			for (int j = 0; j < ns2+1 - len; j++)
			{
				String s = s2.substring(j,j+len);			
				if (hm2.containsKey(s))
					hm2.put(s,  hm2.get(s)+1);
				else
					hm2.put(s,  1);
			}
			
			for (Map.Entry<String,Integer> ent : hm1.entrySet()) 
				if (ent.getValue() == 1 
				&& hm2.containsKey(ent.getKey()) && hm2.get(ent.getKey()) == 1)
				{
					out.println(len);
					return;
				}
			
//			for (Map.Entry<String,Integer> ent : hm1.entrySet()) 
//				System.out.println(ent.getKey() + "-" + ent.getValue());
//			System.out.println();
//			for (Map.Entry<String,Integer> ent : hm2.entrySet()) 
//				System.out.println(ent.getKey() + "-" + ent.getValue());
//			System.out.println();
		}

		
		out.println(-1);		
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
