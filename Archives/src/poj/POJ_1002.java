package poj;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class POJ_1002
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new POJ_1002().run();
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
		String[] s = new String[n+1];
		for (int i = 0; i < n; i++)
		{
			s[i] = "";
			String st = in.next();
			for (char c : st.toCharArray())
			{
				if (c >='A' && c <='C') s[i] += "2";
				else if (c >='D' && c <='F') s[i] += "3";
				else if (c >='G' && c <='I') s[i] += "4";
				else if (c >='J' && c <='L') s[i] += "5";
				else if (c >='M' && c <='O') s[i] += "6";
				else if (c >='P' && c <='S') s[i] += "7";
				else if (c >='T' && c <='V') s[i] += "8";
				else if (c >='W' && c <='Y') s[i] += "9";
				else if (c >= '0' && c <= '9') s[i] += c;
				if (s[i].length() == 3) s[i] += "-";
			}
		}
		s[n] = "99999999";
		Arrays.sort(s);
		int cnt = 1;
		boolean dup = false;
		for (int i = 1; i < n+1; i++)
			if (s[i].equals(s[i-1])) 
				cnt++;
			else if (cnt > 1)
			{
				out.println(s[i-1] + " " + cnt);
				cnt = 1;
				dup = true;
			}	
		
		if (!dup) out.println("No duplicates.");
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
