/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class PK implements OpstiDomenskiObjekat, Serializable {

    private Poslasticar poslasticar;
    private Kvalifikacija kvalifikacija;
    private LocalDate datumSticanja;

    public PK() {
    }

    public PK(Poslasticar poslasticar, Kvalifikacija kvalifikacija, LocalDate datumSticanja) {
        this.poslasticar = poslasticar;
        this.kvalifikacija = kvalifikacija;
        this.datumSticanja = datumSticanja;
    }

    public Poslasticar getPoslasticar() {
        return poslasticar;
    }

    public void setPoslasticar(Poslasticar poslasticar) {
        this.poslasticar = poslasticar;
    }

    public Kvalifikacija getKvalifikacija() {
        return kvalifikacija;
    }

    public void setKvalifikacija(Kvalifikacija kvalifikacija) {
        this.kvalifikacija = kvalifikacija;
    }

    public LocalDate getDatumSticanja() {
        return datumSticanja;
    }

    public void setDatumSticanja(LocalDate datumSticanja) {
        this.datumSticanja = datumSticanja;
    }

    @Override
        public String toString() {
            return (poslasticar != null ? poslasticar.getIme() + " " + poslasticar.getPrezime() : "") +
                   " - " + (kvalifikacija != null ? kvalifikacija.getNaziv() : "") +
                   " (" + datumSticanja + ")";
        }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PK)) return false;
            PK pk = (PK) o;
            return poslasticar != null && kvalifikacija != null &&
                   poslasticar.getIdPoslasticar()== pk.poslasticar.getIdPoslasticar() &&
                   kvalifikacija.getIdKvalifikacija()== pk.kvalifikacija.getIdKvalifikacija();
        }

    

    @Override
    public String vratiVrednostiAtributa() {
        return poslasticar.getIdPoslasticar()+ ", " + kvalifikacija.getIdKvalifikacija()+
               ", '" + datumSticanja.toString() + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "datumIzdavanja = '" + datumSticanja.toString() + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "PK";
    }

    @Override
    public boolean napuni(ResultSet rs, ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public boolean napuni(ResultSet rs) {
        try {
            Poslasticar p = new Poslasticar();
            p.setIdPoslasticar(rs.getInt("po.idPoslasticar"));
            p.setIme(rs.getString("imePo"));
            p.setPrezime(rs.getString("prezimePo"));
            p.setKorisnickoIme(rs.getString("korisnickoImePo"));
            p.setTelefon(rs.getString("telefonPo"));
            this.poslasticar = p;

            Kvalifikacija k = new Kvalifikacija();
            k.setIdKvalifikacija(rs.getInt("k.idKvalifikacija"));
            k.setNaziv(rs.getString("nazivK"));
            k.setUstanova(rs.getString("ustanovaK"));
            this.kvalifikacija = k;

            this.datumSticanja = rs.getDate("pk.datumSticanja").toLocalDate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PK.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idPoslasticar = " + poslasticar.getIdPoslasticar()+
               " AND idKvalifikacija = " + kvalifikacija.getIdKvalifikacija();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (poslasticar != null && poslasticar.getIdPoslasticar() != 0)
            sb.append(" AND pk.idPoslasticar = ").append(poslasticar.getIdPoslasticar());
        if (kvalifikacija != null && kvalifikacija.getIdKvalifikacija() != 0)
            sb.append(" AND pk.idKvalifikacija = ").append(kvalifikacija.getIdKvalifikacija());
        if (datumSticanja != null)
            sb.append(" AND pk.datumSticanja = '").append(datumSticanja).append("'");
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
        return "idPoslasticar, idKvalifikacija, datumSticanja";
    }

    @Override
    public void postaviID(int ID) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String vratiAlijas() {
        return "pk";
    }

    @Override
    public String vratiJoin() {
        return "JOIN Poslasticar po ON pk.idPoslasticar = po.idPoslasticar " +
               "JOIN Kvalifikacija k ON pk.idKvalifikacija = k.idKvalifikacija";
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        return "pk.datumSticanja, " +
               "po.idPoslasticar, po.ime AS imePo, po.prezime AS prezimePo, " +
               "po.korisnickoIme AS korisnickoImePo, po.telefon AS telefonPo, " +
               "k.idKvalifikacija, k.naziv AS nazivK, k.ustanova AS ustanovaK";
    }
}

 