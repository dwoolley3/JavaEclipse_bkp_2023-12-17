package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2018_01_CO_B_MULTHREE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2018_01_CO_B_MULTHREE().run();
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
		//d0 d1 and rest
		//1 0 1 24862486248624862486248624862486248624862486248
		//1 1  248624862486248624862486248624862486248624862486
		//1 2 36 2486248624862486248624862486248624862486248624
		//1 3 486 248624862486248624862486248624862486248624862
		//1 4 500000000000000000000000000000000000000000000000
		//1 5 6 24862486248624862486248624862486248624862486248
		//1 6 7486 24862486248624862486248624862486248624862486
		//1 7 86 2486248624862486248624862486248624862486248624
		//1 8 986 248624862486248624862486248624862486248624862
		//1 9 000000000000000000000000000000000000000000000000
		
        int T = in.nextInt();        
        for (int t = 0; t < T; t++)
        {        	
			long k = in.nextLong();
			int[] d = new int[10];
			d[0] = in.nextInt();
			d[1] = in.nextInt();
			int min = (int)Math.min(k, 10);
			//out.print(d[0] + " " + d[1] + " ");
			
			long sum = d[0] + d[1];
			for (int i = 2; i < min; i++)
			{
				d[i] = (int)sum % 10;
				//out.print(d[i]);
				sum += d[i];
			}
			if (d[min-1] != 0 && k > min) {
				//d[min-1] is 2,4,8,or 6
				int rep = 2+4+8+6;
				sum += rep * ((k - min) / 4);
				int x = (int)((k - min) % 4);
				for (int i = 1; i <= x; i++)
					sum += d[min-1 - 4 + i];				
			}
			out.println(sum % 3 == 0 ? "YES" : "NO");
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
