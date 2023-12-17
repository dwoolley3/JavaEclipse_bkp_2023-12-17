package dougTest;
import java.util.*; //Scanner;
import java.io.*;

public class QuickOther 
{
    public static void QSort(String[] b, int left, int right) {
        int i, j, mid;
        String p, temp;
        if(left >= right) return;
        Random rd = new Random();
        i = left; j = right; mid = left + rd.nextInt(right - left + 1);
        p = b[mid];
        while(i <= j){
            while(b[i].compareTo(p) < 0) i++; 
            while(b[j].compareTo(p) > 0) j--;
            if(i <= j) {
                //temp = a[i]; a[i] = a[j]; a[j] = temp;  //For 2nd array
                temp = b[i]; b[i] = b[j]; b[j] = temp;
                i++; j--;
            }
        }
        QSort(b, left, j); QSort(b, i, right);
    }
    
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
		
		QuickOther.QSort(a, 0, n-1);

		for (String s : a)
			out.println(s);
	}
}