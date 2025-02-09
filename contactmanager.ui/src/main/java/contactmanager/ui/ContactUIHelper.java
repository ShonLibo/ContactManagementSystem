package contactmanager.ui;

import javax.swing.*;
import java.awt.*;

public class ContactUIHelper {

    public static void styleCardPanel(JPanel panel) {
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(180, 180, 180), 10),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                )
        );
    }

    public static void styleHeaderLabel(JLabel label) {
        label.setOpaque(true);
        label.setBackground(new Color(70, 130, 180)); // SteelBlue
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    }

    public static void styleDetailLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.BLACK);
    }

    public static void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180)); // SteelBlue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void updateRowPanelColors(JPanel listContainer, int selectedContactIndex) {
        Component[] comps = listContainer.getComponents();
        for (Component comp : comps) {
            if (comp instanceof JPanel) {
                JPanel row = (JPanel) comp;
                Integer idx = (Integer) row.getClientProperty("index");
                if (idx != null && idx == selectedContactIndex) {
                    row.setBackground(new Color(180, 180, 180));
                } else {
                    row.setBackground(new Color(230, 230, 230));
                }
            }
        }
        listContainer.repaint();
    }
}