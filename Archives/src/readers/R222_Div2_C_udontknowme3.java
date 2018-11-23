package readers;
import java.util.*; //Scanner;
import java.io.*; //PrintWriter

public class R222_Div2_C_udontknowme3 {

    public static void main(String[] args) throws IOException {
    	R222_Div2_C_udontknowme3 solver = new R222_Div2_C_udontknowme3();
        solver.solve();
    }

    private void solve() throws IOException {
        FastScanner sc = new FastScanner(System.in);
//        sc = new FastScanner("3 4 2\n" +
//                "#..#\n" +
//                "..#.\n" +
//                "#...\n");
//        sc = new FastScanner("5 4 5\n" +
//                "#...\n" +
//                "#.#.\n" +
//                ".#..\n" +
//                "...#\n" +
//                ".#.#\n");

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        char[][] f = new char[n][];
        for (int i = 0; i < n; i++) {
            f[i] = sc.next().toCharArray();
        }

        int free = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (f[i][j] == '.') free++;
            }
        }

        char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = f[i][j] == '#' ? '#' : 'X';
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        LinkedList<Integer> frontier = new LinkedList<Integer>();

        OUTER:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (f[i][j] == '.') {
                    frontier.add(i);
                    frontier.add(j);
                    break OUTER;
                }
            }
        }

        while (!frontier.isEmpty()) {
            if (free <= k) break;

            int y = frontier.removeFirst();
            int x = frontier.removeFirst();

            if (g[y][x] != 'X') continue;

            g[y][x] = '.';

            free--;

            for (int i = 0; i < dx.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && g[ny][nx] == 'X') {
                    frontier.add(ny);
                    frontier.add(nx);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
    }

    private static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream in) throws IOException {
            br = new BufferedReader(new InputStreamReader(in));
        }

        @SuppressWarnings("unused")
		public FastScanner(File file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        @SuppressWarnings("unused")
        public FastScanner(String s) {
            br = new BufferedReader(new StringReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                    return "";
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        @SuppressWarnings("unused")
        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}