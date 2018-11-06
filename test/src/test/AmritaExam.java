//package test;


import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class AmritaExam extends JFrame implements ActionListener  
{  
	public static void main(String[] args) {
	  
		AmritaExam a = new AmritaExam("Online Test Of Java");  

	}
	
    JLabel l,l1;  
    JLabel label = new JLabel("I'm bold");
    Font font = new Font("Courier", Font.BOLD,12);

    JCheckBox jb[]= new JCheckBox[5];  
    JButton button1,button2, button3, button0; 
    JButton button4;
    
    ButtonGroup bg;  
    int total=0,current=0,x=1,y=1,now=0;  
    int m[] = new int[10];      
    AmritaExam(String s)  
    {  
        super(s);  
        l = new JLabel(); 
        l1 = new JLabel();
        add(l1);
        add(l);  
        bg = new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i] = new JCheckBox();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  

        button0 = new JButton("Previous");
        button1 = new JButton("Next");  
        button2 = new JButton("Bookmark");  
        button3 = new JButton("Percentage");
        button4 = new JButton("Clear");
        
        button0.addActionListener(this);
        button1.addActionListener(this);  
        button2.addActionListener(this);  
        button3.addActionListener(this);  
        button4.addActionListener(this);
        
        add(button1);add(button2);add(button0);
        add(button4);
        
        set();  
        l.setBounds(30,40,450,20);  
        	
        jb[0].setBounds(80,80,140,20);  
        jb[1].setBounds(250,80,140,20);  
        jb[2].setBounds(80,140,140,20);  
        jb[3].setBounds(250,140,140,20);  
        
        button0.setBounds(70,240,100,30);
        button1.setBounds(180,240,100,30);  
        button2.setBounds(400,240,130,30); 
        button4.setBounds(290, 240, 100, 30);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        getContentPane().setBackground(new Color(169, 204, 227));
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==button1)  
        {  
            if(check())  
                total=total+1;  
            current++;  
            set(); 
            button0.setEnabled(true);
            if(current==9)  
            {  
                button1.setEnabled(false);  
                button2.setText("Result");  
            }  
        }
        if(e.getSource()== button0)  
        {  
            if(check())  
                total=total-1;  
            current--;  
            button1.setEnabled(true);  
            set();    
            if(current==0)  
            {  
            	button0.setEnabled(false);
            	JOptionPane.showMessageDialog(this,"No Previous Questions");
            }  
        }
        
        // This Clear button
        if(e.getSource()== button4)  
        {   
            	jb[0].setSelected(false);
        
            	jb[1].setSelected(false);
            		
            	jb[2].setSelected(false);
            	jb[3].setSelected(false);
        }
        
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk = new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                button2.setText("Result");  
            	button3.setText("Average");
            setVisible(false);  
            setVisible(true);  
        } 
        
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        	if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                {
            		total=total+1;  
                }
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                total=total+1;  
            current++;  
            float percentage =  (float) ((float)total/10)*100;  
   
            JOptionPane.showMessageDialog(this,"All the Very Best Lets See Your Mark Card");
            JOptionPane.showMessageDialog(this,"Total Marks Secured = " + total);  
            JOptionPane.showMessageDialog(this,"Percentage Marks =" + percentage);  
            System.exit(0);
        }  
        
    }  
   
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[3].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[3].isSelected());  
        if(current==6)  
            return(jb[2].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[3].isSelected());  
        if(current==9)  
            return(jb[0].isSelected());  
        return false;  
    }
	
    void set()  
    {  
        jb[4].setSelected(true); 
//        z.setFont(z.getFont().deriveFont(Font.BOLD, 14f));
//        l1.setFont(l1.getFont().deriveFont(Font.BOLD, 14f)"Welcome to the Amrita Exam !!");
        l1.setText("<html><u>Welcome to Amrita Exam</html>");
        if(current==0)  
        {  
            l.setText("Question1: Which one among these is not a primitive datatype?");  
            jb[0].setText("int");jb[1].setText("enum");jb[2].setText("boolean");jb[3].setText("char");   
        }  
        if(current==1)  
        {  
            l.setText("Question2: Integer Data type does not include following primitive data type ____________.");  
            jb[0].setText("double");jb[1].setText("long");jb[2].setText("short");jb[3].setText("byte");  
        }  
        if(current==2)  
        {  
            l.setText("Question3: Which of the following data types comes under floating data types ?");  
            jb[0].setText("byte");jb[1].setText("long");jb[2].setText("double");jb[3].setText("int");  
        }  
        if(current==3)  
        {  
            l.setText("Question4: Character data type cannot store following value.");  
            jb[0].setText("Special Character");jb[1].setText("Letter");jb[2].setText("Digit");jb[3].setText("String");  
        }  
        if(current==4)  
        {  
            l.setText("Question5: Which of the following is smallest integer data type ?");  
            jb[0].setText("long");jb[1].setText("int");jb[2].setText("byte");jb[3].setText("short");  
        }  
        if(current==5)  
        {  
            l.setText("Question6: Range of Byte Data Type is ____________.");  
            jb[0].setText("-128 to 256");jb[1].setText("-127 to 128");jb[2].setText("-128 to 255");jb[3].setText("-128 to 127");  
        }  
        if(current==6)  
        {  
            l.setText("Question7: Which of the following data type(s) can store 64 bit Value. ");  
            jb[0].setText("int");jb[1].setText("float");jb[2].setText("double");  
                        jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Question8: Default value of String (or any object) in Java Programming is _____________.");  
            jb[0].setText("0");jb[1].setText("false");jb[2].setText("'\\u0000'");jb[3].setText("null");   
                        jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            l.setText("Question9: Java Source Code is compiled into ______________.");  
            jb[0].setText("Source Code");jb[1].setText(".Obj");jb[2].setText(".Exe");jb[3].setText("Bytecode");  
        }  
        if(current==9)  
        {  
            l.setText("Question10: Which of the following tool used to execute java code.");  
            jb[0].setText("java");jb[1].setText("rmic");jb[2].setText("javadoc");  
                        jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,700,20);  
        l1.setBounds(150,20,700,20);  
        jb[0].setBounds(80,80,140,20);  
        jb[1].setBounds(250,80,140,20);  
        jb[2].setBounds(80,140,140,20);  
        jb[3].setBounds(250,140,140,20);  
    }  
	
    
}
