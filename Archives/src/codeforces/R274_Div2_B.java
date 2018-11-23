package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R274_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R274_Div2_B().run();
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
		
		int sum = 0;
		int[] a = new int[n];
		int min = 10001, mini = -1, max = 0, maxi = -1;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			sum += a[i];
			if (a[i] < min)
			{
				min = a[i];
				mini = i;
			}
			if (a[i] > max)
			{
				max = a[i];
				maxi = i;			
			}
		}
		
		int bestMin = sum / n;
		int bestMax = sum / n;
		if (sum % n > 0) bestMax++;
		
		ArrayList<Integer> ind1 = new ArrayList<Integer>();
		ArrayList<Integer> ind2 = new ArrayList<Integer>();
		for (int j = 0; j < k; j++)
		{
			if (max == bestMax && min == bestMin) break;
			a[maxi]--;
			a[mini]++;
			ind1.add(maxi+1);
			ind2.add(mini+1);
			min = 10001; mini = -1; max = 0; maxi = -1;
			for (int i = 0; i < n; i++)
			{
				if (a[i] < min)
				{
					min = a[i];
					mini = i;
				}
				if (a[i] > max)
				{
					max = a[i];
					maxi = i;			
				}
			}
		
		}
		int instability = max - min;
		int cnt = ind1.size();
		out.println(instability + " " + cnt);
		for (int i = 0; i < cnt; i++)
			out.println(ind1.get(i) + " " + ind2.get(i));

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
