package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R189_Div2_B //Name: Ping-Pong (Easy Version)
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
    public static int[][] graph;
    public static boolean[] visited;
    public static boolean moves = false;
	
	public static void solve(Scanner in, PrintWriter out)
	{
		int n = in.nextInt();	
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
        graph = new int[n][n];                        
        ArrayList<String> ans = new ArrayList<String>();

         for (int i = 0; i < n; i++)
         {
             int d = in.nextInt();
             if (d == 1)
             {
                 x.add(in.nextInt());
                 y.add(in.nextInt());
                 int k = x.size() - 1;
                 for (int j = 0; j < k; j++)
                 {
                     if (x.get(j) > x.get(k) && x.get(j) < y.get(k)
                     ||  y.get(j) > x.get(k) && y.get(j) < y.get(k))
                         graph[j][k] = 1;

                     if (x.get(k) > x.get(j) && x.get(k) < y.get(j)
                     ||  y.get(k) > x.get(j) && y.get(k) < y.get(j))
                         graph[k][j] = 1;
                 }
             }
             else //d == 2
             {
                 int i1 = in.nextInt() - 1;
                 int i2 = in.nextInt() - 1;
                 visited = new boolean[n+1];

                 moves = false;
                 dfs(i1, i2, x.size());
                
                 if (moves)
                     ans.add("YES");
                 else
                     ans.add("NO");
             }
         }

         for (String ret : ans)
             out.println(ret);	
	}
    public static void dfs(int v, int t, int len)
    {
        visited[v] = true;
        for (int i = 0; i < len; i++)
        {
            if (!visited[i] && graph[v][i] == 1)
            {
                if (i == t)
                {
                    moves = true;
                    return;
                }
                else
                    dfs(i, t, len);
            }
        }
    }
}
