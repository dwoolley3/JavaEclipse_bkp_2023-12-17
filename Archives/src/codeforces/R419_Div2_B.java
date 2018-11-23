package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R419_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R419_Div2_B().run();
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
		int q = in.nextInt();
		
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++)
		{
			l[i] = in.nextInt();
			r[i] = in.nextInt();
		}
		
		int ra, temp;
		for (int i = 0; i < n; i++)
		{
			ra = (int)(Math.random()*(i+1));  //i+1 better than n
			temp = l[i]; l[i] = l[ra]; l[ra] = temp;
			temp = r[i]; r[i] = r[ra]; r[ra] = temp;
		}
		Arrays.sort(l);
		Arrays.sort(r);
		
		int max = 200_000;
		int[] cnt = new int[max+1];
		
		int indl = 0, indr = 0, ind = 1, inRange = 0;
		while (indl < n || indr < n)
		{
			while (indl < n && l[indl] == ind)
			{
				inRange++;
				indl++;
			}
			cnt[ind] = inRange;
			
			while (indr < n && r[indr] == ind)
			{
				inRange--;
				indr++;
			}
			ind++;
		}
		
		int numGood[] = new int[max+1];
		for (int i = 1; i <= max; i++)
		{
			numGood[i] = numGood[i-1];
			if (cnt[i] >= k) numGood[i]++;
		}
			
		
		for (int i = 0; i < q; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int ans = numGood[b] - numGood[a-1];
			out.println(ans);
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
