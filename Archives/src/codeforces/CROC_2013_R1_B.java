package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CROC_2013_R1_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CROC_2013_R1_B().run();
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
		
        int[] x = new int[m];
        int[] y = new int[m];
        int maxNum = 100000;
        int[] b = new int[maxNum+1];
        for (int i = 0; i < m; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            b[x[i]]++;
            b[y[i]]++;
        }

        int one = 0, two = 0, max = 0;
        for (int i = 1; i <= n; i++)
        {
            if (b[i] == 1) one++;
            if (b[i] == 2) two++;
            max = Math.max(max, b[i]);
        }
        
        String ans;
        if (one == 2 && two == m - 1)
            ans = "bus";
        else if (two == m)
            ans = "ring";
        else if (one == m && max == m)
            ans = "star";
        else ans = "unknown";

        out.println(ans + " topology");
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
