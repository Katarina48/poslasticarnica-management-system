/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import style.Stil;
import model.Poslastica;
import model.StavkaRacuna;
import view.model.PoslasticaTableModel;
import ui.logic.UIController;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PromenaStavkeForm extends javax.swing.JDialog {

    private StavkaRacuna stavkaZaPromenu;

    public PromenaStavkeForm(java.awt.Window parent, boolean modal, StavkaRacuna stavkaZaPromenu) {
        super(parent, ModalityType.APPLICATION_MODAL);
        this.stavkaZaPromenu = stavkaZaPromenu;
        initComponents();
        setTitle("Promena stavke");
        setLocationRelativeTo(null);
        setResizable(false);
        ucitajPoslasticu();
        popuniPolja();

        Stil.primarna(btnSacuvaj);
        Stil.primarna(btnIzaberiPoslasticu);
        Stil.labela(jLabel1); 
        Stil.labela(jLabel2); 
        Stil.polje(txtKolicina);
        Stil.tabela(tblPoslastice);
        Stil.pozadina(getContentPane());
    }

    public StavkaRacuna getStavkaZaPromenu() {
        return stavkaZaPromenu;
    }

    private void ucitajPoslasticu() {
        try {
            ArrayList<Poslastica> lista = UIController.getInstance().vratiListuSviPoslastica(new Poslastica());
            tblPoslastice.setModel(new PoslasticaTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da učita poslastice.", "Greška", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

    private void popuniPolja() {
        txtKolicina.setText(String.valueOf(stavkaZaPromenu.getKolicina()));
        if (stavkaZaPromenu.getPoslastica()!= null) {
            txtIzabranaPoslastica.setText(stavkaZaPromenu.getPoslastica().getNaziv());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIzabranaPoslastica = new javax.swing.JTextField();
        txtKolicina = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPoslastice = new javax.swing.JTable();
        btnIzaberiPoslasticu = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Poslastica:");

        jLabel2.setText("Količina:");

        tblPoslastice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPoslastice);

        btnIzaberiPoslasticu.setText("Izaberi poslasticu");
        btnIzaberiPoslasticu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiPoslasticuActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sačuvaj promenu");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtIzabranaPoslastica, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIzaberiPoslasticu)
                        .addGap(34, 34, 34)
                        .addComponent(btnSacuvaj)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIzabranaPoslastica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnIzaberiPoslasticu))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzaberiPoslasticuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiPoslasticuActionPerformed
        int row = tblPoslastice.getSelectedRow();
        if (row >= 0) {
            Poslastica p = ((PoslasticaTableModel) tblPoslastice.getModel()).getPoslastica(row);
            stavkaZaPromenu.setPoslastica(p);
            stavkaZaPromenu.setCena(p.getCena());
            txtIzabranaPoslastica.setText(p.getNaziv());
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite pecivo iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnIzaberiPoslasticuActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            if (txtKolicina.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite količinu!","Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int kolicina = Integer.parseInt(txtKolicina.getText().trim());
            if (kolicina <= 0) {
                JOptionPane.showMessageDialog(this,"Količina mora biti pozitivan broj!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                return;
            }
            stavkaZaPromenu.setKolicina(kolicina);
            stavkaZaPromenu.setUkupanIznos(stavkaZaPromenu.getCena() * kolicina);
            JOptionPane.showMessageDialog(this, "Stavka je uspešno promenjena.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Količina mora biti ceo broj!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberiPoslasticu;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPoslastice;
    private javax.swing.JTextField txtIzabranaPoslastica;
    private javax.swing.JTextField txtKolicina;
    // End of variables declaration//GEN-END:variables
}
