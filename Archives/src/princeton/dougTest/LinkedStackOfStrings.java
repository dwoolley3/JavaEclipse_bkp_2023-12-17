package dougTest;

import java.util.NoSuchElementException;

public class LinkedStackOfStrings {

	private Node first = null;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		String item = first.item;
		first = first.next;
		return item;
	}

	public static void main(String[] args) {
		LinkedStackOfStrings ls = new LinkedStackOfStrings();
		for (int i = 1; i < 10; i++) {
			String s = i + "";
			System.out.print(s);
			ls.push(s);
		}
		System.out.println();
		while (!ls.isEmpty())
			System.out.print(ls.pop() + " ");
	}
}