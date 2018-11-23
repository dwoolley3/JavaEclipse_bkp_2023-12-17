package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R174_Div2_C //Name: Cows and Sequence
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
        int t, a, x, k;
        ArrayList<Integer> s = new ArrayList<Integer>();
        s.add(0);
        int size = 1;
        long sum = 0;
        int[] r = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            //String[] ss = Console.ReadLine().Split();
            t = in.nextInt();	
            if (t == 1)
            {
                a = in.nextInt();	
                x = in.nextInt();	
                a = Math.min(a, size);
                sum += a * x;
                r[a-1] += x;
            }
            else if (t == 2)
            {
                k = in.nextInt();
                s.add(k);
                size++;
                sum += k;
            }
            else if (t == 3)
            {
                if (size >= 2)
                {
                    size--;
                    sum -= (s.get(size) + r[size]);
                    s.remove(size);  //0 based
                    r[size - 1] += r[size];
                    r[size] = 0;
                }
            }

            sb.append((double)sum / size);
            sb.append("\r\n");
        }	
		out.println(sb);		
	}
}
