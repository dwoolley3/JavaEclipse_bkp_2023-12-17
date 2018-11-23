package hackerRank;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HR_World_CodeSprint7_3_Gridland
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new HR_World_CodeSprint7_3_Gridland().run();
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
		int k = in.nextInt();
			
		int[] r = new int[k];
		int[] c1 = new int[k];
		int[] c2 = new int[k];
		for (int i = 0; i < k; i++) 
		{
			r[i] = in.nextInt();
			c1[i] = in.nextInt();
			c2[i] = in.nextInt();
		}
		
		long ans = 1L * n * m;
		
		ArrayList<Integer> used = new ArrayList<>();
		for (int i = 0; i < k; i++)
		{
			if (used.contains(r[i])) continue;
			ArrayList<Integer> conC1 = new ArrayList<>();
			ArrayList<Integer> conC2 = new ArrayList<>();
			for (int j = i; j < k; j++)
			{
				if (r[j] != r[i]) continue;
				boolean overlap = false;
				int sz = conC1.size();
				for (int ind = 0; ind < sz; ind++)
				{
					if (c1[j] <= conC2.get(ind) && conC1.get(ind) <= c2[j])
					{
						conC1.set(ind, Math.min(c1[j], conC1.get(ind)));
						conC2.set(ind, Math.max(c2[j], conC2.get(ind)));
						overlap = true;
					}
				}
				if (!overlap)
				{
					conC1.add(sz, c1[j]);
					conC2.add(sz, c2[j]);
				}				
			}
			
			boolean overlap = true;
			while (overlap)
			{
				overlap = false;
				int sz = conC1.size();
				for (int j = 0; j < sz && !overlap; j++)
					for (int ind = j+1; ind < sz && !overlap; ind++)
					{
						if (conC1.get(j) <= conC2.get(ind) && conC1.get(ind) <= conC2.get(j))
						{
							conC1.set(ind, Math.min(conC1.get(j), conC1.get(ind)));
							conC2.set(ind, Math.max(conC2.get(j), conC2.get(ind)));
							conC1.remove(j);
							conC2.remove(j);
							overlap = true;
						}
					}
			}
			
			for (int ind = 0; ind < conC1.size(); ind++)
			{
				ans -= conC2.get(ind) - conC1.get(ind) + 1;
			}
			used.add(r[i]);
		}

		
		out.println(ans);
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
