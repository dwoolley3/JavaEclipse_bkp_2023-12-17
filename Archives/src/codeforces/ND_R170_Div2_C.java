package codeforces;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class ND_R170_Div2_C
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new ND_R170_Div2_C().run();
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
//		int n = in.nextInt();
//		int k = in.nextInt();
//		
//		int[] a = new int[n];
//		for (int i = 0; i < n; i++) 
//			a[i] = in.nextInt();
//		
//		String st = in.next();
//		
//		StringBuilder sb = new StringBuilder(st + k);
//		sb.append("\r\n");
//		
//		out.println(sb);	
		
		//Union Find? UF
		//MARWARI's code:
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[][] a = new boolean[n][m];
		boolean any = false;
		for(int i = 0; i < n; i++){
			int now = in.nextInt();
			for(int j = 0; j < now; j++){
				a[i][in.nextInt() - 1] = true;
				any = true; // some knows atleast one language
			}
		}
		
		boolean[][] graph = new boolean[n][n];
		for(int i = 0; i < n; i++) graph[i][i] = true;
		
		for(int i = 0; i < n; i++){ // select vertex A
			for(int j = 0; j < n; j++){//select vertex b
				for(int k = 0; k < m; k++){//select language
					if(a[i][k] && a[j][k]) graph[i][j] = true; //then they can communicate, join the edge, make the graph
				}
			}
		}
		
		//find the connected components. ie., if n can reach n1, n2 ..... nN 
		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					graph[i][j] |= graph[i][k] && graph[k][j];
				}
			}
		}
		
		
		//now its  time to run dfs to find the number of connected componenets
		int connectedComponents = 0;
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++){
			if(!visited[i]){
				connectedComponents++;
				for(int j = 0; j < n; j++) if(graph[i][j]) visited[j] = true;
			}
		}
		
		if(!any)System.out.println(n);
		else System.out.println(connectedComponents - 1);
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
