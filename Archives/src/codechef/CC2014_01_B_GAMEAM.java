package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
//Name: Subtraction Game //**** Wrong Answer
class CC2014_01_B_GAMEAM 
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_01_B_GAMEAM().run();
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
			//int[] a = new int[n];
			int x, y, min, max, cnt=0, opt = 0, opt1=0, opt2=0, w=0, l=0; // either=0;
			for (int i = 0; i < n; i++)
			{
				x = in.nextInt();
				y = in.nextInt();
				min = Math.min(x, y);
				max = Math.max(x, y);
				cnt = 0;
				while (max % min > 0)
				{
					cnt++;
					if ((double)max / min > 2.0) 
						opt = cnt;
					int temp = min;
					min = max % min;
					max = temp;
				}
				cnt++;
				if ((double)max / min > 2.0) 
					opt = cnt;				
				
				//out.println(cnt + " opt=" + opt);
				
				if (cnt%2 == 1 && opt == 0) // || (opt % 2 == 1))
					w++;
				else if (cnt%2 == 0 && opt == 0) // || (opt % 2 == 0 && opt > 0))
					l++;
				else if (opt % 2 == 1)
					opt1++;
				else
					opt2++;
					//either++;
				out.println(w + " " + l + " " + opt1 + " " + opt2);			
			}
			
//			int mw = Math.min(w, l);
//			w -= mw;
//			l -= mw;
//			w += (l/2);
//			l = l % 2;
//			mw = Math.min(w, l);
//			w -= mw;
//			l -= mw;
			if (Math.abs(w-l) % 2 == 0 && opt1 >= opt2) 
			//if (w + opt1 >= l + opt2)
				out.println("YES");
			else				
				out.println("NO");	
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

