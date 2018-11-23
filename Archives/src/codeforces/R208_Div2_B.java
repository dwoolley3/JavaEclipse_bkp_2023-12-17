package codeforces;
import java.util.*; //Scanner;

public class R208_Div2_B  //Name: Dima and Text Messages
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int num = n*2+1;
        String[] w = new String[num];
        w[0] = "<3";
        for (int i = 0; i < n; i++)
        {
            w[i*2+1] = sc.next();
            w[i*2+2] = "<3";
        }
        String s = sc.next();

        int ind = 0;
        for (int i = 0; i < num; i++)
        {
            int wl = w[i].length();
            for (int j = 0; j < wl; j++)
            {
                char c = w[i].charAt(j);
                ind = s.indexOf(c, ind);                    
                if (ind == -1) 
                {
                	System.out.println("no");
                	sc.close();
                    return;
                }
                ind++;
            }
        }
		
		System.out.println("yes");
		sc.close();
	}
}
