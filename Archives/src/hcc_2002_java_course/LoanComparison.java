package hcc_2002_java_course;

public class LoanComparison {

  public static void main(String[] args)
  {
     SimpleLoan I1 = new SimpleLoan(10000.0, 0.0725, 48);
     CompoundLoan I2 = new CompoundLoan(10000.0, 0.0725, 48);

     System.out.println("Borrowing $10,000 at 7.25% for 48 months\n");
     System.out.println("Simple interest: $" + I1.interestPaid());
     System.out.println("Compund interest: $" + I2.interestPaid());
  }
}