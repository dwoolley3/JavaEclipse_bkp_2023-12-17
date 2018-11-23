package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Lyft_Level5_2018_FR_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Lyft_Level5_2018_FR_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	@SuppressWarnings("unused")
	void solve()
	{
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] vert = new int[n+1];
		for (int i = 0; i < n; i++) 
			vert[i] = in.nextInt();
		vert[n] = 1_000_000_000;
		
		Arrays.sort(vert);
		
		int[] hor = new int[m];
		int col1, col2, hrow;
		for (int i = 0; i < m; i++) {
			col1 = in.nextInt();
			hor[i] = in.nextInt();
			hrow = in.nextInt();
			if (col1 > 1) {
				hor[i] = 0;
			}
		}
		Arrays.sort(hor);
		
		int minRemove = m;		
		
		int vertInd = 0, horInd = m;
		for (vertInd = 0; vertInd <= n; vertInd++) {
			while (horInd > 0 && hor[m - horInd] < vert[vertInd]) {
				horInd--;
			}
			int removeHor = horInd;
			int removeVert = vertInd;
			minRemove = Math.min(minRemove, removeHor + removeVert);
		}
		
		out.println(minRemove);		
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
