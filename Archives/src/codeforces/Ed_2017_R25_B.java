package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Ed_2017_R25_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Ed_2017_R25_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	static String[] s;
	
	void solve()
	{

		s = new String[10];
		for (int i = 0; i < 10; i++)
			s[i] = in.next();
		
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				if (s[i].charAt(j) == '.')
				{
					if (checkRow(i,j) || checkCol(i,j) || checkDiag(i,j)) 
					{
						out.println("YES");
						return;
					}
				}
		
		out.println("NO");
	}
	
	private boolean checkRow(int i, int j)
	{
		for (int colStart = j-4; colStart <= j; colStart++)
		{
			int colEnd = colStart + 4;
			if (colStart >= 0 && colEnd < 10)
			{
				int cnt = 0;
				for (int k = colStart; k <= colEnd; k++)
					if (s[i].charAt(k) == 'X') cnt++;
				if (cnt == 4) return true;
			}
		}
		return false;
	}
	
	private boolean checkCol(int i, int j)
	{
		for (int rowStart = i-4; rowStart <= i; rowStart++)
		{
			int rowEnd = rowStart + 4;
			if (rowStart >= 0 && rowEnd < 10)
			{
				int cnt = 0;
				for (int k = rowStart; k <= rowEnd; k++)
					if (s[k].charAt(j) == 'X') cnt++;
				if (cnt == 4) return true;
			}
		}
		return false;
	}
	
	private boolean checkDiag(int i, int j)
	{
		for (int start = -4; start <= 0; start++)
		{
			int rowStart = i + start, rowEnd = rowStart + 4;
			int colStart = j + start, colEnd = colStart + 4;
			if (rowStart >= 0 && rowEnd < 10 && colStart >= 0 && colEnd < 10)
			{
				int cnt = 0;
				for (int k = 0; k <= 4; k++)
					if (s[rowStart + k].charAt(colStart + k) == 'X') cnt++;
				if (cnt == 4) return true;
			}
		}
		
		for (int start = -4; start <= 0; start++)
		{
			int rowStart = i + start, rowEnd = rowStart + 4;
			int colStart = j - start, colEnd = colStart - 4;
			if (rowStart >= 0 && rowEnd < 10 && colStart < 10 && colEnd >= 0)
			{
				int cnt = 0;
				for (int k = 0; k <= 4; k++)
					if (s[rowStart + k].charAt(colStart - k) == 'X') cnt++;
				if (cnt == 4) return true;
			}
		}
		return false;
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
