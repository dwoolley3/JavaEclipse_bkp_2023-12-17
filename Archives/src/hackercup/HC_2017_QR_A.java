package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2017_QR_A
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "A_ex";
	final String PROBLEM_NAME = "A";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2017_QR_A().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + "_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + "_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int p = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int x1 = x - 50, y1 = y - 50;
					
			String colorWhite = "white";
			String colorBlack = "black";
			
			String ans = colorBlack;
			if (x1*x1 + y1*y1 > 50 * 50) //distance outside of 50
				ans = colorWhite;
			else if (p == 0)             //Covers 0 percent
				ans = colorWhite;
			else if (x1 == 0 && y1 == 0)
				ans = colorBlack;
			else 
			{
				double a = 50;
				double b = Math.sqrt(x1*x1 + y1*y1);
				int x2 = 50 - x, y2 = 100 - y;
				double c = Math.sqrt(x2*x2 + y2*y2);
				
				double radians = Math.acos((a*a + b*b - c*c) / (2*a*b));
				double degrees = radians * 180 / Math.PI;
				double pdegrees = 360 * (p / 100.0);
				
				if (x < 50) degrees = 360 - degrees;
				
				//System.out.println();
				//System.out.println(a + " " + b + " " + c);
				//System.out.println(radians + " " + degrees + " " + pdegrees);
				
				if (degrees > pdegrees)
					ans = colorWhite;
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}

	//-----------------------------------------------------

	
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
