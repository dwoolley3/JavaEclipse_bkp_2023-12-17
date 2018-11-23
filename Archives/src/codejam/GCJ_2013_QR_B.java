package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2013_QR_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2013_QR_B().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/B_input.txt"));
		//in = new FastReader(new File("src/input_B_ex.txt"));
		in = new FastReader(new File("src/B-small-practice.in"));
		//in = new FastReader(new File("src/B-large-practice.in"));
		try {
			out = new PrintWriter(new File("src/B_output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  
		//in.nextLine(); //use after a nextInt() and prior to reading another in.nextLine()

		for (int tc = 1; tc <= T; tc++)
		{
			int N = in.nextInt();
			int M = in.nextInt();
			
            int[][] a = new int[N][M];
            int[] maxInRow = new int[N];
            int[] maxInCol = new int[M];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    a[i][j] = in.nextInt();
                    maxInRow[i] = Math.max(maxInRow[i], a[i][j]);
                }
            }
            
            for (int c = 0; c < M; c++)
                for (int r = 0; r < N; r++)
                    maxInCol[c] = Math.max(maxInCol[c], a[r][c]);

            String ans = "";
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                    if (a[i][j] != maxInCol[j] && a[i][j] != maxInRow[i])
                    {
                        ans = "NO";
                        break;
                    }
                if (ans == "NO") break;
            }
            if (ans == "") ans = "YES";

			
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
