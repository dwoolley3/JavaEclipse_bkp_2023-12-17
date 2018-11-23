package codeforces;
import java.util.*; //Scanner;

public class R211_Div2_D  //Name: Renting Bikes
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int budget = sc.nextInt();

        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();

        int[] p = new int[m];
        for (int i = 0; i < m; i++)
            p[i] = sc.nextInt();

        Arrays.sort(b);  //length n
        Arrays.sort(p);  //length m
        int bikes = Math.min(n, m);

        //Binary Search: between 0 and largest possible number of bikes
        int lo = 0, hi = bikes, mid = 0;
        while (lo <= hi)
        {
            mid = (lo + hi) / 2;
            if (calcPersonalMoney(b, p, mid, budget) == Integer.MAX_VALUE)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        System.out.println(hi + " " + calcPersonalMoney(b, p, hi, budget));
		sc.close();
	}
	
    private static int calcPersonalMoney(int[] b, int[] p, int mid, int budget)
    {
        int personalMoneySpent = 0, price, have;
        for (int i = 0; i < mid; i++)
        {
            price = p[i];
            have = b[b.length - mid + i];
            if (have >= price)
            {
                personalMoneySpent += price;
            }
            else
            {
                personalMoneySpent += have;
                budget -= (price - have);
                if (budget < 0)
                {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if (personalMoneySpent >= budget)
        {
            return personalMoneySpent - budget;
        }
        return 0;
    }
}
