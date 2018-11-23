package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2015_07_CO_C_COMB4SUM_TLE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2015_07_CO_C_COMB4SUM_TLE().run();
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
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();	
				
			int[] a = new int[n];
			for (int i = 0; i < n; i++) 
				a[i] = in.nextInt();
			
			long sum = 0;
			for (int i = 0; i < n; i++)
				for (int j = i+1; j < n; j++)
					for (int k = j+1; k < n; k++)
						for (int l = k+1; l < n; l++)
							sum += SpecialSum(a[i],a[j],a[k],a[l]);
			
			out.println(sum);	
        }		
	}
	
	int SpecialSum(int a, int b, int c, int d)
	{
		int sum = 0, x;
		//out.print(a + " " + b + " " + c + " " + d + ": ");
		x = Math.abs(a+b-c-d); sum += x; //out.print(x + " ");
		x = Math.abs(a+c-b-d); sum += x; //out.print(x + " ");
		x = Math.abs(a+d-b-c); sum += x; //out.print(x + " ");
		sum += sum;
//		x = Math.abs(c+d-a-b); sum += x; out.print(x + " ");
//		x = Math.abs(b+d-a-c); sum += x; out.print(x + " ");
//		x = Math.abs(b+c-a-d); sum += x; out.print(x + " ");
//		out.println(sum);
		return sum;
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
