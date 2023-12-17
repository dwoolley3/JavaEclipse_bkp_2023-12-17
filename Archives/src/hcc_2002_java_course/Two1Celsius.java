package hcc_2002_java_course;

// Two1Celsius.java: Convert Fahrenheit to Celsius temperature
public class Two1Celsius
{
  // Main method
  public static void main(String[] args)
  {
     double celsius;
     double fahrenheit;
     System.out.print("Enter number of degrees in fahrenheit: ");
     fahrenheit = MyInput.readDouble();
     celsius = (5.0/9)*(fahrenheit-32);
     System.out.println(fahrenheit + " fahrenheit = " + celsius + " celsius degrees");
  }
}
     
