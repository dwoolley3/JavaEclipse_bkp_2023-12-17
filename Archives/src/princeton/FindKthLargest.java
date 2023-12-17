
public class FindKthLargest {
	
	public static void shuffle(int[] a)
	{
		//randomize array 1..n
		for (int i = 0; i < a.length; i++)
		{
			int r = (int) (Math.random()*(i+1));
			int t = a[i]; a[i] = a[r]; a[r] = t;
		}	
	}
	
	public static void main(String[] args) {
		int n = 10, k = 3;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = i;
		//randomize array 1..n
		shuffle(a);
		for (int i = 0; i < n; i++)
			System.out.print(a[i]+ " ");	
		System.out.println();
		
		int lo = 0, hi = n-1, pIndex = 0;
		while (lo < hi)
		{
			pIndex = partition(a, lo, hi);
			if (pIndex < k) lo = pIndex +1;
			else if (pIndex > k) hi = pIndex - 1;
			else break;
		}
		System.out.println("pIndex, val = " + k + ", " + a[k]);
	}
	
	private static int partition(int[] a, int lo, int hi) {
	        int i = lo;
	        int j = hi + 1;
	        int p = a[lo];
	        while (true) { 

	            // find item on lo to swap
	            while (a[++i] < p)
	                if (i == hi) break;

	            // find item on hi to swap
	            while (p < a[--j])
	                if (j == lo) break;      // redundant since a[lo] acts as sentinel

	            // check if pointers cross
	            if (i >= j) break;

	            int t = a[i]; a[i] = a[j]; a[j] = t;
	        }

	        // put partitioning item v at a[j]
	        int t = a[lo]; a[lo] = a[j]; a[j] = t;

	        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	        for (i = lo; i <= hi; i++)
				System.out.print(a[i]+ " ");	
			System.out.println();
	        return j;
	    }

}
