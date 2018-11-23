package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R270_Div2_B_orig //Name: Design Tutorial: Learn from Life
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R270_Div2_B_orig().run();
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
		
		int[] f = new int[n];
		int[] haveonf = new int[2001];
		int[] needonf = new int[2001];
		int sum = 0;
		ArrayList<Integer> la = new ArrayList<Integer>();
		la.add(1);
		for (int i = 0; i < n; i++) 
		{
			f[i] = in.nextInt();
			needonf[f[i]]++;
			if (!la.contains(f[i])) la.add(f[i]);
		}
		
		Collections.sort(la);
		int rem = n, take, ind = 0, fl = 0;
		haveonf[0] = n; needonf[0] = 0;
		rem = haveonf[fl] - needonf[fl];
		ind++;
		while (rem > 0 && ind < la.size())
		{
			fl = la.get(ind);
			take = Math.min(rem,  k);
			rem -= take;
			sum += (fl - la.get(ind-1));
			haveonf[fl] += take;
			haveonf[la.get(ind-1)] -= take;
			if (rem > 0)
				sum += (fl - la.get(ind-1));
			else
			{	
				rem = haveonf[fl] - needonf[fl];
				ind++;
			}
		}
		sum += la.get(ind-1) - la.get(0);

		out.println(sum);		
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
