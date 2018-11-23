package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2014_R1C_B_small
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2014_R1C_B_small().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/B-ex.in"));
		in = new FastReader(new File("src/B-small-attempt0.in"));
		//in = new FastReader(new File("src/B-large.in"));
		try {
			//out = new PrintWriter(new File("src/B-ex.out"));
			out = new PrintWriter(new File("src/B-small-attempt0.out"));
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

		//long MOD = 1_000_000_007;
		int[] p;
	
		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			
			String[] s = in.nextLine().split(" ");
			long cnt = 0;
			boolean ok = true;
			for (String st : s)
				ok &= isValid(st);			
						
			String ans = "";
			if (ok) 
			{
				p = new int[n];
				for (int i = 0; i < n; i++) p[i] = i;
				
				do
				{				
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < n; i++)
						sb.append(s[p[i]]);
					
					if (isValid(sb.toString())) cnt++;
				} 
				while (next_permutation(p));
			}
			
			ans = cnt + "";
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	boolean next_permutation(int[] p) 
	{
		// 0,1,2 -> 0,2,1 -> 1,0,2 -> 1,2,0 -> 2,0,1 -> 2,1,0
		int t, n = p.length;
		for (int i = n - 2; i >= 0; i--)
		    if (p[i] < p[i + 1])
		    	for (int j = n - 1;; j--)
		    		if (p[j] > p[i]) 
		    		{
		    			t = p[i]; p[i] = p[j];  p[j] = t;
				        for (i++, j = n - 1; i < j; i++, j--) 
				        {
				        	t = p[i]; p[i] = p[j]; p[j] = t;
				        }
				        return true;
		    		}
		 return false;  //p is last lexicographically, e.g. -> 2, 1, 0
	}
	
	boolean isValid(String s)
	{
		int n = s.length();
		HashSet<Character> hs = new HashSet<Character>(); 
		char prevc = ' ';
		for (int i = 0; i < n; i++)
		{
			char c = s.charAt(i);
			if (!hs.contains(c))
				hs.add(c);
			else if (c != prevc) 
				return false;	
			prevc = c;
		}
		return true;			
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
