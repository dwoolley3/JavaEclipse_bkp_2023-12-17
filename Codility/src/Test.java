import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
	public void roar (String roar1, StringBuilder roar2) {
		roar1.concat("!!!");
		roar2.append("!!!");
	}
	public static void main(String[] args) {
		String roar1 = "roar";
		StringBuilder roar2 = new StringBuilder("roar");
		new Test().roar(roar1, roar2);
		System.out.println(roar1 + " " + roar2);		
		
		String s1 = "java";
		StringBuilder s2 = new StringBuilder("java");
		
		//if (s1 == s2) 
		//	System.out.println("2");
		
		System.out.println(ZonedDateTime.now());
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		
		LocalDate date1 = LocalDate.of(2019,4, 1);
		LocalDate date2 = LocalDate.of(2019, Month.DECEMBER , 1);
		date2 = date2.minusYears(2019).minusDays(335);
		System.out.println(date1);
		System.out.println(date2);
		
		Period p = Period.ofMonths(1);
		p = p.plusDays(3).plusMonths(4).plusYears(4);
		System.out.println(p);
		date2 = date2.plus(p);
		if (date1.isBefore(date2)) 
			System.out.println("Before");
		else if (date1.isAfter(date2))
			System.out.println("After");
		
		LocalDateTime ldt = LocalDateTime.of(2019, 01, 21, 18, 01);
		System.out.println(ldt);
		
		System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(ldt));
		DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
		System.out.println(ldt.format(myFormatter));
		System.out.println(myFormatter.format(ldt));
		
//		List<String> list = new ArrayList<>();
//		list.add("10");
//		list.add("500");
//		int x = Collections.binarySearch(list, "500");
//		//System.out.println(x);
//		
//		long startTime = System.currentTimeMillis();
//		for (int i = 0; i < 2_000_000_000; i++) {x++;}
//		long totalTime = System.currentTimeMillis() - startTime;
//		System.out.println(totalTime);
		
//		String[] strings = {"StringValue", "Doug", "Craig"};
//		Object[] objects = strings;
//		String[] againStrings = (String[]) objects;
//		//ArrayList<Object> al = new ArrayList();
//		List<Object> al = new ArrayList<>();
//		al.add(1);
//		al.add("String");
//		System.out.println(strings);
//		System.out.println(al);
//		System.out.println(al.get(0));
//		System.out.println(al.get(1));
//		
//		Integer primitive = Integer.parseInt("132");
//		Integer pri = Integer.valueOf("123");
//		Integer[] a = {1,2,3,4};
//		List<Integer> al2 = new ArrayList<>();
//		//Integer[] obj = (Integer[])al2.toArray();
//		al2 = Arrays.asList(a);
//		System.out.println(al2);
//		

//		
//		int oct = 010, hex = 0X10, bin = 0B10, sum = oct+hex+bin;
//		System.out.println(oct + " " + hex + " " + bin + " " + sum);
//		System.out.println(Integer.toOctalString(sum));
//		System.out.println(Integer.toHexString(sum));
//		System.out.println(Integer.toBinaryString(sum));
//		final double hexPi = 0x1.8p1; // p is hex floating point num, 1.5 dec x 2^1 = 3.0
//		System.out.println(hexPi);
//		int x = 1;
//		int y = ++x * 5 / x--;
//		System.out.println(x + " " + y);
//		x = 5;
//		y = x = 3;
//		System.out.println(x + " " + y);
//		x = 10;
//		x = x++;
//		System.out.println(x);
//		x = 128;
//		byte b = (byte)x;
//		System.out.println(b);
//		double x2 = 44.25234253535354345354;
//		float y2 = 3.35f;
//		float z = y2 + y2;
//		float f2 = (float)x2;
//		System.out.println(f2);
		
//      int x = 1.0; // does not compile
//      short y = 19812345;
//      int z = 9f;
//      long t = 1923012345678910;

//      int x = (int)1.0;
//      short y = (short)19812345;
//      int z = (int)9f;
//      long t = 1923012345678910L;
//
//      System.out.println("x= " + x);
//      System.out.println("y= " + y);
//      System.out.println("z= " + z);
//      System.out.println("t= " + t);
//
//      // overflow and underflow with byte (-128 to 127)
//      byte myByte = 127;
//      byte mySecondByte = -128;
//
//      System.out.println("myByte= " + myByte);
//      System.out.println("mySecondByte= " + mySecondByte);
//
////      myByte = myByte + 1;
//      myByte++;
//
////      mySecondByte = mySecondByte - 1;
//      mySecondByte--;
//
//      System.out.println("myByte= " + myByte);
//      System.out.println("mySecondByte= " + mySecondByte);
//
//      short a3 = 10;
//      short b3 = 20;
//      short c = (short)(a3 *  b3);
//      System.out.println("c= " + c);
//      
//      int x2; boolean b2;
//      System.out.println(x2 + " " + b2);
		
//		Integer a = new Integer(127);
//		Integer b = new Integer(127);
//		Integer b2 = 127;
//		boolean c = b==b2;
//		c = b.equals(b2);
//		System.out.println(c);
//		for (short i = -129; i < 129; i++) {
//			Short a = i;
//			Short b = i;
//			boolean c = a==b;
//			//c = b.equals(b2);
//			System.out.println(i + " " + c);			
//		}
//		String s = "abce";
//		String t = "abce";
//		System.out.println(s == t);
//		char letter = 65;
//		int myInt = letter + 3;
//		char myNewLetter = ++letter;
//		System.out.println(myNewLetter);
//		for(int i=1;i<5;i++);;;

		//StringBuilder sb = new StringBuilder("Doug");
//		int[] a = {1,2,3};
//		
//		my_loop2:
//		if (a.length == 3) {
//			System.out.println(3);
//		}
//			
//		my_loop:
//			for (int b : a) {
//			b = 5;
//			if (b==5) continue my_loop;
//			System.out.println(b);
//
//		}
//		System.out.println(Arrays.toString(a));
//		
//		Arrays.sort(a);
//		int[] random = {3,6,-4,12,0,-10,3};
//		int x = 12;
//		int y = Arrays.binarySearch(random, x);
//		System.out.println(y);
//		int[] arr1;
//		int[] arr2 = new int[3];
//		char[] arr3 = {'a','b'};
//		arr1=arr2;
//		arr1=arr3;
//		System.out.println(arr1[0]+":"+arr1[1]);
	}
}
