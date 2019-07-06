package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R535_Div3_E1
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R535_Div3_E1().run();
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
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] a = new int[n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			max = Math.max(max,a[i]);
			min = Math.min(min,a[i]);
		}
		int dif = max - min;
		
		int[] l = new int[m];
		int[] r = new int[m];
		for (int i = 0; i < m; i++) {
			l[i] = in.nextInt();
			r[i] = in.nextInt();
		}
		
		int maxDif = 0;
		ArrayList<Integer> alBest = new ArrayList<>();
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				int sub = 0;
				ArrayList<Integer> al = new ArrayList<>();
				for (int k = 0; k < m; k++) {
					if (a[i] < a[j]) {
						if (l[k] <= i+1 && i+1 <= r[k] 
								&& (j+1 < l[k] || r[k] < j+1)) {
							sub++;						
							al.add(k+1);
						}
					} else if (a[i] > a[j]) {
						if (l[k] <= j+1 && j+1 <= r[k] 
								&& (i+1 < l[k] || r[k] < i+1)) {
							sub++;	
							al.add(k+1);
						}
					}					
				}
				dif = Math.abs(a[i] - a[j]) + sub;
				if (dif > maxDif) {
					maxDif = dif;
					alBest.clear();
					for (int k = 0; k < al.size(); k++)
						alBest.add(al.get(k));
				}
			}
		}
		
		out.println(maxDif);	
		out.println(alBest.size());
		for (int b : alBest)
			out.print(b + " ");
		
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
