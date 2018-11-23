package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2016_R1_C
{	
	FastReader in;
	PrintWriter out;
	final String PROBLEM_NAME = "C_ex";
	//final String PROBLEM_NAME = "C";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2016_R1_C().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() throws IOException  {
		in = new FastReader(new File("src/" + PROBLEM_NAME + "_in.txt"));
		out = new PrintWriter(new File("src/" + PROBLEM_NAME + "_out.txt"));

		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			
			int[] c = new int[n];
			long sumC = 0;
			for (int i = 0; i < n; i++) 
			{
				c[i] = in.nextInt();
				sumC += c[i];
			}
			
			long firstL = a;
			long firstR = (a / sumC) * sumC; 
			if (a % sumC > 0) firstR += sumC;
			if (firstR >  b)
			{
				firstR = b;
			}
			
			long second = (b - firstR) / sumC;
			long secondL = firstR;
			long secondR = secondL + second * sumC;
			long lastL = secondR;
			long lastR = b;
			long range = b - a;
			
			System.out.println(firstL + " " + firstR 
				+ " " + secondL + " " + secondR + " " + lastL + " " + lastR);
			

			double aveMiddle = 0;
			double[] aveMid = new double[n];
			for (int i = 0; i < n; i++)
			{
				aveMid[i] += 1.0 * c[i] / sumC * (c[i] + 0) / 2;
				aveMiddle += aveMid[i];
			}
			
			long maxL = firstL % sumC;
			if (maxL == 0) maxL = sumC;
			long maxR = firstR % sumC;			
			if (maxR == 0) maxR = sumC;
			
			long rem = sumC, whole = 0;
			double aveFirst = 0;
			long start = firstL / sumC * sumC;
			long value = start;
			for (int i = 0; i < n; i++)
				if (value + c[i] <= firstL)				
					value += c[i];
				else if (value < firstL)
				{
					long x = Math.min(c[i], firstR);
					rem = value + x - firstL;
					aveFirst += 1.0 * rem * (x - rem +x) / 2;
					value +=x;
					whole += rem;
				}			
				else if (value <= firstR)
				{
					aveFirst += aveMid[i];
					whole += c[i];
				}
			if (whole > 0)
				aveFirst /= whole;
				
			
			double aveLast = 0; //1.0 * (maxL + maxR) / 2;
			value = lastL;
			for (int i = 0; i < n; i++)
				if (value + c[i] <= lastR)	
				{
					aveLast += aveMid[i];
					whole += c[i];
					value += c[i];
				}
				else if (value < lastR)
				{
					rem = lastR - value;
					aveLast += 1.0 * rem * (rem + 0) / 2;
					whole += rem;
				}			

			if (whole > 0)
				aveLast /= whole;

			
			//double ave = 1.0 * (firstR - firstL) / range * (maxL + maxR) / 2;
			double ave = 0.0;
			ave += 1.0 * (firstR - firstL) / range * aveFirst;
			//ave += 1.0* (secondR - secondL) / range * (0 + sumC) / 2;
			ave += 1.0 * (secondR - secondL) / range * aveMiddle;
			maxL = lastL % sumC;
			if (maxL == 0) maxL = sumC;
			maxR = lastR % sumC;			
			if (maxR == 0) maxR = sumC;
			ave += 1.0 * (lastR - lastL) / range * aveLast;
			
			double ans = ave;
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
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
