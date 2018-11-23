package codechef;
//import java.io.*;	 // .BufferedReader, .InputStreamReader
import java.util.*;  // .Scanner

class CC2013_11_A_AMIFIB_orig {

	//Java version takes 1/2 the time of the C# version (0.96 vs. 2.12 sec)
	 static ArrayList<String> fib;
	 
     public static void main(String[] args) throws Exception
     {
         //4789 Fibinocci numbers having at most 1000 digits
         fib = new ArrayList<String>();
         GenerateFibs();

         Scanner sc = new Scanner(System.in);
         int T = sc.nextInt();         
         //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
         //int T = Integer.parseInt(br.readLine());

         for (int t = 0; t < T; t++)
         {
        	 //String s = br.readLine();
        	 String s = sc.next();
             if (fib.contains(s))
                 System.out.println("YES");
             else
            	 System.out.println("NO");
         }
         sc.close();
         //br.close();
     }

     static void GenerateFibs()
     {
         fib.add("0"); //0 element
         fib.add("0");
         fib.add("1");
         int n = 2;
         while (fib.get(n).length() <= 1000)
         {
             n++;
             int len1 = fib.get(n - 1).length();
             int len2 = fib.get(n - 2).length();
             int[] a = new int[len1 + 1];
             int i = 0;
             for (i = 0; i < len2; i++)
             {
                 a[i] += (fib.get(n - 1).charAt(len1-1-i) - '0') 
                     + (fib.get(n - 2).charAt(len2-1-i) - '0');
                 if (a[i] >= 10)
                 {
                     a[i] -= 10;
                     a[i + 1] = 1;
                 }
             }
             if (len1 > len2)
                 a[i] += (fib.get(n - 1).charAt(len1-1-i) - '0');
             if (a[i] == 0) i--; //i as 1st positive value

             StringBuilder sb = new StringBuilder();
             for (int j = i; j >= 0; j--)
                 sb.append(a[j]);
             fib.add(sb.toString());
         }
     }
 }
