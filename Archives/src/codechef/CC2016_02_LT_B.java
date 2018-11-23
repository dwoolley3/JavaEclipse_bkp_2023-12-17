package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2016_02_LT_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2016_02_LT_B().run();
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
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
        {
			int n = in.nextInt();	
			int k = in.nextInt();
				
			String[] s = new String[n];
			for (int i = 0; i < n; i++) 
				s[i] = in.next();
			
			int max = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (s[i].charAt(j) == '.')
					{
						s[i] = s[i].substring(0, j) + 'X' + s[i].substring(j+1);
						//out.println(findMaxCol(s));	
						//out.println(findMaxRow(s));
						//out.println(findMaxDiag(s));
						//out.println();
						max = Math.max(max,findMaxCol(s));
						max = Math.max(max,findMaxRow(s));
						max = Math.max(max,findMaxDiag(s));
						s[i] = s[i].substring(0, j) + '.' + s[i].substring(j+1);
					}
			//out.println(max);
			out.println(max >= k ? "YES" : "NO");
        }		
	}
	
	int findMaxDiag(String[] s)
	{
		int n = s.length;	
		int max = -1;
		int st = -1, en = -1;		
		//Main Diagonal
		for (int i = 0; i < n; i++)
		for (int j = 0; j <= n; j++)
		{
			char c = (j + i < n && j < n ? s[j].charAt(j+i) : 'a');				
			if (c == 'X')
			{
				if (st == -1)
				{
					st = j;
					en = j;
				}
				else
					en = j;
			}
			else if (st > -1)
			{
				max = Math.max(max,  en - st);
				st = -1; en = -1;
			}
		}
		
		st = -1; en = -1;	
		for (int i = 0; i < n; i++)
		for (int j = 0; j <= n; j++)
		{
			char c = (j + i < n && j < n ? s[j+i].charAt(j) : 'a');				
			if (c == 'X')
			{
				if (st == -1)
				{
					st = j;
					en = j;
				}
				else
					en = j;
			}
			else if (st > -1)
			{
				max = Math.max(max,  en - st);
				st = -1; en = -1;
			}
		}
		
		//Other diagonal
		st = -1; en = -1;
		for (int i = 0; i < n; i++)
		for (int j = 0; j <= n; j++)
		{
			char c = (n-1-j < n && j + i < n ? s[n-1-j].charAt(j+i) : 'a');				
			if (c == 'X')
			{
				if (st == -1)
				{
					st = j;
					en = j;
				}
				else
					en = j;
			}
			else if (st > -1)
			{
				max = Math.max(max,  en - st);
				st = -1; en = -1;
			}
		}
		
		st = -1; en = -1;
		for (int i = 0; i < n; i++)
		for (int j = 0; j <= n; j++)
		{
			char c = (n-1-j >= 0 && j - i >= 0 ? s[n-1-j].charAt(j-i) : 'a');				
			if (c == 'X')
			{
				if (st == -1)
				{
					st = j;
					en = j;
				}
				else
					en = j;
			}
			else if (st > -1)
			{
				max = Math.max(max,  en - st);
				st = -1; en = -1;
			}
		}
		
		return max + 1;
	}
	
	
	int findMaxCol(String[] s)
	{
		int n = s.length;	
		int maxCol = -1;
		for (int i = 0; i < n; i++)	
		{
			int colSt = -1, colEn = -1;			
			for (int j = 0; j <= n; j++)
			{
				char c = (j < n ? s[j].charAt(i) : 'a');				
				if (c == 'X')
				{
					if (colSt == -1)
					{
						colSt = j;
						colEn = j;
					}
					else
						colEn = j;
				}
				else if (colSt > -1)
				{
					maxCol = Math.max(maxCol,  colEn - colSt);
					colSt = -1; colEn = -1;
				}
			}
		}
		return maxCol + 1;
	}
	
	int findMaxRow(String[] s)
	{
		int n = s.length;	
		int maxRow = -1;
		for (int i = 0; i < n; i++)	
		{
			int rowSt = -1, rowEn = -1;			
			for (int j = 0; j <= n; j++)
			{			
				char c = (j < n ? s[i].charAt(j) : 'a');
				if (c == 'X')
				{
					if (rowSt == -1)
					{
						rowSt = j;
						rowEn = j;
					}
					else
						rowEn = j;
				}
				else if (rowSt > -1)
				{
					maxRow = Math.max(maxRow,  rowEn - rowSt);
					rowSt = -1; rowEn = -1;
				}
			}
		}
		return maxRow + 1;
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
