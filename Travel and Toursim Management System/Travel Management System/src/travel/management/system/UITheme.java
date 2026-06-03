package travel.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class UITheme {
    static final Color BACKGROUND = new Color(245, 247, 250);
    static final Color SURFACE = Color.WHITE;
    static final Color PRIMARY = new Color(24, 119, 242);
    static final Color PRIMARY_DARK = new Color(13, 90, 185);
    static final Color ACCENT = new Color(0, 150, 136);
    static final Color TEXT = new Color(35, 45, 60);
    static final Color MUTED_TEXT = new Color(98, 111, 134);
    static final Color BORDER = new Color(220, 226, 235);
    static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 28);
    static final Font SUBTITLE_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    static final Font LABEL_FONT = new Font("Segoe UI", Font.BOLD, 13);
    static final Font BODY_FONT = new Font("Segoe UI", Font.PLAIN, 13);
    static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 13);

    private UITheme() {
    }

    static void prepareFrame(JFrame frame, String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    static JPanel panel(Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        return panel;
    }

    static JLabel title(String text) {
        JLabel label = new JLabel(text);
        label.setFont(TITLE_FONT);
        label.setForeground(TEXT);
        return label;
    }

    static JLabel subtitle(String text) {
        JLabel label = new JLabel(text);
        label.setFont(SUBTITLE_FONT);
        label.setForeground(MUTED_TEXT);
        return label;
    }

    static JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(TEXT);
        return label;
    }

    static void styleField(JTextField field) {
        field.setFont(BODY_FONT);
        field.setForeground(TEXT);
        field.setBackground(Color.WHITE);
        field.setBorder(fieldBorder());
        field.setCaretColor(PRIMARY);
    }

    static void styleCombo(JComboBox comboBox) {
        comboBox.setFont(BODY_FONT);
        comboBox.setForeground(TEXT);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(new LineBorder(BORDER));
    }

    static JButton primaryButton(String text) {
        return button(text, PRIMARY, Color.WHITE);
    }

    static JButton secondaryButton(String text) {
        return button(text, new Color(232, 240, 254), PRIMARY_DARK);
    }

    static JButton quietButton(String text) {
        return button(text, new Color(241, 244, 248), TEXT);
    }

    static void styleMenu(JMenuBar menuBar) {
        menuBar.setBackground(Color.WHITE);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER));
        menuBar.setFont(BODY_FONT);
    }

    static void styleMenu(JMenu menu) {
        menu.setFont(BUTTON_FONT);
        menu.setForeground(TEXT);
        menu.setBorder(new EmptyBorder(8, 14, 8, 14));
    }

    static void styleMenuItem(JMenuItem item) {
        item.setFont(BODY_FONT);
        item.setForeground(TEXT);
        item.setBackground(Color.WHITE);
        item.setBorder(new EmptyBorder(8, 14, 8, 30));
    }

    private static JButton button(String text, final Color background, final Color foreground) {
        final JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(8, 16, 8, 16));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(background.darker());
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(background);
            }
        });
        return button;
    }

    private static Border fieldBorder() {
        return new CompoundBorder(new LineBorder(BORDER), new EmptyBorder(6, 10, 6, 10));
    }

    static void addSoftBorder(JComponent component) {
        component.setBorder(new CompoundBorder(new LineBorder(BORDER), new EmptyBorder(18, 22, 18, 22)));
    }
}
