package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R196_Div2_B //Name: Routine Problem
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
		int a = in.nextInt();	
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		int num1, den1, num2, den2, num, den;
        num1 = a * d - b * c;
        den1 = b * d;

        num2 = b * c - a * d;
        den2 = a * c;

        if (num1 >= 0)
        {
            num = num1; den = den1;
            num *= b; den *= a;
        }
        else
        {
            num = num2; den = den2;
            num *= a; den *= b;
        }

        int g = GCD(num, den);
        num /= g;
        den /= g;

        out.println(num + "/" + den);
    }

    static int GCD(int a, int b)
    {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
