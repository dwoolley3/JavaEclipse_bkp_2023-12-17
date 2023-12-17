package dougTest;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphStuff {
	
	public class Edge implements Comparable<Edge> {
		int fr, to, color;

		public Edge(int fr, int to, int color) {
			super();
			this.fr = fr;
			this.to = to;
			this.color = color;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(color, o.color);
		}
	}
	
    static class Edge2 implements Comparable<Edge2> {
        int from, to, col;

        public Edge2(int from, int to, int col) {
            this.from = from;
            this.to = to;
            this.col = col;
        }

        @Override
        public int compareTo(Edge2 o) {
            return col - o.col;
        }

        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", col=" + col + "]";
        }       
    }
    


	public static void main(String[] args) {
		int m = 3;
		ArrayList<Integer>[] byColor = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			byColor[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			byColor[i].add(i);
		}
		
        ArrayList<Integer>[] edges = new ArrayList[m];
        for (int i = 0; i < m; ++i)
            edges[i] = new ArrayList<>();
		
		int n = 3;
		//Edge e = new Edge(1,2,3);
		Edge[] allE = new Edge[n];
		for (int i = 0; i < n; i++) {
			//allE[i] = new Edge(i, i+1, i+2);
		}
	}
}

class GraphUtils {

    public static int[][] getEdgesUndirectedWeighted(int n, int[] v, int[] u) {
        int[][] edges = new int[n][];
        int[] deg = getDegreeUndirected(n, v, u);
        for (int i = 0; i < n; i++) {
            edges[i] = new int[deg[i]];
        }
        int m = v.length;
        Arrays.fill(deg, 0);
        for (int i = 0; i < m; i++) {
            edges[v[i]][deg[v[i]]++] = i;
            edges[u[i]][deg[u[i]]++] = i;
        }
        return edges;
    }

    public static int[] getDegreeUndirected(int n, int[] v, int[] u) {
        int[] deg = new int[n];
        for (int i : v) {
            deg[i]++;
        }
        for (int i : u) {
            deg[i]++;
        }
        return deg;
    }
    
	/// TEMPLATE
	static int gcd(int n, int r) { return r == 0 ? n : gcd(r, n%r); }
	static long gcd(long n, long r) { return r == 0 ? n : gcd(r, n%r); }
	
	static <T> void swap(T[] x, int i, int j) { T t = x[i]; x[i] = x[j]; x[j] = t; }
	static void swap(int[] x, int i, int j) { int t = x[i]; x[i] = x[j]; x[j] = t; }

}

class Pair<U, V> implements Comparable<Pair<U, V>> {
	public final U first;
	public final V second;

	public static <U, V> Pair<U, V> makePair(U first, V second) {
		return new Pair<U, V>(first, second);
	}

	private Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Pair<?, ?> pair = (Pair<?, ?>) o;

		return !(first != null ? !first.equals(pair.first) : pair.first != null)
				&& !(second != null ? !second.equals(pair.second)
						: pair.second != null);

	}

	@Override
	public int hashCode() {
		int result = first != null ? first.hashCode() : 0;
		result = 31 * result + (second != null ? second.hashCode() : 0);
		return result;
	}

	public Pair<V, U> swap() {
		return makePair(second, first);
	}

	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}

	@SuppressWarnings({ "unchecked" })
	public int compareTo(Pair<U, V> o) {
		int value = ((Comparable<U>) first).compareTo(o.first);
		if (value != 0)
			return value;
		return ((Comparable<V>) second).compareTo(o.second);
	}
}


