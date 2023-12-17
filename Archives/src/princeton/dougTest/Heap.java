package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class Heap 
{
	public static void sort(String[] pq)
	{
		//Construct heap from 1..N
		int N = pq.length - 1;
		for (int k = N/2; k >= 1; k--)
			sink(pq, k, N);
		
		while (N > 1)
		{
            swap(pq, 1, N--);
            sink(pq, 1, N);
		}
		assert isSorted(pq);
	}
	
	private static void swap(String[] pq, int i, int j)
	{
		String t = pq[i]; pq[i] = pq[j]; pq[j] = t;
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
	
	private static boolean isSorted(String[] a)
	{
		for (int i = 0; i < a.length - 1; i++)
			if (a[i].compareTo(a[i+1]) > 0) return false;
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException  {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileReader("src/algs4-data/words3.txt"));
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<String> al = new ArrayList<String>();
		while (in.hasNext())
			al.add(in.next());
				
		int n = al.size();	
		String[] a = new String[n+1];
		for (int i = 0; i < n; i++) 
			a[i+1] = al.get(i);
		
		Heap.sort(a);

		for (String s : a)
			if (s != null)
			out.println(s);

		out.close();
		in.close();	
	}
}