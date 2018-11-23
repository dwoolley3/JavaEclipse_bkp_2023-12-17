package codeforces;
import java.util.*;

public class R211_Div2_A  //Soroban
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int d;
        String s;
        ArrayList<String> ans = new ArrayList<String>();
        while (n >= 0)
        {
            d = n % 10;
            n /= 10;
            if (d < 5)
                s = "O-|";
            else
                s = "-O|";
            if (d % 5 == 0)      s += "-OOOO";
            else if (d % 5 == 1) s += "O-OOO";
            else if (d % 5 == 2) s += "OO-OO";
            else if (d % 5 == 3) s += "OOO-O";
            else if (d % 5 == 4) s += "OOOO-";
            ans.add(s);
            if (n == 0) n = -1;
        }
        for (String st : ans)
            System.out.println(st);
       sc.close();
	}
}
