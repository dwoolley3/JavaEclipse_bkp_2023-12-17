
public class WeightedQuickUnionUF2
{
    //Given a set of N nodes, with several connections between nodes
    //designated by union(x,y), determine if a path exists from node a to b.
	//1. QuickFind           uses union(), connected, n^2
	//2. QuickUnion          uses union2(), connected2(), n * log n (up to n^2)
	//3. WeightedQuickUnion  uses union3(), connected2(), n * log n

    private int[] id;    // id[i] = parent of i; for root, id[i] = i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    public WeightedQuickUnionUF2(int N)
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

    //QuickOther Find
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
	
	//QuickOther Union
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
	
	//Weighted QuickOther Union
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
	
	public static void main(String[] args) 
    {
		long startTime = System.currentTimeMillis();
    	In in = new In("algs4-data/mediumUF.txt");        
        int N = in.readInt();
        WeightedQuickUnionUF2 uf = new WeightedQuickUnionUF2(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
		long endTime = System.currentTimeMillis();
		System.out.println (//endTime + " " + startTime +
				" " + (endTime - startTime) / 1000.0 + " seconds");
    }
}		
