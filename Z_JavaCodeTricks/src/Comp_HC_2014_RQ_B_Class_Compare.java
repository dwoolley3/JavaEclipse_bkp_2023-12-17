
import java.io.*;
import java.util.*; //Scanner;


class Player implements Comparable<Player>
{
    public String nam;
    public int percent;
    public int height;
    public int minPlayed;
    public boolean inGame;
    public Player(String nam, int percent, int height)
    {
        this.nam = nam;
        this.percent = percent;
        this.height = height;
        this.minPlayed = 0;
        this.inGame = false;
    }
    //Comparable interface: sort using a type's natural order.
    //The type Player must implement the inherited abstract method
    //Comparable<Player>.compareTo(Player)
    public int compareTo(Player that)
    {
    	 if (this.percent > that.percent) return -1;
	     if (this.percent < that.percent) return 1;
	     if (this.percent == that.percent)
	         if (this.height > that.height) return -1; else return 1;
	     return 0;    
    }
}

public class Comp_HC_2014_RQ_B_Class_Compare
{   
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("src/HC_2014_RQ_B_input_ex.txt"));
		PrintWriter pw = new PrintWriter("src/HC_2014_RQ_B_output_ex.txt");

		int t = sc.nextInt();  
		for (int tc = 1; tc <= t; tc++)
		{
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            
            String nam;
            int percent, height;
            Player[] player = new Player[n];
            for (int i = 0; i < n; i++)
            {
                nam = sc.next();
                percent = sc.nextInt();
                height = sc.nextInt();
                player[i] = new Player(nam, percent, height);
            }

            //Sort according to highest percent then height (total)
            //C#: Array.Sort<Player>(player, new Comparison<Player>(Compare));
            Arrays.sort(player);
            //Comparator interface: sort using an alternate order, from the one
            //established by default or by Comparable<>.compareTo()
			Arrays.sort(player, new Comparator<Player>()
			{
				 @Override
		            public int compare(Player a, Player b) {
				        //Sort according to highest percent then height (total)
				        if (a.percent > b.percent) return -1;
				        if (a.percent < b.percent) return 1;
				        if (a.percent == b.percent)
				            if (a.height > b.height) return -1; else return 1;
				        return 0;
		            }
			});

            //Rank is index of 0..n-1. Team 0 has even indexes; Team 1 has odd indexes

            boolean[] teamMoreThanP = new boolean[2];
            teamMoreThanP[0] = (n / 2 + (n% 2) > p);
            teamMoreThanP[1] = (n / 2 > p);
            for (int i = 0; i < 2 * p; i++)
            {
                player[i].minPlayed++;
                player[i].inGame = true;
            }

            for (int rotation = 1; rotation <= m; rotation++)
            {
                for (int team = 0; team <= 1; team++) 
                    if (teamMoreThanP[team])
                    {
                        int chooseIn = -1, chooseOut = -1;
                        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                        for (int i = team; i < n; i += 2)
                            if (player[i].inGame && player[i].minPlayed >= max)
                            {
                                max = player[i].minPlayed;
                                chooseOut = i;
                            }
                            else if (!player[i].inGame && player[i].minPlayed < min)
                            {
                                min = player[i].minPlayed;
                                chooseIn = i;
                            }
                        player[chooseIn].inGame = true;
                        player[chooseOut].inGame = false;
                    }
                for (int i = 0; i < n; i++)
                    if (player[i].inGame) player[i].minPlayed++;
            }

            String[] namesInGame = new String[2 * p];
            int k = 0;
            for (int i = 0; i < n; i++)
                if (player[i].inGame) namesInGame[k++] = player[i].nam;
            
            Arrays.sort(namesInGame);
            String ans = "";
            for (String st : namesInGame) ans += st + " ";
            ans.trim();
			pw.println("Case #" + tc + ": " + ans);
		}

		pw.close();
		sc.close();
	}
}