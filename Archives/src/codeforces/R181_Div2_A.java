package codeforces;
import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R181_Div2_A //Name: Array
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
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		ArrayList<Integer> n2 = new ArrayList<Integer>();
		ArrayList<Integer> n3 = new ArrayList<Integer>();
		int a;		
		for (int i = 0; i < n; i++)
		{
			a = in.nextInt();
			if (a == 0)
				n3.add(a);
			else if (a < 0)
				n1.add(a);
			else // a > 0
				n2.add(a);
		}
		if (n1.size() % 2 == 0)
		{
			//Place one negative to 0 area
			n3.add(n1.get(n1.size()-1));
			n1.remove(n1.size()-1);
		}
		if (n2.size() == 0) //need 2 negatives
		{
			n2.add(n1.get(n1.size()-1));
			n2.add(n1.get(n1.size()-2));
			n1.remove(n1.size()-1);
			n1.remove(n1.size()-1);
		}
			
		printNums(n1,out);
		printNums(n2,out);
		printNums(n3,out);	
	}
	
	private static void printNums(ArrayList<Integer> nums, PrintWriter out)
	{
		out.print(nums.size());
		for (int i : nums)
			out.print(" " + i);		
		out.println();
	}
}
