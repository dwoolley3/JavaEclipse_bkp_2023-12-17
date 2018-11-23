package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R317_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R317_Div2_B().run();
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
		int bd = in.nextInt();
		
		ArrayList<Integer> sPrice = new ArrayList<Integer>();
		ArrayList<Integer> sQuant = new ArrayList<Integer>();
		ArrayList<Integer> bPrice = new ArrayList<Integer>();
		ArrayList<Integer> bQuant = new ArrayList<Integer>();
		int max = 100_001;
		int[] bp = new int[max];
		int[] sp = new int[max];	
		int p,q;
		for (int i = 0; i < n; i++) 
		{
			String s = in.next();		
			p = in.nextInt();
			q = in.nextInt();
			if (s.equals("B"))
				bp[p]+= q;
			else
				sp[p]+= q;
		}
		
		for (int i = 0; i < max; i++)
		{
			if (bp[i] > 0)
			{
				bPrice.add(i);
				bQuant.add(bp[i]);
			}
			if (sp[i] > 0)
			{
				sPrice.add(i);
				sQuant.add(sp[i]);
			}
		}
		
		for (int i = 0; i < sPrice.size(); i++)
			for (int j = i+1; j < sPrice.size(); j++)
				if (sPrice.get(i) > sPrice.get(j))  //lower price better
				{
					int t = sPrice.get(i); sPrice.set(i,sPrice.get(j));
					sPrice.set(j,t);
					t = sQuant.get(i); sQuant.set(i,sQuant.get(j));
					sQuant.set(j,t);
				}

		for (int i = 0; i < bPrice.size(); i++)
			for (int j = i+1; j < bPrice.size(); j++)
				if (bPrice.get(i) < bPrice.get(j))  //higher price better
				{
					int t = bPrice.get(i); bPrice.set(i,bPrice.get(j));
					bPrice.set(j,t);
					t = bQuant.get(i); bQuant.set(i,bQuant.get(j));
					bQuant.set(j,t);
				}
		
		for (int i = Math.min(bd, sPrice.size()) - 1; i >= 0; i--)
			out.println("S " + sPrice.get(i) + " " + sQuant.get(i));
		
		for (int i = 0; i <  Math.min(bd, bPrice.size()); i++)
			out.println("B " + bPrice.get(i) + " " + bQuant.get(i));
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
