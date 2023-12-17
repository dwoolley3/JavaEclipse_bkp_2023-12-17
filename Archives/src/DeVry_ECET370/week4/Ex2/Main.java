package week4.Ex2;

/************************************************
*  Week 4 lab - exercise 2:                     *
*   Problem 3 in the Projects section at the    *
*   end of Chapter 4 in the textbook. Find a    *
*   value of n for which Loop B is faster       *
*   than Loop A, or "Loop A Big".               *
*************************************************/

import java.util.*;

public class Main
{

    public void algorithmA(long n)
    {
    	// Algorithm A
        long sum = 0;
        for (long i = 1; i <= n; i++)
        	sum = sum + i;
        System.out.println(sum);
    }

    public void algorithmB(long n)
    {
    	// Algorithm B
        long sum = 0;
        for (long i = 1; i <= n; i++)
        {
        	for (long j = 1; j <= i; j++)
        		sum = sum + 1;
        } // end for
        System.out.println(sum);
    }

    public void algorithmC(long n)
    {
    	// Algorithm C
        long sum = n * (n + 1) / 2;
        System.out.println(sum);
    }
    
    public void loopA(long n)
    {
    	// Loop A
    	long sum = 0;
    	for (long i = 1; i <= n; i++)
    		for (long j = 1; j <= 10_000; j++)
    			sum = sum + j;    
    	//return sum;
    }
    
    public void loopA_Bigger(long n)
    {
    	// Loop A
    	long sum = 0;
    	for (long i = 1; i <= n; i++)
    		for (long j = 1; j <= 1_000_000; j++)
    			sum = sum + j;    
    	//return sum;
    }
    
    public void loopB(long n)
    {
    	// Loop B
    	long sum = 0;
    	for (long i = 1; i <= n; i++)
    		for (long j = 1; j <= n; j++)
    			for (long k = 1; k <= n; k++)
     			sum = sum + k;    
    	//return sum;
    }
    
    public Main()
    {    	
        //Mathematically, Loop A will take n * 10,000 units of time
        //and Loop B will take n * n * n (or n^3) units of time,
        //and the units of time are equal when n = 100. 
        //When n < 100, Loop B takes less time than Loop B
        //When n > 100, Loop A takes less time than Loop B
        //The following experiment verifies this mathematical analysis:
        
    	int mid = 100;  // Threshold for comparing Loop A and Loop B
    	//int mid = 1000; // Threshold for comparing Loop A Big and Loop B
    	
        for (int n = mid - 90; n <= mid + 100; n += 10)
        {
        	System.out.print("n = " + n);
        	
        	// Call Loop A and get elapsed time
        	Date current = new Date();
        	long startTime = current.getTime();
      	
        	loopA(n);           //Uses constat 10_000
        	//loopA_Bigger(n);    //Uses constant 1_000_000          
      	
        	current = new Date();
        	long stopTime = current.getTime();
        	long elapsedTimeA = stopTime - startTime;
        	System.out.print(", Loop A: Elapsed time = " + elapsedTimeA);
        	
        	// Call Loop B and get elapsed time
        	current = new Date();
        	startTime = current.getTime();
      	
        	loopB(n);        	          
      	
        	current = new Date();
        	stopTime = current.getTime();
        	long elapsedTimeB = stopTime - startTime;
        	System.out.print(", Loop B: Elapsed time = " + elapsedTimeB);
        	
        	// Display the loop that was quicker
        	if (elapsedTimeA < elapsedTimeB)
        		System.out.println(", Loop A was quicker ");
        	else if (elapsedTimeA > elapsedTimeB)
        		System.out.println(", Loop B was quicker ");
        	else 
        		System.out.println(", Loop A and B were the same ");          
        }
        
        
//        Scanner in = new Scanner(System.in);
//
//        System.out.print("Enter a number: ");
//        int n = in.nextInt();
//        
//        if (n > 0)
//        {           
//            // Call Algorithm A and get elapsed time
//        	Date current = new Date();
//        	long startTime = current.getTime();
//        	
//        	System.out.print("Algorithm A: Sum of first " + n + " integers is ");
//        	algorithmA(n);        	          
//        	
//            current = new Date();
//            long stopTime = current.getTime();
//            long elapsedTimeA = stopTime - startTime;
//            System.out.println("Elapsed time for Algorithm A: " + elapsedTimeA);
//            
//            // Call Algorithm B and get elapsed time
//            current = new Date();
//        	startTime = current.getTime();    
//        	
//            System.out.print("Algorithm B: Sum of first " + n + " integers is ");
//        	algorithmB(n);             
//        	
//            current = new Date();
//            stopTime = current.getTime();
//            long elapsedTimeB = stopTime - startTime;
//            System.out.println("Elapsed time for Algorithm B: " + elapsedTimeB);
//
//            // Call Algorithm C and get elapsed time
//            current = new Date();
//        	startTime = current.getTime();
//
//            System.out.print("Algorithm C: Sum of first " + n + " integers is ");
//            algorithmC(n);
//            
//            current = new Date();
//            stopTime = current.getTime();
//            long elapsedTimeC = stopTime - startTime;
//            System.out.println("Elapsed time for Algorithm C: " + elapsedTimeC);
//        }
//        else
//            System.out.println("Input Error!");
    }

    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Main myAppl = new Main();
    }
}
