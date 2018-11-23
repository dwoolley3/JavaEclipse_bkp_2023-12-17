package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R202_Div2_A //Name: Cinema Line
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		int n = in.nextInt();	
        int d25 = 0;
        int d50 = 0;
        int a;

        String status = "YES";
        for (int i = 0; i < n; i++)
        {
            a = in.nextInt();
            if (a == 25)
                d25++;
            else if (a == 50 && d25 > 0)
            {
                d25--;
                d50++;
            }
            else if (a == 100 && d25 > 0 && d50 > 0)
            {
                d25--;
                d50--;
            }
            else if (a == 100 && d25 > 2)
            {
                d25 -= 3;
            }
            else
            {
                status = "NO";
                break;
            }
        }
		
		out.println(status);		
	}
}
