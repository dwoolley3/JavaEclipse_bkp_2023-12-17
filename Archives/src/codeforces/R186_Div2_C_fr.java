package codeforces;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.InputStream;

public class R186_Div2_C_fr 
{
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader2 in = new InputReader2(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader2 in, PrintWriter out) {
    	int n = in.nextInt();
		
		int[] a = new int[n];
		long total = 0;
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			total += a[i];
		}
		
		Random rnd = new Random();
		int ra, temp;
		for (int i = 0; i < n; i++) {
			ra = rnd.nextInt(i + 1);
			temp = a[i];
			a[i] = a[ra];
			a[ra] = temp;
		}	
        Arrays.sort(a);

        int num = 1;
        int prod = 1;
        while (prod < n)
        {
            num++;
            prod *= 4;
        }

        long sum = 0;
        prod = 1;
        for (int i = 0; i < num-1; i++)
        {
            for (int j = n-1; j >= n - prod; j--)
                sum += a[j];
            prod *= 4;
        }
        sum += total;
		
		out.println(sum);		
    }
}

class InputReader2 {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader2(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    public long nextLong() {
        return Long.parseLong(next());
    }
}