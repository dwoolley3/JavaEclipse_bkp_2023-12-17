package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R306_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R306_Div2_C().run();
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
		String s = in.next();
		int n = s.length();
	
		int[] a = new int[n];
		int yes = -1;
		for (int i = 0; i < n; i++)
		{
			a[i] = s.charAt(i) - '0';
			if (a[i] == 8 || a[i] == 0)
				yes = a[i];
		}
		if (yes > -1)
		{
			out.println("YES");
			out.println(yes);
			return;
		}
		
		//If a number that is 3 digits or less is either divisible by 8 or not.
		//Adding digits to the beginning will always retain the same divisibility,
		//since 1000 is divisible by 8.
		for (int i = 0; i < n-1; i++)
			for (int j = i+1; j < n; j++)
			{
				int x = a[i] * 10 + a[j];
				if (x % 8 == 0) yes = x;
			
				for (int k = j+1; k < n && yes == -1; k++)
				{
					x = a[i] * 100 + a[j] * 10 + a[k];
					if (x % 8 == 0) yes = x;
				}
				
				if (yes > -1)
				{
					out.println("YES");
					out.println(yes);
					return;
				}
			}
		
		out.println("NO");	
		
//		//Alternate - clever
//		char[] input = in.next().toCharArray();
//		ArrayList<String> list8 = new ArrayList<>();
//		for (int i = 0; i * 8 < 1000; i++) {
//			list8.add(String.valueOf(i * 8));
//		}
//
//		for (String string : list8) {
//			int cur = string.length() - 1;
//			for (int i = input.length - 1; i >= 0; i--) {
//				if (string.charAt(cur) == input[i]) {
//					if (cur == 0) {
//						System.out.println("YES");
//						System.out.println(string);
//						return;
//					}
//					cur--;
//				}
//			}
//		}
//		out.println("NO");
		
//		//Alternate 2 - clever
//        for(String s1 : list8)
//        {
//          StringBuilder temp=new StringBuilder();
//          for(int i=0;i<s1.length();i++)
//          {
//            temp.append(".*["+s1.charAt(i)+"]");
//          }
//          temp.append(".*");
//
//          if(s.matches(temp.toString()))
//          {
//            out.println("YES");
//            out.println(s1);
//            return;
//          }
//        }
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
