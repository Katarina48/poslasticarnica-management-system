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
public class StavkaRacuna implements OpstiDomenskiObjekat, Serializable{

    private int idRacun;
    private int rb;
    private double cena;
    private int kolicina;
    private double ukupanIznos;
    private Poslastica poslastica;
    private Racun racun;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int idRacun, int rb, double cena, int kolicina, double ukupanIznos, Poslastica pecivo, Racun racun) {
        this.idRacun = idRacun;
        this.rb = rb;
        this.cena = cena;
        this.kolicina = kolicina;
        this.ukupanIznos = ukupanIznos;
        this.poslastica = pecivo;
        this.racun = racun;
    }
    
    public StavkaRacuna(double cena, int kolicina, double ukupanIznos, Poslastica pecivo) {
        this.cena = cena;
        this.kolicina = kolicina;
        this.ukupanIznos = ukupanIznos;
        this.poslastica = pecivo;
    }

    public int getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(int idRacun) {
        this.idRacun = idRacun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Poslastica getPoslastica() {
        return poslastica;
    }

    public void setPoslastica(Poslastica poslastica) {
        this.poslastica = poslastica;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
        if (racun != null) {
            this.idRacun = racun.getIdRacun();
        }
    }
    
    @Override
    public String toString() {
        return "rb:" + rb + " | " + (poslastica != null ? poslastica.getNaziv() : "") + " | kol:" + kolicina + " | iznos:" + ukupanIznos;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return idRacun + ", " + rb + ", " + cena + ", " + kolicina + ", " + ukupanIznos + ", " + poslastica.getIdPoslastica();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "cena = " + cena + ", kolicina = " + kolicina + ", ukupanIznos = " + ukupanIznos +
               ", idPoslastica = " + poslastica.getIdPoslastica();
    }

    @Override
    public String vratiImeKlase() {
        return "StavkaRacuna";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            this.idRacun = rs.getInt("idRacun");
            this.rb = rs.getInt("rb");
            this.cena = rs.getDouble("cena");
            this.kolicina = rs.getInt("kolicina");
            this.ukupanIznos = rs.getDouble("ukupanIznos");
            this.poslastica = new Poslastica();
            this.poslastica.setIdPoslastica(rs.getInt("idPoslastica"));
            this.poslastica.setNaziv(rs.getString("nazivPoslastica"));
            this.poslastica.setCena(rs.getDouble("cenaPoslastica"));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StavkaRacuna.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idRacun = " + idRacun + " AND rb = " + rb;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idRacun != 0)
            sb.append(" AND sr.idRacun = ").append(idRacun);
        else if (racun != null && racun.getIdRacun() != 0) {
            sb.append(" AND sr.idRacun = ").append(racun.getIdRacun());
        }
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
        return "idRacun, rb, cena, kolicina, ukupanIznos, idPoslastica";
    }

    @Override
    public void postaviID(int ID) {
        // composite key - not used
    }

    @Override
    public String vratiAlijas() {
        return "sr";
    }
    
    @Override
    public String vratiJoin() {
        return "JOIN Poslastica p ON sr.idPoslastica = p.idPoslastica";
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        return "sr.*, p.naziv AS nazivPoslastica, p.cena AS cenaPoslastica, p.opis, p.rokTrajanja";
    }
    
    public String getNazivPoslastice() {
        if (poslastica == null) return "";
        String naziv = poslastica.getNaziv();
        return naziv != null ? naziv : "";
    }

    public double getCenaPoslastice() {
        return poslastica != null ? poslastica.getCena() : 0.0;
    }
    
}
