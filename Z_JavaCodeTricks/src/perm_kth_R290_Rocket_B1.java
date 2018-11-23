import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class perm_kth_R290_Rocket_B1
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new perm_kth_R290_Rocket_B1().run();
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
		//ithPermutation(n,k-1);
		
		int[] per = generateInitialPermutation(n);
		int cnt = 0, max = 0;
		do {			
			int sum = 0;
			for (int i = 0; i < n; i++)
			{	
				for (int j = i; j < n; j++)
				{
					int min = 100;	
					for (int kk = i; kk <= j; kk++)
						min = Math.min(min,(per[kk]+1));
					sum += min;
				}
			}
			max = Math.max(max, sum);
		} while (next_permutation(per));  //next in lexicographical order

		//out.println(max);
		per = generateInitialPermutation(n);
		do {			
			int sum = 0;
			for (int i = 0; i < n; i++)
			{	
				for (int j = i; j < n; j++)
				{
					int min = 100;	
					for (int kk = i; kk <= j; kk++)
						min = Math.min(min,(per[kk]+1));
					sum += min;
				}
			}
			if (sum == max) 
			{
				cnt++;
//				out.print(cnt + " - ");
//				for (int i = 0; i < n; i++)
//					out.print((per[i] + 1) + " ");
//				out.println();
			}
		} while (cnt < k && next_permutation(per));  //next in lexicographical order
		
//		cnt = 0;
//		per = generateInitialPermutation(n);
//		do {
//			cnt++;	
//		} while (cnt < k && next_permutation(per));  //next in lexicographical order
		
		for (int i = 0; i < n; i++)
			out.print((per[i] + 1) + " ");
		out.println();

	}
	
	void ithPermutation(int n, long i)
	{
	   int j, k = 0;
	   long[] fact = new long[n];
	   long[] perm = new long[n];

	   // compute factorial numbers
	   fact[k] = 1;
	   while (++k < n)
	      fact[k] = fact[k - 1] * k;

	   // compute factorial code
	   for (k = 0; k < n; k++)
	   {
	      perm[k] = i / fact[n - 1 - k];
	      i = i % fact[n - 1 - k];
	   }

	   // re-adjust values to obtain the permutation
	   // start from the end and check if preceding values are lower
	   for (k = n - 1; k > 0; k--)
	      for (j = k - 1; j >= 0; j--)
	         if (perm[j] <= perm[k])
	            perm[k]++;

	   // print permutation
		for (k = 0; k < n; k++)
			out.print((perm[k] + 1) + " ");
		out.println();
	}
	
	
	public int[] generateInitialPermutation(int size)
	{
		int[] p = new int[size];
		for (int i = 0; i < size; i++) p[i] = i;
		return p;
	}
	
	public boolean next_permutation(int[] p) 
	{
		// 0,1,2 -> 0,2,1 -> 1,0,2 -> 1,2,0 -> 2,0,1 -> 2,1,0
		int t, n = p.length;
		for (int i = n - 2; i >= 0; i--)
		    if (p[i] < p[i + 1])
		    	for (int j = n - 1;; j--)
		    		if (p[j] > p[i]) 
		    		{
		    			t = p[i]; p[i] = p[j];  p[j] = t;
				        for (i++, j = n - 1; i < j; i++, j--) 
				        {
				        	t = p[i]; p[i] = p[j]; p[j] = t;
				        }
				        return true;
		    		}
		 return false;  //p is last lexicographically, e.g. -> 2, 1, 0
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
