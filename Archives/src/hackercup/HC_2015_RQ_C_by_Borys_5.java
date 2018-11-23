package hackercup;
import java.io.*;
import java.util.*;

public class HC_2015_RQ_C_by_Borys_5 {
	FastScanner in;
	PrintWriter out;

	String dir = "^>v<";
	int[] dx = new int[] { -1, 0, 1, 0 };
	int[] dy = new int[] { 0, 1, 0, -1 };

	void solve() {
		int tc = in.nextInt();
		for (int t = 0; t < tc; t++) {
			out.print("Case #" + (t + 1) + ": ");
			int n = in.nextInt();
			int m = in.nextInt();
			char[][] a = new char[n][];
			for (int i = 0; i < n; i++) {
				a[i] = in.next().toCharArray();
			}
			boolean[][][] can = new boolean[4][n][m];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < n; j++)
					Arrays.fill(can[i][j], true);
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					if (a[i][j] != '.' && a[i][j] != 'S' && a[i][j] != 'G') {
						for (int k = 0; k < 4; k++) {
							can[k][i][j] = false;
						}
					}
					int id = dir.indexOf(a[i][j]);
					if (id != -1) {
						for (int k = 0; k < 4; k++) {
							int x = i, y = j;
							while (true) {
								x = x + dx[id];
								y = y + dy[id];
								if (x < 0 || x == n || y < 0 || y == m)
									break;
								if (a[x][y] != '.' && a[x][y] != 'S'
										&& a[x][y] != 'G') {
									break;
								}
								can[k][x][y] = false;
							}
							id = (id + 1) % 4;
						}
					}
				}
			int[][][] d = new int[4][n][m];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < n; j++) {
					Arrays.fill(d[i][j], Integer.MAX_VALUE);
				}
			int[] qK = new int[n * m * 3];
			int[] qX = new int[n * m * 3];
			int[] qY = new int[n * m * 3];
			int qIt = 0, qSz = 1;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if (a[i][j] == 'S') {
						d[0][i][j] = 0;
						qK[0] = 0;
						qX[0] = i;
						qY[0] = j;
					}
			while (qIt < qSz) {
				int x = qX[qIt];
				int y = qY[qIt];
				int k = qK[qIt++];
				for (int ii = 0; ii < 4; ii++) {
					int nx = x + dx[ii], ny = y + dy[ii];
					int nd = d[k][x][y] + 1;
					if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
						if (can[nd % 4][nx][ny]) {
							if (d[nd % 4][nx][ny] == Integer.MAX_VALUE) {
								d[nd % 4][nx][ny] = nd;
								qX[qSz] = nx;
								qY[qSz] = ny;
								qK[qSz++] = nd % 4;
							}
						}
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			for (int ii = 0; ii < n; ii++)
				for (int jj = 0; jj < m; jj++)
					if (a[ii][jj] == 'G')
						for (int i = 0; i < 4; i++) {
							ans = Math.min(ans, d[i][ii][jj]);
						}
			out.println(ans == Integer.MAX_VALUE ? "impossible" : ans);
			System.err.println((t + 1) + "/" + tc + " done");
		}
	}

	void run() {
		try {
			in = new FastScanner(new File("src/C_in.txt"));
			out = new PrintWriter(new File("src/c_out_Borys_5.txt"));

			solve();

			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void runIO() {

		in = new FastScanner(System.in);
		out = new PrintWriter(System.out);

		solve();

		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return null;
				st = new StringTokenizer(s);
			}
			return st.nextToken();
		}

		boolean hasMoreTokens() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) {
		new HC_2015_RQ_C_by_Borys_5().run();
	}
}