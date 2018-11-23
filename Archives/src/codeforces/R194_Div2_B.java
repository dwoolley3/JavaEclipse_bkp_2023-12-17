package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R194_Div2_B //Name: Eight Point Sets
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
        int n = 8;

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            if (!a.contains(x[i])) a.add(x[i]);
            if (!b.contains(y[i])) b.add(y[i]);
        }

        if (a.size() == 3 && b.size() == 3)
        {
            Collections.sort(a);
            Collections.sort(b);
            boolean ugly;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (i == 1 && j == 1)
                    {
                        ugly = false;
                        for (int k = 0; k < n; k++)
                            if (x[k] == a.get(i) && y[k] == b.get(j))
                            {
                                ugly = true;
                                break;
                            }
                        if (ugly)
                        {
                            out.println("ugly");
                            return;
                        }
                    }
                    else
                    {
                        ugly = true;
                        for (int k = 0; k < n; k++)
                        	if (x[k] == a.get(i) && y[k] == b.get(j))
                            {
                                ugly = false;
                                break;
                            }
                        if (ugly)
                        {
                        	out.println("ugly");
                            return;
                        }
                    }
                }
            }
            out.println("respectable");
        }
        else
        {
        	out.println("ugly");
        }
	}
}
