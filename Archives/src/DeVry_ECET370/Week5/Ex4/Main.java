package Week5.Ex4;

import java.util.ArrayList;

/***********************************
*  Week 5 lab - exercise 4:        *
*   a class that generates hash    *
*   values for Java keywords and   * 
*   determines if there are any key*
*   collisions.                    *
***********************************/

/**
 * Class to test hash function and collisions.
 */
public class Main
{

    public static void main(String[] args)
    {
       
        String[] reservedWords = {"abstract", "assert", "boolean", "break",
    		"byte", "case", "catch", "char", "class", "const", "continue",
    		"default", "do", "double", "else", "enum", "extends", "false",
    		"final", "finally", "float", "for", "goto", "if", "implements",
    		"import", "instanceof", "int", "interface", "long", "native",
    		"new", "null", "package", "private", "protected", "public",
    		"return", "short", "static", "strictfp", "super", "switch",
    		"syncrhonized", "this", "throw", "throws", "transient", "true",
    		"try", "void", "volatile", "while" 
		};

        ArrayList<Integer> hashValues = new ArrayList<>();
        int cntCollisions = 0;
        
        //Display Hash Value for each Java reserved word, and
        //display count of collisions (duplicate hash values among this list)
        System.out.println("--- Display Hash Values for Reserved Words ----");
        for (int i = 0; i < reservedWords.length; i++)
        {        	
        	int hashValue = getHashValueFor(reservedWords[i]);
        	if (hashValues.contains(hashValue))
        		cntCollisions++;
        	hashValues.add(hashValue);
        	System.out.println(reservedWords[i] + " = " + hashValue);
        }
        System.out.println();
        System.out.println("Total collisions = " + cntCollisions);
    }
    
    /**
     * Calculate hash value for a given Java reserved word, using Horner's method.
     * Each character within the word is converted to the character's Unicode value
     * and then added to the product of the current hash tally and g, which is a 
     * special value. Java's class String uses 31 for g.
     *
     * @return hash value for a given Java reserved word
     */
    static private int getHashValueFor(String reservedWord)
    {
    	int hash = 0;
    	int g = 31; //For g = 31, no collisions; for g = 1, 3 collisions; for g = 2, 1 collision
    	int n = reservedWord.length();
    	for (int i = 0; i < n; i++)
    		hash = g * hash + reservedWord.charAt(i);
    	return hash;
    }
}
