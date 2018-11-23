package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R178_Div2_B //Name: Shaass and Bookshelf
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
		
        ArrayList<Integer> oneW = new ArrayList<Integer>();
        ArrayList<Integer>  twoW = new ArrayList<Integer>();
        int i;
        for (i = 0; i < n; i++)
        {
            int t = in.nextInt();	
            int w = in.nextInt();	
            if (t == 1)
                oneW.add(w);
            else
                twoW.add(w);
        }
        Collections.sort(oneW);
        Collections.reverse(oneW);
        Collections.sort(twoW);
        Collections.reverse(twoW);
        int ans = Integer.MAX_VALUE;

        for (i = 0; i <= oneW.size(); i++)
            for (int j = 0; j <= twoW.size(); j++)
            {
                int totalT = i + j * 2;
                int needW = 0;
                for (int k = i; k < oneW.size(); k++)
                    needW += oneW.get(k);
                for (int k = j; k < twoW.size(); k++)
                    needW += twoW.get(k);
                if (totalT < ans && needW <= totalT)
                    ans = totalT;
            }            

        out.println(ans);		
	}
}
