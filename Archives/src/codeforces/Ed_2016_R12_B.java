package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2016_R12_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2016_R12_B().run();
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
	
		int[] a = new int[n];
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (a[i] == 0) al.add(i);
		}
		
		int zn = al.size();
		Integer[] z = new Integer[zn];
		for (int i = 0; i < zn; i++)
			z[i] = al.get(i);
		
		for (int i = 0; i < n; i++)
		{
			int x = Arrays.binarySearch(z, i);
			if (x >= 0)
				out.print("0 ");
			else
			{
				int ind = -x - 1;
				if (ind == zn) ind = zn-1;
				int ans = Math.abs(i - z[ind]);
				if (ind > 0)
					ans = Math.min(ans, Math.abs(i - z[ind - 1]));
				
				out.print(ans + " ");
			}
		}
		out.println();		
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
