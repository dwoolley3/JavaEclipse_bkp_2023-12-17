package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2017_R23_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2017_R23_B().run();
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

		int[]a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		//Randomization of array needed for test case 43, prior to sort
	    int ra, temp;
	    for (int i = 0; i < n; i++)
	    {
	        ra = (int)(Math.random()*(i+1));  //i+1 better than n
	        temp = a[i]; a[i] = a[ra]; a[ra] = temp;
	    }
		Arrays.sort(a);
		
		int num = 3;
		for (int i = 3; i < n; i++)
			if (a[2] == a[i]) num++;
		
		long ans = 0;
		if (a[0] == a[1] && a[1] == a[2])
			ans = nCr(num, 3);
		else if (a[1] == a[2])
			ans = nCr(num-1, 2);
		else
			ans = nCr(num-2, 1);
		
		out.println(ans);
	}
	
	private long nCr(int n, int r)
	{
		long num = 1, den = 1;
		for (int i = 1; i <= r; i++)
		{
			num *= (n - (i-1));
			den *= i;
		}
		return num / den;
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
