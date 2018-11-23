package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R454_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R454_Div2_C().run();
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

		int shock = 0, min = (int)1e9;
		TreeSet<Character> pos = new TreeSet<>();
		for (char c = 'a'; c <= 'z'; c++) pos.add(c);
		
		TreeSet<Character> elim = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			char type = in.next().charAt(0);
			String word = in.next();
			if (type == '?') {
				shock++;
				char c = word.charAt(0);
				pos.remove(c);
				elim.add(c);
			}
			else  {
				TreeSet<Character> wSet = new TreeSet<>();
				for (int j = 0; j < word.length(); j++) 
					wSet.add(word.charAt(j));
				
				if (type == '!')
				{
					shock++;
					for (char let = 'a'; let <= 'z'; let++)
						if (wSet.contains(let)) {
							if (!elim.contains(let)) 
								pos.add(let);
						}
						else {
							pos.remove(let);
							elim.add(let);
						}
				} else //type == '.'
				{
					for (char let = 'a'; let <= 'z'; let++)
					{
						if (wSet.contains(let)) {
							elim.add(let);
							pos.remove(let);
						}
					}
				}
			}
			if (pos.size() == 1 && min == (int)1e9)
			{
				min = shock + 1;
			}
		}
		if (min == (int)1e9)
			out.println(0);
		else
			out.println(shock - min);		
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
