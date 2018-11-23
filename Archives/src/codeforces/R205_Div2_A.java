package codeforces;
import java.util.*; //Scanner;

public class R205_Div2_A  //Name: Domino
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int a, b;
        int to = 0, bo = 0, eo = 0;
        for (int i = 0; i < n; i++)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a % 2 == 0) {} else to++;
            if (b % 2 == 0) {} else bo++;
            if (a % 2 != b % 2) eo++;
        }

        if (to % 2 == 0 && bo % 2 == 0)
        	System.out.println(0);
        else if (n == 1 || eo == 0 || Math.abs(to-bo) % 2 == 1)
        	System.out.println(-1);
        else
        	System.out.println(1);

		sc.close();
	}
}
