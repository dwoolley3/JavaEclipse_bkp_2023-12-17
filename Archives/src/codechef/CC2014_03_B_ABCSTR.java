package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
//Name: ABC-Strings   *** TLE - Time Limit Exceeded
class CC2014_03_B_ABCSTR
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_03_B_ABCSTR().run();
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
		String s = in.next();
		int n = s.length();
       
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n+1];
		int aCnt=0,bCnt=0,cCnt=0;
		for (int i = 1; i <= n; i++)
		{
			char ch = s.charAt(i-1);
			if (ch=='A') aCnt++;
			else if (ch=='B') bCnt++;
			else cCnt++;  // (ch=='C')
			a[i] = aCnt;
			b[i] = bCnt;
			c[i] = cCnt;			
		}
		
		int aTot, bTot, cTot;
		long cnt = 0;
		for (int i = 3; i <= n; i +=3) //i is length of substring
			for (int j = 0; j < n-i+1; j++) //j is starting index
				{
					aTot = a[j+i] - a[j];
					bTot = b[j+i] - b[j];
					cTot = c[j+i] - c[j];
					if (aTot == bTot && bTot == cTot) cnt++;						
				}
			
		out.println(cnt);		
	}

//	private static void tr(Object... o) { 
//		//if(INPUT.length() != 0)
//			System.out.println(Arrays.deepToString(o)); 
//	}
	
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
