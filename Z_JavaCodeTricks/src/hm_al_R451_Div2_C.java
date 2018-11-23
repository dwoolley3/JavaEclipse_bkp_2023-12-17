import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class hm_al_R451_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new hm_al_R451_Div2_C().run();
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
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			String nm = in.next();
			if (!hm.containsKey(nm)) 
			{
				ArrayList<String> al = new ArrayList<>();
				hm.put(nm, al);
			}
			ArrayList<String> al = hm.get(nm);
			
			int num = in.nextInt();
			for (int j = 0; j < num; j++)
			{
				String ph = in.next();
				boolean ok = true;
				for (int k = al.size()-1; k >= 0 && ok; k--)
				{					
					if (al.get(k).endsWith(ph)) 
						ok = false;
					else if (ph.endsWith(al.get(k)))
						al.remove(k);
				}
				if (ok) al.add(ph);				
			}
		}

		out.println(hm.size());
		for (String key : hm.keySet()) 
		{
			out.print(key + " ");
			ArrayList<String> al = hm.get(key);
			out.print(al.size());
			for (String st : al)
				out.print(" " + st);
			out.println();
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
