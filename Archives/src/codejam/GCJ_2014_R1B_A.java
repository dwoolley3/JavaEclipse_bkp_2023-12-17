package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2014_R1B_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2014_R1B_A().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/A-ex.in"));
		//in = new FastReader(new File("src/A-small-attempt0.in"));
		in = new FastReader(new File("src/A-large.in"));
		try {
			//out = new PrintWriter(new File("src/A-ex.out"));
			//out = new PrintWriter(new File("src/A-small-attempt0.out"));
			out = new PrintWriter(new File("src/A-large.out"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	//*** Failed on Large test cases, but passed on Samll test cases
	
	void solve()
	{
		int T = in.nextInt();  
		//in.nextLine(); //use after a nextInt() and prior to reading another in.nextLine()

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			
			String[] s = new String[n];
			int[] ind = new int[n];
			int[] contig = new int[n];
			for (int i = 0; i < n; i++)
				s[i] = in.next();
			
			String ans = "";
			int cnt = 0;
			boolean FelgaWon = false;
			for (ind[0] = 0; ind[0] < s[0].length() && !FelgaWon; ind[0]++)
			{				
				contig[0] = 1;
				char c = s[0].charAt(ind[0]);
				ind[0]++;
				while (ind[0] < s[0].length() && c == s[0].charAt(ind[0]))
				{
					contig[0]++;
					ind[0]++;
				}
				ind[0]--;
				
				int sum = contig[0], ave = 0;
				for (int i = 1; i < n; i++)
				{
					contig[i] = 0;
					while (ind[i] < s[i].length() && c == s[i].charAt(ind[i]))
					{
						contig[i]++;
						ind[i]++;
					}
					if (contig[i] == 0) {FelgaWon = true; break; }
					sum += contig[i];
				}

				if (!FelgaWon)
				{
					ave = sum / n;
					if (sum % n > n/2) ave++;
					for (int i = 0; i < n; i++)
						cnt += Math.abs(ave - contig[i]);
				}
			}
			for (int i = 1; i < n; i++)
			{
				//System.out.println(ind[i]);			
				if (ind[i] < s[i].length()) FelgaWon = true;
			}
			
			if (FelgaWon)
				ans = "Fegla Won";
			else
				ans = cnt + "";
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
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
