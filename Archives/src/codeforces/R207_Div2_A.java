package codeforces;
import java.util.*; //Scanner;

public class R207_Div2_A  //Name: Group of Students
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            cnt += a[i];
            if (cnt >= x && cnt <= y && (sum - cnt) >= x && (sum - cnt) <= y)
            {
                ans = i+2;
                break;
            }
        }
		
		System.out.println(ans);
		sc.close();
	}
}
