package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R168_Div2_A //Name: Lights Out
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R168_Div2_A().run();
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
        int[][] a = new int[3][3];
        int[][] b = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                a[i][j] = in.nextInt();
                b[i][j] = 1;
            }
        }
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                int it = a[i][j] % 2;
                for (int num = 0; num < it; num++)
                {
                    for (int k = 0; k < 3; k++)
                    {
                        if (Math.abs(k - j) <= 1)
                            b[i][k] = 1 - b[i][k];
                        if (Math.abs(k - i) <= 1)
                            b[k][j] = 1 - b[k][j];
                    }
                    b[i][j] = 1 - b[i][j]; // remove duplicate
                }
            }

         for (int i = 0; i < 3; i++)
        	 out.println(b[i][0] + "" + b[i][1] + "" + b[i][2]);

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
