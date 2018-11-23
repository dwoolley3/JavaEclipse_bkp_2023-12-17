package Bayan;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Bayan_2014_ShortCut_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Bayan_2014_ShortCut_A().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/AA-in-ex.txt"));
		in = new FastReader(new File("src/A.txt"));
		try {
			//out = new PrintWriter(new File("src/AA-out-ex.txt"));
			out = new PrintWriter(new File("src/A-out.txt"));
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

		for (int tc = 1; tc <= T; tc++)
		{
			String p = in.next();	
			int n = p.length(), cnt = 0;
			boolean unique = true, digit = false, latin = false, special = false;
			boolean lower = false, upper = false;
			String s = "";
			for (char c : p.toCharArray())
			{
				if (s.contains(c+"")) unique = false;
				s+= c;
				if (c >= '0' && c <= '9') 
					digit = true;
				else if (c >= 'a' && c <= 'z')
				{
					 latin = true;
					 lower = true;
				}
				else if (c >= 'A' && c <= 'Z')
				{
					 latin = true;
					 upper = true;
				}
				else special = true;				
			}
			if (digit) cnt++;
			if (latin) cnt++;
			if (special) cnt++;			
			if (n >= 6) cnt++;
			if (n > 10) cnt++;
			if (lower && upper) cnt++;
			if (unique) cnt++;
			
			String strength = "weak";
			if (cnt >= 6) strength = "strong";
			else if (cnt >= 4) strength = "normal";
			
			String ans = "Case #" + tc + ":";			
			System.out.println(ans);
			System.out.println(strength);
			out.println(ans);
			out.println(strength);
		}
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
