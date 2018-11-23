package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM534_Div2_L1_EllysDirectoryListing
{
	public String[] getFiles(String[] files)
	{
        int n = files.length;
        if (files[n - 1].equals(".")  && files[n - 2].equals("..")
         || files[n - 1].equals("..") && files[n - 2].equals("."))
            return files;

        for (int i = 0; i < n-2; i++)
            if (files[i].equals(".") || files[i].equals(".."))
            {
                String temp = files[n - 1];
                files[n - 1] = files[i];
                files[i] = temp;
                break;
            }

        for (int i = 0; i < n-2; i++)
            if (files[i].equals(".") || files[i].equals(".."))
            {
                String temp = files[n - 2];
                files[n - 2] = files[i];
                files[i] = temp;
                break;
            }

        return files;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, String[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SRM534_Div2_L1_EllysDirectoryListing obj;
		String[] answer;
		obj = new SRM534_Div2_L1_EllysDirectoryListing();
		long startTime = System.currentTimeMillis();
		answer = obj.getFiles(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p1.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print("\"" + p1[i] + "\"");
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + answer[i] + "\"");
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (!answer[i].equals(p1[i])) {
						res = false;
					}
				}
			}
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		String[] p0;
		String[] p1;
		
		// ----- test 0 -----
		p0 = new String[]{"ContestApplet.jnlp",".","Image.jpg","..","Book.pdf","Movie.avi"};
		p1 = new String[]{"ContestApplet.jnlp","Movie.avi","Image.jpg","Book.pdf","..","."};
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"Image.jpg","..","."};
		p1 = new String[]{"Image.jpg","..","."};
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"..",".","Image.jpg"};
		p1 = new String[]{"Image.jpg",".",".."};
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"No","..","Zaphod",".","Just","very","very...","Improbable"};
		p1 = new String[]{"No","Improbable","Zaphod","very...","Just","very",".",".."};
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"www.topcoder.com","Ever.tried",".","Ever.failed","..","No","Matter.","Try","Again.","Fail","Again..","Fail.Better"};
		p1 = new String[]{"www.topcoder.com","Ever.tried","Fail.Better","Ever.failed","Again..","No","Matter.","Try","Again.","Fail","..","."};
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"This",".","is","tricky","test",".."};
		p1 = new String[]{"This","test","is","tricky","..","."};
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
