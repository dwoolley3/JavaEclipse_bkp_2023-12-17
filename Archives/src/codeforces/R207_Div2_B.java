package codeforces;
import java.util.*; //Scanner;

public class R207_Div2_B  //Name: Flag Day
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int m = sc.nextInt();

        int[] c = new int[n+1];
        int d1, d2, d3;
        for (int i = 0; i < m; i++)
        {
            d1 = sc.nextInt();
            d2 = sc.nextInt();
            d3 = sc.nextInt();

            if (c[d1] > 0)
            {
                if (c[d1] == 1)
                {
                    c[d2] = 2; c[d3] = 3;
                }
                else if (c[d1] == 2)
                {
                    c[d2] = 1; c[d3] = 3;
                }
                else if (c[d1] == 3)
                {
                    c[d2] = 1; c[d3] = 2;
                }
            }
            else if (c[d2] > 0)
            {
                if (c[d2] == 1)
                {
                    c[d1] = 2; c[d3] = 3;
                }
                else if (c[d2] == 2)
                {
                    c[d1] = 1; c[d3] = 3;
                }
                else if (c[d2] == 3)
                {
                    c[d1] = 1; c[d3] = 2;
                }
            }
            else if (c[d3] > 0)
            {
                if (c[d3] == 1)
                {
                    c[d1] = 2; c[d2] = 3;
                }
                else if (c[d3] == 2)
                {
                    c[d1] = 1; c[d2] = 3;
                }
                else if (c[d3] == 3)
                {
                    c[d1] = 1; c[d2] = 2;
                }
            }
            else
            {
                c[d1] = 1; c[d2] = 2; c[d3] = 3;
            }                
        }
        
        //The following is fine in CF, with extra space at end and no line-feed
        for (int i = 1; i <= n; i++)
        	System.out.print(c[i] + " ");

        //Alternatively, StringBuilder is 30% faster; 
        //StringBuilder sb = new StringBuilder();
        //for (int i = 1; i <= n; i++)
        //{
        //    if (i > 1) sb.append(" ");
        //    sb.append(c[i]);
        //}		
		//System.out.println(sb);
        
		sc.close();
	}
}
