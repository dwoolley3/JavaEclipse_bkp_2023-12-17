package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R313_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R313_Div2_D().run();
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
		String a = in.next();
		String b = in.next();
		
		//if (check(a,b)) //TLE on Test #89 ??
		if (check(a).equals(check(b)))
			out.println("YES");
		else
			out.println("NO");
	}
	static String check(String s)
	{
		int n = s.length();
		if (n == 0 || n%2 == 1) return s;
		String s1 = check(s.substring(0, n/2));
		String s2 = check(s.substring(n/2));
		if (s1.compareTo(s2) < 0) 
			return s1 + s2;
		else
			return s2 + s1;
	}
//	public static boolean check (String a, String b)
//	{
//		if (a.equals(b))
//			return true;
//		int n = a.length();
//		if (n != b.length() || n%2 == 1) return false;
//		String a1 = a.substring(0,n/2);
//		String a2 = a.substring(n/2); //, n);
//		String b1 = b.substring(0,n/2);
//		String b2 = b.substring(n/2); //, n);
//		if (check(a1, b1) && check(a2, b2)) return true;
//		if (check(a1, b2) && check(a2, b1)) return true;
//		return false;
//	}

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
