package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Looksery_Cup_2015_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Looksery_Cup_2015_A().run();
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
		
		char[][] a = new char[n][m];
		for (int i = 0; i < n; i++)
			a[i] = in.next().toCharArray();
		
		int cnt = 0;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < m-1; j++)
			{
				String s = ""+a[i][j]+a[i+1][j]+a[i][j+1]+a[i+1][j+1];
				if (s.contains("f") && s.contains("a")
				&& s.contains("c") && s.contains("e"))
						cnt++;
				
				//Alternate #1
//				char[] c = {a[i][j], a[i][j+1], a[i+1][j], a[i+1][j+1]};
//				Arrays.sort(c);
//				if (new String(c).equals("acef")) cnt++;
				
				//Alternate #2
//				String s = ""+a[i][j]+a[i+1][j]+a[i][j+1]+a[i+1][j+1];
//				s = s.replaceFirst("f", "");
//				s = s.replaceFirst("a", "");
//				s = s.replaceFirst("c", "");
//				s = s.replaceFirst("e", "");
//				if (s.equals("")) cnt++;
			}
		
		out.println(cnt);		
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
