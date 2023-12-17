package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class Insertion 
{
	public static void sort(String[] a)
	{
		int n = a.length;
		for (int i = 1; i < n; i++)
			for (int j = i; j > 0 && a[j].compareTo(a[j-1]) < 0; j--)
			{
				String t = a[j]; a[j] = a[j-1]; a[j-1] = t;
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
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileReader("src/algs4-data/words3.txt"));
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<String> al = new ArrayList<String>();
		while (in.hasNext())
			al.add(in.next());
				
		int n = al.size();	
		String[] a = new String[n];
		for (int i = 0; i < n; i++) 
			a[i] = al.get(i);
		
		Insertion.sort(a);

		for (String s : a)
			out.println(s);

		out.close();
		in.close();	
	}
}