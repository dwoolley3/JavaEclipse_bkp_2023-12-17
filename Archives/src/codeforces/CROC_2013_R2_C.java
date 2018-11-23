package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CROC_2013_R2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CROC_2013_R2_C().run();
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
        String s = in.next();
        String t = in.next();

        int two = 0, y = 0, a = 0;
        for (int i = 0; i < 2*n; i++)
        {
            if (s.charAt(i) == '1' && t.charAt(i) == '1') two++;
            else if (s.charAt(i) == '1') y++;
            else if (t.charAt(i) == '1') a++;
        }

        int cntY = 0, cntA = 0;
        for (int i = 0; i < n; i++)
        {
            if (two > 0)
            {
                cntY++;
                two--;
            }
            else if (y > 0)
            {
                cntY++;
                y--;
            }
            else if (a > 0)
                a--;

            if (two > 0)
            {
                cntA++;
                two--;
            }
            else if (a > 0)
            {
                cntA++;
                a--;
            }
            else if (y > 0)
                y--;
        }

        if (cntY > cntA)
        	out.println("First");
        else if (cntY < cntA)
        	out.println("Second");
        else
        	out.println("Draw");
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
