package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class MemSQL_R2_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new MemSQL_R2_Div2_C().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	public class Contestant {
		long s, a, b;
		int dif;
		public Contestant(long S, long A, long B, int Dif) {
			s = S; a = A; b = B; dif = Dif;
		}
	}
	
	void solve()
	{
		int n = in.nextInt(); //Contestants
		int slicesPerPie = in.nextInt();
		
		Contestant[] c = new Contestant[n];
		for (int i = 0; i < n; i++)	{
			long s = in.nextInt();
			long a = in.nextInt();
			long b = in.nextInt();
			int dif = (int)(a-b);
			c[i] = new Contestant(s,a,b,dif);
		}
		Arrays.sort(c, (o1,o2) -> o2.dif - o1.dif);  //Descending order
		
		long maxhap = 0, hap = 0, sl0 = 0;
		long hap2 = 0, sl2 = 0, hapOnTy1 = 0, hapOnTy2 = 0;
		long sl = 0;
		for (int i = 0; i < n; i++)
		{
			if (c[i].dif > 0)
			{
				hap += c[i].s * c[i].a;
				hapOnTy2 += c[i].s * c[i].b;
				sl += c[i].s;
				if (sl / slicesPerPie >= 1)
				{
					long extra = sl % slicesPerPie;
					hap -= extra * c[i].a;
					maxhap += hap;
					hap = extra * c[i].a;
					hapOnTy2 = extra * c[i].b;
					sl = extra;
				}
			}
			else if (c[i].dif == 0) 
			{
				maxhap += c[i].s * c[i].a;
				sl0 += c[i].s;
			}
			else break;
		}
		
		for (int i = n-1; i >= 0; i--)
		{
			if (c[i].dif < 0)
			{
				hap2 += c[i].s * c[i].b;
				hapOnTy1 += c[i].s * c[i].a;
				sl2 += c[i].s;
				if (sl2 / slicesPerPie >= 1)
				{
					long extra = sl2 % slicesPerPie;
					hap2 -= extra * c[i].b;
					maxhap += hap2;
					hap2 = extra * c[i].b;
					hapOnTy1 = extra * c[i].a;
					sl2 = extra;
				}
			}
			else break;
		}
		
		long slices = sl + sl2 + sl0;
		if (slices > slicesPerPie)
			maxhap += hap + hap2;
		else
		{
			if (hap + hapOnTy1 > hap2 + hapOnTy2)
				maxhap += hap + hapOnTy1;
			else
				maxhap += hap2 + hapOnTy2;
		}		
		
		out.println(maxhap);		
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
