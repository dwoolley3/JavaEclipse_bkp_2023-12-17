package codeforces;


//import java.util.*; //Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; //PrintWriter
import java.util.ArrayList;

public class R174_Div2_C_br //Name: Cows and Sequence
{
	public static void main(String[] args) throws IOException {
		//Scanner      in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter   out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(BufferedReader in, PrintWriter out) throws IOException
	{
		int n = Integer.parseInt(in.readLine());
        int t, a, x, k;
        ArrayList<Integer> s = new ArrayList<Integer>();
        s.add(0);
        int size = 1;
        long sum = 0;
        int[] r = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            String[] ss =  in.readLine().split(" ");
            t = Integer.parseInt(ss[0]);	
            if (t == 1)
            {
                a = Integer.parseInt(ss[1]);		
                x = Integer.parseInt(ss[2]);		
                a = Math.min(a, size);
                sum += a * x;
                r[a-1] += x;
            }
            else if (t == 2)
            {
                k = Integer.parseInt(ss[1]);	
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
