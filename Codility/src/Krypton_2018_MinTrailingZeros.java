public class Krypton_2018_MinTrailingZeros {
	public static void main(String[] args) { 
		MinTrailingZeros obj = new MinTrailingZeros();

		//Program successful for all but 1 test case
		//Problem on size N=2, got 1 expected 0
		// [[1, 1], [0, 1]] 
		int[][] in = new int[2][2];
		int n = in.length;
		for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++)
			in[i][j] = (i==1 && j==0) ? 0 : 1;
		System.out.println(in); 
		System.out.println(obj.solution(in)); 
	}
}

// Difficulty level: HARD

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

	class MinTrailingZeros {
	    public int solution(int[][] A) {
	        // write your code in Java SE 8
	        int n = A.length;
	        int[][] num5 = new int[n][n];
	        int[][] num2 = new int[n][n];
	        boolean has0 = false;
	        for (int row = 0; row < n; row++)
	            for (int col = 0; col < n; col++)
	            {
	                if (A[row][col] == 0) {
	                    has0 = true;
	                    num5[row][col] = 1_000_000;
		                num2[row][col] = 1_000_000;
	                }
	                else {
		                num5[row][col] = getNum5(A[row][col]);
		                num2[row][col] = getNum2(A[row][col]);
	                }
	            }
	            
	        //Find path with smallest number of 2's; find path with smallest number of 5's; take best of 2 paths.
	        int[][] best5 = new int[n][n];
	        int[][] best2 = new int[n][n];
	        for (int row = 0; row < n; row++)
	                for (int col = 0; col < n; col++)
	                {
	                    best2[row][col] = num2[row][col];
	                    best5[row][col] = num5[row][col];
	                    if (row == 0) {
	                        if (col > 0) {
	                            best2[row][col] += best2[row][col-1];
	                            best5[row][col] += best5[row][col-1];
	                        }
	                    } else if (col == 0) {
	                        best2[row][col] += best2[row-1][col];
	                        best5[row][col] += best5[row-1][col];
	                    } else {
	                        int b2 = Math.min(best2[row-1][col], best2[row][col-1]);
	                        int b5 = Math.min(best5[row-1][col], best5[row][col-1]);
	                        best2[row][col] += b2;
	                        best5[row][col] += b5;
	                    }
	                }
	            
	        int ans = Math.min(best2[n-1][n-1], best5[n-1][n-1]);
	        if (has0 && ans > 0) return 1;
	        return ans;
	    }
	    
	    private int getNum2(int num) {
	        int num2 = 0;
	        while (num >=2 && num % 2 == 0) {
	            num2++;
	            num /= 2;
	        }
	        return num2;
	    }
	    private int getNum5(int num) {
	        int num5 = 0;
	        while (num >=5 && num % 5 == 0) {
	            num5++;
	            num /= 5;
	        }
	        return num5;
	    }
	}
