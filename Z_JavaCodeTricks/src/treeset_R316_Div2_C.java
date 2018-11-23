import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class treeset_R316_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new treeset_R316_Div2_C().run();
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
		int m = in.nextInt();
		String s = in.next();
		char[] c = s.toCharArray();
		
		TreeSet<Integer> ts = new TreeSet<Integer>(); 
		ts.add(0); ts.add(n+1);
		int cnt = 0, total = 0;
		for (int i = 0; i < n; i++)
		{
			if (c[i]=='.') 
			{
				cnt++;
			}
			else
			{
				ts.add(i+1);
				if (cnt >= 1)
					total += (cnt - 1);
				cnt = 0;
			}
		}
		if (cnt >= 1)
			total += (cnt - 1);
		
		for (int i = 0; i < m; i++)
		{
			int a = in.nextInt();
			String str = in.next();			
			if (c[a-1] == '.' && !str.equals("."))
			{
				//Replace period with letter
				c[a-1] = str.charAt(0);
				int st = ts.floor(a-1);
				int en = ts.ceiling(a+1);
				cnt = en - st - 1;
				int tot2 = 0;
				if (cnt >= 1)
					tot2 -= (cnt - 1);
				cnt = a - st - 1;
				if (cnt >= 1)
					tot2 += (cnt - 1);
				cnt = en - a - 1;
				if (cnt >= 1)
					tot2 += (cnt - 1);
				total += tot2;
				ts.add(a);
			}
			else if (c[a-1] != '.' && str.equals("."))
			{
				//Replace letter with period
				c[a-1] = '.';
				int st = ts.floor(a-1);
				int en = ts.ceiling(a+1);
				cnt = en - st - 1;
				int tot2 = 0;
				if (cnt >= 1)
					tot2 += (cnt - 1);
				cnt = a - st - 1;
				if (cnt >= 1)
					tot2 -= (cnt - 1);
				cnt = en - a- 1;
				if (cnt >= 1)
					tot2 -= (cnt - 1);
				total += tot2;
				ts.remove(a);				
			}
			out.println(total);
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
