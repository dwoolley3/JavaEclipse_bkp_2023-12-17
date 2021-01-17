package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2020_R1A_Solution_A_Pattern_Matching_3rd
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2020_R1A_Solution_A_Pattern_Matching_3rd().run();
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

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			String[] ls = new String[n];
			String[] rs = new String[n];
			
			String[] s = new String[n];
			String mid = "", mid2 = "";
			for (int i = 0; i < n; i++) {
				s[i] = in.next();
				s[i] = removeDouble(s[i]);
				mid = getMiddle(s[i]);
				mid2 += mid;
				//System.out.println(s[i]);
				//System.out.println(mid);
				int ind = s[i].indexOf('*');
				ls[i] = s[i].substring(0, ind);
				ind = s[i].lastIndexOf('*');
				rs[i] = s[i].substring(ind+1);
			}
			
			String left = ls[0], right = rs[0];
			boolean ok = true;
			for (int i = 1; i < n && ok; i++) {
				if (ls[i].length() <= left.length()) {
					ok = left.startsWith(ls[i]);
				} else {
					ok = ls[i].startsWith(left);
					left = ls[i];
				}
			}
			
			for (int i = 1; i < n && ok; i++) {
				if (rs[i].length() <= right.length()) {
					ok = right.endsWith(rs[i]);
				} else {
					ok = rs[i].endsWith(right);		
					right = rs[i];
				}
			}
			
			String ans = ok ? (left + mid2 + right) : "*";
			
			out.println("Case #" + tc + ": " + ans);
		}
	}

	public String removeDouble(String s) {
		char c = s.charAt(0);
		StringBuilder sb = new StringBuilder(c+"");
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '*' && c == '*') {
				
			} else {
				sb.append(s.charAt(i));
			}
			c = s.charAt(i);
		}
		return sb.toString();
	}
	
	public String getMiddle(String s) {
		int n = s.length();
		boolean start = false;
		String mid = "", word = "";
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '*' && !start) {
				start = true;
			}
			else if (start) {
				if (s.charAt(i) == '*') {
					mid += word;
					word = "";
				} else {
					word += s.charAt(i);
				}
			}
		}
		return mid;
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
