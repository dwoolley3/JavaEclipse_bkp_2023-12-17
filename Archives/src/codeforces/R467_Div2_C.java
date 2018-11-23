package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R467_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R467_Div2_C().run();
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
		long k = in.nextLong(); //stove turns off after k min after turning on
		long d = in.nextLong(); //turns on stove every d min if off
		long t = in.nextLong(); //chicken needs t min when stove on, 2t when off
		t*=2;
		
        long whole = (k + d - 1) / d;
        long slow = whole * d - k;
        long cycle = 2 * k + slow;
        long cycles = t / cycle;
        long extra = t % cycle;
        if (extra <= 2 * k) {
            out.println((double) cycles * (whole * d) + extra / 2.0);
        } else {
            out.println((double) cycles * (whole * d) + k + (extra - 2 * k));
        }
        
        
//		double c1 = 1.0 * k / t;
//		long x = (k / d) * d;
//		if (x < k) x += d;
//		long off = x - k;
//		double c2 = 1.0 * off / t / 2;
//		
//		double both = c1 + c2;
//		long bothsec = k + off;
//		//out.println(both + " " + bothsec);
//		long num = (long)(1.0 / both);
//		//out.println("num = " + num);
//		double dif = 1.0 - num * both;
//		//out.println("dif=" + dif);
//		long totsec = bothsec * num;
//		//out.println("totsec=" + totsec);
//		
//		double extra = 0;
//		if (dif >= c1) {
//			dif -= c1;
//			totsec += k;
//			
//			double part = dif / c2;
//			extra = off * part;
//			
//		} else {
//			double part = dif / c1;
//			extra = k * part;
//		}	
//		totsec += extra;
//		double frac = extra - (long)extra;
//		String f = frac + "";
//		f = f.substring(1);
//		double ans = totsec + frac;
//		
//		out.println(totsec + f);		
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
