package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R283_Div1_B_FAILED
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R283_Div1_B_FAILED().run();
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
		int a1 = 0, a2 =0;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (a[i] == 1) a1++; else a2++;
		}
		
		ArrayList<Long> al = new ArrayList<Long>();
		if (a[n-1] == 1)
		{
			for (int s = 1; s * s <= a1; s++)
				if (a1 % s == 0)
				{
					int t = a1 / s;					
					int sum1 = 0, sum2 = 0, set1 = 0, set2 = 0;
					for (int i = 0; i < n; i++)
					{
						if (a[i] == 1) sum1++; else sum2++;
						if (sum1 == t || sum2 == t) {
							if (sum1 == t) set1++; else set2++;
							sum1 = 0; sum2 = 0;
							if (set1 == s || set2 == s) {
								if (i == n-1)
								{
									//out.println(s + " " + t);
									al.add(s*1_000_000L + t);
								}
								break;
							}
						}
					}
					
					if (s != t)
					{
						int temp = t; t = s; s = temp;			
						sum1 = 0; sum2 = 0; set1 = 0; set2 = 0;
						for (int i = 0; i < n; i++)
						{
							if (a[i] == 1) sum1++; else sum2++;
							if (sum1 == t || sum2 == t) {
								if (sum1 == t) set1++; else set2++;
								sum1 = 0; sum2 = 0;
								if (set1 == s || set2 == s) {
									if (i == n-1)
									{
										//out.println(s + " " + t);
										al.add(s*1_000_000L + t);
									}
									break;
								}
							}
						}
						
						
						temp = t; t = s; s = temp;
					}
				}
		}
		if (a[n-1] == 2)
		{
			for (int s = 1; s * s <= a2; s++)
				if (a2 % s == 0)
				{
					int t = a2 / s;					
					int sum1 = 0, sum2 = 0, set1 = 0, set2 = 0;
					for (int i = 0; i < n; i++)
					{
						if (a[i] == 1) sum1++; else sum2++;
						if (sum1 == t || sum2 == t) {
							if (sum1 == t) set1++; else set2++;
							sum1 = 0; sum2 = 0;
							if (set1 == s || set2 == s) {
								if (i == n-1)
								{
									//out.println(s + " " + t);
									al.add(s*1_000_000L + t);
								}
								break;
							}
						}
					}
					
					if (s != t)
					{
						int temp = t; t = s; s = temp;			
						sum1 = 0; sum2 = 0; set1 = 0; set2 = 0;
						for (int i = 0; i < n; i++)
						{
							if (a[i] == 1) sum1++; else sum2++;
							if (sum1 == t || sum2 == t) {
								if (sum1 == t) set1++; else set2++;
								sum1 = 0; sum2 = 0;
								if (set1 == s || set2 == s) {
									if (i == n-1)
									{
										//out.println(s + " " + t);
										al.add(s*1_000_000L + t);
									}
									break;
								}
							}
						}
						
						temp = t; t = s; s = temp;
					}
				}
		}
		Collections.sort(al);
		out.println(al.size());
		for (long num : al)
			out.println((num / 1_000_000) + " " + (num % 1_000_000));		

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
