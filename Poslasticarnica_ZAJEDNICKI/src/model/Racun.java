/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Racun implements OpstiDomenskiObjekat, Serializable {

    private int idRacun;
    private LocalDate datumIzdavanja;
    private int brojStavki;
    private double ukupanIznos;
    private String nacinPlacanja;
    private int popust;
    private double iznosSaPopustom;
    private Poslasticar poslasticar;
    private Kupac kupac;
    private ArrayList<StavkaRacuna> stavke;

    public Racun() {
        stavke = new ArrayList<>();
    }

    public Racun(int idRacun, LocalDate datumIzdavanja, int brojStavki, double ukupanIznos, String nacinPlacanja, int popust, 
            double iznosSaPopustom, Poslasticar pekar, Kupac kupac, ArrayList<StavkaRacuna> stavke) {
        this.idRacun = idRacun;
        this.datumIzdavanja = datumIzdavanja;
        this.brojStavki = brojStavki;
        this.ukupanIznos = ukupanIznos;
        this.nacinPlacanja = nacinPlacanja;
        this.popust = popust;
        this.iznosSaPopustom = iznosSaPopustom;
        this.poslasticar = pekar;
        this.kupac = kupac;
        this.stavke = stavke;
    }

    public int getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(int idRacun) {
        this.idRacun = idRacun;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public int getBrojStavki() {
        return brojStavki;
    }

    public void setBrojStavki(int brojStavki) {
        this.brojStavki = brojStavki;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public double getIznosSaPopustom() {
        return iznosSaPopustom;
    }

    public void setIznosSaPopustom(double iznosSaPopustom) {
        this.iznosSaPopustom = iznosSaPopustom;
    }

    public Poslasticar getPoslasticar() {
        return poslasticar;
    }

    public void setPoslasticar(Poslasticar poslasticar) {
        this.poslasticar = poslasticar;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public ArrayList<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }
    
    public void izracunajIznose() {
        ukupanIznos = 0;
        for (StavkaRacuna s : stavke) {
            ukupanIznos += s.getUkupanIznos();
        }
        if (kupac != null && kupac.getKategorijaKupca() != null) {
            popust = kupac.getKategorijaKupca().getPopust();
        }
        iznosSaPopustom = ukupanIznos - ukupanIznos * popust / 100.0;
        brojStavki = stavke.size();
    }

    @Override
    public String toString() {
        return "Racun #" + idRacun + " | " + (kupac != null ? kupac.getIme() + " " + kupac.getPrezime() : "") + " | " + iznosSaPopustom + " RSD";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "'" + datumIzdavanja.toString() + "', " + brojStavki + ", " + ukupanIznos +
               ", '" + nacinPlacanja + "', " + popust + ", " + iznosSaPopustom +
               ", " + poslasticar.getIdPoslasticar()+ ", " + kupac.getIdKupac();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "datumIzdavanja = '" + datumIzdavanja.toString() + "', brojStavki = " + brojStavki +
               ", ukupanIznos = " + ukupanIznos + ", nacinPlacanja = '" + nacinPlacanja +
               "', popust = " + popust + ", iznosSaPopustom = " + iznosSaPopustom +
               ", idPoslasticar = " + poslasticar.getIdPoslasticar() + ", idKupac = " + kupac.getIdKupac();
    }

    @Override
    public String vratiImeKlase() {
        return "Racun";
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

            Kupac k = new Kupac();
            k.setIdKupac(rs.getInt("ku.idKupac"));
            k.setIme(rs.getString("imeKu"));
            k.setPrezime(rs.getString("prezimeKu"));
            k.setEmail(rs.getString("emailKu"));

            this.idRacun = rs.getInt("r.idRacun");
            this.datumIzdavanja = rs.getDate("r.datumIzdavanja").toLocalDate();
            this.brojStavki = rs.getInt("r.brojStavki");
            this.ukupanIznos = rs.getDouble("r.ukupanIznos");
            this.nacinPlacanja = rs.getString("r.nacinPlacanja");
            this.popust = rs.getInt("r.popust");
            this.iznosSaPopustom = rs.getDouble("r.iznosSaPopustom");
            this.poslasticar = p;
            this.kupac = k;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idRacun = " + idRacun;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        StringBuilder sb = new StringBuilder(" WHERE 1=1");
        if (idRacun != 0)
            sb.append(" AND r.idRacun = ").append(idRacun);
        if (datumIzdavanja != null) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            sb.append(" AND r.datumIzdavanja = '").append(datumIzdavanja.format(f)).append("'");
        }
        if (poslasticar != null && poslasticar.getIdPoslasticar()!= 0)
            sb.append(" AND po.idPoslasticar = ").append(poslasticar.getIdPoslasticar());
        if (poslasticar != null && poslasticar.getIme() != null && !poslasticar.getIme().isEmpty())
            sb.append(" AND po.ime LIKE '%").append(poslasticar.getIme()).append("%'");
        if (poslasticar != null && poslasticar.getPrezime() != null && !poslasticar.getPrezime().isEmpty())
            sb.append(" AND po.prezime LIKE '%").append(poslasticar.getPrezime()).append("%'");
        if (kupac != null && kupac.getIdKupac() != 0)
            sb.append(" AND ku.idKupac = ").append(kupac.getIdKupac());
        if (kupac != null && kupac.getIme() != null && !kupac.getIme().isEmpty())
            sb.append(" AND ku.ime LIKE '%").append(kupac.getIme()).append("%'");
        if (kupac != null && kupac.getPrezime() != null && !kupac.getPrezime().isEmpty())
            sb.append(" AND ku.prezime LIKE '%").append(kupac.getPrezime()).append("%'");
        
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
        return "datumIzdavanja, brojStavki, ukupanIznos, nacinPlacanja, popust, iznosSaPopustom, idPoslasticar, idKupac";
    }

    @Override
    public void postaviID(int ID) {
        setIdRacun(ID);
    }

    @Override
    public String vratiAlijas() {
        return "r";
    }

    @Override
    public String vratiJoin() {
        return "JOIN Poslasticar po ON r.idPoslasticar = po.idPoslasticar " +
               "JOIN Kupac ku ON r.idKupac = ku.idKupac";
    }

    @Override
    public String vratiSelectZaSlozeniSlog() {
        return "r.idRacun, r.datumIzdavanja, r.brojStavki, r.ukupanIznos, r.nacinPlacanja, r.popust, r.iznosSaPopustom, " +
               "po.idPoslasticar, po.ime AS imePo, po.prezime AS prezimePo, po.korisnickoIme AS korisnickoImePo, po.telefon AS telefonPo, " +
               "ku.idKupac, ku.ime AS imeKu, ku.prezime AS prezimeKu, ku.email AS emailKu";
    }
}