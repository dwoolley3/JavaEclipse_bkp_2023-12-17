package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2021_R104_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2021_R104_D().run();
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
		// Examples:
		//		15 112 113
		//		17 144 145
		//		19 180 181
		//		21 220 221
		//		23 264 265
		//      :
		//      44717 999805044 999805045
		//      44719 999894480 999894481
		//      44721 999983920 999983921
		//      a=odd; b = a*a / 2; c = (a*a / 2) + 1

//		for (int a = 1; a <= 0; a++)
//			for (int b = a; b <= 10000; b++)
//				for (int c = b; c <= 10000; c++) {
//					if (c == a*a - b && c*c == a*a + b*b)
//						System.out.println(a + " " + b + " " + c);
//				}
//		System.out.println("done");
		
		int n = 1_000_000_000;
		int max = 2* ((int)Math.sqrt(n) + 1);
		int cnt = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();
		TreeSet<Integer> ts = new TreeSet<>();
		hm.put(1,0);
		ts.add(1);
		for (long a = 3; a <= max; a+= 2) {
			long b = a*a / 2;
			long c = (a*a / 2) + 1;
			if (a <= b && b <= c && c <= n) {
				cnt++;
				//System.out.println(a + " " + b + " " + c);
				hm.put((int)c, cnt);
				ts.add((int)c);
			}
		}
		
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {			
			n = in.nextInt();
			int lowerc = ts.floor(n);

			out.println(hm.get(lowerc));
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
