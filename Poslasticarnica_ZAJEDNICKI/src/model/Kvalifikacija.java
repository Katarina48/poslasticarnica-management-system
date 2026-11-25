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
public class Kvalifikacija implements OpstiDomenskiObjekat, Serializable {

    private int idKvalifikacija;
    private String naziv;
    private String ustanova;

    public Kvalifikacija() {
    }

    public Kvalifikacija(int idKvalifikacija, String naziv, String ustanova) {
        this.idKvalifikacija = idKvalifikacija;
        this.naziv = naziv;
        this.ustanova = ustanova;
    }
    
    public Kvalifikacija( String naziv, String ustanova) {
        this.naziv = naziv;
        this.ustanova = ustanova;
    }

    public int getIdKvalifikacija() {
        return idKvalifikacija;
    }

    public void setIdKvalifikacija(int idKvalifikacija) {
        this.idKvalifikacija = idKvalifikacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getUstanova() {
        return ustanova;
    }

    public void setUstanova(String ustanova) {
        this.ustanova = ustanova;
    }

    @Override
    public String toString() {
        return naziv + " (" + ustanova + ")";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kvalifikacija)) return false;
        return this.idKvalifikacija == ((Kvalifikacija) o).idKvalifikacija;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "'" + naziv + "', '" + ustanova + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "naziv = '" + naziv + "', ustanova = '" + ustanova + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "Kvalifikacija";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idKvalifikacija = rs.getInt("idKvalifikacija");
            this.naziv = rs.getString("naziv");
            this.ustanova = rs.getString("ustanova");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Kvalifikacija.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idKvalifikacija = " + idKvalifikacija;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idKvalifikacija != 0)
            sb.append(" AND idKvalifikacija = ").append(idKvalifikacija);
        if (naziv != null && !naziv.isEmpty())
            sb.append(" AND naziv LIKE '%").append(naziv).append("%'");
        if (ustanova != null && !ustanova.isEmpty())
            sb.append(" AND ustanova LIKE '%").append(ustanova).append("%'");
        return sb.toString();
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiNaziveAtributa() {
        return "naziv, ustanova";
    }

    @Override
    public void postaviID(int ID) {
        setIdKvalifikacija(ID);
    }

    @Override
    public String vratiAlijas() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiJoin() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        throw new UnsupportedOperationException("Not supported.");
    }
}
