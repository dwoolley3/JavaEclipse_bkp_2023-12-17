package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R420_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R420_Div2_C().run();
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

		TreeSet<Integer> ts = new TreeSet<>();
		ArrayList<Integer> stack = new ArrayList<>();
		int sort = 0;
		boolean sortedStackWithSmallestAtTop = true;
		for (int i = 0; i < 2 * n; i++)
		{
			String s = in.next();
			if (s.equals("add"))
			{
				int box = in.nextInt();
				ts.add(box);
				stack.add(box);
				if (ts.first() != box)
					sortedStackWithSmallestAtTop = false;
			}
			else //remove
			{
				//out.println(lastbox);
				int smallestBox = ts.first();
				int lastbox = smallestBox;
				if (stack.size() > 0)
					lastbox = stack.get(stack.size()-1);
				
				if (smallestBox != lastbox && !sortedStackWithSmallestAtTop)
				{
					sort++;
					sortedStackWithSmallestAtTop = true;
					//out.println("sort");					
					stack = new ArrayList<>();
				}
				ts.remove(smallestBox);
				if (stack.size() > 0)
					stack.remove(stack.size()-1);
				//out.println("remove" + smallestBox);
			}
		}
		
		out.println(sort);		
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
