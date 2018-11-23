package spoj;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//****  for SPOJ, class must be called M a i n

public class SPOJ_2157_ABSYS_AntiBlot_System
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new SPOJ_2157_ABSYS_AntiBlot_System().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	@SuppressWarnings("unused")
	void solve()
	{
		int t = in.nextInt();  
		for (int T = 1; T <= t; T++) {
			String st = in.nextLine();
			String[] s = new String[3];
			s[0] = in.next();
			String pl = in.next();
			s[1] = in.next();
			String eq = in.next();
			s[2] = in.next();
			
			String m = "machula";
			int[] ind = new int[3];
			long[] a = new long[3];
			for (int i = 0; i < 3; i++)
			{
				ind[i] = s[i].indexOf(m);
				if (ind[i] == -1)
					a[i] = Long.parseLong(s[i]);
			}
			
			for (int i = 0; i < 3; i++)
				if (ind[i] > -1)
					switch (i) {
						case 0: a[i] = a[2] - a[1]; break;
						case 1: a[i] = a[2] - a[0]; break;
						case 2: a[i] = a[0] + a[1]; break;
					}
			
			out.println(a[0] + " + " + a[1] + " = " + a[2]);	
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
