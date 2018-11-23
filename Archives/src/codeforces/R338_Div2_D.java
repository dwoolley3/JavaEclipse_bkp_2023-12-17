package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R338_Div2_D
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R338_Div2_D().run();
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
		int MOD = 1_000_000_007;
		ArrayList<Integer> al = new ArrayList<>();
		int[] b = new int[200_001];
		for (int i = 0; i < n; i++)
		{
			int x = in.nextInt();
			b[x]++;
			if (!al.contains(x)) al.add(x);
		}
		if (al.size() == 1)
		{
			int x = b[al.get(0)];
			int num = x * (x+1) / 2;
			long prod = 1;
			for (int i = 0; i < num; i++)
			{
				prod *= al.get(0);
				prod %= MOD;
			}
			out.println(prod);
			return;
		}
		Collections.sort(al);
		
		long p = 1;
		for (int y : al)
		{
			for (int i = 1; i <= b[y]; i++)
				for (int z : al)
				{
					if (y == z) continue;
					int num = i * (b[z] + 1);
					for (int j = 0; j < num; j++)
					{
						p *= y;					
						p = p % MOD;
					}
				}
		}
		
		out.println(p);
		
//		for (int i)
//		long p = 1;
//		p = 4*3*5; //2^2 3^3
//		out.println(p);
//		long p2 = 1;
//		for (int i = 1; i <= p; i++)
//			if (p%i == 0)
//				p2 *= i;
//		
//		out.println(p + " " + p2);
//		int cnt2 = 0, cnt3 = 0, cnt5 = 0, cnt7 = 0;
//		while (p2%2==0) { cnt2++; p2 /= 2;}
//		while (p2%3==0) { cnt3++; p2 /= 3;}
//		while (p2%5==0) { cnt5++; p2 /= 5;}
//		while (p2%7==0) { cnt7++; p2 /= 7;}
//		out.println (cnt2 + " " + cnt3 + " " + cnt5 + " " + cnt7);
		
//		for (int i = 0; i < 10; i++)
//			p *= 2;
//		for (int i = 0; i < 8; i++)
//			p *= 3;
//		out.println(p);
//		
//		p = 1;
//		p = p*2*3*4*6*8*9*12*18*24*36*72;
//		out.println(p);
//		int cnt2 = 0, cnt3 = 0;
//		while (p%2==0) { cnt2++; p /= 2;}
//		while (p%3==0) { cnt3++; p /= 3;}
//		out.println (cnt2 + " " + cnt3);
//		
//		int n = in.nextInt();
//		int k = in.nextInt();
//		
//		int[] a = new int[n];
//		for (int i = 0; i < n; i++) 
//			a[i] = in.nextInt();
//		
//		String st = in.next();
//		
//		StringBuilder sb = new StringBuilder(st + k);
//		sb.append("\r\n");
//		
//		out.println(sb);		
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
