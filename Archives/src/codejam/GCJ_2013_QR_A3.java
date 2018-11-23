package codejam;
import java.io.*;
import java.util.*; //Scanner;


public class GCJ_2013_QR_A3
{
	public static void main(String[] args) throws IOException
	{
		Scanner      in = new Scanner(new FileReader("src/A_input_sm.txt")); //A_input.txt"));
		PrintWriter out = new PrintWriter("src/A_output_sm.txt");

		int T = in.nextInt();  
		in.nextLine(); //use after a nextInt() and prior to reading another in.nextLine()

		for (int tc = 1; tc <= T; tc++)
		{
            boolean notFinished = false;
            String[] b = new String[4];
            for (int i = 0; i < 4; i++)
            {
                b[i] = in.nextLine();
                if (b[i].contains("."))
                    notFinished = true;
            }           

            
            String ans = "";
            char[] p = new char[] { 'X', 'O' };

            //Check rows
            for (int j = 0; j < 2; j++)
            {
                for (int r = 0; r < 4; r++)
                {
                    int inRow = 0;
                    for (int c = 0; c < 4; c++)
                    {
                        char ch = b[r].charAt(c);
                        if (ch == p[j] || ch == 'T')
                            inRow++;
                    }
                    if (inRow == 4)
                    {
                        ans = p[j] + " won";
                        break;
                    }
                }
            }

            //Check cols
            if (ans == "")
            {
                for (int j = 0; j < 2; j++)
                {
                    for (int c = 0; c < 4; c++)
                    {
                        int inCol = 0;
                        for (int r = 0; r < 4; r++)
                        {
                            char ch = b[r].charAt(c);
                            if (ch == p[j] || ch == 'T')
                                inCol++;
                        }
                        if (inCol == 4)
                        {
                            ans = p[j] + " won";
                            break;
                        }
                    }
                }
            
            }

            //Check diag
            if (ans == "")
            {
                for (int j = 0; j < 2; j++)
                {
                    int inDiag = 0;
                    for (int r = 0; r < 4; r++)
                    {
                        char ch = b[r].charAt(r);
                        if (ch == p[j] || ch == 'T')
                            inDiag++;
                    }
                    if (inDiag == 4)
                    {
                        ans = p[j] + " won";
                        break;
                    }

                    inDiag = 0;
                    for (int r = 0; r < 4; r++)
                    {
                        char ch = b[r].charAt(3 - r);
                        if (ch == p[j] || ch == 'T')
                            inDiag++;
                    }
                    if (inDiag == 4)
                    {
                        ans = p[j] + " won";
                        break;
                    }
                }
            }

            if (ans == "")
                ans = notFinished ? "Game has not completed" : "Draw";
                            		
			System.out.println("Case #" + tc + ": " + ans);
			out.println("Case #" + tc + ": " + ans);
			
            @SuppressWarnings("unused")
			String empty = in.nextLine();
		}

		out.close();
		in.close();
	}
}