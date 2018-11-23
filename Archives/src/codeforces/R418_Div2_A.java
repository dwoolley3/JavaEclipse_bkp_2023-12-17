package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R418_Div2_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R418_Div2_A().run();
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
		
		int[] a = new int[n];
		ArrayList<Integer> al1 = new ArrayList<>();
		ArrayList<Integer> al2 = new ArrayList<>();
		int zInd = -1;
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			if (a[i] == 0)
			{
				zInd = i;
			}
			else
			{
				al1.add(a[i]);
				al2.add(a[i]);
			}			
		}
		boolean yes = false;
		
		Collections.sort(al1);		
		for (int i = 0; i < al1.size(); i++)
		{
			//int x = al1.get(i);
			//int y = al2.get(i);		
			//if (al1.get(i) != al2.get(i))  //Note: Doesn't work; can't compare Object Integers
			if (!al1.get(i).equals(al2.get(i)))
				yes = true;
		}
		
		int[] b = new int[k];		
		for (int i = 0; i < k; i++) 
			b[i] = in.nextInt();	

		if (!yes && k > 1) 
			yes = true;
		else
		{
			if ((zInd > 0 && a[zInd-1] >= b[0])
			|| (zInd < n-1 && b[0] >= a[zInd+1]))
				yes = true;
		}
		out.println(yes ? "Yes" : "No");		
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
