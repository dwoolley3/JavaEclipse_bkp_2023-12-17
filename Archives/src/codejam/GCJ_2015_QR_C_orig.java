package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2015_QR_C_orig
{	
	FastReader in;
	PrintWriter out;
//	final String PROBLEM_NAME = "C-ex";
	final String PROBLEM_NAME = "C-small-attempt0";
//	final String PROBLEM_NAME = "C-small-attempt1";
//	final String PROBLEM_NAME = "C-large";
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2015_QR_C_orig().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + ".in")); //"_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + ".out")); //"_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int L = in.nextInt();
			long X = in.nextLong();
			
			String s = in.next();
			StringBuilder sb = new StringBuilder();			
			for (int i = 1; i <= X; i++)
				sb.append(s);
			
			String ans = "NO";
			
			String prodi = "1", prodj, prodk;
			int i = 0, j = 0, k = 0;
			while (i < X*L && !ans.equals("YES"))
			{
				for (; i < X*L; i++)
				{
					prodi = getProd(prodi, sb.charAt(i)+"");
					if (prodi.equals("i")) break;
				}
				i++;
				
				if (prodi.equals("i"))
				{
					prodj = "1";
					for (j = i;  j < X*L; j++)
					{
						prodj = getProd(prodj, sb.charAt(j)+"");
						if (prodj.equals("j")) break;
					}
					j++;
				
					if (prodj.equals("j"))
					{
						prodk = "1";
						for (k = j;  k < X*L; k++)
						{
							prodk = getProd(prodk, sb.charAt(k)+"");
						}
						
						if (prodk.equals("k"))
							ans = "YES";
					}
				}
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	String getProd(String a, String b)
	{
		int sign = 1;
		String prod = "";
		if (a.startsWith("-"))
		{
			sign *= -1;
			a = a.substring(1);
		}
		if (b.startsWith("-"))
		{
			sign *= -1;
			b = b.substring(1);
		}
		if (a.equals("i") && b.equals("j"))
			prod = "k";
		else if (a.equals("j") && b.equals("i"))
		{
			prod = "k";
			sign *= -1;
		}
		else if (a.equals("j") && b.equals("k"))
			prod = "i";
		else if (a.equals("k") && b.equals("j"))
		{
			prod = "i";
			sign *= -1;
		}
		else if (a.equals("k") && b.equals("i"))
			prod = "j";
		else if (a.equals("i") && b.equals("k"))
		{
			prod = "j";
			sign *= -1;
		}
		else if (a.equals(b))
		{
			prod = "1";
			sign *= -1;
		}
		else if (a.equals("1"))
			prod = b;
		else if (b.equals("1"))
			prod = a;
		
		if (sign == -1)
			prod = "-" + prod;
		
		return prod;
	}

	//-----------------------------------------------------

	
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
