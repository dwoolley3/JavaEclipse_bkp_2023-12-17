package codechef;
import java.util.Scanner;
import java.io.IOException;

class CC2013_10_C_PPTEST {

    static int[] itemPoints;
    static int[] itemTimes;
    static int timeLimit;
    static int[][] matrix;
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++)
        {
            int n = sc.nextInt();
            int w = sc.nextInt();

            int[] c = new int[n];
            int[] p = new int[n];
            int[] Tim = new int[n];
            int[] ptot = new int[n];
            itemPoints = new int[n];
            itemTimes = new int[n];
            //int totalPoints = 0;
            matrix = new int[101][101];
            for (int i = 0; i < n; i++)
            {                
                c[i] = sc.nextInt();
                p[i] = sc.nextInt();
                Tim[i] = sc.nextInt();
                ptot[i] = c[i] * p[i];
                itemPoints[i] = ptot[i];
                itemTimes[i] = Tim[i];
                //totalPoints += ptot[i];
            }
            timeLimit = w;
            int bestPoints = knapsack(n, timeLimit, itemTimes, itemPoints);
            System.out.println(bestPoints);
        }
        sc.close();
    }

    static int knapsack(int numItems, int size, int[] times, int[] points)
    {
        for (int i = 1; i <= numItems; i++)
        {
            for (int j = 0; j <= size; j++)
            {
                if (times[i - 1] <= j)
                {
                    matrix[i][j] = Math.max(matrix[i - 1][j], 
                        points[i - 1] + matrix[i - 1][j - times[i - 1]]);
                }
                else
                {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix[numItems][size];
    }
}
