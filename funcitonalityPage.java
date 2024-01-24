
package lms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class funcitonalityPage extends JFrame {
    private JPanel tP,cp,tpEp,tpcp;
    public static JPanel mainpanel;
    private JLabel lblTitle;
    private JButton btnborrow,btnadd,btnreturn,btndelete,btnback,btnlogout;
    private static JFrame frame;
    
    funcitonalityPage(){
    frame=new JFrame("FUNCTIONALTY PAGE");
    
    frame.setSize(420, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initializer();
    frame.setVisible(true);
        }
    
    void initializer(){
        
        mainpanel=new JPanel();
        
        mainpanel.setLayout(new BorderLayout());
       
        //TOP PANEL
        tP=new JPanel(new BorderLayout());
        
        tpcp=new JPanel(new BorderLayout());
        
        Icon bookicon=new ImageIcon(getClass().getResource("book3.png"));
        JLabel l=new JLabel(bookicon,JLabel.CENTER);
        tpcp.add(l,BorderLayout.CENTER);    
        lblTitle=new JLabel("ONLINE PUBLIC LIBRARY",SwingConstants.CENTER);
        lblTitle.setFont(new Font("Algerian",Font.BOLD,20));
        lblTitle.setForeground(Color.WHITE);
        tpcp.setBackground(new Color(31,31,31));
        tpcp.add(lblTitle,BorderLayout.SOUTH);
        
        //TOP CENTER PANEL , EAST PANEL, for BACK BUTTON
        JPanel tpEp = new JPanel();
            //tpEp.setPreferredSize(new Dimension(35,50));
            tpEp.setBackground(new Color(31, 31, 31));
            Icon backicon=new ImageIcon(getClass().getResource("back.png"));
            JLabel l6=new JLabel(backicon);
        btnback = new JButton();
        btnback.setBorder(BorderFactory.createLineBorder(new Color(31, 31, 31)));
            //btnback.setPreferredSize(new Dimension(65,50));
            btnback.setBackground(new Color(31, 31, 31));
            
            btnback.add(l6);
            tpEp.add(btnback);
        
            //TOP CENTER PANEL , WEST PANEL, for LOGOUT BUTTON
        JPanel tpWp = new JPanel();
           // tpWp.setPreferredSize(new Dimension(35,50));
            tpWp.setBackground(new Color(31, 31, 31));
            Icon logouticon=new ImageIcon(getClass().getResource("logout.png"));
            JLabel l7=new JLabel(logouticon);
        btnlogout = new JButton();
         btnlogout.setBorder(BorderFactory.createLineBorder(new Color(31, 31, 31)));
          // btnhome.setPreferredSize(new Dimension(65,50));
            btnlogout.setBackground(new Color(31, 31, 31));
            
            btnlogout.add(l7);
            tpWp.add(btnlogout);
            
            tpcp.add(tpEp,BorderLayout.EAST);
            tpcp.add(tpWp,BorderLayout.WEST);
       
        
        
        //tP.add(tpEp,BorderLayout.EAST);
        tP.add(tpcp,BorderLayout.CENTER);  //adding tpcp to toppanel
        
        mainpanel.add(tP,BorderLayout.NORTH);
        
        
        //CENTER PANEL
        cp= new JPanel(new GridLayout(2,2,5,5));
        
        btnborrow = new JButton();
        Icon borrowicon=new ImageIcon(getClass().getResource("borrow.png"));
        JLabel l2=new JLabel(borrowicon,JLabel.CENTER);
        l2.setText("BORROW BOOK");
         btnborrow.add(l2);
        cp.add(btnborrow);
        
        
        btnreturn = new JButton();
        Icon returnicon=new ImageIcon(getClass().getResource("return.png"));
        JLabel l3=new JLabel(returnicon,JLabel.CENTER);
        l3.setText("RETURN BOOK");
        btnreturn.add(l3);
        cp.add(btnreturn);
        
        btnadd = new JButton();
        Icon addicon=new ImageIcon(getClass().getResource("add.png"));
        JLabel l4=new JLabel(addicon,JLabel.CENTER);
        l4.setText("ADD BOOK");
        btnadd.add(l4);
        cp.add(btnadd);
        
       
       btndelete = new JButton();
        Icon deleteicon=new ImageIcon(getClass().getResource("delete.png"));
        JLabel l5=new JLabel(deleteicon,JLabel.CENTER);
        l5.setText("DELETE BOOK");
        btndelete.add(l5);
        cp.add(btndelete);
        
        mainpanel.add(cp,BorderLayout.CENTER);
        
        frame.add(mainpanel);
        
        ButtonHandler b=new ButtonHandler();
        btnborrow.addActionListener(b);
        btnreturn.addActionListener(b);
        btndelete.addActionListener(b);
        btnadd.addActionListener(b);
        btnback.addActionListener(b);
        btnlogout.addActionListener(b);
    }
public static void disposer(){
frame.dispose();
}
    
   
    
    class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
        if(e.getSource().equals(btnborrow)){
            new borrowBook();
        }
        else if(e.getSource().equals(btnreturn)){
            new returnBook();
        }
        else if(e.getSource().equals(btndelete)){
            new deleteBook();
        }
        else if(e.getSource().equals(btnadd)){
            new addBook();
        }
        else if(e.getSource().equals(btnback)||e.getSource().equals(btnlogout)){
            frame.dispose();
        }
      }  
    }  
}