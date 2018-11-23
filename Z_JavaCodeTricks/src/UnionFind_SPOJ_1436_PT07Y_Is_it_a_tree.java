import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

//****  for SPOJ, class must be called M a i n

public class UnionFind_SPOJ_1436_PT07Y_Is_it_a_tree
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new UnionFind_SPOJ_1436_PT07Y_Is_it_a_tree().run();
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
		int N = in.nextInt();
		int M = in.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        boolean isTree = true;
		for (int T = 1; T <= M; T++) 
		{			
			int u = in.nextInt() - 1;  //0 ... N-1
			int v = in.nextInt() - 1;  //0 ... N-1			
            if (uf.connected2(u, v)) 
            	isTree = false;
            else
	            uf.union3(u, v);
		}
		isTree = isTree && uf.count() == 1;
        if (isTree)
        	out.println("YES");
        else
        	out.println("NO");
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

class WeightedQuickUnionUF
{
    //Given a set of N nodes, with several connections between nodes
    //designated by union(x,y), determine if a path exists from node a to b.
	//1. QuickFind           uses union(), connected, n^2
	//2. QuickUnion          uses union2(), connected2(), n * log n (up to n^2)
	//3. WeightedQuickUnion  uses union3(), connected2(), n * log n

    private int[] id;    // id[i] = parent of i; for root, id[i] = i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    public WeightedQuickUnionUF(int N)
    {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
        count = N;
    }
    
    // Returns the number of components.
    public int count() {
        return count;
    }

    public boolean connected(int p, int q)
    { return id[p] == id[q]; }

    //Quick Find
    public void union(int p, int q)
    {
        //Union too expensive: takes n^2 array accesses to process 
    	//sequence of N union commands on N objects.
    	int pid = id[p];
    	int qid = id[q];
    	for (int i = 0; i < id.length; i++)
    		if (id[i] == pid) id[i] = qid;
    	count--;
    }
	
    public int find(int i) {
        return id[i];
    }
    
	private int find2(int i)
	{
	    while (i != id[i])
	    {
	        id[i] = id[id[i]];  //Keeps tree almost completely flat
	        i = id[i];
	    }
	    return i;
	}
	
	public boolean connected2(int p, int q)	{ 
		return find2(p) == find2(q); 
	}
	
	//Quick Union
	public void union2(int p, int q)
	{
	    //id[i] is parent of i. Root of i is id[id[id[...id[i]...]]].
	    //Find operation: Check if p and q have the same root.
	    int i = find2(p);
	    int j = find2(q);
	    id[i] = j;
	    count--;
	    //However, you can get a tall skinny tree, so Find is too expensive.
	}
	
	//Weighted Quick Union
	//Keep track of size of each tree (number of objects)
	//Balance by linking root of smaller tree to root of larger tree
	public void union3(int p, int q)
	{
	    //Link root of smaller tree to root of larger tree.
	    //Update the sz[] array
        int i = find2(p);
        int j = find2(q);
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
        count--;
    }
}