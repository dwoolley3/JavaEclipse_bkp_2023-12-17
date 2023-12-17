package dougTest;

import java.io.*;

public class MyInput {
	// Read a string from the keyboard
	public static String readString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Get the string from the keyboard
		String st = "";
		try {
			st = br.readLine();
		} catch (IOException ex) {
			System.out.println(ex);
		}
		return st;
	}

	// Read an int value from the keyboard
	public static int readInt() {
		return Integer.parseInt(readString());
	}

	// Read an double value from the keyboard
	public static double readDouble() {
		return Double.parseDouble(readString());
	}
}
