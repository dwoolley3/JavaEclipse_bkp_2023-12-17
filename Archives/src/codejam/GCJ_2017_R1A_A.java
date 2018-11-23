package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2017_R1A_A
{	
	FastReader in;
	PrintWriter out;
//	final String PROBLEM_NAME = "A-ex";
//	final String PROBLEM_NAME = "A-small-attempt0";
//	final String PROBLEM_NAME = "A-small-attempt1";
	final String PROBLEM_NAME = "A-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2017_R1A_A().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + ".in")); //"_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + ".out")); //"_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int R = in.nextInt();
			int C = in.nextInt();
			char[][] c = new char[R][C];
			for (int i = 0; i < R; i++)
			{
				String s = in.next();
				c[i] = s.toCharArray();
			}
			
			TreeSet<Character> charsUsed = new TreeSet<>();
			
			for (int i = 0; i < R; i++)
				for (int j = 0; j < C; j++)
				{
					if (c[i][j] != '?' && !charsUsed.contains(c[i][j]))						
					{
						charsUsed.add(c[i][j]);
						int left = j;
						while (left - 1 >= 0 && c[i][left - 1] == '?')
							left--;
						
						int right = j;
						while (right + 1 < C && c[i][right + 1] == '?')
							right++;
						
						int top = i;
						boolean ok = true;
						for (; top >= 0; top--)
						{
							for (int k = left; k <= right && ok; k++)
								if (c[top][k] != '?' && c[top][k] != c[i][j]) ok = false;
							if (!ok) break;
						}
						top++;
						
						int bottom = i;
						ok = true;
						for (; bottom < R; bottom++)
						{
							for (int k = left; k <= right && ok; k++)
								if (c[bottom][k] != '?'  && c[bottom][k] != c[i][j]) ok = false;
							if (!ok) break;
						}
						bottom--;
						
						//System.out.println(left + " " + right + " " + top + " " + bottom);
						
						for (int r = top; r <= bottom; r++)
							for (int col = left; col <= right; col++)
								c[r][col] = c[i][j];
					}
				}
		
			String ans = "";
			
			System.out.println("Case #" + tc + ": " + ans);
			for (int i = 0; i < R; i++)
			{
				for (int j = 0; j < C; j++)
					System.out.print(c[i][j]);
				System.out.println();
			}
			out.println("Case #" + tc + ": " + ans);
			for (int i = 0; i < R; i++)
			{
				for (int j = 0; j < C; j++)
					out.print(c[i][j]);
				out.println();
			}
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
