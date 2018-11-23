import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//****  for SPOJ, class must be called M a i n

public class stack_SPOJ_0095_STPAR_Street_Parade
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new stack_SPOJ_0095_STPAR_Street_Parade().run();
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
		while (n > 0) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) 
				a[i] = in.nextInt();
			 
			ArrayDeque<Integer> stack = new ArrayDeque<>(); 
			int pos = 1;
			for (int i = 0; i < n; i++)
			{
				if (a[i] != pos)
				{
					while (!stack.isEmpty() && stack.peek() == pos) 
					{
						stack.pop();
						pos++;
					}
					stack.push(a[i]);
				}
				else// (a[i] == pos) 
					pos++;
			}
			while (!stack.isEmpty() && stack.peek() == pos) 
			{
				stack.pop();
				pos++;
			}
			if (stack.isEmpty()) 
				out.println("yes");
			else 
				out.println("no");
			
			n = in.nextInt();
		}
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
