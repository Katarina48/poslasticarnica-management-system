/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Poslastica implements OpstiDomenskiObjekat, Serializable {

    private int idPoslastica;
    private String naziv;
    private String opis;
    private String rokTrajanja;
    private double cena;
    private JedinicaMere jedinicaMere;

    public Poslastica() {
    }

    public Poslastica(int idPecivo, String naziv, String opis, String rokTrajanja, double cena,JedinicaMere jedinicaMere) {
        this.idPoslastica = idPecivo;
        this.naziv = naziv;
        this.opis = opis;
        this.rokTrajanja = rokTrajanja;
        this.cena = cena;
        this.jedinicaMere = jedinicaMere;
    }
    
    public Poslastica(String naziv, String opis, String rokTrajanja, double cena,JedinicaMere jedinicaMere) {
        this.naziv = naziv;
        this.opis = opis;
        this.rokTrajanja = rokTrajanja;
        this.cena = cena;
        this.jedinicaMere = jedinicaMere;
    }   

    public int getIdPoslastica() {
        return idPoslastica;
    }

    public void setIdPoslastica(int idPoslastica) {
        this.idPoslastica = idPoslastica;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getRokTrajanja() {
        return rokTrajanja;
    }

    public void setRokTrajanja(String rokTrajanja) {
        this.rokTrajanja = rokTrajanja;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }
    
    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poslastica)) return false;
        return this.idPoslastica == ((Poslastica) o).idPoslastica;
    }
    
    @Override
    public String vratiVrednostiAtributa() {
        return "'" + naziv + "', '" + opis + "', '" + rokTrajanja + "', " + cena+ ", '" + jedinicaMere.name() + "'";
    }
    
    @Override
    public String postaviVrednostiAtributa() {
        return "naziv = '" + naziv + "', opis = '" + opis +
               "', rokTrajanja = '" + rokTrajanja + "', cena = " + cena+ ", jedinicaMere = '" + jedinicaMere.name() + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "Poslastica";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idPoslastica = rs.getInt("idPoslastica");
            this.naziv = rs.getString("naziv");
            this.opis = rs.getString("opis");
            this.rokTrajanja = rs.getString("rokTrajanja");
            this.cena = rs.getDouble("cena");
            this.jedinicaMere = JedinicaMere.valueOf(rs.getString("jedinicaMere"));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Poslastica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idPoslastica = " + idPoslastica;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idPoslastica != 0)
            sb.append(" AND idPoslastica = ").append(idPoslastica);
        if (naziv != null && !naziv.isEmpty())
            sb.append(" AND naziv LIKE '%").append(naziv).append("%'");
        if (cena != 0)
            sb.append(" AND cena = ").append(cena);
        return sb.toString();
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String vratiNaziveAtributa() {
        return "naziv, opis, rokTrajanja, cena, jedinicaMere";
    }

    @Override
    public void postaviID(int ID) {
        setIdPoslastica(ID);
    }

    @Override
    public String vratiAlijas() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String vratiJoin() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
