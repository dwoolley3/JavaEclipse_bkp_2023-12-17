package week4.Ex1_Minimum;

/********************************
*  Week 4 lab - exercise 1:     *
*   finding the smallest number *
*********************************/

public class Main
{

    int minimum(int a[], int n)
    {
        int min = a[0];

        for (int i = 1; i < n; i++)
            if (min > a[i]) min = a[i];

        return min;
    }

    public Main()
    {
        int[] a = new int[10];

        for (int i = 0; i < 10; i++)
        {
            a[i] = (int) (Math.random() * 100);
            System.out.print(a[i] + " ");
        }

        System.out.println("\nMin =  " + minimum(a, 10));
        
    }

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Main myAppl = new Main();
    }
}
