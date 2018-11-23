package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Lyft_Level5_2018_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Lyft_Level5_2018_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	int[] a;
	int[] b;
	int n;
	
	void solve()
	{
		n = in.nextInt();
		
		a = new int[n+1];
		b = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
			b[a[i]] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> al = getPossible(i);
			
			if (al.size() == 0)			
				sb.append("B");
			else {
				int count0 = 0;;
				for (int j = 0; j < al.size(); j++) {
					ArrayList<Integer> al2 = getPossible(al.get(j));
					if (al2.size() == 0) count0++;
				}
				if (count0 == 0)
					sb.append("B");
				else
					sb.append("A");
			}
		}
		
		out.println(sb);		
	}
	
	ArrayList<Integer> getPossible(int i) {
		ArrayList<Integer> al = new ArrayList<>();
		int ind = i;
		ind -= a[i];
		while (ind > 0) {
			if (a[ind] > a[i]) al.add(ind);
			ind -= a[i];
		}
		ind = i;
		ind += a[i];
		while (ind <= n) {
			if (a[ind] > a[i]) al.add(ind);
			ind += a[i];
		}
		
		return al;
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
