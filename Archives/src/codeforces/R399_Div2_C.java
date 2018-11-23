package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R399_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R399_Div2_C().run();
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
		int k = in.nextInt();  //times of operations
		int x = in.nextInt();  //favorite num
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		Arrays.sort(a);
		
		TreeSet<String> ts = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(a[i] + " ");
		String s = sb.toString();
		ts.add(s);
		//out.println(s);


		String first = "";
		boolean repeatFound = false;
		int j1 = -1, j2 = -1, usej = -1;
		for (int j = 1; j <= k; j++)
		{
			for (int i = 0; i < n; i += 2)
				a[i] = a[i] ^ x;

			Arrays.sort(a);
			sb = new StringBuilder();
			for (int i = 0; i < n; i++)
				sb.append(a[i] + " ");
			
			s = sb.toString();

			if (repeatFound)
			{
				if (s.equals(first))
				{
					j2 = j;
					//out.println(j2);
					int cycle = j2 - j1;
					usej = j2 + ((k - j2) % cycle);
					//out.println("usej = " + usej);
				}
			}
			else if (ts.contains(s))
			{
				repeatFound = true;				
				first = s;
				j1 = j;
				//out.println(j1);
			}
			else
				ts.add(s);
			
//			for (int i = 0; i < n; i++)
//				out.print(a[i] + " ");
//			out.println();
			
			if (j == usej) break;
		}
		
		int min = a[0];
		int max = a[n-1];
		
		out.println(max + " " + min);		
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
