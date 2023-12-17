package week4.Ex1_Factorial;

/************************************************
*  Week 4 lab - exercise 1:                     *
*   implementing a recursive factorial function *
*************************************************/

import java.util.*;

public class Main
{

    public long factorial(int n)
    {
        if (n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public Main()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = in.nextInt();

        if (n > 0)
            System.out.println(n + "!= " + factorial(n));
        else
            System.out.println("Input Error!");
        in.close();
    }

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Main myAppl = new Main();
    }
}
