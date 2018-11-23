package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R367_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R367_Div2_D().run();
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
		
		HashMap<Integer,Integer> hm = new HashMap<>(); 
		TreeSet<Integer> ts = new TreeSet<>(); 

		for (int i = 0; i < n; i++)
		{
			String s = in.next();		
			int x = in.nextInt();
			//if (i < n / 2) s = "+"; else s = "?";
			//x =  (int)(Math.random()*(n*100));
			
			if (s.equals("+"))
			{
				int cnt = 0;
				if (hm.containsKey(x)) cnt = hm.get(x);
				cnt++;
				hm.put(x,  cnt);
				if (cnt == 1) ts.add(x);
			}
			else if (s.equals("-"))
			{
				int cnt = hm.get(x);
				cnt--;
				hm.put(x,  cnt);
				if (cnt == 0) ts.remove(x);
			}
			else // ?
			{
				int max = x ^ 0;
				for (int key : ts)  
				{
					max = Math.max(max, x ^ key);
				}
				out.println(max);
			}
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
