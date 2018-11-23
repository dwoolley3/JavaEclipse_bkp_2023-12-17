package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R346_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R346_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Stud {
		String s;
		int r, sc;
		public Stud(String s, int r, int sc)
		{
			this.s = s;
			this.r = r;
			this.sc = sc;
		}
	}
	
	void solve()
	{
		int n = in.nextInt();
		@SuppressWarnings("unused")
		int m = in.nextInt();
		
		Stud[] stud = new Stud[n];
		
		for (int i=0;i<n;i++) 
		{
			String s = in.next();
			int r = in.nextInt();
			int sc = in.nextInt();
			stud[i] = new Stud(s,r,sc);
		}
		
       Arrays.sort(stud, new Comparator<Stud>() {
            @Override
            public int compare(Stud o1, Stud o2) {
                if(o1.r == o2.r)
                    return o2.sc - o1.sc;
                return o1.r - o2.r;
            }
        });
        
		int reg = 1, cnt = 0;
		String ans = "";
		for (int i = 0; i <= n; i++)
		{
			if (i == n || stud[i].r != reg)
			{
				out.println(ans);
				if (i < n)
				{
					reg = stud[i].r;
					cnt = 0;
				}
			}
			if (i < n)
			{
				cnt++;
				if (cnt == 1) ans = stud[i].s;
				else if (cnt == 2) ans += " " + stud[i].s;
				else if (cnt == 3 && stud[i].sc == stud[i-1].sc) ans = "?";
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
