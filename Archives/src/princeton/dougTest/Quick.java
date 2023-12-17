package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class Quick 
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
			String t = a[j]; a[j] = a[i]; a[i] = t;
		}
		String t = a[lo]; a[lo] = a[j]; a[j] = t;	
		return j;
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
		
		Quick.quickSort(a);

		for (String s : a)
			out.println(s);
	}
}