package codeforces;
import java.util.*; //Scanner;

public class R208_Div2_A  //Name: Dima and Continuous Line
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int max, min;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1; j++)
            {
                if (j >= i - 1 && j <= i + 1) continue;
                max = Math.max(a[i], a[i + 1]);
                min = Math.min(a[i], a[i + 1]);
                if ((a[j] > min && a[j] < max) ^ (a[j + 1] > min && a[j + 1] < max))
                {
                	System.out.println("yes");
                	sc.close();
                    return;
                }
            }
		
		System.out.println("no");
		sc.close();
	}
}
