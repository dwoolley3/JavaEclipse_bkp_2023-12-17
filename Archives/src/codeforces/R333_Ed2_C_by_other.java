package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R333_Ed2_C_by_other
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R333_Ed2_C_by_other().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	public static final int LETTERS_COUNT = 26;
	
	void solve()
	{		
	       @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	        String s = sc.next();
	        char[] chars = s.toCharArray();

	        int[] count = new int[LETTERS_COUNT];
	        for (char aChar : chars) {
	            count[aChar - 'a']++;
	        }
	        int len = chars.length;
	        char[] palindrome = new char[len];

	        int pos = 0;
	        int i = 0;

	        char middle = '\0';
	        out:
	        while (i < LETTERS_COUNT) {
	            while (count[i] >= 2) {
	                palindrome[pos] = (char) ('a' + i);
	                palindrome[len - pos - 1] = (char) ('a' + i);
	                count[i] -= 2;
	                pos++;
	            }
	            if (count[i] > 0) {
	                for (int j = LETTERS_COUNT - 1; j > i; j--) {
	                    if ((count[j] & 1) == 1) {
	                        palindrome[pos] = (char) ('a' + i);
	                        palindrome[len - pos - 1] = (char) ('a' + i);
	                        count[i]--;
	                        count[j]--;
	                        pos++;
	                        i++;
	                        continue out;
	                    }
	                }
	                // have not found pair - all others are even
	                middle = (char) ('a' + i);
	                count[i]--;
	            }
	            i++;
	        }
	        if (middle != '\0') {
	            palindrome[len / 2] = middle;
	        }
	        System.out.println(new String(palindrome));	
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
