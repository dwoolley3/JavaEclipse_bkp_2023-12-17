package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R516_Div2_D_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R516_Div2_D_orig().run();
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
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] left = new int[n+1][m+1];
		int[][] right = new int[n+1][m+1];
		
		int r = in.nextInt();
		int c = in.nextInt();
		int pt = r*10000 + c;
		
		int x = in.nextInt();  //max num left movement
		int y = in.nextInt();  //max num right movement
		String[] s = new String[n];
		for (int i = 0; i < n; i++)
			s[i] = in.next();		
		
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				left[i][j] = -1;
				right[i][j] = -1;
			}
		
		//Breath First Search - BFS
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(pt);
		left[r][c] = 0;
		right[r][c] = 0;
		while(!que.isEmpty())
		{
			int t = que.poll();  //Retrieve and remove from head
			r = t / 10000; 
			c = t - r*10000;

			int r2 = r+1, c2 = c; //down
			if (r2 <= n && s[r2-1].charAt(c2-1) == '.' && left[r2][c2] < 0) {
				left[r2][c2] = left[r][c];
				right[r2][c2] = right[r][c];
				pt = r2*10000 + c2;
				que.add(pt);					
			}
			
			r2 = r-1; c2 = c; //up
			if (r2 > 0 && s[r2-1].charAt(c2-1) == '.' && left[r2][c2] < 0) {
				left[r2][c2] = left[r][c];
				right[r2][c2] = right[r][c];
				pt = r2*10000 + c2;
				que.add(pt);					
			}
			
			r2 = r; c2 = c-1; //left
			if (c2 > 0 && s[r2-1].charAt(c2-1) == '.' && left[r2][c2] < 0) {
				if (left[r][c] + 1 <= x) {
					left[r2][c2] = left[r][c] + 1;
					right[r2][c2] = right[r][c];
					pt = r2*10000 + c2;
					que.add(pt);				
				}
			}
			
			r2 = r; c2 = c+1; //right
			if (c2 <= m && s[r2-1].charAt(c2-1) == '.' && left[r2][c2] < 0) {
				if (right[r][c] + 1 <= y) {
					left[r2][c2] = left[r][c];
					right[r2][c2] = right[r][c] + 1;
					pt = r2*10000 + c2;
					que.add(pt);
				}
			}						
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				if (left[i][j] != -1 && right[i][j] != -1)
					cnt++;
			}
		
		out.println(cnt);	
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
