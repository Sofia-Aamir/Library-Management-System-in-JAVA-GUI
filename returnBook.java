
package lms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static lms.funcitonalityPage.mainpanel;

public class returnBook extends JFrame{
    private JLabel mainlabel;
    private JLabel name,id,currentdate,issuedate;
    private JPanel panel,tp,bp;
    private JTextField namefield,idfield;
    //private GridBagConstraints c;
    private JButton returnbtn,btnback,btnlogout;
    private JComboBox<String> box1,box2,box3;
    private JFrame frame;
    
    returnBook(){
        frame=new JFrame();
        frame.setTitle("RETURNBOOK PAGE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 400);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        initialize();
        frame.setVisible(true);
    }
    
    private void initialize(){
         
        // panel.setLocale(Locale.UK);
        GridLayout grid=new GridLayout(8,1,3,3);
       // Panel.setLayout(new GridBagLayout());
       
        
        frame.setLayout(new BorderLayout());
        
       
        //top panel
        JPanel tP = new JPanel(new BorderLayout());
        
        JPanel tpcp = new JPanel(new BorderLayout());
        
        Icon bookicon=new ImageIcon(getClass().getResource("return2.png"));
        JLabel l=new JLabel(bookicon,JLabel.CENTER);
        tpcp.add(l,BorderLayout.CENTER);    
        JLabel lblTitle = new JLabel("RETURN BOOK",SwingConstants.CENTER);
        lblTitle.setFont(new Font("Algerian",Font.BOLD,20));
        lblTitle.setForeground(Color.WHITE);
        tpcp.setBackground(new Color(131,135,141));
        tpcp.add(lblTitle,BorderLayout.SOUTH);
        
         //TOP CENTER PANEL , EAST PANEL, for BACK BUTTON
        JPanel tpEp = new JPanel();
            tpEp.setBackground(new Color(131,135,141));
            Icon backicon=new ImageIcon(getClass().getResource("back.png"));
            JLabel l6=new JLabel(backicon);
        
            btnback = new JButton();
            btnback.setBorder(BorderFactory.createTitledBorder("Back"));
      
            btnback.setBackground(new Color(131,135,141));
            
            btnback.add(l6);
            tpEp.add(btnback);
        
            //TOP CENTER PANEL , WEST PANEL, for LOGOUT BUTTON
        JPanel tpWp = new JPanel();
            tpWp.setBackground(new Color(131,135,141));
            Icon logouticon=new ImageIcon(getClass().getResource("logout.png"));
            JLabel l7=new JLabel(logouticon);
        btnlogout = new JButton();
         btnlogout.setBorder(BorderFactory.createTitledBorder("logout"));
            btnlogout.setBackground(new Color(131,135,141));
            
            btnlogout.add(l7);
            tpWp.add(btnlogout);
            
            tpcp.add(tpEp,BorderLayout.EAST);
            tpcp.add(tpWp,BorderLayout.WEST);
            
 
        tP.add(tpcp,BorderLayout.CENTER);  //adding tpcp to toppanel
        
        mainpanel.add(tP,BorderLayout.NORTH);
        
       tp=new JPanel();
       mainlabel=new JLabel("BORROW BOOK INFORMATION");
       mainlabel.setFont(new Font("Arial Black",Font.LAYOUT_NO_LIMIT_CONTEXT,20));
       mainlabel.setForeground(Color.WHITE);
       tp.setBackground(new Color(40, 40, 40));
       tp.add(mainlabel,BorderLayout.CENTER);
       tp.add(mainlabel);
       
       //center panel
       panel=new JPanel();
       
       panel.setLayout(grid);

       name=new JLabel("ENTER BOOK NAME",SwingConstants.CENTER);
       panel.add(name);
       
       namefield=new JTextField("");
       panel.add(namefield);
       
       id=new JLabel("ENTER BOOK ID",SwingConstants.CENTER);
       panel.add(id);
       
       idfield=new JTextField("");
       panel.add(idfield);
       issuedate=new JLabel("ENTER ISSUE DATE",SwingConstants.CENTER);
       panel.add(issuedate);
       panel.add(datepanel());
     
       currentdate=new JLabel("CURRENT DATE",SwingConstants.CENTER);
       panel.add(currentdate);
       panel.add(datepanel());
       
       
       bp=new JPanel();
       returnbtn=new JButton("RETURN");
       bp.add(returnbtn);
    
       frame.add(tP,BorderLayout.NORTH);
       frame.add(panel,BorderLayout.CENTER);
       frame.add(bp,BorderLayout.SOUTH);                                                                                            
       
       ButtonHandler h=new ButtonHandler();
       returnbtn.addActionListener(h);
       btnback.addActionListener(h);
       btnlogout.addActionListener(h);
    }
    
    private JPanel datepanel(){
    
        JPanel datepnl=new JPanel(new GridLayout(1,3,5,5));
       
      
      String date[] = new String[31];
      for(int i=0;i<31;i++){
      date[i]=String.format("%s",i+1);
      }
      
     box1=new JComboBox<String> (date);
     
     datepnl.add(box1);
    
      
      String month[]=new String[12];
      for(int i=0;i<12;i++){
          month[i]=String.format("%s", i+1);
      }
      box2=new JComboBox<String> (month);
      datepnl.add(box2);
     
      //datepnl.add(date2);
      
       String year[]=new String[44];
       int j=1980;
      for(int i=0;i<44;i++){
          year[i]=String.format("%s", j);
          j++;
      }
      box3=new JComboBox<String> (year);
      datepnl.add(box3);
       
       panel.add(datepnl);
       
    return datepnl;
    }
    
    
  private class ButtonHandler implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
          if(e.getSource().equals(returnbtn)&&!namefield.getText().equals("")&&!idfield.getText().equals("")){
              JOptionPane.showMessageDialog(null,String.format("  BOOK SUCESSFULLY RETURNED\n"
                      + "BOOK NAME : %s\nBOOK ID : %s",namefield.getText(),idfield.getText()));
          }     
          else if(e.getSource().equals(btnback)){
          frame.dispose();
          }       
          else if(e.getSource().equals(btnlogout)){
            frame.dispose();
            funcitonalityPage.disposer();
          }     
      }
  }
    
}
