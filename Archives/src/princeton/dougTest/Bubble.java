package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class Bubble 
{
	public static void sort(String[] a)
	{
		//Bubble the largest elements to the back of the array
		int n = a.length;
		for (int i = 0; i < n; i++)
			for (int j = 1; j < n-i; j++)
			{
				if (a[j].compareTo(a[j-1]) < 0)
				{
					String t = a[j]; a[j] = a[j-1]; a[j-1] = t;
				}
				//System.out.println(Arrays.toString(a));
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
		
		//Randomize Array prior to using sort - Shuffling array
		int ra;
		String temp;
	    for (int i = 0; i < n; i++)
	    {
	    	ra = (int)(Math.random()*(i+1));  //i+1 better than n
	        temp = a[i]; a[i] = a[ra]; a[ra] = temp;
	    }
	      
		Bubble.sort(a);

		for (String s : a)
			out.println(s);

		out.close();
		in.close();	
	}
}