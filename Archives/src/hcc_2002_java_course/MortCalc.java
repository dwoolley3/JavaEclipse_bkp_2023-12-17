package hcc_2002_java_course;

// Name:     MortCalc.java
// Author:   Douglas Woolley
// Date:     8/12/02
// Purpose:  This program will produce a GUI Mortgage Calculator.

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MortCalc extends Frame
{
  private static final long serialVersionUID = 1L;
  //private SimpleLoan         sloan;
  //private CompoundLoan       cloan;
  private static LoanResults lr;

  public MortCalc (String title)
  {
    super(title);
  }

  @SuppressWarnings("deprecation")
public static void main (String[] args)
  {
    final MortCalc app =
      new MortCalc("GUI Mortgage Calculator - by Doug Woolley");
 
    lr = new LoanResults(400, 200, "First");

    // Prepare the menu bar
    MenuBar mb = new MenuBar();
    Menu file  = new Menu("File");

    MenuItem fNew  = new MenuItem ("New");
    MenuItem fOpen = new MenuItem ("Open");
    MenuItem fSave = new MenuItem ("Save");
    MenuItem fQuit = new MenuItem ("Quit");

    fNew.setActionCommand("NEW");
    fOpen.setActionCommand("OPEN");
    fSave.setActionCommand("SAVE");
    fQuit.setActionCommand("QUIT");

    file.add( fNew );
    file.add( fOpen );
    file.add( fSave );
    file.addSeparator();
    file.add( fQuit );
 
    mb.add( file );

    // Generate the components
    final TextField fPrin = new TextField( "", 15 );
    Label lPrin = new Label( "Principal" );
  
    final TextField fAPR = new TextField( "", 10);
    Label lAPR = new Label( "APR" );

    final TextField fMo = new TextField( "", 5);
    Label lMo = new Label( "# months" );

    final Checkbox cb = new Checkbox ("Compound Interest");

    fNew.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
          if ( cmd.equals("NEW") )
          {
            fPrin.setText("");
            fAPR.setText("");
            fMo.setText("");
            // If checkbox is selected (true), then deselect it.
            if (cb.getState()) { cb.setState(false); }
 
            System.out.println("Wants a new loan");
          }
       }
   });

   fOpen.addActionListener( new ActionListener() {
     public void actionPerformed( ActionEvent e ) {
       String cmd = e.getActionCommand();
       if (cmd.equals("OPEN") )
       {
         System.out.println("Wants an existing loan");
         FileDialog fd = new FileDialog( app, "Open a loan",
                                         FileDialog.LOAD );
         fd.setDirectory("C:/");
         fd.show();
         String fullName = fd.getDirectory() + fd.getFile();
         System.out.println( "Selected " + fullName);

         // Analyze checkbox for Compound Loan(true) or Simple
         // Loan(false).
         // Retrieve essential data from file into proper loan.
         if (cb.getState())        // Compound Loan
         {
           System.out.println("Reading data into Compound Loan");

           CompoundLoan cloan = new CompoundLoan(1.0,1.0,1);
           try {cloan.load(fullName); }
           catch (IOException fe) {}
 
           // Convert numerics to String data to put in Textfields
           fPrin.setText( Double.toString(cloan.getPrincipal()) );
           fAPR.setText(  Double.toString(cloan.getAPR()) );
           fMo.setText(  Integer.toString(cloan.getNMonths()) );
         
           // Capture NMonths and allocate two double precision
           // arrays with NMonths elements: pPrin and pInt.
           int N = cloan.getNMonths();
           double [] pInt  = new double[N];
           double [] pPrin = new double[N];

           // Capture the Principal and APR from cloan and 
           // compute the loan amortization in pPrin[] and pInt[]
           double total = cloan.totalPaid();
           double APR   = cloan.getAPR();

           int i;
           double balance = cloan.getPrincipal();
           double ppr = APR/12.0;
           double pmt = total/(double)N;
           for (i=0; i<N; i++) {
             pInt[i]  = ppr * balance;
             pPrin[i] = pmt - pInt[i];
             balance -= pPrin[i];
           }
           System.out.println("Amortized the loan");

           // Call lr.setData with number of months and array data
           lr.setData(N, pPrin, pInt);
         }
         else                        // Simple Loan
         {
           System.out.println("Reading data into Simple Loan");
 
           SimpleLoan sloan = new SimpleLoan(1.0,1.0,1); // Init
           try {sloan.load(fullName); }
           catch (IOException fe) {}

           // Convert numerics to String data to put in Textfields
           fPrin.setText( Double.toString(sloan.getPrincipal()) );
           fAPR.setText(  Double.toString(sloan.getAPR()) );
           fMo.setText(  Integer.toString(sloan.getNMonths()) );
         
           // Capture NMonths and allocate two double precision
           // arrays with NMonths elements: pPrin and pInt.
           int N = sloan.getNMonths();
           double [] pInt  = new double[N];
           double [] pPrin = new double[N];

           // Capture the Principal and APR from cloan and 
           // compute the loan amortization in pPrin[] and pInt[]
           double total = sloan.totalPaid();
           double APR   = sloan.getAPR();
         
           int i;
           double balance = sloan.getPrincipal();
           double ppr = APR/12.0;
           double pmt = total/(double)N;
           for (i=0; i<N; i++) {
             pInt[i]  = ppr * balance;
             pPrin[i] = pmt - pInt[i];
           }
           System.out.println("Amortized the loan");
  
           // Call lr.setData with number of months and array data
           lr.setData(N, pPrin, pInt);
         }

         Graphics g = lr.getGraphics();     
         lr.paint(g);
       }
     }
   });

   fSave.addActionListener( new ActionListener() {
     public void actionPerformed( ActionEvent e ) {
       String cmd = e.getActionCommand();
       if (cmd.equals("SAVE") )
       {
         System.out.println("Wants to save a loan");
         FileDialog fd = new FileDialog( app, "Save a loan",
                                         FileDialog.SAVE );
         fd.setDirectory("C:/");
         fd.show();
         String fullName = fd.getDirectory() + fd.getFile();
         System.out.println( "Selected " + fullName);

         // Save essential data to file by using a constructor
         // initialization instead of the set methods.
         // Save essential data from file into proper loan.
         if (cb.getState())        // Compound Loan
         {
           CompoundLoan cloan = new CompoundLoan(
             Double.parseDouble(fPrin.getText()),
             Double.parseDouble(fAPR.getText()),
             Integer.parseInt(fMo.getText()) );
           try {cloan.save(fullName); }
           catch (IOException fe) {}
         }
         else                      // Simple Loan
         {
           SimpleLoan sloan = new SimpleLoan(
             Double.parseDouble(fPrin.getText()),
             Double.parseDouble(fAPR.getText()),
             Integer.parseInt(fMo.getText()) );
           try {sloan.save(fullName); }
           catch (IOException fe) {}
         }
       }
     }
   });

   fQuit.addActionListener( new ActionListener() {
     public void actionPerformed( ActionEvent e ) {
       String cmd = e.getActionCommand();
       if (cmd.equals("QUIT") )
       {
         System.exit(0);
       }
     }
   });

   // Close window frame
   app.addWindowListener( new WindowAdapter() {
     public void windowClosing( WindowEvent e ) {
       System.exit(0);
     }
   });

   app.setMenuBar( mb );
   app.setSize( 500, 400 );
   app.setLayout( new FlowLayout() );

   Button compute = new Button( " Compute " );
   compute.setActionCommand( "COMPUTE" );
   compute.addActionListener( new ActionListener() {
     public void actionPerformed( ActionEvent e ) {
       String cmd = e.getActionCommand();
       if ( cmd.equals("COMPUTE") )
       {
         // Retreive numbers from text fields for computation
         String sPrin = fPrin.getText();
         String sAPR = fAPR.getText();
         String sMo = fMo.getText();
         
         // Capture NMonths and allocate two double precision
         // arrays with NMonths elements: pPrin and pInt.
         if (sMo.equals("") || (Integer.parseInt(sMo) < 1) )
         {
          System.out.println("N is less than 1; Cannot compute!");
         }
         else if (sAPR.equals("") || sPrin.equals(""))
         {
           System.out.println("Text fields cannot be blank!");
         }
         else  // Number of months is greater than 0
         {
           // Save essential data to file by using a constructor
           // initialization instead of the set methods.
           if (cb.getState())        // Compound Loan
           {
             CompoundLoan cloan = new CompoundLoan(
               Double.parseDouble(sPrin),
               Double.parseDouble(sAPR),
               Integer.parseInt(sMo) );

             int N = cloan.getNMonths();
             double [] pInt  = new double[N];
             double [] pPrin = new double[N];

             // Capture the Principal and APR from cloan and 
             // compute the loan amortization in pPrin[] & pInt[]
             double total = cloan.totalPaid();
             double APR   = cloan.getAPR();

             int i;
             double balance = cloan.getPrincipal();
             double ppr = APR/12.0;
             double pmt = total/(double)N;
             for (i=0; i<N; i++) {
               pInt[i]  = ppr * balance;
               pPrin[i] = pmt - pInt[i];
               balance -= pPrin[i];
             }
 
             lr.setData(N, pPrin, pInt);
           }
           else                        // Simple Loan
           {
             SimpleLoan sloan = new SimpleLoan(
               Double.parseDouble(sPrin),
               Double.parseDouble(sAPR),
               Integer.parseInt(sMo) );

             int N = sloan.getNMonths();
             double [] pInt  = new double[N];
             double [] pPrin = new double[N];

             // Capture the Principal and APR from sloan and 
             // compute the loan amortization in pPrin[] & pInt[]
             double total = sloan.totalPaid();
             double APR   = sloan.getAPR();

             int i;
             double balance = sloan.getPrincipal();
             double ppr = APR/12.0;
             double pmt = total/(double)N;
             for (i=0; i<N; i++) {
               pInt[i]  = ppr * balance;
               pPrin[i] = pmt - pInt[i];
             }

             lr.setData(N, pPrin, pInt);
           }

           System.out.println("Amortized the loan");

           Graphics g = lr.getGraphics();
           lr.paint(g);
         } // end of if/else (N < 1)
       }
     }
   });

  Button clear = new Button( " Clear " );
    clear.setActionCommand( "CLEAR" );
    clear.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        if ( cmd.equals("CLEAR") )
        {
          fPrin.setText("");
          fAPR.setText("");
          fMo.setText("");
          // If checkbox is selected (true), then deselect it.
          if (cb.getState()) { cb.setState(false); }
 
          System.out.println("Wants a new loan");
        }
      }
   });

   app.add( lPrin );
   app.add( fPrin );
 
   app.add( lAPR );
   app.add( fAPR );

   app.add( lMo );
   app.add( fMo );

   app.add( cb );

   app.add( compute );
   app.add( clear );

   app.add(lr);
   app.show();
     
 } // End of main block
}