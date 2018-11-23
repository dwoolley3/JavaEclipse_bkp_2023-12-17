package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2016_03_LT_C_ARRAYSUM
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2016_03_LT_C_ARRAYSUM().run();
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
        //int T = in.nextInt();
        //for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();	
			int m = in.nextInt();
				
			int[] a = new int[n];
			for (int i = 0; i < n; i++) 
				a[i] = in.nextInt();
			
			int[] b = new int[m];
			for (int i = 0; i < m; i++) 
				b[i] = in.nextInt();
			
			int cnt = 0;
			int[] c = new int[m];	
			if (m == 1)
				cnt = n;
			else if (m == 2)
			{			
				for (int i1 = 0; i1 < n; i1++)
					for (int i2 = i1+1; i2 < n; i2++)
					{
						c[0] = b[0] + a[i1];
						c[1] = b[1] + a[i2];
						boolean ok = true;
						for (int j = 0; j < m-1; j++)
							if (c[j] > c[j+1]) ok = false;
						if (ok) cnt++;
					}				
			}
			else if (m == 3)
			{			
				for (int i1 = 0; i1 < n; i1++)
					for (int i2 = i1+1; i2 < n; i2++)
						for (int i3 = i2+1; i3 < n; i3++)
						{
							c[0] = b[0] + a[i1];
							c[1] = b[1] + a[i2];
							c[2] = b[2] + a[i3];
							boolean ok = true;
							for (int j = 0; j < m-1; j++)
								if (c[j] > c[j+1]) ok = false;
							if (ok) cnt++;
						}
			}
			else if (m == 4)
			{			
				for (int i1 = 0; i1 < n; i1++)
					for (int i2 = i1+1; i2 < n; i2++)
						for (int i3 = i2+1; i3 < n; i3++)
							for (int i4 = i3+1; i4 < n; i4++)
							{
								c[0] = b[0] + a[i1];
								c[1] = b[1] + a[i2];
								c[2] = b[2] + a[i3];
								c[3] = b[3] + a[i4];
								boolean ok = true;
								for (int j = 0; j < m-1; j++)
									if (c[j] > c[j+1]) ok = false;
								if (ok) cnt++;
							}			
			}
			else if (m == 5)
			{			
				for (int i1 = 0; i1 < n; i1++)
					for (int i2 = i1+1; i2 < n; i2++)
						for (int i3 = i2+1; i3 < n; i3++)
							for (int i4 = i3+1; i4 < n; i4++)
								for (int i5 = i4+1; i5 < n; i5++)
								{
									c[0] = b[0] + a[i1];
									c[1] = b[1] + a[i2];
									c[2] = b[2] + a[i3];
									c[3] = b[3] + a[i4];
									c[4] = b[4] + a[i5];
									boolean ok = true;
									for (int j = 0; j < m-1; j++)
										if (c[j] > c[j+1]) ok = false;
									if (ok) cnt++;
								}		
			}
			out.println(cnt);
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
