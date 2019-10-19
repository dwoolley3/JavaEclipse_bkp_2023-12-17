package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R575_Div3_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R575_Div3_B().run();
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
		int q = in.nextInt();
		
		for (int j = 0; j < q; j++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] a = new int[n];
			int[] ans = new int[k];
			long sum = 0;
			int odd = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				sum += a[i];
				//out.println(sum);
				if (sum % 2 == 1) {
					if (odd < k) ans[odd] = i+1;
					odd++;
					sum = 0;

				}
			}
			
			if (k > odd)
				out.println("NO");
			else if ((odd - k) % 2 == 1) 
				out.println("NO");
			else {				
				out.println("YES");
				ans[k-1] = n;
				for (int i = 0; i < k; i++) {
					out.print(ans[i] + " ");
				}
				out.println();
			}
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
