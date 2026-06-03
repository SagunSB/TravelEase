package travel.management.system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About extends JFrame implements ActionListener {

    private JButton closeButton;

    public About() {
        UITheme.prepareFrame(this, "About Travel Management", 560, 560);

        JPanel contentPane = UITheme.panel(UITheme.BACKGROUND);
        setContentPane(contentPane);

        JPanel card = UITheme.panel(UITheme.SURFACE);
        UITheme.addSoftBorder(card);
        card.setBounds(34, 30, 480, 450);
        contentPane.add(card);

        JLabel heading = UITheme.title("About TravelEase");
        heading.setBounds(30, 24, 260, 36);
        card.add(heading);

        JLabel subheading = UITheme.subtitle("Travel and Tourism Management System");
        subheading.setBounds(30, 62, 360, 24);
        card.add(subheading);

        String description = "This application helps travel teams manage customers, tour packages, "
                + "hotel bookings, payments and destination information from one simple desktop system.\n\n"
                + "It is designed to reduce manual paperwork, keep booking information easy to find, "
                + "and give users clear feedback while they work.\n\n"
                + "Key benefits:\n"
                + "- Accurate customer and booking records\n"
                + "- Faster package and hotel management\n"
                + "- Less manual documentation\n"
                + "- Easy access to traveler details\n"
                + "- Clear booking confirmation messages\n"
                + "- Simple and friendly navigation";

        JTextArea aboutText = new JTextArea(description);
        aboutText.setEditable(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        aboutText.setForeground(UITheme.TEXT);
        aboutText.setBackground(UITheme.SURFACE);
        aboutText.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JScrollPane scrollPane = new JScrollPane(aboutText);
        scrollPane.setBorder(BorderFactory.createLineBorder(UITheme.BORDER));
        scrollPane.setBounds(30, 104, 420, 270);
        card.add(scrollPane);

        closeButton = UITheme.primaryButton("Close");
        closeButton.setBounds(30, 394, 110, 34);
        closeButton.addActionListener(this);
        card.add(closeButton);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        new About().setVisible(true);
    }
}
