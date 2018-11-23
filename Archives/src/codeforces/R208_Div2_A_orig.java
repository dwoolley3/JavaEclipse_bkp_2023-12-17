package codeforces;
import java.util.*; //Scanner;

public class R208_Div2_A_orig  //Name: Dima and Continuous Line
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        if (n <= 3)  //missed case of n=1, a[0]=0 in contest; runtime err
        {
        	System.out.println("no");
        	sc.close();
            return;
        }
        boolean ok = true;
        int max = Math.max(a[0], a[1]);
        int min = Math.min(a[0], a[1]);
        for (int i = 2; i < n; i++)
        {
            if ((a[i - 1] == min || a[i - 1] == max) && a[i] < min)
                min = a[i];
            else if ((a[i - 1] == max || a[i - 1] == min) && a[i] > max)
                max = a[i];
            else if (a[i - 1] > a[i])
                for (int j = 0; j < i - 1; j++)
                {
                    //check if a[j] between a[i-1], a[i]
                    if (a[j] > a[i] && a[j] < a[i-1])
                    {
                        ok = false;
                        break;
                    }
                }
            else if (a[i - 1] < a[i])
                for (int j = 0; j < i - 1; j++)
                {
                    //check if a[j] between a[i-1], a[i]
                    if (a[j] > a[i-1] && a[j] < a[i])
                    {
                        ok = false;
                        break;
                    }
                }
            else
            {
                ok = false;
                break;
            }
        }
        
        if (ok)
        	System.out.println("no");
        else
        	System.out.println("yes");

		sc.close();
	}
}
