package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R153_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R153_Div2_B().run();
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
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
        if (n > 2)
        {
            //bool asc = IsSortedAsc(a);
            //bool dec = IsSortedDec(a);
            for (int i = 0; i < 2; i++)
                for (int j = i + 1; j < n; j++)
                {
                    if (a[i] != a[j])
                    {
                        int t = a[i]; a[i] = a[j]; a[j] = t;
                        if (!IsSortedAsc(a) && !IsSortedDec(a))
                        {
                        	out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                        t = a[i]; a[i] = a[j]; a[j] = t;
                    }
                }
        }	
		out.println(-1);		
	}

    static boolean IsSortedAsc(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
            if (a[i + 1] < a[i]) return false;

        return true;
    }
    static boolean IsSortedDec(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
            if (a[i + 1] > a[i]) return false;

        return true;
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
