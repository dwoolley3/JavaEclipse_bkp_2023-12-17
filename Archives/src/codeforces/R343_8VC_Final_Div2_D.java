package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R343_8VC_Final_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R343_8VC_Final_Div2_D().run();
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
		//n = number of days, k = length of repair time
		//a,b = production rates of factory (a>b), q = number of updates
		int n = in.nextInt();
		int k = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int q = in.nextInt();
		
		int li = 200_001;
		int[] minProd = new int[li];
		int[] maxProd = new int[li];
		//int[] minSum = new int[li];
		//int[] maxSum = new int[li];
		
		for (int i = 0; i < q; i++) 
		{
			int type = in.nextInt();
			if (type == 1)
			{
				int d = in.nextInt();  //on day d
				int ai = in.nextInt(); //add ai orders				
				minProd[d] = Math.min(minProd[d] + ai, b);
				maxProd[d] = Math.min(maxProd[d] + ai, a);
			}
			else //type = 2
			{
				int p = in.nextInt(); //start repairs on day p for k days
				int sum = 0;
				for (int j = 1; j < p; j++)
					sum += minProd[j];
				for (int j = p+k; j <= n; j++)
					sum += maxProd[j];
				out.println(sum);
			}
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
