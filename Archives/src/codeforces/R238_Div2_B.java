package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R238_Div2_B //Name: Domino Effect
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R238_Div2_B().run();
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
		String s = in.next();
		int cnt = 0;		
		
		int p = 0;
		int st = 0, en = n-1;
		int l = s.indexOf('L');
		int r = s.indexOf('R');
		if (l > -1 && (l < r || r == -1))
			st = l+1;
			
		l = s.lastIndexOf('L');
		r = s.lastIndexOf('R');
		if (r > -1 && (r > l || l == -1))
			en = r-1;
		
		while (st <= en && s.charAt(st) == '.')
		{
			cnt++; st++;
		}
		while (en >= st && s.charAt(en) == '.')
		{
			cnt++; en--;
		}
	
		for (int i = st; i <= en; i++)
		{			
			char c = s.charAt(i);
			if (c == '.') p++;
			else if (c == 'L')
			{
				if (p % 2 == 1) cnt++;
				p = 0;
			}
			else if (c == 'R')
			{
				cnt += p;
				p = 0;
			}			
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
