package codeforces;
import java.util.*; //Scanner;

public class R213_Div2_B  //Name: The Fibonacci Segment
{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
        int max = Math.min(n, 2); //1 or 2
        int cnt = max;
        for (int i = 2; i < n; i++)
        {
            if (a[i] == a[i - 1] + a[i - 2])
                cnt++;
            else
            {
                max = Math.max(max, cnt);
                cnt = 2;
            }
        }
        max = Math.max(max, cnt);	
        System.out.println(max);
        sc.close();
	}
}
