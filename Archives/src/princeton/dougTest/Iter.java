package dougTest;

import java.util.*;

public class Iter<T> implements Iterable<T> {
	private T[] a = (T[]) new Object[2];	
	private int N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	public void push(T item) {
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public T pop() {
		T item = a[--N];
		// a[N] = null;
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<T> {
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public T next() {
			return a[--i];
		}

		public void remove() {
		}
	}

	public static void main(String[] args) {
		ResizingArrayStack<Integer> s = new ResizingArrayStack();
		for (int i = 1; i < 9; i++)
			s.push(i);
		for (int x : s)
			System.out.print(x + " ");
		System.out.println();

		// while (!StdIn.isEmpty()) {
		// int item = Integer.parseInt(StdIn.readString());
		// if (item != 0) s.push(item);
		// else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		// }
		// StdOut.println("(" + s.size() + " left on stack)");

		int[] a = { 1, 2, 3, 4 };
		int[] b = { 5, 6, 7, 8, 9 };
		for (int x : a)
			System.out.print(x);
		System.out.println();
		for (int x : b)
			System.out.print(x);
		System.out.println();

		ArrayList<String> al = new ArrayList<String>();
		// add elements to the array list
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");

		for (String st : al)
			System.out.print(st + " ");
		System.out.println();

		// Use iterator to display contents of al
		System.out.print("Original contents of al: ");
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();

		// Modify objects being iterated
		ListIterator<String> litr = al.listIterator();
		while (litr.hasNext()) {
			Object element = litr.next();
			litr.set(element + "+");
		}
		System.out.print("Modified contents of al: ");
		itr = al.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}
		System.out.println();

		// Now, display the list backwards
		System.out.print("Modified list backwards: ");
		while (litr.hasPrevious()) {
			Object element = litr.previous();
			System.out.print(element + " ");
		}
		System.out.println();

	}

}
