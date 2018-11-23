package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R290_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R290_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	boolean[][] g;
	boolean[][] used;
	ArrayDeque<Character> stack;
	boolean cycle;
	void solve()
	{
		int n = in.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < n; i++) 
			s[i] = in.next();
		
		//Create a graph of which letters must precede another letter
		g = new boolean[26][26];
		stack = new ArrayDeque<Character>();
		
		boolean good = true;
		for (int i = 0; i < n; i++)
			for (int j = i+1; j < n; j++)
			{
				if (s[i].startsWith(s[j])) good = false;
				int minLen = Math.min(s[i].length(), s[j].length());			
				for (int k = 0; k < minLen; k++)
				{
					char from = s[i].charAt(k);
					char to = s[j].charAt(k);				
					if (from != to)
					{
						g[from-'a'][to-'a'] = true;
						break;
					}
				}
			}
		
		if (!good) 
		{
			out.println("Impossible");
			return;
		}
		
		//My logic is just printing out the alphabet a-z. Needs work.		
//		used = new boolean[26][26];
//		for (int i = 0; i < 26; i++)
//			for (int j = 0; j < 26; j++)
//			{
//				if (g[i][j] && !used[i][j])
//				{
//					cycle = false;		
//					dfs(j);
//				}
//				if (cycle)
//				{
//					out.println("Impossible");
//					return;
//				}				
//			}
//		
//		boolean[] let = new boolean[26];
//		for (char c : stack)
//		{
//			let[c-'a'] = true;
//			out.print(c);
//		}
//		
//		for (char c = 'a'; c <= 'z'; c++)
//			if (!let[c-'a']) out.print(c);
//		out.println();
					
		//The following needs to be re-worked from mkirsche
		for(int k = 0; k<26; k++)
	        for(int i = 0; i<26; i++)
	            for(int j = 0; j<26; j++)
	                g[i][j] |= g[i][k] && g[k][j];
	    for(int i = 0; i < 26; i++)
	    	good &= !g[i][i]; 
	    if(!good) 
	    	out.println("Impossible");
	    else
	    {
	        int[] ds = new int[26];
	        for(int i = 0; i<26; i++)
	            for(int j = 0; j<26; j++)
	                if(g[i][j]) ds[j]++;
	        Queue<Integer> q = new LinkedList<Integer>();
	        for(int i = 0; i<26; i++)
	        {
	            if(ds[i] == 0) q.add(i);
	        }
	        while(!q.isEmpty())
	        {
	            int at = q.poll();
	            out.print((char)('a'+at));
	            for(int i = 0; i<26; i++)
	            {
	                if(g[at][i])
	                {
	                    ds[i]--;
	                    if(ds[i] == 0) q.add(i);
	                }
	            }
	        }
	    }
	}
	
	@SuppressWarnings({ "unused", "unlikely-arg-type" })
	private void dfs(int to)
	{
		stack.add((char)('a' + to));
		for (int i = 0; i < 26; i++)
		{
			if (g[to][i])
			{
				if (cycle) return;			
				if (!used[to][i])
				{				
					used[to][i] = true;
					dfs(i);
				}
				else if (stack.contains(i))
				{
					cycle = true;
				}
			}
		}
		stack.remove((char)('a' + to));
		return;
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
