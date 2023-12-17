package week3.Ex3;

/****************************
*  Week 3 lab - exercise 3: *
*   a simple Stack class    *
*   with error messages     *
*   to test whether an input*
*   string is a palindrome  * 
*****************************/

/**
 * Class to test the Stack class.
 */
public class Main
{

    public static void main(String[] args)
    {       
        String[] st = {"Race car", "A man, a plan, a canal: Panama",
        		"banana", "Race cars", "A"};

        //For each string within st array, test if the string is a palindrome.
        //"A palindrome is a string of characters (a word, phrase, or sentence)
        //that is the same regardless of whether you read it forward or backward,
        //assuming that you ignore spaces, punctuation, and case."
        
        for (int i = 0; i < st.length; i++)
        {           
        	if (isPalindrome(st[i]))
        		System.out.println(st[i] + " -- is a palindrome");
        	else
        		System.out.println(st[i] + " -- is NOT a palindrome");
        }
    }
        
    /**
     * Determines whether a string is a palindrome.
     * "A palindrome is a string of characters (a word, phrase, or sentence)
     * that is the same regardless of whether you read it forward or backward,
     * assuming that you ignore spaces, punctuation, and case."
     * 
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str)
    {
    	//Makes all upper case letters lowercase for comparison
    	str = str.toLowerCase(); 
    	
    	//Allocate stack to the size of the length of the string,
    	//which will always be enough since string may contain some
    	//non-letters that are not added to the stack.
    	Stack myStack = new Stack(str.length());  
    	
    	for (char c : str.toCharArray())
    	{
    		//Only place letters onto the stack
    		if ('a' <= c && c <= 'z')
    			myStack.push(c);
    	}
    		
    	//Compare each letter in the original string, in order,
    	//with each element of the stack, given in reverse order.
    	//If every comparison matches, then string is a palindrome.
    	//If any comparison does not match, it is not a palindrome.
    	boolean isPal = true;
    	for (char c : str.toCharArray())
    	{
    		if ('a' <= c && c <= 'z')
    		{
    			if (c != myStack.peek())
    			{
    				isPal = false;
    				break;
    			}
    			//Only need to pop from stack when the string has a letter
    			myStack.pop();
    		}
    	}
    	
    	return isPal;
    }
}
