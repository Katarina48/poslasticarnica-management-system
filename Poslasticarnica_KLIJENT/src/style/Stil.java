/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package style;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class Stil {

    
    public static final Color BRAON         = new Color(196, 130, 89);  // Topla karamela — glavna boja
    public static final Color BRAON_HOVER   = new Color(216, 155, 115); // Svetlija karamela na hover
    public static final Color KREM_SVETLA   = new Color(250, 240, 227); // Nežna krem boja za tabele i detalje

   
    public static final Color CRVENA        = new Color(196, 90, 74);   // Meka terakota-crvena za otkazivanje/brisanje
    public static final Color CRVENA_HOVER  = new Color(214, 115, 100);
    public static final Color POZADINA      = new Color(253, 248, 242); // Topla bela/krem pozadina formi
    public static final Color SIVA_BORDER   = new Color(222, 205, 190); // Prefinjeni topli border
    public static final Color BELA          = Color.WHITE;
    public static final Color TEKST_TAMNI   = new Color(74, 48, 36);    // Toplo tamno braon za tekst


    public static final Font FONT_NORMAL  = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_BOLD    = new Font("Segoe UI", Font.BOLD, 13);
    public static final Font FONT_NASLOV  = new Font("Segoe UI", Font.BOLD, 16);
    public static final Font FONT_DUGME   = new Font("Segoe UI", Font.BOLD, 12);
    public static final Font FONT_TABELA  = new Font("Segoe UI", Font.PLAIN, 12);
    public static final Font FONT_HEADER  = new Font("Segoe UI", Font.BOLD, 12);

    
    public static void primarna(JButton btn) {
        primeniDugme(btn, BRAON, BRAON_HOVER);
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
        lbl.setForeground(BRAON);
    }

    public static void naslov(JLabel lbl) {
        lbl.setFont(FONT_NASLOV);
        lbl.setForeground(BRAON);
        lbl.setHorizontalAlignment(JLabel.CENTER);
    }

    public static void iznosLabela(JLabel lbl) {
        lbl.setFont(FONT_BOLD);
        lbl.setForeground(BRAON);
        lbl.setBackground(KREM_SVETLA);
        lbl.setOpaque(true);
        lbl.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1, true),
            BorderFactory.createEmptyBorder(4, 10, 4, 10)
        ));
    }

    public static void polje(JTextField txt) {
        txt.setFont(FONT_NORMAL);
        txt.setForeground(TEKST_TAMNI);
        txt.setBackground(BELA);
        txt.setCaretColor(BRAON);
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }

    public static void lozinka(JPasswordField txt) {
        txt.setFont(FONT_NORMAL);
        txt.setForeground(TEKST_TAMNI);
        txt.setBackground(BELA);
        txt.setCaretColor(BRAON);
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
    }

    public static void tabela(JTable tbl) {
        tbl.setFont(FONT_TABELA);
        tbl.setRowHeight(30);

        tbl.setBackground(BELA);
        tbl.setForeground(TEKST_TAMNI);
        tbl.setSelectionBackground(BRAON);
        tbl.setSelectionForeground(BELA);
        tbl.setGridColor(new Color(230, 225, 220));

        tbl.setShowHorizontalLines(true);
        tbl.setShowVerticalLines(false);

        tbl.getTableHeader().setReorderingAllowed(false);

        tbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    setBackground(row % 2 == 0 ? BELA : KREM_SVETLA);
                    setForeground(TEKST_TAMNI);
                } else {
                    setBackground(BRAON);
                    setForeground(BELA);
                }
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
                return this;
            }
        });

        JTableHeader header = tbl.getTableHeader();
        header.setFont(FONT_HEADER);
        header.setBackground(BRAON);
        header.setForeground(BELA);
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        header.setBorder(BorderFactory.createLineBorder(BRAON));
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
            .setHorizontalAlignment(JLabel.LEFT);
    }

    public static void stilizujOptionPane() {
        javax.swing.UIManager.put("OptionPane.background", POZADINA);
        javax.swing.UIManager.put("Panel.background", POZADINA);

        javax.swing.UIManager.put("OptionPane.messageForeground", TEKST_TAMNI);
        javax.swing.UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 13));

        javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 12));
        javax.swing.UIManager.put("Button.background", BRAON);
        javax.swing.UIManager.put("Button.foreground", BELA);
        javax.swing.UIManager.put("Button.focus", new Color(91, 52, 36, 0)); 
        javax.swing.UIManager.put("Button.select", BRAON.darker());

        javax.swing.UIManager.put("OptionPane.titleFont", new Font("Segoe UI", Font.BOLD, 13));

        javax.swing.UIManager.put("TextField.background", BELA);
        javax.swing.UIManager.put("TextField.foreground", TEKST_TAMNI);
        javax.swing.UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 13));
        javax.swing.UIManager.put("TextField.caretForeground", BRAON);
        
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Da");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Ne");
        javax.swing.UIManager.put("OptionPane.okButtonText", "U redu");
        javax.swing.UIManager.put("OptionPane.cancelButtonText", "Otkaži");
        
        javax.swing.UIManager.put("Menu.selectionBackground", BRAON);
        javax.swing.UIManager.put("Menu.selectionForeground", BELA);
        javax.swing.UIManager.put("MenuItem.selectionBackground", BRAON);
        javax.swing.UIManager.put("MenuItem.selectionForeground", BELA);
        javax.swing.UIManager.put("MenuItem.background", POZADINA);
        javax.swing.UIManager.put("MenuItem.foreground", TEKST_TAMNI);
        javax.swing.UIManager.put("Menu.background", BRAON);
        javax.swing.UIManager.put("Menu.foreground", BELA);
    }

    public static void kombo(javax.swing.JComboBox<?> cmb) {
        cmb.setFont(FONT_NORMAL);
        cmb.setBackground(BELA);
        cmb.setForeground(TEKST_TAMNI);
        cmb.setBorder(BorderFactory.createLineBorder(SIVA_BORDER, 1));
        cmb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmb.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
                setFont(FONT_NORMAL);
                setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
                if (isSelected) {
                    setBackground(BRAON);
                    setForeground(BELA);
                } else {
                    setBackground(BELA);
                    setForeground(TEKST_TAMNI);
                }
                return this;
            }
        });
    }

    public static void meni(javax.swing.JMenuBar menuBar) {
        menuBar.setBackground(BRAON);
        menuBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        menuBar.setOpaque(true);

        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            javax.swing.JMenu menu = menuBar.getMenu(i);
            if (menu != null) {
                stilizujMenu(menu);
            }
        }
    }

    private static void stilizujMenu(javax.swing.JMenu menu) {
        menu.setFont(FONT_BOLD);
        menu.setForeground(BELA);
        menu.setBackground(BRAON);
        menu.setOpaque(true);
        menu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menu.setCursor(new Cursor(Cursor.HAND_CURSOR));

        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                menu.setBackground(BRAON_HOVER);
                menu.setOpaque(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                menu.setBackground(BRAON);
            }
        });

        menu.getPopupMenu().setBackground(POZADINA);
        menu.getPopupMenu().setBorder(
            BorderFactory.createLineBorder(SIVA_BORDER, 1));

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
                item.setBackground(KREM_SVETLA);
                item.setForeground(BRAON);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                item.setBackground(POZADINA);
                item.setForeground(TEKST_TAMNI);
            }
        });
    }

    public static void scrollPanel(javax.swing.JScrollPane scroll) {
        scroll.setBorder(BorderFactory.createLineBorder(SIVA_BORDER, 1));
        scroll.getViewport().setBackground(BELA);
        scroll.setBackground(BELA);
    }

    public static void pozadina(java.awt.Container container) {
        container.setBackground(POZADINA);
    }

    public static void tekstualnaZona(javax.swing.JTextArea txtArea) {
        txtArea.setFont(FONT_NORMAL);
        txtArea.setForeground(TEKST_TAMNI);
        txtArea.setBackground(BELA);
        txtArea.setCaretColor(BRAON);
        txtArea.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
    }
}
