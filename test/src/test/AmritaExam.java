//package test;


import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class AmritaExam extends JFrame implements ActionListener  
{  
	public static void main(String[] args) {
	  
		AmritaExam a = new AmritaExam("Online Test Of Java");  

	}
	
    JLabel l;  
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
        jb[1].setBounds(80,110,140,20);  
        jb[2].setBounds(80,140,140,20);  
        jb[3].setBounds(80,170,140,20);  
        
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
            	JOptionPane.showMessageDialog(this,"No Previous Question's");
            }  
        }
        
        // This Clear is not working 
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
            float percentage = (total/10)*100;  
            JOptionPane.showMessageDialog(this,"All the Very Best Lets See Your Mark Card");
            JOptionPane.showMessageDialog(this,"Total Marks Secured = " + total);  
            JOptionPane.showMessageDialog(this,"Percentage Marks=" + percentage);  
            System.exit(0);
        }  
        
    }  
   
	void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: The benefits of the Object Orientation are:?");  
            jb[0].setText("Flexibility");jb[1].setText("Inheritance");jb[2].setText("Maintainability");jb[3].setText("Polymorphism");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: HAS-A relationships are based on inheritance, rather than usage.  ?");  
            jb[0].setText("True");jb[1].setText("False");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: In Java, the actual method executed is determined by the type of the object and not the type of the reference ?");  
            jb[0].setText("True");jb[1].setText("False");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Que5:  Array or collection of superclass references can be used to access a mixture of superclass and subclass objects.  ?");  
            jb[0].setText("True");jb[1].setText("Flase");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which one among these is not a class? ");  
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  
                        jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: which one among these is not a function of Object class?");  
            jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");  
                        jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: The relation between Car and Owner or BankAccount and Customer is example for  ?");  
            jb[0].setText("Aggregation");jb[1].setText("Composition");jb[2].setText("Association");jb[3].setText("None");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Subclassing polymorphism is sometimes called “true polymorphism” ?");  
            jb[0].setText("True");jb[1].setText("False");
                        jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }
    
}
   
