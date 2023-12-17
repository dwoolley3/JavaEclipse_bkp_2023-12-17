package week1.Ex4;

/***********************************
*  Week 1 lab - exercise 4:        *
*   a class bag (multiset) that    *
*   uses an expandable array to    *
*   store bag items. The bag will  *
*   store strings of characters.   *
***********************************/

/**
 * Class to test the oldBag class.
 */
public class Main
{

    public static void main(String[] args)
    {
        Bag myBag = new Bag();
        
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

        for (int i = 0; i < reservedWords.length; i++)
        {
        	myBag.add(reservedWords[i]);
        }

        System.out.println("--- Display entire bag --");
        myBag.print();
        System.out.println();
        System.out.println("Number of items in bag = " + myBag.getLength());
        myBag.add("break");
        myBag.add("abstract");
        myBag.add("abstract");
        System.out.println();
        System.out.println("--- Display entire bag with 3 new words at end --");
        myBag.print();
        System.out.println();
        System.out.println("Count of 'abstract' = " + myBag.count("abstract"));
        System.out.println("Number of items in bag = " + myBag.getLength());
        myBag.removeOne("void");
        myBag.removeAll("abstract");
        myBag.removeOne("break");
        System.out.println();
        System.out.println("--- Display entire bag with several words removed --");
        myBag.print();
        myBag.clear();
        System.out.println();
        System.out.println("oldBag is empty = " + myBag.isEmpty());
        myBag.add("super");
        myBag.add("class");
        System.out.println("--- Display two added words after clearing bag --");
        myBag.print();
    }
}
