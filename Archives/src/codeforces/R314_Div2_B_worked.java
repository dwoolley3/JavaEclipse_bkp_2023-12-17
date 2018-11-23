package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R314_Div2_B_worked
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R314_Div2_B_worked().run();
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
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();

		String[] c = new String[n];
		int[] num = new int[n];
		for (int i = 0; i < n; i++) 
		{			
			c[i] = in.next();
			num[i] = in.nextInt();
			if (c[i].equals("+"))
			{
				a.add(num[i]);
			}
			else // c == '-'
			{
				int ind = a.indexOf(num[i]);
				if (ind > -1)
					a.remove(ind);
				else
					left.add(num[i]);
			}
		}
		
		int inRoomAtStart = left.size();			
		a = new ArrayList<Integer>();
		int gone = 0, roomMax = inRoomAtStart;
		
		for (int i = 0; i < n; i++) 
		{
			if (c[i].equals("+"))
			{
				a.add(num[i]);
				roomMax = Math.max(roomMax, a.size() + inRoomAtStart - gone);
			}
			else // c == '-'
			{
				int ind = a.indexOf(num[i]);
				if (ind > -1)
					a.remove(ind);
				else
				{
					ind = left.indexOf(num[i]);
					left.remove(ind);
					gone++;
				}
			}
			roomMax = Math.max(roomMax, a.size() + inRoomAtStart - gone);
		}
		
		out.println(roomMax);		
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
