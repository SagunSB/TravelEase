/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
	new ForgotPassword().setVisible(true);
    }

    public ForgotPassword() {

        UITheme.prepareFrame(this, "Travel Management - Password Recovery", 820, 450);
	contentPane = UITheme.panel(UITheme.BACKGROUND);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

        JPanel card = UITheme.panel(UITheme.SURFACE);
        UITheme.addSoftBorder(card);
        card.setBounds(44, 34, 720, 340);
        contentPane.add(card);

        JLabel title = UITheme.title("Recover password");
        title.setBounds(38, 24, 320, 36);
        card.add(title);

        JLabel subtitle = UITheme.subtitle("Enter your username, confirm the security answer, and retrieve your password.");
        subtitle.setBounds(38, 62, 520, 24);
        card.add(subtitle);

	JLabel l1 = UITheme.label("Username");
	l1.setBounds(38, 108, 120, 24);
	card.add(l1);

	JLabel l2 = UITheme.label("Name");
	l2.setBounds(38, 170, 120, 24);
	card.add(l2);

	JLabel l3 = UITheme.label("Security Question");
	l3.setBounds(286, 170, 160, 24);
	card.add(l3);

	JLabel l4 = UITheme.label("Answer");
	l4.setBounds(38, 232, 120, 24);
	card.add(l4);

	JLabel l5 = UITheme.label("Recovered Password");
	l5.setBounds(286, 232, 180, 24);
	card.add(l5);

	t1 = new JTextField();
        UITheme.styleField(t1);
	t1.setBounds(38, 132, 210, 34);
	card.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setEditable(false);
        UITheme.styleField(t2);
	t2.setColumns(10);
	t2.setBounds(38, 194, 210, 34);
	card.add(t2);

	t3 = new JTextField();
	t3.setEditable(false);
        UITheme.styleField(t3);
	t3.setColumns(10);
	t3.setBounds(286, 194, 260, 34);
	card.add(t3);

	t4 = new JTextField();
        UITheme.styleField(t4);
	t4.setColumns(10);
	t4.setBounds(38, 256, 210, 34);
	card.add(t4);

	t5 = new JTextField();
	t5.setEditable(false);
        UITheme.styleField(t5);
	t5.setColumns(10);
	t5.setBounds(286, 256, 260, 34);
	card.add(t5);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/forgotpassword.jpg"));
        Image i1 = c1.getImage().getScaledInstance(110, 110,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(570, 108, 110, 110);
        card.add(l6);

	b1 = UITheme.secondaryButton("Search");
	b1.addActionListener(this);
	b1.setBounds(262, 132, 96, 34);
        card.add(b1);

	b2 = UITheme.primaryButton("Retrieve");
	b2.addActionListener(this);
	b2.setBounds(570, 256, 110, 34);
	card.add(b2);

	b3 = UITheme.quietButton("Back to Login");
	b3.addActionListener(this);
	b3.setBounds(38, 304, 132, 34);
	card.add(b3);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            if(ae.getSource() == b1){
                String sql = "select * from account where username=?";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("question"));
		}

            }
            if(ae.getSource() == b2){
                String sql = "select * from account where answer=?";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, t4.getText());
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
                    	t5.setText(rs.getString("password"));
		}

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Login().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }

}
