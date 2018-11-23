package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R181_Div2_B //Name: Coach
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
		int m = in.nextInt();
        int numT = n / 3;

        @SuppressWarnings("unchecked")
		ArrayList<Integer>[] t =  new ArrayList[numT];
        for (int i = 0; i < numT; i++)
            t[i] = new ArrayList<Integer>();

        boolean[] used = new boolean[n+1];

        int a,b;
        boolean good = true;
        for (int i = 0; i < m; i++)
        {
            a = in.nextInt();
            b = in.nextInt();

            if (used[a] || used[b])
                for (int j = 0; j < numT; j++)
                {
                    int cnt = t[j].size();
                    for (int k = 0; k < cnt; k++)
                    {
                        if (t[j].get(k) == a)
                        {
                            if (!t[j].contains(b))
                            {
                                t[j].add(b);
                                used[b] = true;
                                if (t[j].size() > 3)
                                    good = false;
                            }
                        }
                        if (t[j].get(k) == b)
                        {
                            if (!t[j].contains(a))
                            {
                                t[j].add(a);
                                used[a] = true;
                                if (t[j].size() > 3)
                                    good = false;
                            }
                        }
                    }
                }
            else
            {
                boolean placed = false;
                for (int j = 0; j < numT; j++)
                {
                    if (t[j].size() <= 1)
                    {
                        t[j].add(a);
                        t[j].add(b);
                        used[a] = true;
                        used[b] = true;
                        placed = true;
                        break;
                    }
                }
                if (!placed) good = false;
            }
        }

        if (!good)
        {
            out.println(-1);
            return;
        }

        for (int i = 0; i < numT; i++)
        {
            int need = 3 - t[i].size();
            if (need > 0)
            {
                for (int k = 1; k <= n && need > 0; k++)
                {
                    if (!used[k])
                    {
                        t[i].add(k);
                        used[k] = true;
                        need--;
                    }
                }
            }
            Collections.sort(t[i]);
            out.println(t[i].get(0) + " " + t[i].get(1) + " " + t[i].get(2));
        }              
	}
}
