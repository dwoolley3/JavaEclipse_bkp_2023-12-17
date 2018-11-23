package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R401_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R401_Div2_B().run();
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
		String scc = in.next();
		String mcc = in.next();
		
		int[] s = new int[n];
		int[] m = new int[10];
		int[] m2 = new int[10];
		for (int i = 0; i < n; i++) 
		{
			s[i] = scc.charAt(i) - '0';
			m[mcc.charAt(i) - '0']++;
		}
		for (int i = 0; i < 10; i++) m2[i] = m[i];
		
		//Min flicks on Moriaty, by having his digit be greater or equal than Sherlock's
		int min = 0, max = 0;
		for (int i = 0; i < n; i++)
		{
			int ind = s[i];
			while (ind < 9 && m[ind] == 0)
				ind++;
			if (m[ind] == 0) // not greater
			{
				ind = 0;
				while (ind < s[i] && m[ind] == 0)  //use smallest digit
					ind++;
				min++;
			}
			m[ind]--;
		}
				
		for (int i = 0; i < 10; i++) m[i] = m2[i];
		//Max flicks on Sherlock, by having Moriarty's digits greater than Sherlock's
		for (int i = 0; i < n; i++)
		{
			int ind = s[i] + 1;
			while (ind < 9 && m[ind] == 0)
				ind++;
			if (ind < 10 && m[ind] > 0) 
			{
				max++;
			}
			else
			{
				ind = 0;
				while (ind < s[i] && m[ind] == 0)  //use smallest digit
					ind++;
			}
			m[ind]--;
		}
		
		out.println(min);
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
