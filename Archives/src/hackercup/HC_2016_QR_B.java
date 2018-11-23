package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2016_QR_B
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "B_ex";
	final String PROBLEM_NAME = "B";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2016_QR_B().runWithFiles();
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
	
	char[][] g;
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			
			g = new char[2][n];
			for (int i = 0; i < 2; i++) 
				g[i] = in.next().toCharArray();
			
			int ans = 0;
			for (int i = 0; i < n; i++)
			{
				if (g[0][i]=='.' && (i == 0 || g[0][i-1] == 'X'))
				{
					if (i+1 == n || (i+1 < n && g[0][i+1] == 'X'))
					{
						if (g[1][i] == 'X')
							PlaceG(0,i);
						else
							PlaceG(1,i);
						ans++;
					}						
				}
				if (g[1][i]=='.' && (i == 0 || g[1][i-1] == 'X'))
				{
					if (i+1 == n || (i+1 < n && g[1][i+1] == 'X'))
					{
						if (g[0][i] == 'X')
							PlaceG(1,i);
						else
							PlaceG(0,i);
						ans++;
					}						
				}
			}

			for (int i = 0; i < 2; i++)
			{
				boolean dots = false;			
				for (int j = 0; j < n; j++)
					if (g[i][j] == '.')
					{
						if (!dots)
						{
							dots = true;
							ans++;
						}
					}
					else 
						dots = false;
			}
			
			for (int i = 0; i < 2; i++)
				System.out.println(g[i]);
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
			//out.printf("Case #%d: %d\n", tc, ans);
		}
	}
	
	void PlaceG(int row, int col)
	{
		int n = g[0].length;
		g[row][col] = 'G';
		if (row+1 == 1 && g[row+1][col] == '.') g[row+1][col] = 'g';
		if (row-1 == 0 && g[row-1][col] == '.') g[row-1][col] = 'g';
		int i = 1;
		while (col + i < n && g[row][col+i] != 'X') 
		{
			if (g[row][col+i] == '.') g[row][col+i] = 'g';
			i++;
		}
		i = 1;
		while (col - i >= 0 && g[row][col-i] != 'X') 
		{
			if (g[row][col-i] == '.') g[row][col-i] = 'g';
			i++;
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
