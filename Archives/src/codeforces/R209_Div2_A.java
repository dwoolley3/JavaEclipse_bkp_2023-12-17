package codeforces;
import java.util.*; //Scanner;

public class R209_Div2_A  //Name: R212_Div2_A
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();  
        int[][] a = new int[n][m];
        int cnt = 4;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                a[i][j] = sc.nextInt();  
                if (a[i][j] == 1 && 
                    (i == 0 || j == 0 || i == n - 1 || j == m - 1))
                    cnt = 2;
            }
        }
		
		System.out.println(cnt);
		sc.close();
	}
}
