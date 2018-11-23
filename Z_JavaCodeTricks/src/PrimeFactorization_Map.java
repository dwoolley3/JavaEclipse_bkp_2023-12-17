//import java.util.HashMap;
import java.util.Map;
//import java.util.SortedMap;
import java.util.TreeMap;


public class PrimeFactorization_Map {

	public static void main(String[] args) {
		int n = 3000;  // 2*3*5*7*11*13*17*23;
		Map<Integer,Integer> pf = getPrimeFactorization(n);
		System.out.println("Prime Factorization of " + n);
		System.out.println("# of unique primes: " + pf.size());
		
		//Iterate through the map set and display each prime factor x num of occurrences
		for (Map.Entry<Integer, Integer> entry : pf.entrySet())
			System.out.println(entry.getKey() + " x " + entry.getValue());
		for (int i : pf.keySet())	System.out.println(i);
		for (int i : pf.values())	System.out.println(i);
	}
	
	private static TreeMap<Integer, Integer> getPrimeFactorization(int n)
	{
		// 3000 = 2x3 * 3x1 * 5x3
		TreeMap<Integer,Integer> pf = new TreeMap<Integer,Integer>();
		for (int i = 2; i * i <= n; i++)
		{
			 int cnt = 0;
			 while (n % i == 0)
			 {
				 cnt++;
				 n /= i;
//				 if (pf.get(i) != null)
//					 pf.put(i, pf.get(i)+1);
//				 else
//					 pf.put(i, 1);				 
			 }
			 if (cnt > 0) pf.put(i, cnt);
		}
		if (n > 1) pf.put(n, 1);
		return pf;
	}
}
