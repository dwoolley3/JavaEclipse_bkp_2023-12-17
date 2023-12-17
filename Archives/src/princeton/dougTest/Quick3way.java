package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class Quick3way 
{
	static void quickSort(String[] a)
	{
		//Shuffle the array
		int n = a.length;
		for (int i = 0; i < n; i++)
		{
			int ra = (int)(Math.random()*(i+1));
			String t = a[ra]; a[ra] = a[i]; a[i] = t;
		}
		quickSort(a,0,n-1);
		
		assert isSorted(a);
	}
	
	private static void quickSort(String[] a, int lo, int hi)
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
        quickSort(a, lo, lt-1);
        quickSort(a, gt+1, hi);
	}
	
	private static void swap(String[] a, int i, int j)
	{
		String temp = a[i]; a[i] = a[j]; a[j] = temp;
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
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		ArrayList<String> al = new ArrayList<String>();
		while (in.hasNext())
			al.add(in.next());
				
		int n = al.size();	
		String[] a = new String[n];
		for (int i = 0; i < n; i++) 
			a[i] = al.get(i);
		
		Quick3way.quickSort(a);

		for (String s : a)
			out.println(s);
	}
}