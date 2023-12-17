package dougTest;
import java.io.*;
import java.util.*;

public class Sorts {
	
	private static void swap(String[] a, int i, int j)
	{
		String temp = a[i]; a[i] = a[j]; a[j] = temp;
	}
	
	public static String[] bubbleSort(String[] a)
	{
		int n = a.length;
		for (int i = 1; i < n; i++)
			for (int j = 1; j < n+1-i; j++)
				if (a[j].compareTo(a[j-1]) < 0)
					swap(a,j,j-1);
		return a;
	}
	
	public static String[] selectionSort(String[] a)
	{
		int n = a.length;
		for (int i = 0; i < n; i++)
		{
			int min = i;
			for (int j = i+1; j < n; j++)
				if (a[j].compareTo(a[min]) < 0)
					min = j;
			swap(a, i, min);
		}
		return a;
	}
	
	public static String[] insertionSort(String[] a)
	{
		int n = a.length;
		for (int i = 0; i < n; i++)
			for (int j = i; j > 0; j--)
				if (a[j].compareTo(a[j-1]) < 0)
					swap(a,j,j-1);
				else break;
		return a;
	}
		
	public static String[] shellSort(String[] a)
	{
		int n = a.length;
		int h = 1;
		while (h*3 < n / 3) h = h*3+1;
		
		while (h >= 1)
		{
			for (int i = h; i < n; i++)
			{
				for (int j = i; j >= h; j-= h)
					if (a[j].compareTo(a[j-h]) < 0)
						swap(a,j,j-h);
					else break;
			}
			h /= 3;
		}
		return a;
	}
	
	public static void mergeSort(String[] a)
	{
		int n = a.length;
		aux = new String[n];
		mergeSort(a, 0, n-1);		
	}
	
	public static void mergeSort(String[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(a, lo, mid);
		mergeSort(a, mid+1, hi);
		if (a[mid].compareTo(a[mid+1]) <= 0) return; //Array is sorted
		merge(a, lo, mid, hi);		
	}
	
	private static void merge(String[] a, int lo, int mid, int hi)
	{
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		for (int k = lo; k <= hi; k++)
			if      (i > mid)                       a[k] = aux[j++];
			else if (j > hi)                        a[k] = aux[i++];
			else if (aux[j].compareTo(aux[i]) < 0)  a[k] = aux[j++];
			else                                    a[k] = aux[i++];		
	}
	
	public static void mergeSortBU(String[] a)
	{
		int n = a.length;
		aux = new String[n];
		for (int sz = 1; sz < n; sz += sz)
			for (int lo = 0; lo < n - sz; lo += sz+sz)
				merge(a, lo, lo + sz - 1, Math.min(lo + sz+sz - 1, n-1));		
	}

	static String[] aux;
	
	@SuppressWarnings("unused")
	private static void quickSort(String[] a)
	{
		//Shuffle the array
		int n = a.length;
		for (int i = 0; i < n; i++)
		{
			int ra = (int)(Math.random()*(i+1));
			swap(a,i,ra);
		}
		quickSort(a,0,n-1);
	}
	
	private static void quickSort(String[] a, int lo, int hi)
	{
		if (lo >= hi) return;
		int j = quickPartition(a, lo, hi);
		quickSort(a, lo, j-1);
		quickSort(a, j+1, hi);
	}
	
	private static int quickPartition(String[] a, int lo, int hi)
	{
		int i = lo, j = hi + 1;
		
		String p = a[lo];
		while (true)
		{
			while (a[++i].compareTo(p) <  0) if (i == hi) break;			
			while (a[--j].compareTo(p) >= 0) if (j == lo) break;			
			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, lo, j);		
		return j;
	}
	
	private static void quickSort3way(String[] a)
	{
		//Shuffle the array
		int n = a.length;
		for (int i = 0; i < n; i++)
		{
			int ra = (int)(Math.random()*(i+1));
			swap(a,i,ra);
		}
		quickSort3way(a,0,n-1);
	}
	
	private static void quickSort3way(String[] a, int lo, int hi)
	{
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        String v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        quickSort3way(a, lo, lt-1);
        quickSort3way(a, gt+1, hi);
	}
	
	public static void heapSort(String[] pq)
	{
		//Construct heap
		int N = pq.length - 1;
		for (int k = N/2; k >= 1; k--)
			sink(pq, k, N);
		
		//Place root value into descending order toward end & sink new root
		while (N > 1)
		{
            swap(pq, 1, N--);
            sink(pq, 1, N);
		}
	}
	
	private static void sink(String[] pq, int k, int N)
	{
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && pq[j].compareTo(pq[j+1]) < 0) j++;
            if (pq[k].compareTo(pq[j]) >= 0) break;
            swap(pq, k, j);
            k = j;
        }		
	}

	public static void main(String[] args) throws FileNotFoundException  {
		Scanner in = new Scanner(new FileReader("src/algs4-data/words3.txt")); //System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		ArrayList<String> al = new ArrayList<String>();
		while (in.hasNext())		
			al.add(in.next());
		
		String[] a = new String[al.size()];
		for (int i = 0; i < al.size(); i++) 
			a[i] = al.get(i);
		
		//bubbleSort(a);
		//insertionSort(a);
		//selectionSort(a);
		//shellSort(a);
		//mergeSort(a);
		//mergeSortBU(a);
		//quickSort(a);
		//quickSort3way(a);
		//Change array to natural order 1..N for heapSort
		String[] a2 = new String[a.length + 1];
		for (int i = 0; i < a.length; i++) 
			a2[i+1] = a[i];
		heapSort(a2);
		for (int i = 1; i < a2.length; i++)
			out.println(a2[i]);
		
		//for (String s : a)
		//	out.println(s);

		out.close();
		in.close();
	}
}
