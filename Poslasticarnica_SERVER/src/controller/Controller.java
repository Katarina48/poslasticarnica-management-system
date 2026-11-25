/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import so.Poslasticar.PrijaviPoslasticar;
import so.Poslasticar.KreirajPoslasticar;
import so.Poslasticar.ObrisiPoslasticar;
import so.Poslasticar.PromeniPoslasticar;
import so.Poslasticar.PretraziPoslasticar;
import so.Poslasticar.VratiListuPoslasticar;
import so.Poslasticar.VratiListuSviPoslasticar;

import so.Poslastica.KreirajPoslastica;
import so.Poslastica.ObrisiPoslastica;
import so.Poslastica.PromeniPoslastica;
import so.Poslastica.VratiListuPoslastica;
import so.Poslastica.VratiListuSviPoslastica;

import so.Kvalifikacija.UbaciKvalifikacija;
import so.Kvalifikacija.ObrisiKvalifikacija;
import so.Kvalifikacija.PromeniKvalifikacija;
import so.Kvalifikacija.VratiListuKvalifikacija;
import so.Kvalifikacija.VratiListuSviKvalifikacija;

import so.KategorijaKupca.KreirajKategorijaKupca;
import so.KategorijaKupca.ObrisiKategorijaKupca;
import so.KategorijaKupca.PromeniKategorijaKupca;
import so.KategorijaKupca.VratiListuKategorijaKupca;
import so.KategorijaKupca.VratiListuSviKategorijaKupca;

import so.Kupac.KreirajKupac;
import so.Kupac.ObrisiKupac;
import so.Kupac.PromeniKupac;
import so.Kupac.VratiListuKupac;
import so.Kupac.VratiListuSviKupac;

import so.Racun.KreirajRacun;
import so.Racun.PromeniRacun;
import so.Racun.VratiListuRacun;

import java.util.ArrayList;
import model.*;
import so.*;
import so.Racun.PretraziRacun;

public class Controller {
    private static Controller instance;
    private Poslasticar prijavljeni;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // --- POSLASTIČAR ---
    public Poslasticar prijaviPoslasticar(Poslasticar poslasticar) throws Exception {
        OpstaSO prijaviPoslasticar = new PrijaviPoslasticar();
        Poslasticar poslasticarP = (Poslasticar) prijaviPoslasticar.execute(poslasticar);
        prijavljeni = poslasticarP;
        return poslasticarP;
    }

    public void kreirajPoslasticar(Poslasticar p) throws Exception {
        new KreirajPoslasticar().execute(p);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Poslasticar> vratiListuSviPoslasticar(Poslasticar p) throws Exception {
        return (ArrayList<Poslasticar>) new VratiListuSviPoslasticar().execute(p);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Poslasticar> vratiListuNekiPoslasticar(Poslasticar p) throws Exception {
        return (ArrayList<Poslasticar>) new VratiListuPoslasticar().execute(p);
    }

    public void obrisiPoslasticar(Poslasticar p) throws Exception {
        new ObrisiPoslasticar().execute(p);
    }

    public void promeniPoslasticar(Poslasticar p) throws Exception {
        new PromeniPoslasticar().execute(p);
    }

    // --- KATEGORIJA KUPCA ---
    public void kreirajKategorijaKupca(KategorijaKupca kk) throws Exception {
        new KreirajKategorijaKupca().execute(kk);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<KategorijaKupca> vratiListuSviKategorijaKupca(KategorijaKupca kk) throws Exception {
        return (ArrayList<KategorijaKupca>) new VratiListuSviKategorijaKupca().execute(kk);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<KategorijaKupca> vratiListuNekiKategorijaKupca(KategorijaKupca kk) throws Exception {
        return (ArrayList<KategorijaKupca>) new VratiListuKategorijaKupca().execute(kk);
    }

    public void obrisiKategorijaKupca(KategorijaKupca kk) throws Exception {
        new ObrisiKategorijaKupca().execute(kk);
    }

    public void promeniKategorijaKupca(KategorijaKupca kk) throws Exception {
        new PromeniKategorijaKupca().execute(kk);
    }

    // --- POSLASTICA ---
    public void kreirajPoslastica(Poslastica p) throws Exception {
        new KreirajPoslastica().execute(p);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Poslastica> vratiListuSviPoslastica(Poslastica p) throws Exception {
        return (ArrayList<Poslastica>) new VratiListuSviPoslastica().execute(p);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Poslastica> vratiListuNekiPoslastica(Poslastica p) throws Exception {
        return (ArrayList<Poslastica>) new VratiListuPoslastica().execute(p);
    }

    public void obrisiPoslastica(Poslastica p) throws Exception {
        new ObrisiPoslastica().execute(p);
    }

    public void promeniPoslastica(Poslastica p) throws Exception {
        new PromeniPoslastica().execute(p);
    }

    // --- KVALIFIKACIJA ---
    public void ubaciKvalifikaciju(Kvalifikacija k) throws Exception {
        new UbaciKvalifikacija().execute(k);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Kvalifikacija> vratiListuSviKvalifikaciju(Kvalifikacija k) throws Exception {
        return (ArrayList<Kvalifikacija>) new VratiListuSviKvalifikacija().execute(k);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Kvalifikacija> vratiListuNekiKvalifikaciju(Kvalifikacija k) throws Exception {
        return (ArrayList<Kvalifikacija>) new VratiListuKvalifikacija().execute(k);
    }

    public void obrisiKvalifikaciju(Kvalifikacija k) throws Exception {
        new ObrisiKvalifikacija().execute(k);
    }

    public void promeniKvalifikaciju(Kvalifikacija k) throws Exception {
        new PromeniKvalifikacija().execute(k);
    }

    // --- KUPAC ---
    public void kreirajKupac(Kupac k) throws Exception {
        new KreirajKupac().execute(k);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Kupac> vratiListuSviKupac(Kupac k) throws Exception {
        return (ArrayList<Kupac>) new VratiListuSviKupac().execute(k);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Kupac> vratiListuNekiKupac(Kupac k) throws Exception {
        return (ArrayList<Kupac>) new VratiListuKupac().execute(k);
    }

    public void obrisiKupac(Kupac k) throws Exception {
        new ObrisiKupac().execute(k);
    }

    public void promeniKupac(Kupac k) throws Exception {
        new PromeniKupac().execute(k);
    }

    // --- RAČUN ---
    public void kreirajRacun(Racun r) throws Exception {
        r.setPoslasticar(prijavljeni); 
        new KreirajRacun().execute(r);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Racun> vratiListuSviRacun(Racun r) throws Exception {
        return (ArrayList<Racun>) new VratiListuRacun().execute(r);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Racun> vratiListuNekiRacun(Racun r) throws Exception {
        return (ArrayList<Racun>) new VratiListuRacun().execute(r);
    }

    public void promeniRacun(Racun r) throws Exception {
        new PromeniRacun().execute(r);
    }
    public Racun pretraziRacun(Racun r) throws Exception {
        return (Racun) new PretraziRacun().execute(r);
    }
}
