package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CROC_2013_QR_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CROC_2013_QR_C().run();
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
		int k = in.nextInt();

        int[] ip = new int[n];
        String ipSt;
        for (int i = 0; i < n; i++)
        {
            ipSt = in.next();
            {
                String[] s = ipSt.split("[.]");
                for (int j = 0; j < 4; j++)
                    ip[i] = ip[i] * 256 
                    + Integer.parseInt(s[j]);
            }
        }

        int ones = 0;
        for (ones = 1; ones < 32; ones++)
        {
            Set<Integer> set = new HashSet<Integer>();
            int mask = 0;
            for (int j = 0; j < ones; j++)
                mask = 2 * mask + 1;
            for (int j = ones; j < 32; j++)
                mask = 2 * mask;

            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = ip[i] & mask;
                set.add(a[i]);
            }
            if (set.size() == k)
                break;
        }
        if (ones == 32)
        	out.println(-1);
        else
        {
            int[] part = new int[4];
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    int one = (ones-- > 0) ? 1 : 0;
                    part[i] = part[i] * 2 + one;
                }
            }

            String ans = part[0] + "." + part[1] + "." + part[2] + "." + part[3];
            out.println(ans);
        }   
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
