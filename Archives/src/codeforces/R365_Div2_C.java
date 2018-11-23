package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R365_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R365_Div2_C().run();
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
		
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
				
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			ArrayList<Integer> al = new ArrayList<Integer>();
			if (hm.containsKey(a[i]))
				al = hm.get(a[i]);
			al.add(i+1);
			hm.put(a[i], al);
		}
		
		int m = in.nextInt();
		for (int i = 0; i < m; i++)
		{
			int ans = -1;
			int l = in.nextInt();
			int r = in.nextInt();
			for (Map.Entry<Integer,ArrayList<Integer>> ent : hm.entrySet())
			{
				int key = ent.getKey();
				ArrayList<Integer> al = ent.getValue();
				int x = binsearch(al,l);
				int y = binsearch(al,r);
				out.println(key + " " + x + " " + y);
				
				int dif = y - x + 1;
				if (x > -1 && y > -1 && dif % 2 == 0)
				{
					if (ans == -1)
						ans = key;
					else
						ans ^= key;
				}
			}			
			
			out.println(ans);
		}	
	}
	
	//Need to implement Array.binarySearch(a, findI) on an ArrayList.
	private int binsearch(ArrayList<Integer> al, int goal)
	{
		int n = al.size();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = al.get(i);
		
		int pos = Arrays.binarySearch(a, goal);
		return pos;
		
//		int lo = 0, hi = al.size() - 1, mid;
//
//        while (lo < hi)
//        {
//            mid = lo + (hi - lo) / 2;
//            if (al.get(mid) < goal)
//            	lo = mid + 1; 
//            else
//                hi = mid;                           
//        }
//		
//		return lo;
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
