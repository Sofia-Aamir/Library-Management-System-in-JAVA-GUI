/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame{
    private JPanel mainPanel,tP,mP,bp;
    private JLabel lblTitle,lblTitle2,lblEmail,lblPass;
    private JTextField txtEmail;
    private JPasswordField pass;
    private JButton btnsignin,btnsignup;
    private JCheckBox cb;
    private Color lightblueclr;
    private JFrame frame;
    
    public Login(){
        
        //Made JFrame to get its source 
        frame=new JFrame();
        frame.setTitle("LOGIN PAGE");

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,400);
        frame.setLocationRelativeTo(null);
        
        initialize(frame);
        
        frame.setVisible(true);
    }
    
     //public void loc(){System.out.println(this.getX()+"fgh"+this.getY());}
    
        private void initialize(JFrame frame){
        
            BorderLayout BLframe=new BorderLayout();
            mainPanel=new JPanel();
            mainPanel.setLayout(BLframe);
            lightblueclr=new Color(71, 197, 251);
        
            //TOP PANEL
            tP=new JPanel();
            tP.setLayout(new BorderLayout());
            tP.setBackground(lightblueclr);
        
            Icon bookicon=new ImageIcon(getClass().getResource("book.png"));
            JLabel l=new JLabel(bookicon,JLabel.CENTER);
            tP.add(l,BorderLayout.NORTH);
       
            lblTitle=new JLabel("Welcome",SwingConstants.CENTER);
            lblTitle.setFont(new Font("Calibri",Font.BOLD,40));
            lblTitle.setForeground(new Color(255,255,255));
            tP.add(lblTitle,BorderLayout.CENTER);  
        
            lblTitle2=new JLabel("WHEN IN DOUBT GO TO LIBRARY",SwingConstants.CENTER);
            lblTitle2.setFont(new Font("Calibri",Font.BOLD,15));
            lblTitle2.setForeground(Color.WHITE);
            tP.add(lblTitle2,BorderLayout.SOUTH);
    
            //MIDDLE PANEL
            mP=new JPanel();
            mP.setBackground(lightblueclr);
            mP.setLayout(new GridLayout(4,1));
            lblEmail=new JLabel("EMAIL",SwingConstants.CENTER);
            mP.add(lblEmail);
        
            SpringLayout slay=new SpringLayout();                      //Spring Layout for Email and PasswordCheckbox
        
            JPanel pnlEmail=new JPanel(slay);        //panel for email text field 
            pnlEmail.setBackground(lightblueclr);
        
            txtEmail=new JTextField();
            txtEmail.setText("enter your email");
            txtEmail.setColumns(20);
        
            slay.putConstraint(SpringLayout.HORIZONTAL_CENTER, txtEmail, 0, SpringLayout.HORIZONTAL_CENTER, pnlEmail);
            slay.putConstraint(SpringLayout.VERTICAL_CENTER, txtEmail, 0, SpringLayout.VERTICAL_CENTER, pnlEmail);
        
            pnlEmail.add(txtEmail);
            mP.add(pnlEmail);
        
        
            lblPass=new JLabel("PASSWORD",SwingConstants.CENTER);
            mP.add(lblPass);
        
        
            JPanel pnlpassCb=new JPanel(slay);       //panel for password text field
            pnlpassCb.setBackground(lightblueclr);
        
            pass=new JPasswordField("....",20);
            // pass.setText("....");
            cb=new JCheckBox();
            cb.setBackground(lightblueclr);
        
            slay.putConstraint(SpringLayout.EAST,cb,0, SpringLayout.EAST, pnlpassCb);
            slay.putConstraint(SpringLayout.HORIZONTAL_CENTER, pass, 0,SpringLayout.HORIZONTAL_CENTER,pnlpassCb);
        
            pnlpassCb.add(pass);
            pnlpassCb.add(cb);
            mP.add(pnlpassCb);
        
            //BOTTOM PANEL 
            bp=new JPanel();
            bp.setLayout(new FlowLayout());
            bp.setBackground(lightblueclr);
        
            //JPanel buttonpanel=new JPanel(new FlowLayout());
            //buttonpanel.setBackground(new Color(71, 197, 251));
        
            //bp.add(buttonpanel);
        
            btnsignin=new JButton("SIGNIN");
            bp.add(btnsignin);
       
            btnsignup=new JButton("SIGNUP");
            bp.add(btnsignup);
        
        
        
            //adding panels to FRAME    
            mainPanel.add(tP,BorderLayout.NORTH);
            mainPanel.add(mP,BorderLayout.CENTER);
            mainPanel.add(bp,BorderLayout.SOUTH);
        
            frame.add(mainPanel);
        
            texthandler h=new texthandler();
            btnsignin.addActionListener(h);
            btnsignup.addActionListener(h);
            cb.addActionListener(h);
            
        }
    
    
    
    class texthandler implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(btnsignin)){
                
            if(txtEmail.getText().equals("admin") && pass.getText().equals("123")){
                    funcitonalityPage funcitonalityPage = new funcitonalityPage();
                    
                 }
            }
            if(e.getSource().equals(btnsignup)){
            new regestrationForm();
            }
            else if(cb.isSelected()){
                JOptionPane.showMessageDialog(null, "Password is : "+pass.getText());
                System.out.println(" ");            
            }           
        }    
    }  
}
