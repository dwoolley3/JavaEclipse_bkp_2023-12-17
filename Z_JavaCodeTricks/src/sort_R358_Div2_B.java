import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class sort_R358_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new sort_R358_Div2_B().run();
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
		//To avoid O(n^2) sort in Java for big n (e.g. greater than 10,000),
		//use Integer (Object) array rather than int (primitives) array
		//or use ArrayList<Integer> or shuffle the array (for int).
		//Java uses Quick sort for primitive type sorting (e.g. int),
		//and merge sort for Object Sorting (e.g. Integer)
		//Alternatively, use PriorityQueue.
		
		int n = in.nextInt();		
		Integer[] a = new Integer[n];  //objects:  Integer, Long 
		//int[] a = new int[n];        //primitive: int, long
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
		//Shuffle array for Test #105, n = 100,000; otherwise it causes O(n^2) with Java Sort
		//No issue for Sort in C# or C++
//		for (int i = 0; i < n; i++)
//	    {
//			int ra = (int)(Math.random()*(i+1));  //i+1 better than n
//	        int temp = a[i]; a[i] = a[ra]; a[ra] = temp;
//	    }
		
		Arrays.sort(a);  //Quicksort for primitives; Mergesort for objects
		int mex = 1;
		for (int i = 0; i < n; i++)
			if (a[i] >= mex) mex++;
		
		out.println(mex);		
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
