package codeforces;

import java.util.*; //Scanner, Arrays
import java.io.*;

public class R212_Div2_B  //Name: Petya and Staircases
{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[m];
        for (int i = 0; i < m; i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);
        boolean ok = true;
        for (int i = 0; i < m; i++)
        {
            if (a[i] == 1 || a[i] == n) ok = false;
            if (i > 1 && a[i] == a[i - 1] + 1 && a[i - 1] == a[i - 2] + 1)
                ok = false;
        }

        if (ok)
        	System.out.println("YES");
        else
        	System.out.println("NO");

       sc.close();
	}
}
