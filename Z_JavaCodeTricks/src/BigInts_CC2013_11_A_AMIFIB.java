//import java.io.*;	 // .BufferedReader, .InputStreamReader
import java.util.*;  // .Scanner
import java.math.BigInteger;

class CC2013_11_A_AMIFIB {

	//Java version takes 1/2 the time of the C# version (0.96 vs. 2.12 sec),
	//when programming the actual addition steps for really long numbers.
	//However, using BigInteger addition with ArrayList<BigInteger> without
	//converting them to strings reduces the time in half again: 0.49 sec.!
	//Using a sorted TreeSet<BigInteger> performs the same 0.50 sec.
	 
    public static void main(String[] args) throws Exception
    {
         //4789 Fibonacci numbers having at most 1000 digits
    	 ArrayList<BigInteger> fib = new ArrayList<BigInteger>();  
    	 //TreeSet<BigInteger> fib = new TreeSet<BigInteger>();  
         GenerateFibs(fib);

         Scanner sc = new Scanner(System.in);
         int T = sc.nextInt();         

         BigInteger bigNum;
         for (int t = 0; t < T; t++)
         {
        	 String s = sc.next();
        	 bigNum = new BigInteger(s);
             if (fib.contains(bigNum))
                 System.out.println("YES");
             else
            	 System.out.println("NO");
         }
         sc.close();
    }

    static void GenerateFibs(ArrayList<BigInteger> fib)
    {
         BigInteger f1 = new BigInteger("0");
         BigInteger f2 = new BigInteger("1");
         fib.add(f1); //0 element
         fib.add(f1);
         fib.add(f2);
         BigInteger temp;
         int n = 2;
         //while (f2.toString().length() <= 1000)  //Expensive conversion
         while (n <= 4789)
         {
             temp = f2;
             f2 = f1.add(f2);
             f1 = temp;
             fib.add(f2);
             n++;
         }
    }
 }
