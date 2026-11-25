/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import style.Stil;
import javax.swing.JOptionPane;
import model.JedinicaMere;
import model.Poslastica;
import ui.logic.UIController;
import validation.Validator;

/**
 *
 * @author stari
 */
public class AddPoslasticaForm extends javax.swing.JDialog {

    private Poslastica poslastica;

    public AddPoslasticaForm(java.awt.Frame parent, boolean modal, Poslastica poslastica) {
        super(parent, modal);
        this.poslastica = poslastica;
        initComponents();
        setLocationRelativeTo(parent);
        stilizuj();
        popuniCB();
        
        if (poslastica != null) {
            setTitle("Promeni poslasticu");
            txtNaziv.setText(poslastica.getNaziv());
            txtOpis.setText(poslastica.getOpis());
            txtRok.setText(poslastica.getRokTrajanja());
            txtCena.setText(String.valueOf(poslastica.getCena()));
            cmbJedinicaMere.setSelectedItem(poslastica.getJedinicaMere());
        } else {
            setTitle("Dodaj poslasticu");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtOpis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRok = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbJedinicaMere = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Naziv:");

        jLabel2.setText("Opis:");

        jLabel3.setText("Rok trajanja:");

        jLabel4.setText("Cena (RSD):");

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel5.setText("Jedinica mere:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOtkazi)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtRok, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(cmbJedinicaMere, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbJedinicaMere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            Validator.validateNotEmpty(txtNaziv.getText(), "Naziv");
            Validator.validateNotEmpty(txtCena.getText(), "Cena");
            double cena = Double.parseDouble(txtCena.getText().trim());
            Validator.validatePositiveNumber(cena, "Cena");

            if (poslastica == null) {
                Poslastica p = new Poslastica(txtNaziv.getText().trim(),txtOpis.getText().trim(),txtRok.getText().trim(),cena,(JedinicaMere) cmbJedinicaMere.getSelectedItem());
                UIController.getInstance().kreirajPoslastica(p);
            } else {
                poslastica.setNaziv(txtNaziv.getText().trim());
                poslastica.setOpis(txtOpis.getText().trim());
                poslastica.setRokTrajanja(txtRok.getText().trim());
                poslastica.setCena(cena);
                poslastica.setJedinicaMere((JedinicaMere) cmbJedinicaMere.getSelectedItem());
                UIController.getInstance().promeniPoslastica(poslastica);
            }
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio poslasticu.");
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Cena mora biti broj!","Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Sistem ne može da zapamti poslasticu.","Greška", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<JedinicaMere> cmbJedinicaMere;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOpis;
    private javax.swing.JTextField txtRok;
    // End of variables declaration//GEN-END:variables

    private void stilizuj() {
        Stil.primarna(btnSacuvaj);
        Stil.crveno(btnOtkazi);
        Stil.labela(jLabel1);
        Stil.labela(jLabel2);
        Stil.labela(jLabel3);
        Stil.labela(jLabel4);
        Stil.labela(jLabel5);
        Stil.kombo(cmbJedinicaMere);
        Stil.polje(txtNaziv);
        Stil.polje(txtOpis);
        Stil.polje(txtRok);
        Stil.polje(txtCena);
        Stil.pozadina(getContentPane());    
    }

    private void popuniCB() {
        cmbJedinicaMere.removeAllItems();
        for (JedinicaMere jm : JedinicaMere.values()){
            cmbJedinicaMere.addItem(jm);
        }
    }
}
