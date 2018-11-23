package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R278_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R278_Div2_B().run();
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
		
		int[] a = new int[4];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		if (n == 4)
			out.println (isGood(a[0],a[1],a[2],a[3]) ? "YES" : "NO");
		else if (n == 0)
		{
			out.println("YES");
			out.println(1);
			out.println(1);
			out.println(3);
			out.println(3);
		}
		else if (n == 1)
		{
			out.println("YES");
			out.println(a[0]);
			out.println(a[0]*3);
			out.println(a[0]*3);
		}
		else if (n == 3)
		{
			for (int b = 1; b <= 1_000_000; b++)
			{
				if (isGood(a[0],a[1],a[2],b))
				{
					out.println("YES");
					out.println(b);
					return;
				}
			}
			out.println("NO");
		}
		else if (n == 2)
		{
			for (int b1 = 1; b1 <= 1_500; b1++)
				for (int b2 = 1; b2 <= 1_500; b2++)
				{
					if (isGood(a[0],a[1],b1,b2))
					{
						out.println("YES");
						out.println(b1);
						out.println(b2);
						return;
					}
				}
			
			out.println("NO");
		}
	}
	
	private boolean isGood(int x1, int x2, int x3, int x4)
	{
		int sum = 0;
		int[] a = {x1, x2, x3, x4};
		Arrays.sort(a);
		for (int i = 0; i < 4; i++)
			sum += a[i];
		
		return (sum == (a[1]+a[2]) * 2 && sum == (a[3]-a[0]) * 4);
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
