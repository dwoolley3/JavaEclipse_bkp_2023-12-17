package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CoderStrike_2014_R2_B //Name: Spke Chatting
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CoderStrike_2014_R2_B().run();
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
		int n = in.nextInt(); //num of employees
		int m = in.nextInt(); //num of chats
		int k = in.nextInt(); //num of events in log
		
		int[][] a = new int[n+1][m+1];
		int[] e = new int[n+1];
		for (int i = 1; i <= n; i++) 
			for (int j = 1; j <= m; j++)
				a[i][j] = in.nextInt();
		
		int x=0,y=0;
		int[] mes = new int[m+1];
		int[] emp = new int[n+1];
		
		for (int i = 0; i < k; i++)
		{
			//employee xi sent 1 message to chat num yi
			x = in.nextInt();  
			y = in.nextInt();
			emp[x]++;
			mes[y]++;
			//for (int j = 1; j <= n; j++)
			//	if (j != x && a[j][y] == 1) e[j]++;
		}
				
		for (int i = 1; i <= n; i++) 
		{
			for (int j = 1; j <= m; j++)
				e[i] += a[i][j] * mes[j];
			e[i] -= emp[i];
		}
		
		for (int i = 1; i <= n; i++) 
			out.print(e[i] + " ");
		out.println();
		
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
