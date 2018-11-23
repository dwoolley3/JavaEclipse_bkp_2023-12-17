package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class HC_2014_RQ_B_fr
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "B_ex";
	final String PROBLEM_NAME = "B";
	//append "_in.txt" and "_out.txt"
	
	public static void main(String[] args) throws IOException  {
		new HC_2014_RQ_B_fr().runWithFiles();
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
            int m = in.nextInt();
            int p = in.nextInt();
            
            String[] nam = new String[n];
            int[] percent = new int[n];
            int[] height = new int[n];
            int[] total = new int[n];
            for (int i = 0; i < n; i++)
            {
                nam[i] = in.next();
                percent[i] = in.nextInt();
                height[i] = in.nextInt();
                total[i] = (percent[i] + 1) * 1000 + height[i];
            }

            //Sort according to highest percent then height (total)
            int temp;
            String tempNam;
            for (int i = 0; i < n-1; i++)
                for (int j = i+1; j < n; j++)
                    if (total[i] < total[j])
                    {
                        temp = total[i]; total[i] = total[j]; total[j] = temp;
                        temp = height[i]; height[i] = height[j]; height[j] = temp;
                        temp = percent[i]; percent[i] = percent[j]; percent[j] = temp;
                        tempNam = nam[i]; nam[i] = nam[j]; nam[j] = tempNam;
                    }

            //Rank is index of 0..n-1. Team A has even indexes; Team B has odd indexes
            //for (int i = 0; i < n; i++)
            //    writer.WriteLine(nam[i] + " " + total[i]);

            int[] minPlayed = new int[n];
            boolean[] inGame = new boolean[n];
            boolean[] teamMoreThanP = new boolean[2];
            teamMoreThanP[0] = (n / 2 + (n% 2) > p);
            teamMoreThanP[1] = (n / 2 > p);
            for (int i = 0; i < 2 * p; i++)
            {
                minPlayed[i]++;
                inGame[i] = true;
            }

            for (int rotation = 1; rotation <= m; rotation++)
            {
                for (int team = 0; team <= 1; team++) 
                    if (teamMoreThanP[team])
                    {
                        int chooseIn = -1, chooseOut = -1;
                        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                        for (int i = team; i < n; i += 2)
                            if (inGame[i] && minPlayed[i] >= max)
                            {
                                max = minPlayed[i];
                                chooseOut = i;
                            }
                            else if (!inGame[i] && minPlayed[i] < min)
                            {
                                min = minPlayed[i];
                                chooseIn = i;
                            }
                        inGame[chooseIn] = true;
                        inGame[chooseOut] = false;
                    }
                for (int i = 0; i < n; i++)
                    if (inGame[i]) minPlayed[i]++;
            }

            String[] namesInGame = new String[2 * p];
            int k = 0;
            for (int i = 0; i < n; i++)
                if (inGame[i]) namesInGame[k++] = nam[i];

            Arrays.sort(namesInGame);
            String ans = "";
            for (String st : namesInGame) ans += st + " ";
            ans.trim();
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
