
public class FixedCapacityStack<Item> {
    private Item[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStack(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty()            {  return (N == 0);                  }
    public boolean isFull()             {  return (N == a.length);           }
    public void push(Item item)         {  a[N++] = item;                    }
    public Item pop()                   {  return a[--N];                    }
  

} 