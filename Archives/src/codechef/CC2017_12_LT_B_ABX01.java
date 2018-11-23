package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_12_LT_B_ABX01
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_12_LT_B_ABX01().run();
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
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			long a = in.nextLong();
			long n = in.nextLong();	
			
			int fa = f(a);
			int[] d = new int[20];
			d[0] = fa;
			for (int i = 1; i < 20; i++)
				d[i] = f(d[i-1] * fa);
			
			if (fa == 1 || fa == 9)
				out.println(fa);
			else if (fa == 2 || fa == 5)
				out.println(d[(int)((n-1) % 6)]);
			else if (fa == 3 || fa == 6)
				out.println(n == 1 ? fa : 9);
			else if (fa == 4 || fa == 7)
				out.println(d[(int)((n-1) % 3)]);
			else if (fa == 8)
				out.println(n % 2 == 1 ? 8 : 1);

			//T=20, a = 1...20, n = 100
			//out.print(a + " = ");
			//for (int i = 0; i < 20; i++)
			//	out.print(d[i] + " ");
//			1 = 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 
//			2 = 2 4 8 7 5 1 2 4 8 7 5 1 2 4 8 7 5 1 2 4 
//			3 = 3 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 
//			4 = 4 7 1 4 7 1 4 7 1 4 7 1 4 7 1 4 7 1 4 7 
//			5 = 5 7 8 4 2 1 5 7 8 4 2 1 5 7 8 4 2 1 5 7 
//			6 = 6 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 
//			7 = 7 4 1 7 4 1 7 4 1 7 4 1 7 4 1 7 4 1 7 4 
//			8 = 8 1 8 1 8 1 8 1 8 1 8 1 8 1 8 1 8 1 8 1 
//			9 = 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 
//			10 = 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 
//			11 = 2 4 8 7 5 1 2 4 8 7 5 1 2 4 8 7 5 1 2 4 
//			12 = 3 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 
//			13 = 4 7 1 4 7 1 4 7 1 4 7 1 4 7 1 4 7 1 4 7 
//			14 = 5 7 8 4 2 1 5 7 8 4 2 1 5 7 8 4 2 1 5 7 
//			15 = 6 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 
//			16 = 7 4 1 7 4 1 7 4 1 7 4 1 7 4 1 7 4 1 7 4 
//			17 = 8 1 8 1 8 1 8 1 8 1 8 1 8 1 8 1 8 1 8 1 
//			18 = 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 
//			19 = 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 
//			20 = 2 4 8 7 5 1 2 4 8 7 5 1 2 4 8 7 5 1 2 4 
// 			out.println();
        }
	}
	
	int f(long a) {
		int fa = 0;
		do {
			fa = 0;
			while (a > 0) {
				int d = (int)(a % 10);
				fa += d;
				a /= 10;
			}
			a = fa;
		} while (fa >= 10);
		return fa;
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
