import java.util.Iterator;  //enables reference to Java's Iterator interface

//"implements Iterable<>" promises to provide an iterator() method
public class Iterable_FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public Iterable_FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty()            {  return (N == 0);                  }
    public boolean isFull()             {  return (N == a.length);           }
    public void push(String item)       {  a[N++] = item;                    }
    public String pop()                 {  return a[--N];                    }
    public Iterator<String> iterator()  { return new ReverseArrayIterator(); }
    //The above code promises to implement a class that implements the
    //hasNext(), next(), and remove() methods that are called when a 
    //client uses the foreach construct.
    
    public class ReverseArrayIterator implements Iterator<String> {    	
        private int i = N-1;

        public boolean hasNext() { return i >= 0; }
        public String next()     { return a[i--]; }
        public void remove()     { throw new UnsupportedOperationException(); }
    }
} 