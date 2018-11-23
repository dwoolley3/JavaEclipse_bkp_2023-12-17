package codejam;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class GCJ_2013_QR_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new GCJ_2013_QR_A().runWithFiles();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void runWithFiles() {
		//in = new FastReader(new File("src/A_input_sm.txt"));
		in = new FastReader(new File("src/A-large-practice.in"));
		//in = new FastReader(new File("src/A-small-practice.in"));
		//in = new FastReader(new File("src/A_input.in"));
		try {
			//out = new PrintWriter(new File("src/A-small-practice.out"));
			out = new PrintWriter(new File("src/A-large-practice.out"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  
		//in.nextLine(); //use after a nextInt() and prior to reading another in.nextLine()

		for (int tc = 1; tc <= T; tc++)
		{
            boolean notFinished = false;
            String[] b = new String[4];
            for (int i = 0; i < 4; i++)
            {
                b[i] = in.nextLine();
                if (b[i].contains("."))
                    notFinished = true;
            }
            
            String ans = "";
            char[] p = new char[] { 'X', 'O' };

            //Check rows
            for (int j = 0; j < 2; j++)
            {
                for (int r = 0; r < 4; r++)
                {
                    int inRow = 0;
                    for (int c = 0; c < 4; c++)
                    {
                        char ch = b[r].charAt(c);
                        if (ch == p[j] || ch == 'T')
                            inRow++;
                    }
                    if (inRow == 4)
                    {
                        ans = p[j] + " won";
                        break;
                    }
                }
            }

            //Check cols
            if (ans == "")
            {
                for (int j = 0; j < 2; j++)
                {
                    for (int c = 0; c < 4; c++)
                    {
                        int inCol = 0;
                        for (int r = 0; r < 4; r++)
                        {
                            char ch = b[r].charAt(c);
                            if (ch == p[j] || ch == 'T')
                                inCol++;
                        }
                        if (inCol == 4)
                        {
                            ans = p[j] + " won";
                            break;
                        }
                    }
                }
            
            }

            //Check diag
            if (ans == "")
            {
                for (int j = 0; j < 2; j++)
                {
                    int inDiag = 0;
                    for (int r = 0; r < 4; r++)
                    {
                        char ch = b[r].charAt(r);
                        if (ch == p[j] || ch == 'T')
                            inDiag++;
                    }
                    if (inDiag == 4)
                    {
                        ans = p[j] + " won";
                        break;
                    }

                    inDiag = 0;
                    for (int r = 0; r < 4; r++)
                    {
                        char ch = b[r].charAt(3 - r);
                        if (ch == p[j] || ch == 'T')
                            inDiag++;
                    }
                    if (inDiag == 4)
                    {
                        ans = p[j] + " won";
                        break;
                    }
                }
            }

            if (ans == "")
                ans = notFinished ? "Game has not completed" : "Draw";
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
			
            @SuppressWarnings("unused")
			String empty = in.nextLine();
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
