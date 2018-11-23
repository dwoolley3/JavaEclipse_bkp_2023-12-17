package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R268_Div2_D_Failed_ST
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R268_Div2_D_Failed_ST().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	//Passed pretest but not system test:
	//6 15 13
	//10 5 7 8 3 6
	//Should be 1 1 1 1 1 1
	//but returns NO
	//Fails also on:
	//4 7 9
	//2 4 5 7
	//Should be 1 1 1 1
	//but is NO
	
	void solve()
	{
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		
		int ab = 0, start = 0;
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
				
		int[] p = new int[n];
		for (int i = 0; i < n; i++) 
		{
			p[i] = in.nextInt();
			hm.put(p[i], i);
		}
		int[] bit = new int[n];
		for (int i = 0; i < n; i++) 
		{
			if (p[i] < 0) continue; //placed already
			boolean good = false;		
								
			int num = a-p[i];
			if (num == p[i]) //reverse the order
			{
				ab = 1 - start;
				num = b-p[i];
				if (hm.containsKey(num)) 
				{
					int ind = hm.get(num);
					bit[i] = ab; bit[ind] = ab;
					hm.remove(p[i]); hm.remove(num);
					p[i] = -1; p[ind] = -1;
					good = true;
				}
				
				num = a-p[i];
				ab = 1 - ab;
				if (!good && hm.containsKey(num))
				{
					int ind = hm.get(num);
					bit[i] = ab; bit[ind] = ab;
					hm.remove(p[i]); hm.remove(num);
					p[i] = -1; p[ind] = -1;
					good = true;
				}
			}
			else
			{		
				ab = start;
				if (hm.containsKey(num)) 
				{
					int ind = hm.get(num);
					bit[i] = ab; bit[ind] = ab;
					hm.remove(p[i]); hm.remove(num);
					p[i] = -1; p[ind] = -1;
					good = true;
				}
				
				num = b-p[i];
				ab = 1 - ab;
				if (!good && hm.containsKey(num))
				{
					int ind = hm.get(num);
					bit[i] = ab; bit[ind] = ab;
					hm.remove(p[i]); hm.remove(num);
					p[i] = -1; p[ind] = -1;
					good = true;
				}
			}
			
			if (!good)
			{
				out.println("NO");
				return;
			}
		}
		
		out.println("YES");
		for (int i = 0; i < n; i++)
			out.print(bit[i] + " ");
	
		out.println();		
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
