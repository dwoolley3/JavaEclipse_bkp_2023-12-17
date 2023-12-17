package dougTest;
import java.util.*;

public class Employee_Comparable_and_Iterator implements Comparable<Object> {
 
    int EmpID;
     String Ename;
     double Sal;
     static int i;
 
    public Employee_Comparable_and_Iterator() {
         EmpID = i++;
         Ename = "dont know";
         Sal = 0.0;
     }
 
    public Employee_Comparable_and_Iterator(String ename, double sal) {
         EmpID = i++;
         Ename = ename;
         Sal = sal;
     }
 
    public String toString() {
         return "EmpID " + EmpID + "\n" + "Ename " + Ename + "\n" + "Sal " + Sal;
     }
 
    public int compareTo(Object o1) {
         if (this.Sal == ((Employee_Comparable_and_Iterator) o1).Sal)
             return 0;
         else if ((this.Sal) > ((Employee_Comparable_and_Iterator) o1).Sal)
             return 1;
         else
             return -1;
    }
 
	public static void main(String[] args) {
 
    	List<Employee_Comparable_and_Iterator> ts1 = new ArrayList<Employee_Comparable_and_Iterator>();
        ts1.add(new Employee_Comparable_and_Iterator ("Tom",40000.00));
        ts1.add(new Employee_Comparable_and_Iterator ("Harry",20000.00));
        ts1.add(new Employee_Comparable_and_Iterator ("Maggie",50000.00));
        ts1.add(new Employee_Comparable_and_Iterator ("Chris",70000.00));
        Collections.sort(ts1);
        Iterator<Employee_Comparable_and_Iterator> itr = ts1.iterator();
 
        while(itr.hasNext()){
             Object element = itr.next();
             System.out.println(element + "\n");
             
         } 
    }
 } 
