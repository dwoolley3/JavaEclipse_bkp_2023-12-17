package codeforces;
import java.util.*; //Scanner;

public class R209_Div2_B  //Name: Permutation
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n * 2];
        int num = 2;
        if (k == 0)
        {
            a[0] = 1;
            a[1] = 2;
        }
        else
        {
            a[0] = k + 1;
            a[1] = 1;
        }
        for (int i = 2; i < n * 2; i++)
        {
            if (num == a[0] || num == a[1]) num++;
            a[i] = num;
            num++;
        }               

        StringBuilder sb = new StringBuilder();
        sb.append(a[0]);
        for (int i = 1; i < n * 2; i++)                
            sb.append(" " + a[i]);
		
		System.out.println(sb);
		sc.close();
	}
}
