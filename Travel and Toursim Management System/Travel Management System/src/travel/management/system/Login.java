/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;


	public Login() {
        UITheme.prepareFrame(this, "Travel Management - Login", 760, 440);
        panel = UITheme.panel(UITheme.BACKGROUND);
        setContentPane(panel);

        JPanel card = UITheme.panel(UITheme.SURFACE);
        UITheme.addSoftBorder(card);
        card.setBounds(44, 38, 670, 330);
        panel.add(card);

        JLabel title = UITheme.title("Welcome back");
        title.setBounds(40, 30, 300, 36);
        card.add(title);

        JLabel subtitle = UITheme.subtitle("Sign in to manage customers, packages, hotels and bookings.");
        subtitle.setBounds(40, 68, 370, 24);
        card.add(subtitle);

        JLabel l1 = UITheme.label("Username");
        l1.setBounds(40, 120, 120, 24);
        card.add(l1);

        textField = new JTextField();
        UITheme.styleField(textField);
        textField.setBounds(40, 148, 270, 34);
        card.add(textField);

        JLabel l2 = UITheme.label("Password");
        l2.setBounds(40, 194, 120, 24);
        card.add(l2);

        passwordField = new JPasswordField();
        UITheme.styleField(passwordField);
        passwordField.setBounds(40, 222, 270, 34);
        card.add(passwordField);

        b1 = UITheme.primaryButton("Login");
        b1.addActionListener(this);
        b1.setBounds(40, 276, 120, 34);
        card.add(b1);

        b2 = UITheme.secondaryButton("Create Account");
        b2.addActionListener(this);
        b2.setBounds(174, 276, 142, 34);
        card.add(b2);

        b3 = UITheme.quietButton("Forgot Password?");
        b3.addActionListener(this);
        b3.setBounds(330, 276, 152, 34);
        card.add(b3);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/login.png"));
        Image i1 = c1.getImage().getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(i1));
        image.setBounds(430, 62, 190, 190);
        card.add(image);

        getRootPane().setDefaultButton(b1);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    Conn con = new Conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading(textField.getText()).setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		ForgotPassword forgot = new ForgotPassword();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login().setVisible(true);
	}

}
