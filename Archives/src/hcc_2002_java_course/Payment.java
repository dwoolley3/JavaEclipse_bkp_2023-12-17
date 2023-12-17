package hcc_2002_java_course;

// Program: Payment.java
// Author:  Doug Woolley
// Date:    8/10/02
// Purpose: Generate payment coupon book that contains
//          the payment due date and the payment amount.

public class Payment
{
   private String dueDate;
   private double amt;
   public Payment (String d, double a)
   {
     this.dueDate = d;
     this.amt = a;
   }  
   public String getDueDate() { return this.dueDate; }
   public void setDueDate(String d) { this.dueDate = d; }
   public double getAmut() { return this.amt; }
   public void setAmt(double a) { this.amt = a; }
   public void print()
   { System.out.println (this.dueDate + " " + this.amt); }
   public String toString()
   { String s = this.dueDate + " " + this.amt;
     return s;
   }
}