package week1;

/***********************************************************************
Program Name: CircleGUI.java
Programmer's Name: Doug Woolley
Program Description: GUI version of Circle.Java
***********************************************************************/ 
// predefined mathematics package
import java.lang.Math;

//creating a class container that 
//inherits swing JFrame object attributes and methods
public class CircleGUI extends javax.swing.JFrame{
    
    //for netbean usage only non class related
    private static final long serialVersionUID = 1L;
    
    
        //class attributes
        //JLabel - creates a label in swing
        //JTextField - creates an input form box for user interactivity
        //JButton - creats a button
    private javax.swing.JLabel Diameter;
    private javax.swing.JLabel Circumference;
    private javax.swing.JLabel Area;
    private javax.swing.JLabel Radius; 
    private javax.swing.JTextField RadiusTextField;
    private javax.swing.JButton  CalButton;
    
    //Constructor to call method
    public CircleGUI(){
        initApp();
    }
    
    //Method to initialize Windows
    protected void initApp(){
        
        //instance of class objects
        Diameter = new javax.swing.JLabel();
        Circumference = new javax.swing.JLabel();
        Area = new javax.swing.JLabel();
        Radius = new javax.swing.JLabel();
        RadiusTextField = new javax.swing.JTextField();
        CalButton = new javax.swing.JButton();
        
        //default characteristics of a GUI window
        //i.e. close option X or setting the windows title
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Compute Circle");
        
        //output text on window
        // similar to writeln in C# or println in java or PHP or printf() in c
        this.Diameter.setText("Diameter");
        this.Circumference.setText("Circumference");
        this.Area.setText("Area");
        this.Radius.setText("Radius");
        
        //method to perform actions once the button is pressed
        this.CalButton.setText("Calculate");
        CalButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent event){
                CalButtonActionPerformed(event);
            }
        });
        
        //Designing and formating windows layout
        //i.e. dialog input box, button layout etc
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addComponent(Radius)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(RadiusTextField)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Area)
                        .addComponent(Diameter)
                        .addComponent(Circumference)
                    )
                )
            )
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CalButton)
            )
        );
        
        //Designing and formating windows layout
        //i.e. dialog input box, button layout etc
        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CalButton, RadiusTextField});
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Radius)
                .addComponent(RadiusTextField)
                .addComponent(CalButton)
            )
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Area)
                    )
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Diameter)
                    )
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Circumference)
                    )
                )
            )
        );
        pack();
    }
    
    //Method to perform button action
    //This method will find circumference, diameter, area
    protected void CalButtonActionPerformed(java.awt.event.ActionEvent event){
        double CalCircumference = (2 * Math.PI * (Double.parseDouble(RadiusTextField.getText()))); 
        double CalDiameter = (2 * (Double.parseDouble(RadiusTextField.getText())));
        double CalArea = (Math.PI * (Double.parseDouble(RadiusTextField.getText())) * (Double.parseDouble(RadiusTextField.getText())));
        
        this.Diameter.setText(Math.round(CalDiameter*100)/100.0 + " Diameter");
        this.Circumference.setText(Math.round(CalCircumference*100)/100.0 + " Circumference");
        this.Area.setText(Math.round(CalArea*100)/100.0 + " Area");
        }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	CircleGUI StartApp = new CircleGUI();
                StartApp.setVisible(true);
            }
        });
    }
}
