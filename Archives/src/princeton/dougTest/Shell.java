package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class Shell 
{
	public static void sort(String[] a)
	{
		int n = a.length;	
		// 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
		int h = 1;
		while (h < n/3) h = 3*h +1;
		
		while (h >= 1) {
			// h-sort the array
			for (int i = h; i < n; i++)
				for (int j = i; j >= h && a[j].compareTo(a[j-h]) < 0; j-=h)
				{
					String t = a[j]; a[j] = a[j-h]; a[j-h] = t;
				}
			h /= 3;
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
		//Scanner    in = new Scanner(System.in);
		Scanner      in = new Scanner(new FileReader("src/algs4-data/words3.txt"));
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<String> al = new ArrayList<String>();
		while (in.hasNext())
			al.add(in.next());
				
		int n = al.size();	
		String[] a = new String[n];
		for (int i = 0; i < n; i++) 
			a[i] = al.get(i);
		
		Shell.sort(a);

		for (String s : a)
			out.println(s);
		
		out.close();
		in.close();	
	}
}