package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R271_Bayan_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R271_Bayan_A().run();
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

//        char[][] c = new char[6][];
//        c[0] = ("+------------------------+").toCharArray();
//        c[1] = ("|#.#.#.#.#.#.#.#.#.#.#.|D|)").toCharArray();
//        c[2] = ("|#.#.#.#.#.#.#.#.#.#.#.|.|").toCharArray();
//        c[3] = ("|#.......................|").toCharArray();
//        c[4] = ("|#.#.#.#.#.#.#.#.#.#.#.|.|)").toCharArray();
//        c[5] = ("+------------------------+").toCharArray();
		
        char[][] c = new char[][] {
                "+------------------------+".toCharArray(),
                "|#.#.#.#.#.#.#.#.#.#.#.|D|)".toCharArray(),
                "|#.#.#.#.#.#.#.#.#.#.#.|.|".toCharArray(),
                "|#.......................|".toCharArray(),
                "|#.#.#.#.#.#.#.#.#.#.#.|.|)".toCharArray(),
                "+------------------------+".toCharArray()
        };
                
        for (int j = 1; n > 0; j+=2) 
            for (int i = 0; i < 6 && n > 0; i++)
                if (c[i][j] == '#') 
                {
                    c[i][j] = 'O';
                    n--;
                }
        
        for (int i = 0; i < 6; ++i)
            out.println(c[i]);	
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
