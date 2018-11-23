package code_tricks;

public class PrimeFactorization_Array {

	public static void main(String[] args) {
		int n = 3000;  // 2*3*5*7*11*13*17*23;  //up to 10 million
		int[] pf = getPrimeFactorization(n);
		System.out.println("Prime Factorization of " + n);
		int cnt = 0;
		for (int i : pf) if (i > 0) cnt++;
		System.out.println("# of unique primes: " + cnt);
		
		//Iterate through the map set and display each prime factor x num of occurrences
		for (int i = 0; i < pf.length; i++) 
			if (pf[i] > 0)			
				System.out.println(i + " x " + pf[i]);
	}
	
	private static int[] getPrimeFactorization(int n)
	{
		// 3000 = 2x3 * 3x1 * 5x3
		int[] pf = new int[10_000_000];
		for (int i = 2; i * i <= n; i++)
		{
			 int cnt = 0;
			 while (n % i == 0)
			 {
				 cnt++;
				 n /= i;		 
			 }
			 if (cnt > 0) pf[i] = cnt;
		}
		if (n > 1) pf[n] = 1;
		return pf;
	}
}
