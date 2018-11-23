package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Canada_Cup_2016_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Canada_Cup_2016_C().run();
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
		char[] c = s.toCharArray();
		int[] a = new int[26];
		char dup = ' ';
		int pos1 = 0, pos2 = 0;
		for (int i = 0; i < 27; i++)
		{
			a[c[i]-'A']++;
			if (a[c[i]-'A'] > 1)
			{
				dup = c[i];
				pos2 = i;
				for (int j = i-1; j >= 0; j--)
					if (c[j] == dup)
					{
						pos1 = j;
						break;
					}
				break;
			}
		}

		int n = pos2 - pos1;
		//out.println(pos1 + " " + pos2);
		if (n == 1)
		{
			out.println("Impossible");
			return;
		}
		else
		{
			String top = "", bot = "";
			if (n % 2 == 0) n--;
			n /= 2;

			for (int i = pos1; i <= pos1 + n; i++)
				top += c[i];
			for (int i = pos1 + n + 1; i < pos2; i++)
				bot = c[i] + bot;	
			
			String botleft = "";
			for (int i = pos2 + 1; i < 27; i++)
			{
				if (top.length() < 13)
					top = c[i] + top;
				else
					botleft += c[i];
			}
			
			for (int i = 0; i < pos1; i++)
			{
				if (top.length() < 13)
					top = c[i] + top;
				else
					botleft += c[i];
			}
			bot = botleft + bot;	

			out.println(top);
			out.println(bot);
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
