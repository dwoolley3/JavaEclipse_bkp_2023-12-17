package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R281_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R281_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public void p(Object ...o) {System.out.println(Arrays.deepToString(o));}
	
	void solve()
	{
		int n = in.nextInt();	
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		Arrays.sort(a);
		
		int m = in.nextInt();	
		int[] b = new int[m];
		for (int i = 0; i < m; i++) 
			b[i] = in.nextInt();
		Arrays.sort(b);
		
		int[] c = new int[n+m];
		int ni = 0, mi = 0, j = 0;
		while (ni < n || mi < m) {
			if (ni < n && mi < m)
				if (a[ni] <= b[mi])
					c[j++] = a[ni++];
				else
					c[j++] = b[mi++];
			else if (ni < n)
				c[j++] = a[ni++];
			else
				c[j++] = b[mi++];
		}
		
		ni = 0; mi = 0;
		int atot = n*3;
		int btot = m*3;
		int max = atot - btot;
		int anum = atot;
		int bnum = btot;
		
		for (int i = 0; i < n+m; i++) {
			while (ni < n && c[i] >= a[ni]) ni++;
			while (mi < m && c[i] >= b[mi]) mi++;
			
			atot = ni * 2 + (n - ni) * 3;
			btot = mi * 2 + (m - mi) * 3;
	
            if (atot - btot > max || (atot - btot == max && atot > anum))
            {
            	max = atot - btot;
            	anum = atot;
            	bnum = btot;          
            	//out.println(anum + " " + bnum + " " + max + " " + ni + " " + mi);
            }
		}

		out.println(anum + ":" + bnum);		
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
