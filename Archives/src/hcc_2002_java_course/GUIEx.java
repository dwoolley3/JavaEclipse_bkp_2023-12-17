package hcc_2002_java_course;

//GUIEx.java program

import java.awt.*;
import java.awt.event.*;

public class GUIEx extends Frame
{
	private static final long serialVersionUID = 1L;

   public GUIEx (String title)
   {
       super(title);
   }

   @SuppressWarnings("deprecation")
public static void main (String[] args)
   {
      final GUIEx app = new GUIEx("GUI Mortgage Calculator");

     // Prepare the menu bar
    MenuBar mb = new MenuBar();
    Menu file = new Menu("File");

   MenuItem fNew  = new MenuItem ("New");
   MenuItem fOpen = new MenuItem ("Open");
   MenuItem fSave  = new MenuItem ("Save");
   MenuItem fQuit   = new MenuItem ("Quit");

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

   fNew.addActionListener( new ActionListener() {
       public void actionPerformed( ActionEvent e ) {
            String cmd = e.getActionCommand();
            if ( cmd.equals("NEW") )
           {
               fPrin.setText("");
               fAPR.setText("");
               fMo.setText("");
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
             FileDialog fd = new FileDialog( app, "Open a loan", FileDialog.LOAD );
             fd.setDirectory("C:/");
             fd.show();
             String fullName = fd.getDirectory() + fd.getFile();
             System.out.println( "Selected " + fullName);
          }
     }
   });

   fSave.addActionListener( new ActionListener() {
	public void actionPerformed( ActionEvent e ) {
           String cmd = e.getActionCommand();
           if (cmd.equals("SAVE") )
          {
             System.out.println("Wants to save a loan");
             FileDialog fd = new FileDialog( app, "Save a loan", FileDialog.SAVE );
             fd.setDirectory("C:/");
             fd.show();
             String fullName = fd.getDirectory() + fd.getFile();
             System.out.println( "Selected " + fullName);
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

   app.setMenuBar( mb );
   app.setSize( 400, 300 );
   app.setLayout( new FlowLayout() );
  
   Button compute = new Button( " Compute " );
   compute.setActionCommand( "COMPUTE" );
   compute.addActionListener( new ActionListener() {
       public void actionPerformed( ActionEvent e ) {
           String cmd = e.getActionCommand();
           if ( cmd.equals("COMPUTE") )
          {
              String sPrin = fPrin.getText();
              String sAPR = fAPR.getText();
              String sMo = fMo.getText();
              System.out.println(sPrin);
              System.out.println(sAPR);
              System.out.println(sMo);
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

   app.add( compute );
   app.add( clear );

   app.show();
   }
}