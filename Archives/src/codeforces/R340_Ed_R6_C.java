package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R340_Ed_R6_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R340_Ed_R6_C().run();
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
		
		HashMap<Integer,Boolean> hm = new HashMap<>();
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<Integer> r = new ArrayList<>();
		int lasti = 0;
		for (int i = 0; i < n; i++) 
		{
			int a = in.nextInt();
			if (hm.containsKey(a))
			{
				l.add(lasti+1);
				r.add(i+1);
				lasti = i+1;
				hm = new HashMap<>();
			}
			else
				hm.put(a, true);
		}
		if (l.size() == 0)
			out.println(-1);
		else
		{		
			out.println(l.size());
			for (int i = 0; i < l.size(); i++)
				if (i < l.size()-1)
					out.println(l.get(i) + " " + r.get(i));
				else
					out.println(l.get(i) + " " + n);
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
