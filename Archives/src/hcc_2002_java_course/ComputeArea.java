package hcc_2002_java_course;

// ComputeArea.java: Compute the area of a circle
public class ComputeArea
{
  // Main method
  public static void main(String[] args)
  {
     double radius;
     double area;

     // Prompt the user to enter radius
     System.out.print("Enter radius: ");
     radius = MyInput.readDouble();

     // Compute area
     area = radius * radius * 3.14159;

     // Display results
     System.out.println("The area for the circle of radius " +
       radius + " is " + area);
  }
}
     
