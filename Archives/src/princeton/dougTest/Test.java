package dougTest;

public class Test {

	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		for (int i = 1; i < 1_000_000_000; i++)	{
			int x = i % 32;
			double a = 1;
			//for loop = 2.00 milleseconds
			//for (int j = 0; j < x; j++)
			//	a *= 2;
			//1 << x takes 0.01 millesconds
			//a = 1 << x;
			//Math.pow(2,x) takes 86.56 milleseconds
			a = Math.pow(2,  x);
			//a = Math.log(i) / Math.log(3);
		}
		long endTime = System.currentTimeMillis();
		System.out.println (endTime + " " + startTime 
				+ " " + (endTime - startTime) / 1000.0 + " millesconds");
	}
}
