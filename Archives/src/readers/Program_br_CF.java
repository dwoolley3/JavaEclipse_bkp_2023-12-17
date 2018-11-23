package readers;
import java.io.*;

public class Program_br_CF
{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String s = in.readLine();

		System.out.println(s + n);
		in.close();
	}
}
