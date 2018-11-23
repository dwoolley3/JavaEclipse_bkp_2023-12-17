package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R185_Div2_B //Name: Archer
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
		double a = in.nextInt();	
		double b = in.nextInt();
		double c = in.nextInt();	
		double d = in.nextInt();
		
        double p = 0;
        for (int i = 0; i < 7000; i++)
        {
            double prod = 1.0;
            for (int j = 0; j < i; j++)
                prod *= (1.0 - a/b) * (1.0 - c/d);
            prod *= a / b;
            p += prod;
        }
        //Alternatively, no loop is needed
//        double p = (double)a/b, q = (double)c/d;
//        double ans = p * (1 / (1- (1-p)*(1-q)))
		
		out.println(p);		
	}
}
