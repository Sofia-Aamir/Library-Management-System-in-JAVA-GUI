

package lms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class regestrationForm extends JFrame{
    
    private JLabel firstlabel,dateofbirth,gender,errorlbl;
    private JPanel cp,bp;
    private JFrame frame;
    private JTextField firsttext,lasttext,emailtext,passtext,date1,date2,date3;
    private JRadioButton gender1,gender2,gender3;
    private JComboBox<String> box1,box2,box3;
    private JButton register;
    private ButtonGroup G;
    
    regestrationForm(){
       frame = new JFrame();
       frame.setTitle("REGISTRATION FORM");
        frame.setSize(420, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       initialize();
       frame.setVisible(true);
       
    }
    
    void initialize(){
        frame.setLayout(new BorderLayout(10,10));
        //TOP PANEL
        JLabel l=new JLabel("REGISTRATION FORM",SwingConstants.CENTER);
        
       // l.setFont(new Font("serif",Font.BOLD,16));
         l.setFont(new Font("Arial Black",Font.LAYOUT_NO_LIMIT_CONTEXT,20));
       l.setForeground(Color.DARK_GRAY);
        setBackground(new Color(40, 40, 40));
        frame.add(l,BorderLayout.NORTH);
        
       //CENTER PANEL 
        cp= new JPanel();
        frame.add(cp,BorderLayout.CENTER);
        cp.setLayout(new GridLayout(6,1,2,2));
        
        JPanel namepnl=new JPanel(new GridLayout(1,2,5,5));
        
        firsttext=new JTextField("");
        firsttext.setBorder(BorderFactory.createTitledBorder("name"));
        namepnl.add(firsttext);
        
        lasttext=new JTextField("");
        lasttext.setBorder(BorderFactory.createTitledBorder("lastname"));
        namepnl.add(lasttext);
        
        cp.add(namepnl);
        
        emailtext=new JTextField("");
        emailtext.setBorder(BorderFactory.createTitledBorder("email"));
       cp.add(emailtext);
       
       passtext=new JTextField("");
       passtext.setBorder(BorderFactory.createTitledBorder("password"));
       cp.add(passtext);
  
  
      dateofbirth=new JLabel("DATE OF BIRTH",SwingConstants.CENTER);
    // cp.add(dateofbirth);
      
      JPanel datepnl=new JPanel(new GridLayout(1,3,1,1));
      
      String date[] = new String[31];
      for(int i=0;i<31;i++){
      date[i]=String.format("%s",i+1);
      }
      
     box1=new JComboBox<String> (date);
     
     datepnl.add(box1);
      date1=new JTextField();
      
      String month[]=new String[12];
      for(int i=0;i<12;i++){
          month[i]=String.format("%s", i+1);
      }
      box2=new JComboBox<String> (month);
      datepnl.add(box2);
       date2=new JTextField();
      //datepnl.add(date2);
      
       String year[]=new String[44];
       int j=1980;
      for(int i=0;i<44;i++){
          year[i]=String.format("%s", j);
          j++;
      }
       box3=new JComboBox<String> (year);

      datepnl.add(box3);
       date3=new JTextField();
     // datepnl.add(date3);
      
      cp.add(datepnl);
      bp=new JPanel(new BorderLayout());
      bp.add(dateofbirth,BorderLayout.NORTH);
      bp.add(datepnl,BorderLayout.CENTER);
      
      cp.add(bp);
      
      gender=new JLabel("GENDER",SwingConstants.CENTER);
        JPanel gp=new JPanel(new GridLayout(1,3,5,5));
        
        gender1=new JRadioButton("Male");
       gp.add(gender1);
       
        gender2=new JRadioButton("Female");
       gp.add(gender2);
       
        gender3=new JRadioButton("Other");
       gp.add(gender3);
       
       cp.add(gp);
       
       G=new  ButtonGroup();
       G.add(gender1);
       G.add(gender2);
       G.add(gender3);
       
       
       register=new JButton("REGISTER");
       cp.add(register);
       
       errorlbl=new JLabel("",SwingConstants.CENTER);
       errorlbl.setForeground(Color.red);
       frame.add(errorlbl,BorderLayout.SOUTH);
       
        ButtonHandler h=new  ButtonHandler();
        register.addActionListener(h);
    }
    
    public String checkgender(){
    if(gender1.isSelected())
        return "MALE";
    else if(gender2.isSelected())
        return "FEMALE";
    else if(gender3.isSelected())
        return "OTHER";
    return null;
    }
    
    public class ButtonHandler implements ActionListener{
   
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            if(firsttext.getText().equals("")){
                errorlbl.setText("*name must be entered");
            }
            else if(lasttext.getText().equals("")){
                errorlbl.setText("*last name must be entered");
            }
            else if(emailtext.getText().equals("")){
                errorlbl.setText("*email must be entered");
            }
            else if(passtext.getText().equals("")){
                errorlbl.setText("*pass must be entered");
            }
            else if(!gender1.isSelected()&&!gender2.isSelected()&&!gender3.isSelected()){
                        errorlbl.setText("*select gender");
                    } 
            //gender1.isSelected()
            else if(e.getSource().equals(register)){
                String s =String.format("Name : %s/%s \nEmail : %s\nPassword : %s\nDOB : %s/%s/%s\nGENDER: %s"
                        + "",firsttext.getText(),lasttext.getText(),emailtext.getText(),passtext.getText(),
                        (String)box1.getSelectedItem(),(String)box2.getSelectedItem(),(String)box3.getSelectedItem(),checkgender());
                JOptionPane.showMessageDialog(regestrationForm.this,s);
            }
        }
    }
}