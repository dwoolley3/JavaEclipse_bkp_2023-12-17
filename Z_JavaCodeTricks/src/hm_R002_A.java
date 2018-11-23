import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class hm_R002_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new hm_R002_A().run();
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
		
		String[] name = new String[n];
		int[] a = new int[n];
		int max = Integer.MIN_VALUE;
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for (int i = 0; i < n; i++)
		{
			name[i] = in.next();
			a[i] = in.nextInt();
			
			if (hm.containsKey(name[i]))
				hm.put(name[i], hm.get(name[i]) + a[i]);
			else
				hm.put(name[i], a[i]);	
		}
		
		for (int i = 0; i < n; i++)
			max = Collections.max(hm.values());
			//max = Math.max(max, hm.get(name[i]));	
		
		HashMap<String,Integer> hm2 = new HashMap<String,Integer>();
		String ans = "";
		for (int i = 0; i < n; i++)
		{
			if (hm.get(name[i]) != max) continue;
			if (hm2.containsKey(name[i]))
				hm2.put(name[i], hm2.get(name[i]) + a[i]);
			else
				hm2.put(name[i], a[i]);
			if (hm2.get(name[i]) >= max)
			{
				ans = name[i];
				break;
			}
		}
		out.println(ans);		
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
