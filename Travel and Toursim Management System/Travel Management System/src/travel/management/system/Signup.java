/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        UITheme.prepareFrame(this, "Travel Management - Create Account", 760, 460);
	contentPane = UITheme.panel(UITheme.BACKGROUND);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

        JPanel card = UITheme.panel(UITheme.SURFACE);
        UITheme.addSoftBorder(card);
        card.setBounds(44, 34, 670, 350);
        contentPane.add(card);

        JLabel title = UITheme.title("Create account");
        title.setBounds(38, 24, 280, 36);
        card.add(title);

        JLabel subtitle = UITheme.subtitle("Use a memorable security answer so account recovery is easy later.");
        subtitle.setBounds(38, 62, 420, 24);
        card.add(subtitle);

	JLabel lblUsername = UITheme.label("Username");
	lblUsername.setBounds(38, 104, 120, 24);
	card.add(lblUsername);

	JLabel lblName = UITheme.label("Name");
	lblName.setBounds(38, 166, 120, 24);
	card.add(lblName);

	JLabel lblPassword = UITheme.label("Password");
	lblPassword.setBounds(38, 228, 120, 24);
	card.add(lblPassword);

	JLabel lblAnswer = UITheme.label("Answer");
	lblAnswer.setBounds(320, 228, 120, 24);
	card.add(lblAnswer);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
        UITheme.styleCombo(comboBox);
	comboBox.setBounds(320, 190, 260, 34);
	card.add(comboBox);

	JLabel lblSecurityQuestion = UITheme.label("Security Question");
	lblSecurityQuestion.setBounds(320, 166, 160, 24);
	card.add(lblSecurityQuestion);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/signup.png"));
        Image i1 = c1.getImage().getScaledInstance(118, 118,Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(480, 34, 118, 118);
        card.add(l6);

        textField = new JTextField();
        UITheme.styleField(textField);
	textField.setBounds(38, 128, 250, 34);
	card.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
        UITheme.styleField(textField_1);
	textField_1.setColumns(10);
	textField_1.setBounds(38, 190, 250, 34);
	card.add(textField_1);

        textField_2 = new JTextField();
        UITheme.styleField(textField_2);
	textField_2.setColumns(10);
	textField_2.setBounds(38, 252, 250, 34);
	card.add(textField_2);

	textField_3 = new JTextField();
        UITheme.styleField(textField_3);
	textField_3.setColumns(10);
	textField_3.setBounds(320, 252, 260, 34);
	card.add(textField_3);

	b1 = UITheme.primaryButton("Create Account");
	b1.addActionListener(this);
	b1.setBounds(38, 304, 150, 34);
	card.add(b1);

	b2 = UITheme.quietButton("Back to Login");
	b2.addActionListener(this);
	b2.setBounds(206, 304, 138, 34);
	card.add(b2);

        getRootPane().setDefaultButton(b1);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            
            if(ae.getSource() == b1){
                String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		st.setString(4, (String) comboBox.getSelectedItem());
		st.setString(5, textField_3.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                }

                textField.setText("");
                textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Login().setVisible(true);
			
            }
        }catch(Exception e){
                System.out.println(e);
        }
    }
}
