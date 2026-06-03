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

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
        String username;
	int s;
	Thread th;

	public static void main(String[] args) {
            new Loading("").setVisible(true);
	}

	public void setUploading() {
            setVisible(false);
            th.start();
	}

	public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    s = s + 1;
                    int m = progressBar.getMaximum();
                    int v = progressBar.getValue();
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } else {
                        i = 201;
                        setVisible(false);
                        new Home(username).setVisible(true);
                    }
                    Thread.sleep(50);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public Loading(String username) {
            this.username = username;
            th = new Thread((Runnable) this);

            setBounds(600, 300, 600, 360);
            contentPane = UITheme.panel(UITheme.BACKGROUND);
            setContentPane(contentPane);

            JPanel card = UITheme.panel(UITheme.SURFACE);
            UITheme.addSoftBorder(card);
            card.setBounds(40, 44, 520, 240);
            contentPane.add(card);

            JLabel lbllibraryManagement = UITheme.title("Preparing your workspace");
            lbllibraryManagement.setBounds(40, 34, 430, 36);
            card.add(lbllibraryManagement);

            JLabel message = UITheme.subtitle("Loading customer, package and booking tools...");
            message.setBounds(40, 76, 420, 24);
            card.add(message);
	
            progressBar = new JProgressBar();
            progressBar.setFont(UITheme.BODY_FONT);
            progressBar.setStringPainted(true);
            progressBar.setForeground(UITheme.PRIMARY);
            progressBar.setBackground(new Color(232, 240, 254));
            progressBar.setBounds(40, 128, 440, 28);
            card.add(progressBar);

            JLabel lblNewLabel_2 = UITheme.subtitle("Please wait...");
            lblNewLabel_2.setBounds(40, 168, 200, 24);
            card.add(lblNewLabel_2);
              
            setUndecorated(true);
            setUploading();
	}
}
