package hcc_2002_java_course;

// Name:    SimpleLoan.java
// Author:  Doug Woolley
// Date:    8/9/02
// Purpose: Extend the base Loan clas to include Simple Loan

public class SimpleLoan extends Loan
{
  private Payment payments[];
  int np;
  
  public SimpleLoan(double p, double a, int m)
  {
     super(p, a, m);
  }

  public double interestPaid()
  {
    double i;
    double r = getAPR() / 12.0;

    i = getPrincipal() * r * (double)getNMonths();

    return i;
  }

  public double totalPaid()
  {
    return getPrincipal() + interestPaid();
  }

 
  // This method uses dueDate and amt to allocate a new
  // Payment object and adds it to the payments array.
  public void addPayment( String dueDate, double amt ) 
  {
    Payment p = new Payment(dueDate, amt);
    // if (this.np < (this.payments.length() - 1))
    {
      this.payments[this.np] = p;
      this.np++;
    }
  }

  // This method returns the last Payments object
  public Payment lastPayment()
  {
     return payments[np];
  }

  // This method takes the loan principal and interest, 
  // computes the total amount of money repaid over the loan life,
  // and splits it into equal-size payments.
  public void generatePayments()
  {   
  }

  // This method loops through the payments array and calls
  // the print() method for each Payment object retrieved.
  public void printPayments()
  {
  }

}