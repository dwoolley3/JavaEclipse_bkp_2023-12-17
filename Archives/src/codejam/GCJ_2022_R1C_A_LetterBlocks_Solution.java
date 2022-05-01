package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2022_R1C_A_LetterBlocks_Solution
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2022_R1C_A_LetterBlocks_Solution().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
		long time = System.currentTimeMillis();
		System.err.printf("Time solved in %d ms\n", System.currentTimeMillis() - time);
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			
			ArrayList<String> s = new ArrayList<>();
			HashMap<Character, String> hm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String st = in.next();
				
				if (isContig(st)) {
					char c = st.charAt(0);
					String stringInHash = hm.containsKey(c) ? hm.get(c) : "";
					hm.put(c, stringInHash + st);
				} else {
					s.add(st);
				}
			}			
			for (int j = 0; j < s.size(); j++) {
				String st = s.get(j); 
				char first = st.charAt(0);
				char last = st.charAt(st.length() - 1);
				if (hm.containsKey(first)) {
					s.set(j, hm.get(first) + st);
					hm.remove(first);
				} else if (hm.containsKey(last)) {
					s.set(j, st + hm.get(last));
					hm.remove(last);
				}				
			}
			String ans2 = "";
			for (char c = 'A'; c <= 'Z'; c++) {
				if (hm.containsKey(c)) {
					ans2 += hm.get(c);
				}
			}
			//ans = contig.size() + " " + s.size();

			String ans = "";
			if (s.size() > 0) {
				ans = s.get(0);
				s.remove(0);
			}
			boolean imp = false;
			while (!imp && s.size() > 0) {
				imp = true;
				for (int j = 0; j < s.size(); j++) {
					String st = s.get(j); 
					char first = st.charAt(0);
					char last = st.charAt(st.length() - 1);
					if (first == ans.charAt(ans.length() - 1)) {
						ans += st;
						imp = false;
						s.remove(j);
						j--;
					} else if (last == ans.charAt(0)) {
						ans = st + ans;
						imp = false;
						s.remove(j);
						j--;
					}
				}
			}
			if (!imp) {
				ans += ans2;
				HashSet<Character> hs = new HashSet<>();
				for (int i = 0; i < ans.length() && !imp; i++) {
					char c = ans.charAt(i);
					if (i == 0 || (c != ans.charAt(i-1))) {
						if (hs.contains(c)) {
							imp = true;
						}
						else {
							hs.add(c);
						}
					}
				}
			}
			if (imp) {
				ans = "IMPOSSIBLE";
			}	
			
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	private boolean isContig(String s) {
		boolean contig = true;
		char first = s.charAt(0);
		for (int i = 1; i < s.length() && contig; i++) {
			if (first != s.charAt(i)) contig = false;
		}
		return contig;
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
