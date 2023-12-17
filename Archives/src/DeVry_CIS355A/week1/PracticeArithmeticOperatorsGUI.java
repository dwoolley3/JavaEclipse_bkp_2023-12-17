/***********************************************************************
Program Name: PracticeArithmeticOperatorsGUI.java
Programmer's Name: Doug Woolley
Program Description: GUI version of PracticeArithmeticGUI.java
***********************************************************************/ 

package week1;

//class to definite Arithmetic Operation
public class PracticeArithmeticOperatorsGUI extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private javax.swing.JLabel userFirstNum;
    private javax.swing.JLabel userSecondNum;
    private javax.swing.JLabel add;
    private javax.swing.JLabel substract;
    private javax.swing.JLabel multiple;
    private javax.swing.JLabel divide;
    
    private javax.swing.JButton CalButton;
    
    private javax.swing.JTextField firstNumTextField;
    private javax.swing.JTextField secondNumTextField;
    
    //Constructor to call method
    public PracticeArithmeticOperatorsGUI(){
        initApp();
    }
    
    //Method to initialize Windows
    protected void initApp(){
        
        //instance of class objects
        userFirstNum  = new javax.swing.JLabel();
        userSecondNum = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        substract = new javax.swing.JLabel();
        multiple  = new javax.swing.JLabel();
        divide = new javax.swing.JLabel();
        
        CalButton = new javax.swing.JButton();
        firstNumTextField  = new javax.swing.JTextField();
        secondNumTextField = new javax.swing.JTextField();
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Arithmetic Operators");
        
        this.userFirstNum.setText("Enter your first number");
        this.userSecondNum.setText("Enter your second number");
        this.add.setText("Addition");
        this.substract.setText("Substraction");
        this.multiple.setText("Multiplication");
        this.divide.setText("Division");
    
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userFirstNum)
                    .addComponent(userSecondNum)
            )
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(firstNumTextField)
                .addComponent(secondNumTextField)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(add)
                        .addComponent(substract)
                        .addComponent(multiple)
                        .addComponent(divide)
                    )
                )
            )
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CalButton)
            )
        );
        
        //Designing and formating windows layout
        //i.e. dialog input box, button layout etc
        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CalButton, userFirstNum});
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userFirstNum)
                    .addComponent(firstNumTextField)
                    .addComponent(CalButton)
                  )
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userSecondNum)
                    .addComponent(secondNumTextField)
                  )
                )
            )
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add)
                    )
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(substract)
                    )
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(multiple)
                    )
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(divide)
                    )
                )
            )
        );
        pack();        
    }
    
    //Method to perform button action
    //This method will perform the arithmetic
    protected void CalButtonActionPerformed(java.awt.event.ActionEvent event){
        
        int addition = ((Integer.parseInt(firstNumTextField.getText())) + (Integer.parseInt(secondNumTextField.getText()))); 
        int substraction = ((Integer.parseInt(firstNumTextField.getText())) - (Integer.parseInt(secondNumTextField.getText())));
        int multiplication = ((Integer.parseInt(firstNumTextField.getText())) * (Integer.parseInt(secondNumTextField.getText())));
        int division = ((Integer.parseInt(firstNumTextField.getText())) / (Integer.parseInt(secondNumTextField.getText())));
        
        this.add.setText(addition + " Addition");
        this.substract.setText(substraction + " Substraction");
        this.multiple.setText(multiplication + " Multiplication");
        this.divide.setText(division + " Division");
        
        }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	PracticeArithmeticOperatorsGUI StartApp = 
            			new PracticeArithmeticOperatorsGUI();
                StartApp.setVisible(true);
            }
        });
    }
}


