package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2017_01_LT_C_IMPROVE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2017_01_LT_C_IMPROVE().run();
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
			
			int[] a = new int[n+1];
			for (int i = 1; i <= n; i++) 
				a[i] = in.nextInt();
			
			boolean swap = true;
			int left = 1, right = n;
			ArrayList<Integer> al = new ArrayList<>();
			while(swap)
			{
				swap = false;
				for (int i = left; i < right; i++)
					if (a[i] > a[i+1] && i != a[i] && i+1 != a[i+1])
					{
						if (a[i+1] == i && left == i && a[i] == i+1)
						{
							int temp = a[i]; a[i] = a[i+1]; a[i+1] = temp;
							al.add(i);
							left+=2;
							i++;
						}
						else if (a[i] == i+1 && right == i+1 && a[i+1] == i)
						{
							int temp = a[i]; a[i] = a[i+1]; a[i+1] = temp;
							al.add(i);
							right-=2;
							i++;
						}
						else
						{
							if (a[i+1] == i && left != i) continue;
							if (a[i] == i+1 && right != i+1) continue;
							int temp = a[i]; a[i] = a[i+1]; a[i+1] = temp;
							al.add(i);
							swap = true;
							if (a[i] == i && i == left)
								left++;
							if (a[i+1] == i+1 && i+1 == right) 
								right--;
						}
					}
			}
			
			out.println(al.size());	
			for (int i = 0; i < al.size() -1; i++)
				out.print(al.get(i) + " ");
			out.println(al.get(al.size()-1));
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
