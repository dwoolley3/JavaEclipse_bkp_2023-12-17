package topcoder;
import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;


public class SRM669_Div2_L1c_LiveConcert
{
	public int maxHappiness(int[] h, String[] s)
	{
		int n = s.length, sum = 0;
		Map<String,Integer> hm = new HashMap<String,Integer>();
		for (int i = 0; i < n; i++)
		{
			if (hm.get(s[i]) == null || hm.get(s[i]) < h[i])
				hm.put(s[i], h[i]);
		}
		for (String st : hm.keySet())
			sum += hm.get(st);
		return sum;
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
