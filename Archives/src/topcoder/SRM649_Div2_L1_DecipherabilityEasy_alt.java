package topcoder;
//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM649_Div2_L1_DecipherabilityEasy_alt
{
	public String check(String s, String t)
	{
		for (int i = 0; i < s.length(); i++)
		{
			StringBuilder sb = new StringBuilder();
			if (sb.append(s).deleteCharAt(i).equals(t)) return "Possible";
		}
		return "Impossible";
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
