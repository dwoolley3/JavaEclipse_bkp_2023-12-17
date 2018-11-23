package hackercup;
import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class HC_2015_RQ_C_submitted
{	
	FastReader in;
	PrintWriter out;
	//final String PROBLEM_NAME = "C_ex";
	final String PROBLEM_NAME = "C";
	
	public static void main(String[] args) throws IOException  {
		new HC_2015_RQ_C_submitted().runWithFiles();
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
	
	public class Queue { 
		private LinkedList<Integer> data = new LinkedList<Integer>();
		public void enqueue(Integer item) {data.addLast(item); }   
		public Integer dequeue() {return data.removeFirst(); } 
		public Integer peek() {return data.getFirst(); }
		public int size() {return data.size(); }
		public boolean isEmpty() {return data.isEmpty(); }
	}
	
	//This version solves the maze and does not go where lasers go.
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int m = in.nextInt();
			int n = in.nextInt();			
			int[][][] a = new int[m][n][4];
			char[][] ch = new char[m][n];
			int[][] wl = new int[m][n];
			int sRow = -1, sCol = -1, gRow = -1, gCol = -1;
			String lasers = "^>v<";  //clockwise: up, right, down, left; 0,1,2,3
			for (int i = 0; i < m; i++)	
			{
				ch[i] = in.next().toCharArray();
				for (int j = 0; j < n; j++)
					if (ch[i][j] == 'S') {
						sRow = i; sCol = j;
					} else if (ch[i][j] == 'G') {
						gRow = i; gCol = j;
					} else if (ch[i][j] == '#') 
						wl[i][j] = 1;
					else if (lasers.contains(ch[i][j]+"") )
						wl[i][j] = 2;
			}			

		    //Start facing North, then turn 90 degrees to the right
		    int[] dx = new int[] { 0, 1, 0, -1 };
		    int[] dy = new int[] { 1, 0, -1, 0 };

		    int[][] cnt = new int[m][n];
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
				{
					cnt[i][j] = 1 << 30;
					if (wl[i][j] == 2) //a laser
					{
						int dir = lasers.indexOf(ch[i][j]+""); //up, right, down, left
						for (int d = 0; d < 4; d++) 
						{					
							int row = i, col = j;
							for (int k = 0; k < n; k++) 
							{
								row -= dy[dir];
								col += dx[dir];
								if (row < 0 || row >= m || col < 0 || col >= n) break;
								if (wl[row][col] > 0) break;
								//Every dir, dir+4, dir+8 steps is a laser beam here at row,col
								a[row][col][d] = 1; 
							}
							dir++;
							if (dir == 4) dir = 0;
						}
					}					
				}
			//p(a);
								
			String ans = "impossible";
			if (sRow > -1 & gRow > -1)  //otherwise impossible
			{
				//Breadth-first search			
				int[][] marked = new int[m][n];
		        Queue qr = new Queue();
		        Queue qc = new Queue();
		        marked[sRow][sCol] = 1;
		        cnt[sRow][sCol] = 0;
		        
		        qr.enqueue(sRow);
		        qc.enqueue(sCol);
		        int step = 0;
		        
		        while (!qr.isEmpty()) {
		            int r = qr.dequeue();
		            int c = qc.dequeue();
		            //step++; totalSteps++;
		            //if (step == 4) step = 0;
		            for (int dir = 0; dir < 4; dir++)
		            {
						int row = r + dy[dir];
						int col = c + dx[dir];
						if (row < 0 || row >= m || col < 0 || col >= n) continue;
						if (wl[row][col] > 0) continue;
						int min = Math.min(cnt[row][col], cnt[r][c] + 1);
						step = min % 4;
						//if (a[row][col][step] == 1) continue;
						if (a[row][col][step] == 1)
						{
							//Check if there is a safe way to backtrack once
							boolean good = false;
							if (a[row][col][(step+2)%4] == 0)
								for (int dir2 = 0; dir2 < 4; dir2++)
								{
									int row2 = r + dy[dir2];
									int col2 = c + dx[dir2];
									if (row2 < 0 || row2 >= m || col2 < 0 || col2 >= n) continue;
									if (wl[row2][col2] > 0) continue;
									if (a[row2][col2][step] == 0 
									&&  a[r][c][(step+1)%4] == 0)
										good = true;							
								}							
							if (!good) continue;
							min = Math.min(cnt[row][col], cnt[r][c] + 3);
						}
						cnt[row][col] = min;
		                if (marked[row][col] == 0) 
		                {
		                	marked[row][col]++;
		                    qr.enqueue(row);
		                    qc.enqueue(col);
		                }
		            }
		        }
		        //p(cnt);
				if (cnt[gRow][gCol] < 1 << 30) 
					ans = cnt[gRow][gCol] + "";
			}
			
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
		}
	}
	public void p(Object ...o) {System.out.println(Arrays.deepToString(o));}

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
