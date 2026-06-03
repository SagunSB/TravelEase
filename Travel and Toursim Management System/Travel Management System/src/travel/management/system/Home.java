/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame{
    String username;
    public static void main(String[] args) {
        new Home("").setVisible(true);
    }
    
    public Home(String username) {
        super("TravelEase");
	this.username = username;
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(null);
        welcomePanel.setBackground(new Color(255, 255, 255, 230));
        welcomePanel.setBounds(80, 70, 720, 220);
        NewLabel.add(welcomePanel);

        JLabel l1 = UITheme.title("TravelEase");
	l1.setBounds(34, 26, 560, 42);
	welcomePanel.add(l1);

        JLabel welcomeTitle = UITheme.label("Welcome section");
	welcomeTitle.setBounds(34, 74, 220, 24);
	welcomePanel.add(welcomeTitle);

        JLabel l2 = UITheme.subtitle("Welcome " + (username == null || username.trim().length() == 0 ? "traveler" : username)
                + ". Use the menu above to manage customers, bookings, hotels, destinations and payments.");
	l2.setBounds(34, 104, 650, 28);
	welcomePanel.add(l2);

        JLabel l3 = UITheme.subtitle("Tip: start with Customer, then choose Packages or Hotels for bookings.");
	l3.setBounds(34, 140, 650, 28);
	welcomePanel.add(l3);
		
		
        JMenuBar menuBar = new JMenuBar();
        UITheme.styleMenu(menuBar);
	setJMenuBar(menuBar);

        JMenu accountMenu = new JMenu("Account");
        UITheme.styleMenu(accountMenu);
	menuBar.add(accountMenu);

        JMenuItem profileItem = new JMenuItem("Profile");
	accountMenu.add(profileItem);

        JMenuItem logoutItem = new JMenuItem("Logout");
	accountMenu.add(logoutItem);
        styleItems(profileItem, logoutItem);

        profileItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new UpdateCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	});

        logoutItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new Login().setVisible(true);
            }
	});
		
        JMenu m1 = new JMenu("Customers");
        UITheme.styleMenu(m1);
	menuBar.add(m1);
		
        JMenuItem mi1 = new JMenuItem("Add Customer");
	m1.add(mi1);
        
        JMenuItem mi2 = new JMenuItem("Update Customer");
	m1.add(mi2);
        
        JMenuItem mi3 = new JMenuItem("View Customers");
	m1.add(mi3);
        
        JMenuItem mi4 = new JMenuItem("Delete Customer");
	m1.add(mi4);
        styleItems(mi1, mi2, mi3, mi4);
        
        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new UpdateCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        mi3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewCustomers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        mi4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteCustomer().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        
		
	JMenu m2 = new JMenu("Packages");
        UITheme.styleMenu(m2);
	menuBar.add(m2);
        
        JMenuItem mi6 = new JMenuItem("Check Packages");
	m2.add(mi6);
        
        JMenuItem mi7 = new JMenuItem("Book Package");
	m2.add(mi7);
        
        JMenuItem mi5 = new JMenuItem("View Booking");
	m2.add(mi5);
        styleItems(mi6, mi7, mi5);
        
        
        mi6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckPackage().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        mi7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new BookPackage(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	mi5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewPackage(username).setVisible(true);
                }catch(Exception e ){}
                
            }
	});
        
        
        JMenu m3 = new JMenu("Hotels");
        UITheme.styleMenu(m3);
	menuBar.add(m3);
        
        JMenuItem mi8 = new JMenuItem("Book Hotel");
	m3.add(mi8);
        
        JMenuItem mi9 = new JMenuItem("View Hotels");
	m3.add(mi9);
        
        JMenuItem mi10 = new JMenuItem("View Hotel Booking");
	m3.add(mi10);
        styleItems(mi8, mi9, mi10);
        
        mi8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new BookHotel(username).setVisible(true);
            }
	});
        
        
        
	mi9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckHotels().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        mi10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewBookedHotel(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        JMenu m4 = new JMenu("Destinations");
        UITheme.styleMenu(m4);
	menuBar.add(m4);
        
        JMenuItem mi11 = new JMenuItem("Explore Destinations");
	m4.add(mi11);
        styleItems(mi11);
        
        mi11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Destination().setVisible(true);
            }
	});
        
        
        JMenu m5 = new JMenu("Payment");
        UITheme.styleMenu(m5);
	menuBar.add(m5);
        
        JMenuItem mi12 = new JMenuItem("Pay Using Paytm");
	m5.add(mi12);
        styleItems(mi12);
        
        mi12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Payment().setVisible(true);
            }
	});
        
        JMenu m6 = new JMenu("Utilities");
        UITheme.styleMenu(m6);
	menuBar.add(m6);
        
        JMenuItem mi13 = new JMenuItem("Notepad");
	m6.add(mi13);
        
        JMenuItem mi14 = new JMenuItem("Calculator");
	m6.add(mi14);
        styleItems(mi13, mi14);
        
        mi13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){ }
            }
	});
        
        
        mi14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
            }
	});
        
        JMenu m7 = new JMenu("About");
        UITheme.styleMenu(m7);
	menuBar.add(m7);
        
        JMenuItem mi15 = new JMenuItem("About Project");
	m7.add(mi15);
        styleItems(mi15);
        
        mi15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new About().setVisible(true);
            }
	});
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    private void styleItems(JMenuItem... items) {
        for (int i = 0; i < items.length; i++) {
            UITheme.styleMenuItem(items[i]);
        }
    }
}
