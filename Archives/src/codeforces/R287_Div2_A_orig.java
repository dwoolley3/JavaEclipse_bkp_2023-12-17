package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R287_Div2_A_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R287_Div2_A_orig().run();
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
		int k = in.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			b[i] = i+1;
		}
				
		//Arrays.sort(a);
		for (int i = 0; i < n; i++)
			for (int j = i+1; j < n; j++)
				if (a[i] > a[j]) 
				{
					int t = a[i]; a[i] = a[j]; a[j] = t;
					t = b[i]; b[i] = b[j]; b[j] = t;
				}
		
		int sum = 0, cnt = 0;
		String s = "";		
		for (int i = 0; i < n; i++)
			if (sum + a[i] <= k)
			{
				cnt++;
				s += b[i] + " ";
				sum += a[i];
			}
			else
				break;

		out.println(cnt);
		if (cnt > 0) out.println(s);
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
