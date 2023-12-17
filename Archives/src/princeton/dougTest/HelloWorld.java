package dougTest;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.print("Hello! What is your name: ");
		String name = MyInput.readString();
		System.out.println(name + ", that is a nice name.");
		System.out.print("What is your age: ");
		int age = MyInput.readInt();
		System.out.println(name + ", it's hard to believe you are " + age
				+ " years old");
	}

}
