package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R738_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R738_Div2_B().run();
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
		int t = in.nextInt();
		for (int T = 0; T < t; T++) {
			int n = in.nextInt();	
			char[] col = new char[2];
			col[0] = 'B'; col[1] = 'R';
			
			String s = in.next();
			int cntQ = 0; char ch;
			StringBuilder sb = new StringBuilder();
			char nonQ = ' ';
			for (int i = 0; i < n; i++) {
				ch = s.charAt(i);
				if (ch == '?') {
					cntQ++;
				} else {
					if (cntQ > 0) {
						sb.append(getString(cntQ, ch));
					}
					sb.append(ch);
					nonQ = ch;
					cntQ = 0;
				}
			}
			
			if (nonQ == ' ') {
				nonQ = 'B';
			} else {
				if (cntQ % 2 == 0) {
					// swap
					if (nonQ == 'B') nonQ = 'R'; else nonQ = 'B';
				}
			}
			if (cntQ > 0) {
				sb.append(getString(cntQ, nonQ));
			}
			
			out.println(sb.toString());
		}
		

	}
	private String getString(int len, char lastCh) {
		StringBuilder sb = new StringBuilder();
		char firstCh = lastCh;
		if (len % 2 == 1) {
			if (lastCh == 'R') {
				firstCh = 'B'; 
			} else if (lastCh == 'B') {
				firstCh = 'R';
			}
		}
		char secondCh = (firstCh == 'B') ? 'R' : 'B';		
		for (int i = 0; i < len; i++) {
			if (i%2 == 0) sb.append(firstCh); else sb.append(secondCh);
		}
		return sb.toString();			
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
