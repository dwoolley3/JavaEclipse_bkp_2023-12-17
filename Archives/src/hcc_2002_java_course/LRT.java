package hcc_2002_java_course;

// LRT.java

import java.awt.*;
public class LRT extends Frame {
  private static final long serialVersionUID = 1L;
  public LRT (String title) { super(title); }
    @SuppressWarnings("deprecation")
    public static void main ( String[] args ) {
       LRT app = new LRT ("Test Plot");
       app.setSize(600,400);
       LoanResults r = new LoanResults(300,200,"First");
       double[] xP = new double[4];
       double[] xI = new double[4];

       xP[0] = 100; xI[0] = 10;
       xP[1] = 105; xI[0] = 5;
       xP[2] = 107.5; xI[0] = 2.48;
       xP[3] = 109; xI[0] = 1.0;
       r.setData(4, xP, xI);
       app.add(r);
       app.show();
     }
}