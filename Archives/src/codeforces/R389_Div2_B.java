package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R389_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R389_Div2_B().run();
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
		String t = in.next();
		int n = s.length();
		
		HashMap<Character,Character> hm = new HashMap<>(); 
		
		boolean ok = true;
		int swap = 0;
		for (int i = 0; i < n && ok; i++)
		{
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if (hm.containsKey(cs))
			{
				if (hm.get(cs) != ct) ok = false;
			}
			else if (hm.containsKey(ct))
			{ 
				if (hm.get(ct) != cs)				
					ok = false;
			}
			else 
			{
				hm.put(cs, ct);
				hm.put(ct, cs);
				if (cs != ct)
					swap++;
			}
		}
		
		if (ok)
		{
			out.println(swap);
			ArrayList<Character> displayed = new ArrayList<Character>();
			for (Map.Entry<Character,Character> ent : hm.entrySet())  
				if (ent.getKey() != ent.getValue())
				{
					char c1 = ent.getKey();
					char c2 = ent.getValue();
					if (displayed.contains(c1) || displayed.contains(c2)) continue;				
					out.println(c1 + " " + c2);
					displayed.add(c1);
					displayed.add(c2);
				}
		}
		else
			out.println(-1);

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
