package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2015_R1_B
{	
	FastReader in;
	PrintWriter out;
	final String PROBLEM_NAME = "B_ex_big100";
	//final String PROBLEM_NAME = "B";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2015_R1_B().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + "_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + "_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			
			TreeSet<String> hs = new TreeSet<>(); 
			//HashSet<String> hs = new HashSet<String>();
			int ans = 0;
			for (int i = 0; i < n; i++) 
			{
				String w = in.next();
				//StringBuilder sb = new StringBuilder();
				int min = -1;
				String wpre = "";
				for (int j = 0; j < Math.min(w.length(), 3000); j++)
				{
					//sb.append(w.charAt(j));
					wpre += w.charAt(j); 
					//wpre = sb.toString(); //Faster than sb+"";
					if (!hs.contains(wpre) && min == -1)
						min = j+1;

					hs.add(wpre);
				}
				if (min == -1) min = w.length();
				ans += min;	
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
//		out.println(100);
//		for (int k = 0; k < 100; k++)
//		{
//		out.println(1500);
//		for (int i = 0; i < 1500; i++)
//		{
//			for (int j = 0; j < i+1; j++)
//				out.print('a');
//				//out.print((char)(((int)(Math.random()*26))+'a'));
//			out.println();
//		}
//		}
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
