package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R344_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R344_Div2_C().run();
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
		
		int[] a = new int[n];

		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		int[] ty = new int[n];	
		int[] tyOrder = new int[n];		
		for (int i = 0; i < m; i++)
		{
			int t = in.nextInt();
			int r = in.nextInt();
			ty[r-1] = t;
			tyOrder[r-1] = i+1;
		}
		
		int type = 0, typeOrder = -1, asc = 0, desc = 0;
		int[] stack = new int[n];
		boolean sorted = false;
		int[] b = new int[n];
		for (int i = n-1; i >= 0; i--)
		{
			if (ty[i] > 0 && tyOrder[i] > typeOrder)
			{
				type = ty[i];
				typeOrder = tyOrder[i];
				if (!sorted)
				{
					b = new int[i+1];
					for (int j = 0; j <= i; j++)
						b[j] = a[j];
					Arrays.sort(b);	
					sorted = true;
				}
			}
			if (type == 0)
				stack[i] = a[i];
			else if (type == 1) //asc
				stack[i] = b[b.length-1 - asc++];
			else  //desc
				stack[i] = b[desc++]; 
		}
		
		for (int i = 0; i < n; i++)
			out.print(stack[i] + " ");
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
