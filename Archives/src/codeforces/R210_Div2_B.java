package codeforces;
import java.util.*; //Scanner;

public class R210_Div2_B  //Name: Levko and Permutation
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		 StringBuilder sb = new StringBuilder();
         if (k == n)
         {
             sb.append(-1);
         }
         else        	 
         {
	         sb.append((n - k) + " ");
	         for (int i = 1; i < n - k; i++)
	         {
	             sb.append(i + " ");
	         }
	         if (k == 0)
	             sb.deleteCharAt(sb.length() - 1);
	         for (int i = n-k + 1; i <= n; i++)
	         {
	             sb.append(i);
	             //if (i < n)   //not necessary in CF; extra space at end is ok
	                 sb.append(" ");
	         }
         }
		
		System.out.println(sb);
		sc.close();
	}
}
