package codeforces;
import java.util.*; //Scanner;

public class R213_Div2_A  //Name: Good Number
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++)
		{
			int num = sc.nextInt(), dig;
			int[] d = new int[10];
			while (num > 0)
			{
				dig = num % 10;
				d[dig]++;
				num = num / 10;	
			}
			boolean ok = true;
			for (int j = 0; j <= k; j++)
				if (d[j] == 0) ok = false;
			if (ok) cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
