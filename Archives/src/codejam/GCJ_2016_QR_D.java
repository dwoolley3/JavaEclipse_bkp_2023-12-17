package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2016_QR_D
{	
	FastReader in;
	PrintWriter out;
	final String PROBLEM_NAME = "D-ex";
//	final String PROBLEM_NAME = "D-small-attempt0";
//	final String PROBLEM_NAME = "D-small-attempt1";
//	final String PROBLEM_NAME = "D-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2016_QR_D().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + ".in")); //"_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + ".out")); //"_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int k = in.nextInt();
			int c = in.nextInt();
			int s = in.nextInt();
						
			int sNeeded = k / c;
			if (k % c != 0) sNeeded++;
			
			String ans = "";
			if (s < sNeeded) 
				ans = "IMPOSSIBLE";
			else if (c == 1)
			{
				for (int i = 1; i <= s; i++)
					ans += i + " ";			
				ans = ans.trim();
			}
			else
			{
				int start = k;
				for (int i = start; i < start + s; i++)
					ans += i + " ";			
				ans = ans.trim();
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
		
		int kk = 6;
		int num = 1 << kk;
		String[] ss = new String[num];
		for (int i = 0; i < num; i++)
		{
			String s = "", orig = "";
			for (int j = 0; j < kk; j++)
				if ((i & (1 << j)) > 0) orig += "G"; else orig += "L";
			
			int c = 3;
			s = orig;

			for (int j = 1; j < c; j++)
			{
				String ns = "";
				for (int k = 0; k < s.length(); k++)
					if (s.charAt(k) == 'G')
						for (int m = 0; m < kk; m++)
							ns += "G";
					else ns += orig;
				s = ns;
			}
			ss[i] = s;
			System.out.println(s);				
		}

		for (int i = 0; i < ss[0].length()-1; i++)
			for (int j = i+1; j < ss[0].length(); j++)
				//for (int jj = j+1; jj < ss[0].length(); jj++)
					//for (int jjj = jj+1; jjj < ss[0].length(); jjj++)
				{
					int cnt = 0;
					for (int l = 0; l < num; l++)
						if (ss[l].charAt(i) == 'L' 
						&& ss[l].charAt(j) == 'L')
						//&& ss[l].charAt(jj) == 'L'
						//&& ss[l].charAt(jjj) == 'L')
							cnt++;
					if (cnt == 1)
					{
						System.out.println((i+1) + " " + (j+1));// + " " + (jj+1) + " " + (jjj+1));
						if (i+1 > 100) return;
					}
				}
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
