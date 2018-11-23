package hackerRank;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HR_World_CodeSprint7_2_Two_Characters
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new HR_World_CodeSprint7_2_Two_Characters().run();
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
        @SuppressWarnings("unused")
		int n = in.nextInt();
        String s = in.next();
        
        int max = 0;
        for (char c1 = 'a'; c1 <= 'z'; c1++)
        	for (char c2 = 'a'; c2 <= 'z'; c2++)
        	{
        		if (c1 == c2) continue;
        		int first = 0, second = 0;
        		boolean ok = true;
        		for (char c : s.toCharArray())
        		{
        			if (c == c1) first++;
        			else if (c == c2) second++;
        			if (first > second + 1 || second > first) {
        				ok = false;
        				break;
        			}
        		}
        		if (ok && second > 0)
        			max = Math.max(max,  first + second);
        	}
        out.println(max);
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
