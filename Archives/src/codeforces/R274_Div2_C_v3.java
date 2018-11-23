package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

class Pair implements Comparable<Pair> {
	int a, b;
	
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
    public int compareTo(Pair pair) {
        int c = Integer.compare(this.a, pair.a);
        if (c != 0) {
            return c;
        }
        return Integer.compare(this.b, pair.b);
        
    	//Alternatively
//        if (this.a != pair.a)
//        	return this.a - pair.a;
//        return this.b - pair.b;
    }
}

public class R274_Div2_C_v3
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R274_Div2_C_v3().run();
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

		Pair[] c = new Pair[n];
		for (int i = 0; i < n; i++) 
		{		
			c[i] = new Pair(in.nextInt(), in.nextInt() );
		}
		Arrays.sort(c);
		//Alternate
        Arrays.sort(c, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.a == o2.a)
                    return o1.b - o2.b;
                return o1.a - o2.a;
            }
        });
		
		int day = c[0].b;
		for (int i = 1; i < n; i++)
		{
			if (c[i].b >= day)
				day = c[i].b;
			else
				day = c[i].a;
		}
		
		out.println(day);		
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
