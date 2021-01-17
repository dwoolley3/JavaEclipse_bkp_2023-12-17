package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R620_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R620_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	@SuppressWarnings("unused")
	void solve()
	{
		int n = in.nextInt();
		@SuppressWarnings("unused")
		int m = in.nextInt();
		
		String[] s = new String[n];
		boolean[] p = new boolean[n];
		for (int i = 0; i < n; i++)  {
			s[i] = in.next();
			p[i] = isPal(s[i]);
		}
		boolean[] used = new boolean[n];
		String left = "", right = "";
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (isPal(s[i]+s[j])) {
					left += s[i];
					right = s[j] + right;
					used[i] = true;
					used[j] = true;
				}					
			}
		}
		String middle = "";
		for (int i = 0; i < n; i++) {
			if (!used[i] & p[i]) {
				middle = s[i];
				break;
			}
		}
		String bigPal = left + middle + right;
		out.println(bigPal.length());
		out.println(bigPal);		
	}
	
    private boolean isPal(String word)
    {
        int n = word.length();
        for (int i = 0; i < n/2; i++)
            if (word.charAt(i) != word.charAt(n - i - 1)) return false;
        return true;
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
