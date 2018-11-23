package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2017_R26_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2017_R26_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	String[] s;
	int n, m;
	ArrayList<Character> colors;
	
	void solve()
	{
		n = in.nextInt();
		m = in.nextInt();
		
		s = new String[n];
		for (int i = 0; i < n; i++)		
			s[i] = in.next();
		
		out.println(check3rows() || check3cols() ? "YES" : "NO");	
	}
	
	private boolean check3rows() 
	{
		if (n % 3 != 0) return false;
		colors = new ArrayList<>();
		for (int i = 0; i < n; i += n/3) 
		{
			char color = ' ';
			for (int row = i; row < i + n/3; row++)
			{
				if (row == i) color = s[i].charAt(0);
				for (int col = 0; col < m; col++) 
					if (color != s[row].charAt(col))
						return false;
			}
			if (colors.contains(color))
				return false;
			else
				colors.add(color);
		}
		return true;
	}
	
	private boolean check3cols() 
	{
		if (m % 3 != 0) return false;
		colors = new ArrayList<>();
		for (int i = 0; i < m; i += m/3) 
		{
			char color = ' ';
			for (int col = i; col < i + m/3; col++)
			{
				if (col == i) color = s[0].charAt(col);
				for (int row = 0; row < n; row++) 
					if (color != s[row].charAt(col))
						return false;
			}
			if (colors.contains(color))
				return false;
			else
				colors.add(color);
		}
		
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
