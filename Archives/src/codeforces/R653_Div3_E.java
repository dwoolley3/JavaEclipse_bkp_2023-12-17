package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R653_Div3_E
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R653_Div3_E().run();
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
		int k = in.nextInt();
		
		int ti, a, b;
		ArrayList<Integer> aLikes = new ArrayList<>();
		ArrayList<Integer> bLikes = new ArrayList<>();
		ArrayList<Integer> bothLikes = new ArrayList<>();
		int totalTime = 0;
		for (int i = 0; i < n; i++) {
			ti = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			totalTime += ti;
			if (a == 1 && b == 1) bothLikes.add(ti);
			else if (a == 1) aLikes.add(ti);
			else if (b == 1) bLikes.add(ti);
			else totalTime -= ti;
		}
		int nboth = bothLikes.size();
		int na = aLikes.size();
		int nb = bLikes.size();
		int aLikesNum = nboth + na;
		int bLikesNum = nboth + nb;

		if (aLikesNum < k || bLikesNum < k) {
			out.println(-1);
		} else {
			Collections.sort(bothLikes);
			Collections.sort(aLikes);
			Collections.sort(bLikes);
			
			while (nboth > 0 && (aLikesNum > k && na > 0) && (bLikesNum > k && nb > 0)) {
				int both = bothLikes.get(nboth - 1);
				a = aLikes.get(na - 1);
				b = bothLikes.get(nboth-1);
				if ( both > a + b) {
					totalTime -= both;
					bothLikes.remove(--nboth);					
				} else {
					totalTime -= (a + b);
					aLikes.remove(--na);
					bLikes.remove(--nb);					
				}
				aLikesNum--;
				bLikesNum--;
			}
			while (aLikesNum > k && na > 0) {
				a = aLikes.get(na - 1);
				totalTime -= a;
				aLikes.remove(--na);
				aLikesNum--;
			}
			while (bLikesNum > k && nb > 0) {
				b = bLikes.get(nb - 1);
				totalTime -= b;
				bLikes.remove(--nb);
				bLikesNum--;
			}			
			
			out.println(totalTime);
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
