/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import style.Stil;
import javax.swing.JOptionPane;
import model.Poslastica;
import view.model.PoslasticaTableModel;
import ui.logic.UIController;


public class SvePoslasticeForm extends javax.swing.JFrame {


    public SvePoslasticeForm() {
        initComponents();
        setTitle("Poslastice");
        setLocationRelativeTo(null);
        stilizuj();
    }

    private void ucitajSve() {
        try {
            ArrayList<Poslastica> lista = UIController.getInstance().vratiListuSviPoslastica(new Poslastica());
            tblPoslastice.setModel(new PoslasticaTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije pronašao poslastice.", "Info", JOptionPane.INFORMATION_MESSAGE);
            tblPoslastice.setModel(new PoslasticaTableModel(new ArrayList<>()));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPoslastice = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Naziv:");

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnOsvezi.setText("Osveži");
        btnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsveziActionPerformed(evt);
            }
        });

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

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromeni.setText("Promeni");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPretrazi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOsvezi))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(401, 401, 401)
                            .addComponent(btnObrisi)
                            .addGap(45, 45, 45)
                            .addComponent(btnPromeni)
                            .addGap(42, 42, 42)
                            .addComponent(btnDodaj)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnOsvezi))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromeni)
                    .addComponent(btnObrisi))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsveziActionPerformed
        ucitajSve();
    }//GEN-LAST:event_btnOsveziActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        
        try {
            Poslastica p = new model.Poslastica();
            p.setNaziv(txtNaziv.getText());
            ArrayList<Poslastica> lista =UIController.getInstance().vratiListuNekiPoslastica(p);
            tblPoslastice.setModel(new PoslasticaTableModel(lista));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Sistem nije pronašao poslastice po zadatim kriterijumima.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        
        AddPoslasticaForm f = new AddPoslasticaForm(this, true, null);
        f.setVisible(true);
        ucitajSve();

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed

        int row = tblPoslastice.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,"Izaberite poslasticu iz tabele!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Poslastica p = ((PoslasticaTableModel) tblPoslastice.getModel()).getPoslastica(row);
        AddPoslasticaForm f = new AddPoslasticaForm(this, true, p);
        f.setVisible(true);
        ucitajSve();

    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int row = tblPoslastice.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Izaberite poslasticu iz tabele!","Upozorenje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Poslastica p = ((PoslasticaTableModel)tblPoslastice.getModel()).getPoslastica(row);
        int potvrda = JOptionPane.showConfirmDialog(this,"Da li ste sigurni da želite da obrišete poslasticu?","Brisanje", JOptionPane.YES_NO_OPTION);
        if (potvrda == JOptionPane.YES_OPTION) {
            try {
                UIController.getInstance().obrisiPoslasticu(p);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao poslasticu.");
                ucitajSve();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Sistem ne može da obriše poslasticu.","Greška", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPoslastice;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.primarna(btnDodaj);
        Stil.primarna(btnPromeni);
        Stil.primarna(btnPretrazi);
        Stil.primarna(btnOsvezi);
        Stil.crveno(btnObrisi);
        Stil.labela(jLabel1);
        Stil.polje(txtNaziv);
        Stil.tabela(tblPoslastice);
        ucitajSve();
        Stil.scrollPanel(jScrollPane1);
        Stil.pozadina(getContentPane());    }
}
