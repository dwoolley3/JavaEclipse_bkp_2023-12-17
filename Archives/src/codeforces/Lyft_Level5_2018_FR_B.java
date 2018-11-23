package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Lyft_Level5_2018_FR_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Lyft_Level5_2018_FR_B().run();
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
		int n = in.nextInt();  //riders
		int m = in.nextInt();  //tax drivers
		
		int[] x = new int[n+m];
		for (int i = 0; i < n + m; i++) 
			x[i] = in.nextInt();
		
		TreeSet<Integer> tset = new TreeSet<>();
		Integer[] taxis = new Integer[m];
		int ind = 0;
		int[] t = new int[n+m];
		for (int i = 0; i < n + m; i++) {
			t[i] = in.nextInt();
			if (t[i] == 1) {
				tset.add(x[i]);
				taxis[ind++] = x[i];
			}
		}
		
		int[] cnt = new int[m];

		for (int i = 0; i < n + m; i++) {
			if (t[i] == 0) { //needs a ride; which taxi is closest?
				int indTaxiLo = -1, indTaxiHi = -1;
				Integer valLo = tset.floor(x[i]);
				Integer valHi = tset.ceiling(x[i]);
				if (valLo == null) valLo = Integer.MIN_VALUE;
				if (valHi == null) valHi = Integer.MAX_VALUE;
				//out.println(valLo + " " + valHi);
				indTaxiHi = Arrays.binarySearch(taxis, valHi);
				indTaxiLo = Arrays.binarySearch(taxis, valLo);
				//out.println(indTaxiLo + " " + indTaxiHi);	
				
				int difLo = Math.abs(x[i] - valLo);
				int difHi = Math.abs(x[i] - valHi);
				int indTaxi = (difLo <= difHi) ? indTaxiLo : indTaxiHi;
				//out.println("indTaxi=" + indTaxi);
				
				cnt[indTaxi]++;	
			}
		}	

		for (int i : cnt)
			out.print(i + " " );
		out.println();
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
