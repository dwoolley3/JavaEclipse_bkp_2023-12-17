package codechef;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


//For Code Chef, do not precede class Program with "public"
class CC2014_12_LT_A_TADELIVE_Delivery_Man
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new CC2014_12_LT_A_TADELIVE_Delivery_Man().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	class Node implements Comparable<Node> {
		public int a, b, d;
		
		public Node(int A, int B, int D) {
			a = A;
			b = B;
			d = D;
		}
		
		public int compareTo(Node o) {
			return d - o.d;
		}
	}
	
	void solve()
	{
		int n = in.nextInt();	
		int x = in.nextInt();
		int y = in.nextInt();
			
		int[] a = new int[n];
		int[] b = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++)			
			a[i] = in.nextInt();
		
        Node[] nd = new Node[n];
		for (int i = 0; i < n; i++)	 {	
			b[i] = in.nextInt();
			d[i] = a[i] - b[i];
        	nd[i] = new Node(a[i], b[i], d[i]);
		}
        Arrays.sort(nd);
//        for (int i = 0; i < n; i++)	{
//        	out.print(nd[i].a);
//        	out.println(nd[i].b);
//        }

        int miny = y - (x+y - n);
        long max = 0;
//        for (int i = miny; i <= y; i++) {
//        	int sum = 0;
//        	for (int j = 0; j < i; j++)
//        		sum += nd[j].b;
//        	for (int j = i; j < n; j++)
//        		sum += nd[j].a;
//        	max = Math.max(max, sum);
//        }
        
    	long sum = 0;
    	for (int j = 0; j < miny; j++)
    		sum += nd[j].b;
    	for (int j = miny; j < n; j++)
    		sum += nd[j].a;
    	max = Math.max(max, sum);
    	
        for (int i = miny; i < y; i++) {
        	sum += (nd[i].b - nd[i].a);
        	max = Math.max(max, sum);
        }
        out.println(max);

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
