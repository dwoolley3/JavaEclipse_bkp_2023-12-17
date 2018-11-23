package spoj;
import java.io.*;
import java.util.*;

public class SPOJ_3442_LASTDIG_The_last_digit
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new SPOJ_3442_LASTDIG_The_last_digit().run();
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
		int t = in.nextInt();  
		for (int T = 1; T <= t; T++) {			
			int a = in.nextInt();
			int b = in.nextInt();
			if (a == 0) 
				out.println(0);
			else if (b == 0)
				out.println(1);
			else {				
				int[] dig = new int[11];
				int i = 0;
				dig[i] = a % 10;
				int prod = dig[i];
				while (i < 10 && (prod * dig[0]) % 10 != dig[0])
				{
					i++; 
					prod *= dig[0];
					dig[i] = prod % 10;
					prod = dig[i];
				}
				i++;
				b--;
				b %= i;				
				out.println(dig[b]);	
			}
		}
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

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	}
}
