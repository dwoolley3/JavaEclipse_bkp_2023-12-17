package hcc_2002_java_course;

// Name:    Loan.java
// Author:  Doug Woolley
// Date:    8/9/02
// Purpose: Create a base class called Loan.
// It includes methods that Save and Load the essential loan data.

import java.io.*;
import java.util.StringTokenizer;

public class Loan {

   private double principal;
   private double apr;
   private int nmonths;

   public Loan(double p, double a, int m) {
     this.principal = p;
     this.apr = a;
     this.nmonths = m;
   }

   public double getPrincipal() { return this.principal; }
   public void setPrincipal (double p) { this.principal = p; }

   public double getAPR() { return this.apr; }
   public void setAPR(double apr) { this.apr = apr; }

   public int getNMonths() { return this.nmonths; }
   public void setNMonths(int m) { this.nmonths = m; }

   //*************************************************************
   public void save(String fileName) throws IOException,
                                            FileNotFoundException {
       FileOutputStream outF;
       String line;

       try {
          // Create the output file
         outF = new FileOutputStream (fileName);

         // Write out the principal
         line = "principal=" + this.principal + "\n";
         outF.write( line.getBytes() );

         // Write out the APR
         line = "apr=" + this.apr + "\n";
         outF.write( line.getBytes() );

         // Write out the number of months
         line = "nmonths=" + this.nmonths + "\n";
         outF.write( line.getBytes() );

         // Close the file
         outF.close();
      }
      catch (FileNotFoundException fe) {
         throw (fe);
      }
      catch (IOException fe) {
         throw (fe);
      }
      finally {}
   }
   //************************************************************
   public void load(String fileName) throws FileNotFoundException,
                                            IOException {
       File f;
       FileInputStream fis;
       String s;
       int sz;

       // Get the size of the file so we know how big to make
       // our byte[] array.
       f = new File( fileName);
       sz = (int)f.length();

       // allocate our byte array
       byte c[] = new byte[sz];

       try {
          // Create the output file
         fis = new FileInputStream (fileName);
         fis.read(c);
         fis.close();
       }
        
      catch (FileNotFoundException fnfe) {
         throw (fnfe);
      }
      catch (IOException ioe) {
         throw (ioe);
      }
      finally {}

     s = new String(c);
     System.out.println("Load: file contains...");
     System.out.println(s);

     // Note: Content is "principal=10000.0\napr=0.073\nmonths=48\n"
     StringTokenizer t = new StringTokenizer(s, "\n");
     while (t.hasMoreTokens()) {
         String line = t.nextToken();
         StringTokenizer p = new StringTokenizer(line, "=");
         if (p.countTokens() == 2) {
            String kwd = p.nextToken();
            String val = p.nextToken();
            if (kwd.equals("principal"))
              { this.principal = Double.parseDouble(val); }
            else
              if (kwd.equals("apr"))
                 { this.apr = Double.parseDouble(val); }
             else
                if (kwd.equals("nmonths"))
                  { this.nmonths = Integer.parseInt(val); } 
         } // close the if statement
      }  // close the while loop
      
   }
}