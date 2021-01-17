package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R670_Div2_B_orig
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R670_Div2_B_orig().run();
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

			ArrayList<Integer> pos = new ArrayList<>();
			ArrayList<Integer> neg = new ArrayList<>();
			boolean zero = false;
			int a;
			for (int i = 0; i < n; i++) {
				a = in.nextInt();
				if (a < 0) neg.add(a);
				else if (a > 0) pos.add(a);
				else zero = true;
			}
			Collections.sort(pos);
			Collections.sort(neg);
			
			long ans = 0;
			int pn = pos.size();
			int nn = neg.size();
			if (pn + nn < 5) 
				ans = 0;
			else if (pn == 0)
			{
				if (zero) {
					ans = 0;
				} else {
					ans = 1;
					for (int i = 0; i < 5; i++) {				
						ans *= neg.get(nn-1 - i);
					}
				}
			}
			else if (pn + nn == 5) {
				if (zero && pn % 2 == 0) {
					ans = 0;
				} else {
					ans = 1;
					for (int x : pos) ans *= x;
					for (int x : neg) ans *= x;
				}
			} else {
				ans = pos.get(pn - 1);
				int pos2 = 0;
				if (pn >= 3) {
					pos2 = pos.get(pn-2) * pos.get(pn-3);
				}
				int neg2 = 0;					
				if (nn >= 2) {
					neg2 = neg.get(0) * neg.get(1);
				}
				if (pos2 >= neg2) {
					ans *= pos2;
					pos2 = 0;
					if (pn >= 5) {
						pos2 = pos.get(pn-4) * pos.get(pn-5);
					}
					if (pos2 >= neg2) {
						ans *= pos2;
					} else {
						ans *= neg2;
					}
					
				} else  { //pos2 < neg2
					ans *= neg2;
					neg2 = 0;
					if (nn >= 4) {
						neg2 = neg.get(2) * neg.get(3);
					}
					if (pos2 >= neg2) {
						ans *= pos2;
					} else {
						ans *= neg2;
					}
				}
			}

			
			out.println(ans);
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
