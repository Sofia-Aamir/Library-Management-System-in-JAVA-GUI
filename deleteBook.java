
package lms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static lms.funcitonalityPage.mainpanel;

public class deleteBook extends JFrame{
    private JLabel mainlabel;
    private JLabel name,reasonlbl,currentdate;
    private JPanel panel,tp,bp;
    private JButton add,btnback,btnlogout;
    private JComboBox<String> cb1,cb2,box1,box2,box3;
    private JFrame frame;
    deleteBook(){
        frame=new JFrame();
        frame.setTitle("DELETEBOOK PAGE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 400);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        initialize();
       frame.setVisible(true);
    }
    
    private void initialize(){
         
        // panel.setLocale(Locale.UK);
        GridLayout grid=new GridLayout(6,1,3,3);
       // Panel.setLayout(new GridBagLayout());
       
        
        frame.setLayout(new BorderLayout());
        
       
        //top panel
        JPanel tP = new JPanel(new BorderLayout());
        
        JPanel tpcp = new JPanel(new BorderLayout());
        
        Icon bookicon=new ImageIcon(getClass().getResource("delete2.png"));
        JLabel l=new JLabel(bookicon,JLabel.CENTER);
        tpcp.add(l,BorderLayout.CENTER);    
        JLabel lblTitle = new JLabel("DELETE BOOK",SwingConstants.CENTER);
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
        
            
        //TOP CENTER PANEL , WEST PANEL, for HOME BUTTON
        JPanel tpWp = new JPanel();
            tpWp.setBackground(new Color(131,135,141));
            Icon logouticon=new ImageIcon(getClass().getResource("logout.png"));
            JLabel l7=new JLabel(logouticon);
        btnlogout = new JButton();
         btnlogout.setBorder(BorderFactory.createTitledBorder("logout"));
            btnlogout.setBackground(new Color(131,135,141));
            
            btnlogout.add(l7);
            tpWp.add(btnlogout);
            
            btnlogout.add(l7);
            tpWp.add(btnlogout);
            
            tpcp.add(tpEp,BorderLayout.EAST);
            tpcp.add(tpWp,BorderLayout.WEST);
        
       
        
        
        //tP.add(tpEp,BorderLayout.EAST);
        tP.add(tpcp,BorderLayout.CENTER);  //adding tpcp to toppanel
        
        mainpanel.add(tP,BorderLayout.NORTH);
        
       tp=new JPanel();
       mainlabel=new JLabel("BORROW BOOK INFORMATION");
      // mainlabel.setFont(new Font("serif",Font.BOLD,14));
      mainlabel.setFont(new Font("Arial Black",Font.LAYOUT_NO_LIMIT_CONTEXT,20));
        mainlabel.setForeground(Color.WHITE);
        tp.setBackground(new Color(40, 40, 40));
        tp.add(mainlabel,BorderLayout.CENTER);
       tp.add(mainlabel);
       
       //center panel
       panel=new JPanel();
       
       panel.setLayout(grid);

       name=new JLabel("SELECT A BOOK",SwingConstants.CENTER);
       panel.add(name);
       
       String[] booksname={"ULYSSES by James Joyce","THE GREAT by F. Scott Fitzgerald","LOLITA by Vladimir Nabokov","CATCH-22 by Joseph Heller","1984 by George Orwell"};
       cb1=new JComboBox<String>(booksname);
       
       panel.add(cb1);
       
       reasonlbl=new JLabel("SELECT A REASON",SwingConstants.CENTER);
       panel.add(reasonlbl);
       String[] reason={"OLD BOOK","UNNECESSARY MATERIAL","MANY COPIES AVAILAIBLE","UPDATED EDITION ARRIVED","BOOK BANNED"};
       cb2=new JComboBox<String>(reason);
       
       panel.add(cb2);
       
      
      
       
       
       currentdate=new JLabel("CURRENT DATE",SwingConstants.CENTER);
       panel.add(currentdate);
       
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
      
       String year[]=new String[44];
       int j=1980;
      for(int i=0;i<44;i++){
          year[i]=String.format("%s", j);
          j++;
      }
       box3=new JComboBox<String> (year);

      datepnl.add(box3);
       
       panel.add(datepnl);
       
       bp=new JPanel();
       add=new JButton("DELETE BOOK");
       bp.add(add);
    
       frame.add(tP,BorderLayout.NORTH);
       frame.add(panel,BorderLayout.CENTER);
       frame.add(bp,BorderLayout.SOUTH);                                                                                            
       
       ButtonHandler h=new ButtonHandler();
       add.addActionListener(h);
       btnback.addActionListener(h);
       btnlogout.addActionListener(h);
    }
    
  private class ButtonHandler implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
          if(e.getSource().equals(add)){
            JOptionPane.showMessageDialog(null,String.format("BOOK NAME : %s\nREASON : %s\nDATE OF DELETION : %s/%s/%s "
                    + "\n     BOOK SUCESSFULLY DELETED",(String)cb1.getSelectedItem(),(String)cb2.getSelectedItem(),(String)box1.getSelectedItem(),(String)box2.getSelectedItem(),(String)box3.getSelectedItem()));
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
