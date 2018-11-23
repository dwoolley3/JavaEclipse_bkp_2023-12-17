package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R234_Div2_A //Inna and Choose Options
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R234_Div2_A().run();
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
		int t = in.nextInt();
		for (int T = 0; T < t; T++)
		{
			String s = in.next();
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			boolean ok = false;
			for (int i = 0; i < 12; i++)
				if (s.charAt(i) == 'X') ok = true;
			if (ok) { sb.append(" 1x12"); cnt++; }
			
			ok = false;
			for (int i = 0; i < 6; i++)
				if (s.charAt(i) == 'X' && s.charAt(i+6) == 'X') ok = true;
			if (ok) { sb.append(" 2x6"); cnt++; }
			
			ok = false;
			for (int i = 0; i < 4; i++)
				if (s.charAt(i) == 'X' && s.charAt(i+4) == 'X'
				&& s.charAt(i+8) == 'X') ok = true;
			if (ok) {sb.append(" 3x4"); cnt++; }
			
			ok = false;
			for (int i = 0; i < 3; i++)
				if (s.charAt(i) == 'X' && s.charAt(i+3) == 'X'
				&& s.charAt(i+6) == 'X' && s.charAt(i+9) == 'X') ok = true;
			if (ok) {sb.append(" 4x3"); cnt++; }
			
			ok = false;
			for (int i = 0; i < 2; i++)
				if (s.charAt(i) == 'X' && s.charAt(i+2) == 'X'
				&& s.charAt(i+4) == 'X' && s.charAt(i+6) == 'X'
				&& s.charAt(i+8) == 'X' && s.charAt(i+10) == 'X') ok = true;
			if (ok) {sb.append(" 6x2"); cnt++; }
			
			ok = true;
			for (char c : s.toCharArray())
				if (c != 'X') ok = false;
			if (ok)  { sb.append(" 12x1"); cnt++; }
			
			if (cnt ==  0)
				out.println(0);
			else
				out.println(cnt + sb.toString());
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
