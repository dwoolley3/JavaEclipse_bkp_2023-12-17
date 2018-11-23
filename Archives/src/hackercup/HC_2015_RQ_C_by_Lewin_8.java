package hackercup;
import java.util.*;
import java.io.*;

public class HC_2015_RQ_C_by_Lewin_8 {
  private static BufferedReader in;
  private static PrintWriter out;
  public static StringTokenizer st;
  public static final String NAME = "src/C_in";
  public static double INF = 1l << 40;
  
  public static boolean[][][] ok;
  public static char[][] grid;
  public static int N, M;
  public static int[] dx = new int[] {-1, 0, 1, 0},
                      dy = new int[] {0, 1, 0, -1};
  public static int sx, sy, ex, ey;
  public static String dirs = "^<v>";

  private static void main2() throws IOException {
    st = new StringTokenizer(in.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    grid = new char[N][M];
    for (int i = 0; i < N; i++)
      grid[i] = in.readLine().toCharArray();
    ok = new boolean[4][N][M];
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < N; j++)
        Arrays.fill(ok[i][j], true);
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int off = dirs.indexOf(grid[i][j]);
        if (grid[i][j] == 'S') {
          sx = i; sy = j;
        }
        if (grid[i][j] == 'G') {
          ex = i; ey = j;
        }
        if (off == -1) continue;
        for (int k = 0; k < 4; k++) {
          int cx = i + dx[k], cy = j + dy[k];
          while (valid(cx, cy)) {
            ok[(k + off) % 4][cx][cy] = false;
            cx += dx[k]; cy += dy[k];
          }
        }
      }
    }
    
    int[] queued = new int[4 * N * M];
    int[] queuex = new int[4 * N * M];
    int[] queuey = new int[4 * N * M];
    boolean[][][] vis = new boolean[4][N][M];
    
    int front = 0, back = 0;
    queuex[back] = sx;
    queuey[back] = sy;
    queued[back++] = 0;
    vis[0][sx][sy] = true;
    int res = -1;
    outer : while (front < back) {
      int cx = queuex[front], cy = queuey[front], cd = queued[front++];
      for (int k = 0; k < 4; k++) {
        int nx = cx + dx[k], ny = cy + dy[k];
        if (valid(nx, ny) && !vis[(cd+1)%4][nx][ny] && ok[(cd + 1) % 4][nx][ny]) {
          if (nx == ex && ny == ey) {
            res = cd + 1;
            break outer;
          }
          
          vis[(cd+1)%4][nx][ny] = true;
          queuex[back] = nx;
          queuey[back] = ny;
          queued[back++] = cd + 1;
        }
      }
    }
    
    out.println(res == -1 ? "impossible" : res);
  }
  
  public static boolean valid(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < M && 
        (grid[x][y] == '.' || grid[x][y] == 'S' || grid[x][y] == 'G');
  }
  
  

  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new FileReader (new File(NAME + ".txt")));
    out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + "_Lewin_out.txt")));

    int numCases = Integer.parseInt(in.readLine());
    for (int test = 1; test <= numCases; test++) {
      out.print("Case #" + test + ": ");
      main2();
    }

    out.close();
    System.exit(0);
  }
}
