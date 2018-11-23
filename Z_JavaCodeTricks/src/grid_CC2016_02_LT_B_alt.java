import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2016_02_LT_B_alt
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2016_02_LT_B_alt().run();
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
			int n = in.nextInt();	
			int k = in.nextInt();
				
			String[] s = new String[n];
			for (int i = 0; i < n; i++) 
				s[i] = in.next();
			
			int max = getMaxContig(s, k);
			out.println(max >= k-1 ? "YES" : "NO");
        }		
	}

	private int getMaxContig(String[] s, int k) 
	{
		int dx[] = {-1, -1, -1,  0,   1, 1,  1, 0};
		int dy[] = {-1,  0,  1, -1,   1, 0, -1, 1};
				
		int max = 0, n = s.length;
		for (int i = 0; i < n; ++i) {
		  for (int j = 0; j < n; ++j) {
		    if (s[i].charAt(j) == '.') {
		      for (int dir = 0; dir < 4; ++dir) {
		        int cnt = 0;

		          int x = i, y = j;
		          for (int l = 0; l < k - 1; ++l) {
		            x += dx[dir];
		            y += dy[dir];
		            if (x < 0 || x >= n || y < 0 || y >= n || s[x].charAt(y) != 'X') {
		              break;
		            }
		            cnt++;
		          }

		          x = i; y = j;
		          for (int l = 0; l < k - 1; ++l) 
		          {
		            x += dx[dir + 4];
		            y += dy[dir + 4];
		            if (x < 0 || x >= n || y < 0 || y >= n || s[x].charAt(y) != 'X') {
		              break;
		            }
		            cnt++;
		          }
		        
		          max = Math.max(max, cnt);		        
		      }
		    }
		  }
		}
		return max;
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
