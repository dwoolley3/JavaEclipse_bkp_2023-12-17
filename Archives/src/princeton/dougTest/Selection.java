package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class Selection 
{
	public static void sort(String[] a)
	{
		int n = a.length;
		for (int i = 0; i < n; i++)
		{
			int min = i;
			for (int j = i+1; j < n; j++)
				if (a[j].compareTo(a[min]) < 0)
					min = j;
			String t = a[i]; a[i] = a[min]; a[min] = t;
		}
		assert isSorted(a);
	}
	
	private static boolean isSorted(String[] a)
	{
		for (int i = 0; i < a.length - 1; i++)
			if (a[i].compareTo(a[i+1]) > 0) return false;
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException  {
		//Scanner      in = new Scanner(System.in);
		Scanner      in = new Scanner(new 
				FileReader("src/algs4-data/words3.txt"));
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
		
		Selection.sort(a);

		for (String s : a)
			out.println(s);
	}
}