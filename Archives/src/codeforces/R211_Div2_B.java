package codeforces;
import java.util.*; //Scanner;

public class R211_Div2_B  //Name: Fence
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int mini = 0;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += a[i];
            if (i >= k - 1)
            {                    
                if (sum < min)
                {
                    min = sum;
                    mini = i + 1 - k;
                }
                sum -= a[i + 1 - k];
            }
        }
		System.out.println(mini+1);
		sc.close();
	}
}
