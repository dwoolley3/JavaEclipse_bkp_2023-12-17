package codechef;
import java.util.*; //Scanner;
//import java.io.IOException;
import java.io.PrintWriter; //PrintWriter

class CC2013_08_A //Name: Chef and The Right Triangles
{
	public static void main(String[] args) throws Exception  {
		//Takes 0.90 seconds
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
        int T = in.nextInt();
        int cnt = 0;
        for (int t = 0; t < T; t++)
        {
			int x1 = in.nextInt();	
			int y1 = in.nextInt();
			int x2 = in.nextInt();	
			int y2 = in.nextInt();
			int x3 = in.nextInt();	
			int y3 = in.nextInt();

            double s1 = Math.sqrt((x2 - x1) * (x2 - x1)
                + (y2 - y1) * (y2 - y1));
            double s2 = Math.sqrt((x3 - x2) * (x3 - x2)
                + (y3 - y2) * (y3 - y2));
            double s3 = Math.sqrt((x1 - x3) * (x1 - x3)
                + (y1 - y3) * (y1 - y3));

            boolean right = false;
            if (s1 > s2 && s1 > s3)
            {
                if (Math.abs(s1 * s1 - s2 * s2 - s3 * s3) < 0.0000001)
                    right = true;
            }
            else if (s2 > s1 && s2 > s3)
            {
                if (Math.abs(s2 * s2 - s3 * s3 - s1 * s1) < 0.0000001)
                    right = true;
            }
            else  //s3 greatest
            {
                if (Math.abs(s3 * s3 - s2 * s2 - s1 * s1) < 0.0000001)
                    right = true;
            }
            if (right) cnt++;
        }           
        out.println(cnt);	
	}
}
