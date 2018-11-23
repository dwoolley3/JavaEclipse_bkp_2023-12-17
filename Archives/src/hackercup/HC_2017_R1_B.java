package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2017_R1_B
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "B_ex";
	final String PROBLEM_NAME = "B";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2017_R1_B().runWithFiles();
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

		//Find square with most, then square with next most excluding first points
		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int r = in.nextInt();
			
			int[] x = new int[n];
			int[] y = new int[n];
			for (int i = 0; i < n; i++)
			{
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}
			
			//Find square with most points, using each point as a reference for a corner
			int maxCnt = 0, maxi = -1, maxb = 0;
			for (int i = 0; i < n; i++)
				for (int b = 1; b <= 4; b++)
				{
					int cnt = 0;
					for (int j = 0; j < n; j++)
						if (pointInBox(b, x[j],y[j],x[i],y[i],r))
							cnt++;
					if (cnt > maxCnt)
					{
						maxCnt = cnt;
						maxi = i;
						maxb = b;
					}
				}
			//System.out.println(maxCnt + " " + maxi + " " + maxb);
			
			//Store points in best square
			boolean[] pntsInBestSquare = new boolean[n];
			for (int j = 0; j < n; j++)
				if (pointInBox(maxb, x[j],y[j],x[maxi],y[maxi],r))
					pntsInBestSquare[j] = true;
			
			//Find next best square with most points (excluding prior points) 
			int maxCnt2 = 0;
			maxi = -1; maxb = 0;
			for (int i = 0; i < n; i++)
				for (int b = 1; b <= 4; b++)
				{
					int cnt = 0;
					for (int j = 0; j < n; j++)
						if (pntsInBestSquare[j]) 
							continue;
						else if (pointInBox(b, x[j],y[j],x[i],y[i],r))
							cnt++;
					if (cnt > maxCnt2)
					{
						maxCnt2 = cnt;
						maxi = i;
						maxb = b;
					}
				}			
			//System.out.println(maxCnt2 + " " + maxi + " " + maxb);
			
			//Answer is sum of best square and 2nd best square (excluding 1st points)
			String ans = (maxCnt + maxCnt2) + "";
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	boolean pointInBox(int b, int x1, int y1, int x2, int y2, int r)
	{
		switch (b)
		{
		case 1: return (x2 >= x1 && y2 >= y1 && x2 <= x1 + r && y2 <= y1 + r);
		case 2: return (x2 <= x1 && y2 >= y1 && x2 >= x1 - r && y2 <= y1 + r);
		case 3: return (x2 <= x1 && y2 <= y1 && x2 >= x1 - r && y2 >= y1 - r);
		case 4: return (x2 >= x1 && y2 <= y1 && x2 >= x1 + r && y2 >= y1 - r);
		default: return false;
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
