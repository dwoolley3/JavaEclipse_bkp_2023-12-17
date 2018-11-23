package codeforces;
import java.util.*; //Scanner;

public class R210_Div2_A  //Name: Levko and Table
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                if (i == j) sb.append(k);
                else sb.append("0");
                if (j < n - 1) sb.append(" ");
                else sb.append("\r\n");
            }
		
		System.out.println(sb);
		sc.close();
	}
}
