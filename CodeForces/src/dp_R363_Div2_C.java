import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class dp_R363_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new dp_R363_Div2_C().run();
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
		
		int vac = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			if (a[i] == 0) vac++;
		}
		
		int cont = 0;
		for (int i = 0; i < n; i++)
			if (a[i] == 2)
			{
				cont++;
			}
			else
			{
				vac += cont/2;
				cont = 0;
			}
		
		cont = 0;
		for (int i = 0; i < n; i++)
			if (a[i] == 1)
			{
				cont++;
			}
			else
			{
				vac += cont/2;
				cont = 0;
			}
	
		
		int st = -1, en = -1;
		for (int i = 0; i < n; i++)
		{
			if (a[i] == 3)
			{
				if (st == -1)
				{
					st = i;
					en = i;
				}
				else
					en = i;
			}
			else 
			{
				if (st > -1)
				{
					int cnt = en - st + 1;
					if (st > 0 && en < n-1)
						if (a[st-1] != 0 && a[en+1] != 0)
						{
							if (a[st-1] != a[en+1] && cnt % 2 == 1) 
								vac++;
							else if (a[st-1] == a[en+1] && cnt % 2 == 0) 
								vac++;	
						}
					st = -1; en = -1;
				}
				
			}
		}
		if (st > -1)
		{
			int cnt = en - st + 1;
			if (st > 0 && en < n-1)
				if (a[st-1] != 0 && a[en+1] != 0)
				{
					if (a[st-1] != a[en+1] && cnt % 2 == 1) 
						vac++;
					else if (a[st-1] == a[en+1] && cnt % 2 == 0) 
						vac++;	
				}
		}
					
		out.println(vac);		
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
