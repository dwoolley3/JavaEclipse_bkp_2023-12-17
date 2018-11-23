package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_07_LT_B_TASHIFT
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_07_LT_B_TASHIFT().run();
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
		//Time Limit Exceeded for parts 2 and 3
		//Needs Knuth-Morris-Pratt algorithm 
		//at http://www.inf.fh-flensburg.de/lang/algorithmen/pattern/kmpen.htm
		int n = in.nextInt();	
		String a = in.next();
		String b = in.next();
		
		char[] cha = a.toCharArray();
		char[] chb = b.toCharArray();
		
		int[] ca = new int[26];	
		int[] cb = new int[26];	
		for (int i = 0; i < n; i++)
		{
			ca[a.charAt(i)-'a']++;
			cb[b.charAt(i)-'a']++;
		}
		int common = 0;
		for (int i = 0; i < 26; i++)
			common += Math.min(ca[i], cb[i]);
		
		int max = 0, maxi = 0, aind, bind, k;

		for (int j = 0; j < n; j++)
		{
			aind = 0;
			if (cha[aind] == chb[j])
			{		
				k = 0;
				for (k = 0; k < n; k++)
				{
					bind = (j+k) % n;
					if (cha[aind+k] != chb[bind])
						break;
				}
				if (k > max)
				{
					max = k;
					maxi = j;
				}
				if (max == common) break;
			}			
		}

		out.println(maxi);	

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
