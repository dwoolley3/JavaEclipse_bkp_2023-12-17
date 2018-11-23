package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R371_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R371_Div2_C().run();
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
		int n = in.nextInt();

		HashMap<String,Integer> hm2 = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			String sym = in.next();
			long num = in.nextLong();
			if (sym.equals("+"))
			{
				int x = 0;			
				StringBuilder sb2 = new StringBuilder();
				String numSt = num + "";
				int ns = numSt.length();
				for (int j = 0; j < 18 - ns; j++) sb2.append("0");
				for (int j = 0; j < numSt.length(); j++)
				{
					char d = numSt.charAt(j);
					if ((d - '0') % 2 == 0)
						sb2.append("0");
					else
						sb2.append("1");
				}
				String s = sb2.toString();
				if (hm2.containsKey(s)) x = hm2.get(s);
				hm2.put(s, x+1);		
			}
			else if (sym.equals("-"))
			{
				StringBuilder sb2 = new StringBuilder();
				String numSt = num + "";
				int ns = numSt.length();
				for (int j = 0; j < 18 - ns; j++) sb2.append("0");
				for (int j = 0; j < numSt.length(); j++)
				{
					char d = numSt.charAt(j);
					if ((d - '0') % 2 == 0)
						sb2.append("0");
					else
						sb2.append("1");
				}
				String s = sb2.toString();
				int x = hm2.get(s);
				hm2.put(s, x-1);	
			}
			else  //? Display
			{
				StringBuilder sb = new StringBuilder("000000000000000000");
				String numSt = num + "";
				StringBuilder npat = new StringBuilder();
				npat.append(sb.replace(18 - numSt.length(), 18, numSt));
				int ans = 0;
				if (hm2.containsKey(npat.toString()))
					ans = hm2.get(npat.toString());
				out.println(ans);
			}			
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
