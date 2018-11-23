package codeforces;

import java.util.Scanner;
import java.io.*;

public class R212_Div2_A  //Name: Two Semiknights Meet
{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = sc.nextInt();
		//int t = Integer.parseInt(br.readLine());
		
		String s;
        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < t; tt++)
        {
            int n = 8;
            int kx = -1, ky = -1, k2x = -1, k2y = -1, x = -1, y = -1;

            for (int i = 0; i < n; i++)
            {
                s = sc.next();   //ignores line seperator
            	//s = br.readLine();
                for (int j = 0; j < n; j++)
                {
                    if (s.charAt(j) == 'K' && kx == -1)
                    {
                        kx = i; ky = j;
                    }
                    else if(s.charAt(j) == 'K') //found 2nd night
                    {
                        k2x = i; k2y = j;
                        x = Math.abs(k2x - kx);
                        y = Math.abs(k2y - ky);
                    }
                }                   
            }
            if (x % 4 == 0 && y % 4 == 0) //able to meet and go back to safe spot
                sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");

            //if (tt < t-1) br.readLine();
        }
       System.out.println(sb);
       //br.close();
       sc.close();
	}
}
