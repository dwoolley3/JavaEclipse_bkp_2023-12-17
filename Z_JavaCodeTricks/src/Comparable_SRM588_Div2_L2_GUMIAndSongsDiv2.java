import java.util.Arrays;

//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;

class Node implements Comparable<Node> {
	public int a, b;
	
	public Node(int A, int B) {
		a = A;
		b = B;			
	}
	
	public int compareTo(Node o) {
		return a == o.a ? b - o.b : a - o.a;
	}
}

public class Comparable_SRM588_Div2_L2_GUMIAndSongsDiv2
{

	public int maxSongs(int[] duration, int[] tone, int T)
	{
        int n = duration.length;
        
        Node[] x = new Node[n];
        for (int i = 0; i < n; i++)
        	x[i] = new Node(tone[i], duration[i]);
        Arrays.sort(x);
        for (int i = 0; i < n; i++)
        {
        	tone[i] = x[i].a;
        	duration[i] = x[i].b;
        }
        
//        int temp;
//        for (int i = 0; i < n-1; i++)
//            for (int j = i+1; j < n; j++)
//                if (tone[i] > tone[j])
//                {
//                    temp = tone[i]; tone[i] = tone[j]; tone[j] = temp;
//                    temp = duration[i]; duration[i] = duration[j]; 
//                    duration[j] = temp;
//                }

        int maxcnt = 0;
        for (int bitmask = 0; bitmask < (1 << n); bitmask++)
        {
            int cnt = 0, t = T;
            int priorTone = -1, sum;
            for (int j = 0; j < n; j++)
                if ((bitmask & (1 << j)) > 0)
                {
                    if (priorTone > -1)
                        sum = duration[j] + tone[j] - priorTone;
                    else
                        sum = duration[j];
                    if (t - sum >= 0)
                    {
                        t -= sum;
                        cnt++;
                        priorTone = tone[j];
                    }
                    else
                    {
                        cnt = 0;
                        break;
                    }
                }
            if (cnt > maxcnt) maxcnt = cnt;
        }
        return maxcnt;
	}
	

}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
