package codeforces;
import java.util.*; //Scanner;

public class R211_Div2_C  //Name: Fixing Typos
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
        int n = s.length();
        char[] c = new char[n];
        int[] tim = new int[n];
                    
        char lastc = s.charAt(0);
        int num = 1, ind = -1;
        for (int i = 1; i < n; i++)
        {
            if (s.charAt(i) == lastc)
                num++;
            else
            {
                ind++;
                c[ind] = lastc;
                if (num >= 2)
                {
                    if (ind > 0 && tim[ind - 1] == 2)
                        num = 1;
                    else
                        num = 2;
                }
                tim[ind] = num;
                num = 1;
                lastc = s.charAt(i);
            }
        }
        ind++;
        c[ind] = lastc;
        if (num >= 2)
        {
            if (ind > 0 && tim[ind - 1] == 2)
                num = 1;
            else
                num = 2;
        }
        tim[ind] = num;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= ind; i++)
            for (int j = 0; j < tim[i]; j++)
                sb.append(c[i]);
		
		System.out.println(sb);
		sc.close();
	}
}
