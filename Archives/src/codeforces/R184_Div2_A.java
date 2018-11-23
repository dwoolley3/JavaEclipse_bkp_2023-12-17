package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R184_Div2_A //Name: Strange Addition
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
	
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		
        ArrayList<Integer> b = new ArrayList<Integer>();
        boolean one = false, ten = false;
        int possible = -1;
        for (int i = 0; i < n; i++)
            if (a[i] == 100 || a[i] == 0)
                b.add(a[i]);
            else if (a[i] % 10 == 0 && ten == false)
            {
                b.add(a[i]);
                ten = true;
            }
            else if (a[i] < 10 && one == false)
            {
                b.add(a[i]);
                one = true;
            }
            else
                possible = a[i];
        
        if (possible > -1 && !ten && !one)
            b.add(possible);

        String st = "";
        out.println(b.size());
        for (int i = 0; i < b.size(); i++)
            st += b.get(i) + " ";
        out.println(st);
	}
}
