package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R282_Div2_C_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R282_Div2_C_orig().run();
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
		String s = in.next();
		int n = s.length();
		int left = 0, right = 0, pound = 0;
		for (char c : s.toCharArray())
			if (c=='(') left++;
			else if (c==')') right++;
			else if (c=='#') pound++;
		
		int[] ans = new int[pound];
		int dif = left - right;
		if (dif < pound) {
			out.println(-1);
			return;
		}
		
		left = 0; right = 0;
		int dif2 = 0, ind = 0, pound2 = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c=='(') left++;
			else if (c==')') right++;
			else if (c=='#') 
			{
				pound2++;
				dif2 = left - right;
				if (dif2 <= 0)	{
					out.println(-1);
					return;
				}
				if (pound2 < pound)
				{
					ans[ind++] = 1;
					dif -= 1;
					right += 1;
				} else {
					ans[ind++] = dif;
					right += dif;
				}
			}
			if (left < right) {
				out.println(-1);
				return;
			}
		}
			
		for (int i = 0; i < pound; i++)
			out.println(ans[i]);
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
