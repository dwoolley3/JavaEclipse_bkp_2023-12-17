package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class VK_Cup_2016_R3_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new VK_Cup_2016_R3_Div2_B().run();
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
		int m = in.nextInt();
		
		//There is a much simpler way to do this problem
		
		TreeSet<Integer> div1 = new TreeSet<>();
		TreeSet<Integer> div2 = new TreeSet<>();
		int maxDiv2 = -1;
		int minDiv1 = n+1;
		int ans = -1;
		for (int i = 0; i < m; i++)
		{
			int u = in.nextInt();
			int v = in.nextInt();
			int min = Math.min(u, v);
			int max = Math.max(u, v);
			if (div2.contains(min) && div1.contains(max))
				continue;
			else if (div2.contains(max) || div1.contains(min))
			{
				ans = 0;
			}
			else if (min > minDiv1 || max < maxDiv2)
			{
				ans = 0;
			}
			else if (div2.contains(min))
			{
				div1.add(max);
				minDiv1 = Math.min(minDiv1, max);
			}
			else if (div1.contains(max))
			{
				div2.add(min);
				maxDiv2 = Math.max(maxDiv2, min);
			}
			else
			{
				div1.add(max);
				div2.add(min);
				minDiv1 = Math.min(minDiv1, max);
				maxDiv2 = Math.max(maxDiv2, min);
			}
		}
		
		if (ans == 0)
			out.println(0);
		else
		{
			int cnt = 0;
			for (int i = 0; i < n; i++)
				if (i > maxDiv2 && i < minDiv1) cnt++;
			if (div1.size() == 0) cnt--;
			if (div2.size() == 0) cnt--;
			out.println(cnt+1);
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
