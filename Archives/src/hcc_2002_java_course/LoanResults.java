package hcc_2002_java_course;

// Program: LoanResults.java
// Author:  Doug Woolley
// Date:    8/12/02
// Purpose: Generate results output for a given loan.
//          Results include total money paid and a plot,
//          over the life of the loan, of the percentage of
//          payment going to interest and to principal.

import java.awt.*;
//import java.awt.event.*;

public class LoanResults extends Component
{
  private static final long serialVersionUID = 1L;
  private double[] p_interest, p_principal;
  //private double pMin, pMax, iMin, iMax;
  private double totalPaid, totalInterest;
  private int N, width, height;
  @SuppressWarnings("unused")
  private String title;

  public LoanResults( int width, int height, String title )
  {
     this.width  = width;
     this.height = height;
     this.title  = title;
  }

  // These two methods tell the layout manager how big
  // to make the component.

  public Dimension getPreferredSize()
  {
    return new Dimension( width, height );
  }

  public Dimension getMinimumSize()
  {
    return new Dimension( width, height );
  }

  // Sets the data to be used after passing two arrays 
  // and the number of elements.
 
  public void setData( int N, double[] prin, double[] intrst )
  {
    int i;
    double totalPayment;

    totalPaid = 0;
    totalInterest = 0;
    this.N = N;
    // Allocate arrays to store percentage of interest/principal
    p_interest = new double[N];
    p_principal = new double[N];

    // Convert the principal and interest into a percentage
    // such that the total of the two is equal to 1.00.
    // These amounts will be multiplied by a scale factor later.
    for ( i = 0; i<N; i++ )
    {
       totalPayment   = prin[i] + intrst[i];
       p_principal[i] = prin[i]/totalPayment;
       p_interest[i]  = intrst[i]/totalPayment;

       totalPaid += totalPayment;
       totalInterest += intrst[i];
    }
  }

  // Displays info
  public void paint( Graphics g )
  {
     int middle = width/2;
     int orig_H, orig_V;
     int i;

     // Fill Rectangle with white color to remove previous data
     g.setColor( Color.WHITE );
     g.fillRect(0,0, width, height);
     g.setColor( Color.BLACK );

     double tp = (double)Math.round(totalPaid*100) / 100.0;
     double ip = (double)Math.round(totalInterest*100) / 100.0;
     String strTotalPaid = "$" + tp;
     String strIntPaid = "$" + ip;
     
     double pay = (double)Math.round(tp/N*100+0.49) / 100.0;
     double lastPay = tp - (pay * (N-1));
     lastPay = (double)Math.round(lastPay * 100) / 100.0;
     if (N < 1) { N = 1; }
     String strPayment = (N-1) + " payments of $" + pay;
     String strLastPay = "Last payment of $" + lastPay;
     
  
     // Draw strings for the total paid and total interest
     // Positioning is x, y, where y is from the top.
     g.drawString( "Total Paid:", 20, 45);
     g.drawString( strTotalPaid, 80, 45);
     g.drawString( "Total Interest:", 3, 65);
     g.drawString( strIntPaid, 80, 65);
     g.drawString( strPayment, 3, 85);
     g.drawString( strLastPay, 3, 105);
 
     // Now draw the plot.  The rectangle is bounded by:
     //
     // middle, 10                 (upper left point of y-axis)
     // width - 10, height - 10    (lower right point of x-axis)

     orig_H = middle;
     orig_V = height - 10;

     g.drawLine( orig_H, 10, orig_H, orig_V );
     g.drawLine( orig_H, orig_V, width - 10, orig_V);

     // Draw title with Principal in BLUE and Interest in GREEN
     g.setColor( Color.BLACK );
     g.drawString("Percentage of", orig_H + 7, 9);
     g.setColor( Color.BLUE );
     g.drawString("Principal", orig_H + 86, 9);
     g.setColor( Color.BLACK );
     g.drawString("vs.", orig_H + 137, 9);
     g.setColor( Color.GREEN );
     g.drawString("Interest", orig_H + 155, 9);
  
     // Compute the actual width of the horizontal axis 
     // and the actual height of the veritical axis
     int plotAreaWidth = (width - 10) - orig_H;
     int plotAreaHeight  = orig_V - 10;
     double h_increment = (double)plotAreaWidth / (double)(N-1);
    
     // Draw plotted graph based on array elements. 
     // BLUE is for principal; GREEN is for interest

     int prev_v1 = orig_V, prev_v2 = orig_V;
     int v1, v2;
     double prev_h = (double)orig_H;
     double h      = (double)orig_H + h_increment;

    	prev_v1 = (int)Math.round((double)plotAreaHeight*p_principal[0]);
     	prev_v2 = (int)Math.round((double)plotAreaHeight*p_interest[0]);

     for( i=1; i<N; i++ )
     {
       v1 = (int)Math.round((double)plotAreaHeight*p_principal[i]);
       v2 = (int)Math.round((double)plotAreaHeight*p_interest[i]);

       g.setColor( Color.BLUE );
       g.drawLine( (int)prev_h, orig_V - prev_v1, (int)h, orig_V - v1 );
       g.setColor( Color.GREEN );
       g.drawLine( (int)prev_h, orig_V - prev_v2, (int)h, orig_V - v2 );

       prev_h = h;
       prev_v1 = v1;
       prev_v2 = v2;

       h += h_increment;
    }
  }
}
