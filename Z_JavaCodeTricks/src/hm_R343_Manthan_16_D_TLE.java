import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class hm_R343_Manthan_16_D_TLE
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new hm_R343_Manthan_16_D_TLE().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//TLE on Testcase #59
	
	void solve()
	{
		int n = in.nextInt();
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
		}
		int maxCnt = 0, cnt, k;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
			{
				if (i == j) continue;

				cnt = 2;
				int cur = a[i] + a[j];
				int prev = a[j];
				
				ArrayList<Integer> al = new ArrayList<>();
				hm.put(a[i], hm.get(a[i])-1);
				hm.put(a[j], hm.get(a[j])-1);
				al.add(a[i]); al.add(a[j]);
				int zeroCnt = 0;
				
				k = 0;
				boolean ok = true;
				while (k < n && ok)
				{
					if (k != i && k != j)
					{
						int x = hm.getOrDefault(cur, 0);
						if (x > 0)
						{
							cnt++;
							hm.put(cur,x-1);
							if (cur == 0) 
								zeroCnt++;
							else 
								al.add(cur);
							int prevCur = cur;							
							cur += prev;
							prev = prevCur;
						}
						else ok = false;
					}
					k++;
				}
				maxCnt = Math.max(maxCnt,  cnt);
				//Restore hm
				if (zeroCnt > 0)
					hm.put(0,hm.get(0)+zeroCnt);	
				for (int y : al)
					hm.put(y,hm.get(y)+1);				
			}
		
		out.println(maxCnt);		
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
