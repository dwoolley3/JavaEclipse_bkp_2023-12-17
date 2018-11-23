import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Solution
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Solution().run();
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
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int s = in.nextInt();
			
			int[] d = new int[s];
			int[] a = new int[s];
			int[] b = new int[s];
			HashSet<Integer> hsa = new HashSet<>();
			HashSet<Integer> hsb = new HashSet<>();
			for (int i = 0; i < s; i++) { 
				d[i] = in.nextInt();
				a[i] = in.nextInt();
				b[i] = in.nextInt();
				hsa.add(d[i]+a[i]);
				hsb.add(d[i]-b[i]);
			}
			
			int mnum = hsa.size();
			int nnum = hsb.size();
			int[] m = new int[mnum];
			int[] n = new int[nnum];
			int i = 0;
			Iterator<Integer> itra=hsa.iterator(); 
			while (itra.hasNext()) {
				m[i] = itra.next();
				out.println(m[i]);
				i++;
			}
			
			i = 0;
			Iterator<Integer> itrb=hsb.iterator(); 
			while (itrb.hasNext()) {
				n[i] = itrb.next();			
				out.println(n[i]);
				i++;
			}
			
			for (int len = s; len > 0; len--) {
				for (i = 0; i <= s - len; i++) {
						
				}
			}

			for (i = 0; i < mnum; i++)
				for (int j = 0; j < nnum; j++) {
					
				}
			
			String ans = "";
			
			out.println("Case #" + tc + ": " + ans);
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
