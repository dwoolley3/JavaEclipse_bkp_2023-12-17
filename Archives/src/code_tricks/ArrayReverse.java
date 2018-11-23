package code_tricks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrayReverse {

		public static void main(String args[]) {
			int n = 30;
			int[] b = getInt();
			System.out.println();
			Arrays.sort(b);
			for (int i = 0; i < n; i++)
				System.out.print(b[i]+ " ");
			
			System.out.println();
			List<Integer> c = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				c.add(i);
			Collections.reverse(c);
			for (int i = 0; i < c.size(); i++)
				System.out.print(c.get(i)+ " ");
		}
		private static int[] getInt()
		{
			int n = 30;
			Integer[] a = new Integer[n];
			for (int i = 0; i < a.length; i++)
				a[i] = i;
			Arrays.sort(a, Collections.reverseOrder());
			int[] b = new int[a.length];
			for (int i = 0; i < b.length; i++)
				b[i] = a[i];
			for (int i = 0; i < a.length; i++)
				System.out.print(a[i]+ " ");
			return b;
		}
}
