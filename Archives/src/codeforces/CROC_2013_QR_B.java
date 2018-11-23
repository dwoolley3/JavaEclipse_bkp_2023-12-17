package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class CROC_2013_QR_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CROC_2013_QR_B().run();
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
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder w = new StringBuilder();

        int n = s.length();
        char c;
        int q = 0;
        for (int i = 0; i < n; i++)
        {
            c = s.charAt(i);
            if (c == '"')
            {
                if (q == 0) 
                {
                    if (w.length() > 0 && !w.equals(' '))
                    {
                        String[] st = w.toString().split(" ");
                        for (String t : st)
                        {
                        	if (!t.equals(""))
                            {
                                sb.append("<");
                                sb.append(t);
                                sb.append(">" + "\n");
                            }
                        }
                    }
                    w.setLength(0);
                    q = 1;
                }
                else
                {
                    sb.append("<");
                    sb.append(w);
                    sb.append(">" + "\n");
                    w.setLength(0); 
                    q = 0;
                }
            }
            else 
                w.append(c);
        }

        if (w.length() > 0 && !w.equals(" "))
        {
            String[] st = w.toString().split(" ");
            for (String t : st)
            {
                if (!t.equals(""))
                {
                    sb.append("<");
                    sb.append(t);
                    sb.append(">" + "\n");
                }
            }
        }
        
        out.println(sb);
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
