/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package style;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Stil {

    public static final Color PRIMARNA        = new Color(110, 68, 43);   
    public static final Color PRIMARNA_HOVER  = new Color(138, 88, 58);  
    public static final Color SVETLA_NIJANSA  = new Color(249, 243, 238);  


    public static final Color CRVENA          = new Color(180, 30, 30);
    public static final Color CRVENA_HOVER    = new Color(220, 50, 50);
    public static final Color POZADINA        = new Color(248, 248, 248); 
    public static final Color SIVA_BORDER     = new Color(200, 200, 200); 
    public static final Color BELA            = Color.WHITE;
    public static final Color TEKST_TAMNI     = new Color(45, 45, 45);

    public static final Font FONT_NORMAL  = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_BOLD    = new Font("Segoe UI", Font.BOLD, 13);
    public static final Font FONT_NASLOV  = new Font("Segoe UI", Font.BOLD, 18); 
    public static final Font FONT_DUGME   = new Font("Segoe UI", Font.BOLD, 12);

    public static void primarna(JButton btn) {
        primeniDugme(btn, PRIMARNA, PRIMARNA_HOVER);
    }

    public static void crveno(JButton btn) {
        primeniDugme(btn, CRVENA, CRVENA_HOVER);
    }

    private static void primeniDugme(JButton btn, Color osnovna, Color hover) {
        btn.setBackground(osnovna);
        btn.setForeground(BELA);
        btn.setFont(FONT_DUGME);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hover);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(osnovna);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                btn.setBackground(osnovna.darker());
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                btn.setBackground(hover);
            }
        });
    }

    public static void labela(JLabel lbl) {
        lbl.setFont(FONT_BOLD);
        lbl.setForeground(TEKST_TAMNI); 
    }

    public static void naslov(JLabel lbl) {
        lbl.setFont(FONT_NASLOV);
        lbl.setForeground(PRIMARNA);
        lbl.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void polje(JTextField txt) {
        txt.setFont(FONT_NORMAL);
        txt.setForeground(TEKST_TAMNI);
        txt.setBackground(BELA);
        txt.setCaretColor(PRIMARNA);
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1),
            BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));
    }

    public static void tabela(JTable table, JScrollPane scrollPane) {
        table.setFont(FONT_NORMAL);
        table.setForeground(TEKST_TAMNI);
        table.setSelectionBackground(SVETLA_NIJANSA);
        table.setSelectionForeground(PRIMARNA);
        table.setRowHeight(25); 
        table.setGridColor(SIVA_BORDER);
        table.setShowVerticalLines(false); 

        table.getTableHeader().setFont(FONT_BOLD);
        table.getTableHeader().setBackground(PRIMARNA);
        table.getTableHeader().setForeground(BELA);
        table.getTableHeader().setReorderingAllowed(false);

        scrollPane.setBorder(BorderFactory.createLineBorder(SIVA_BORDER, 1));
        scrollPane.getViewport().setBackground(BELA);
    }

    public static void meni(javax.swing.JMenuBar menuBar) {
        menuBar.setBackground(PRIMARNA);
        menuBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        menuBar.setOpaque(true);

        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            javax.swing.JMenu menu = menuBar.getMenu(i);
            if (menu != null) stilizujMenu(menu);
        }
    }

    private static void stilizujMenu(javax.swing.JMenu menu) {
        menu.setFont(FONT_BOLD);
        menu.setForeground(BELA);
        menu.setBackground(PRIMARNA);
        menu.setOpaque(true);
        menu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));

        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                menu.setBackground(PRIMARNA_HOVER);
                menu.setOpaque(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                menu.setBackground(PRIMARNA);
            }
        });

        menu.getPopupMenu().setBackground(POZADINA);
        menu.getPopupMenu().setBorder(BorderFactory.createLineBorder(SIVA_BORDER, 1));

        for (int j = 0; j < menu.getItemCount(); j++) {
            javax.swing.JMenuItem item = menu.getItem(j);
            if (item != null) {
                stilizujMenuItem(item);
            }
        }
    }

    private static void stilizujMenuItem(javax.swing.JMenuItem item) {
        item.setFont(FONT_NORMAL);
        item.setForeground(TEKST_TAMNI);
        item.setBackground(POZADINA);
        item.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));
        item.setOpaque(true);

        item.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                item.setBackground(SVETLA_NIJANSA);
                item.setForeground(PRIMARNA);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                item.setBackground(POZADINA);
                item.setForeground(TEKST_TAMNI);
            }
        });
    }

    public static void pozadina(java.awt.Container container) {
        container.setBackground(POZADINA);
    }
    
    public static void stilizujOptionPane() {
        javax.swing.UIManager.put("OptionPane.background", POZADINA);
        javax.swing.UIManager.put("Panel.background", POZADINA);
        javax.swing.UIManager.put("OptionPane.messageForeground", TEKST_TAMNI);
        javax.swing.UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 13));
        javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 12));
        javax.swing.UIManager.put("Button.background", PRIMARNA);
        javax.swing.UIManager.put("Button.foreground", BELA);
        javax.swing.UIManager.put("Button.focus", new Color(0, 0, 0, 0));
        javax.swing.UIManager.put("Button.select", PRIMARNA.darker());
        javax.swing.UIManager.put("OptionPane.titleFont", new Font("Segoe UI", Font.BOLD, 13));
        javax.swing.UIManager.put("TextField.background", BELA);
        javax.swing.UIManager.put("TextField.foreground", TEKST_TAMNI);
        javax.swing.UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 13));
        javax.swing.UIManager.put("TextField.caretForeground", PRIMARNA);

        javax.swing.UIManager.put("OptionPane.yesButtonText", "Da");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Ne");
        javax.swing.UIManager.put("OptionPane.okButtonText", "U redu");
        javax.swing.UIManager.put("OptionPane.cancelButtonText", "Otkaži");
        
        javax.swing.UIManager.put("Menu.selectionBackground", PRIMARNA);
        javax.swing.UIManager.put("Menu.selectionForeground", BELA);
        javax.swing.UIManager.put("MenuItem.selectionBackground", PRIMARNA);
        javax.swing.UIManager.put("MenuItem.selectionForeground", BELA);
        javax.swing.UIManager.put("MenuItem.background", POZADINA);
        javax.swing.UIManager.put("MenuItem.foreground", TEKST_TAMNI);
        javax.swing.UIManager.put("Menu.background", PRIMARNA);
        javax.swing.UIManager.put("Menu.foreground", BELA);
    }
}
