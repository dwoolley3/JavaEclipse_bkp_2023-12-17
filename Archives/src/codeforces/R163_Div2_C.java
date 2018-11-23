package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R163_Div2_C //Name: Below the Diagonal
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R163_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
    static int m = 0; // num of swaps needed
    static ArrayList<Integer> t = new ArrayList<Integer>(); // 1 = swap rows, 2 = swap cols
    static ArrayList<Integer> ii = new ArrayList<Integer>();
    static ArrayList<Integer> jj = new ArrayList<Integer>();
    
	void solve()
	{
		int n = in.nextInt();
		int[][] a = new int[n+1][n+1];
		for (int i = 0; i < n-1; i++) 
		{
			int x = in.nextInt();
			int y = in.nextInt();		
			a[x][y] = 1;
		}
		
        Solve(a, n);

        out.println(m);
        for (int i = 0; i < m; i++)
        {
        	out.println(t.get(i) + " " + (ii.get(i)) + " " + (jj.get(i)));
        }  
	}
	
    static void Solve(int[][] a, int n)
    {
        if (n == 1) return;

        //Find Column with all 0's
        int c = n, r;
        for (c = n; c > 0; c--)
        {
            boolean empty = true;
            for (r = 1; r <= n; r++)
                if (a[r][c] == 1)
                {
                    empty = false;
                    break;
                }
            if (empty) break;
        }

        //Swap column of 0's to last column
        if (c < n && c > 0)
        {
            m++;
            t.add(2);
            ii.add(c);
            jj.add(n);
            for (r = 1; r <= n; r++)
            {
                a[r][c] = a[r][n];
                a[r][n] = 0;
            }
        }

        //Find row with 1
        r = n;
        for (r = n; r > 0; r--)
        {
            boolean gotOne = false;
            for (c = 1; c <= n; c++)
                if (a[r][c] == 1)
                {
                    gotOne = true;
                    break;
                }
            if (gotOne) break;
        }

        //Swap row having 1 to lastRow
        if (r < n && r > 0)
        {
            m++;
            t.add(1);
            ii.add(r);
            jj.add(n);
            int temp;
            for (c = 1; c <= n; c++)
            {
                temp = a[r][c];
                a[r][c] = a[r][n];
                a[n][c] = temp;
            }
        }

        Solve(a, n - 1);
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
