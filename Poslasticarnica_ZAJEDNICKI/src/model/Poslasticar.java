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
public class Poslasticar implements OpstiDomenskiObjekat, Serializable {
    
    private int idPoslasticar;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String telefon;
    
    public Poslasticar() {
    }

    public Poslasticar(int idPoslasticar, String ime, String prezime, String korisnickoIme, String lozinka, String telefon) {
        this.idPoslasticar = idPoslasticar;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.telefon = telefon;
    }
    
    public Poslasticar(String ime, String prezime, String korisnickoIme, String lozinka, String telefon) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.telefon = telefon;
    }

    public int getIdPoslasticar() {
        return idPoslasticar;
    }

    public void setIdPoslasticar(int idPoslasticar) {
        this.idPoslasticar = idPoslasticar;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    @Override
    public String vratiVrednostiAtributa() {
        return "'" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + lozinka + "', '" + telefon + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "ime = '" + ime + "', prezime = '" + prezime +
               "', korisnickoIme = '" + korisnickoIme + "', telefon = '" + telefon + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "Poslasticar";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idPoslasticar = rs.getInt("idPoslasticar");
            this.ime = rs.getString("ime");
            this.prezime = rs.getString("prezime");
            this.korisnickoIme = rs.getString("korisnickoIme");
            this.lozinka = rs.getString("lozinka");
            this.telefon = rs.getString("telefon");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Poslasticar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idPoslasticar = " + idPoslasticar;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idPoslasticar != 0)
            sb.append(" AND idPoslasticar = ").append(idPoslasticar);
        if (ime != null && !ime.isEmpty())
            sb.append(" AND ime LIKE '%").append(ime).append("%'");
        if (prezime != null && !prezime.isEmpty())
            sb.append(" AND prezime LIKE '%").append(prezime).append("%'");
        if (korisnickoIme != null && !korisnickoIme.isEmpty())
            sb.append(" AND korisnickoIme LIKE '%").append(korisnickoIme).append("%'");
        if (telefon != null && !telefon.isEmpty())
            sb.append(" AND telefon LIKE '%").append(telefon).append("%'");
        return sb.toString();
    }

    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiUslovZaJednog() {
        return "korisnickoIme = '" + korisnickoIme + "' AND lozinka = '" + lozinka + "'";
    }

    @Override
    public String vratiNaziveAtributa() {
        return "ime, prezime, korisnickoIme, lozinka, telefon";
    }

    @Override
    public void postaviID(int ID) {
        setIdPoslasticar(ID);
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poslasticar other = (Poslasticar) obj;
        return this.idPoslasticar == other.idPoslasticar;
    }
    
    
}
