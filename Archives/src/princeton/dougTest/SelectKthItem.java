package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class SelectKthItem 
{
	//This program will find the Kth element of a sorted array,
	//without fully sorting the entire array.
	
	static String select(String[] a, int k)
	{
		//Shuffle the array
		int n = a.length;
		for (int i = 0; i < n; i++)
		{
			int ra = (int)(Math.random()*(i+1));
			String t = a[ra]; a[ra] = a[i]; a[i] = t;
		}
		
		int lo = 0, hi = n - 1;
		while (hi > lo)
		{
			int j = quickPartition(a, lo, hi);
			if   (j < k) lo = j + 1;
			else if (j > k) hi = j - 1;
			else return a[k];
		}
		return a[k];
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
		
		int k = 3; //3=bug, 6=dug;
		String item = SelectKthItem.select(a, k);
		out.println(item + " = " + k);
	}
}