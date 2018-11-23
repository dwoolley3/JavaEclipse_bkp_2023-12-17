package codeforces;

import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R155_Div2_B_files
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R155_Div2_B_files().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/input.txt"));
		in = new FastReader(new File("input.txt"));
		try {
			//out = new PrintWriter(new File("src/output.txt"));
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	static int [] DaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	void solve()
	{
		int n = in.nextInt();
		
        int[] m = new int[100];
        int[] d = new int[100];
        int[] p = new int[100];
        int[] t = new int[100];
        for (int i = 0; i < n; i++)
        {
            m[i] = in.nextInt();
            d[i] = in.nextInt();
            p[i] = in.nextInt();
            t[i] = in.nextInt();
        }

        int[] doy1 = new int[n];
        int[] doy2 = new int[n];
        int min = 366, max = -100, maxp = 0;
        for (int i = 0; i < n; i++)
        {
            //DateTime dt  = new DateTime(2013, m[i], d[i]);
            int doy = 0;
            for (int j = 0; j < m[i]-1; j++)
            	doy += DaysInMonth[j];
            doy += d[i];
            doy2[i] = doy - 1;
            doy1[i] = doy2[i] - t[i] + 1;
            min = Math.min(min, doy1[i]);
            max = Math.max(max, doy2[i]);
        }
        int cnt = 0;
        for (int i = min; i <= max; i++)
        {
            cnt = 0;
            for (int j = 0; j < n; j++)
            {
                if (i >= doy1[j] && i <= doy2[j])
                    cnt += p[j];
            }
            if (cnt > maxp) maxp = cnt;
        }                          	
		System.out.println(maxp);
		out.println(maxp);
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
