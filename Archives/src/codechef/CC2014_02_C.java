package codechef;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

class CC2014_02_C
{
	public static void main(String[] args) throws Exception {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
		//*********** Wrong answer ??? ***
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		int n = in.nextInt();	
		
		int[] m = new int[n];
		ArrayList<Integer> ms = new ArrayList<Integer>();
		int[] f = new int[n];
		ArrayList<Integer> fs = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
		{
			m[i] = in.nextInt();	
			f[i] = in.nextInt();	
			ms.add(m[i]); fs.add(f[i]);
		}
		Collections.sort(ms);
		Collections.sort(fs);

		int mInd, fInd;
		long sum = 0;
		for (int i = 0; i < n; i++)
		{
			mInd = ms.indexOf(m[i]); //ind<0 nf
			fInd = fs.indexOf(f[i]);
			sum += Math.abs(mInd - fInd);
			ms.remove(mInd);
			fs.remove(fInd);
		}
		out.println(sum);
	}
}
