/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.logic;

import communication.Communication;
import java.util.ArrayList;
import model.*;
import model.communication.*;

public class UIController {
    private static UIController instance;

    private UIController() {
    }

    public static UIController getInstance() {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public Poslasticar prijaviPoslasticara(String korisnickoIme, String lozinka) throws Exception {
        Poslasticar p = new Poslasticar();
        p.setKorisnickoIme(korisnickoIme);
        p.setLozinka(lozinka);
        Request request = new Request(Operation.LOGIN, p);
        Response response = Communication.getInstance().prijaviPoslasticara(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (Poslasticar) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void kreirajKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.KREIRAJ_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().kreirajKategorijaKupca(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<KategorijaKupca> vratiListuSviKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().vratiListuSviKategorijaKupca(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<KategorijaKupca>) response.getResult();
        throw response.getException();
    }

    public ArrayList<KategorijaKupca> vratiListuNekiKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().vratiListuSviKategorijaKupca(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<KategorijaKupca>) response.getResult();
        throw response.getException();
    }
    
    public void obrisiKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.OBRISI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().obrisiKategorijaKupca(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }
    
    public void promeniKategorijaKupca(KategorijaKupca kk) throws Exception {
        Request request = new Request(Operation.PROMENI_KATEGORIJA_KUPCA, kk);
        Response response = Communication.getInstance().promeniKategorijaKupca(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }
    
    public void kreirajPoslastica(Poslastica p) throws Exception {
        Request request = new Request(Operation.KREIRAJ_POSLASTICA, p);
        Response response = Communication.getInstance().kreirajPoslastica(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Poslastica> vratiListuSviPoslastica(Poslastica p) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_POSLASTICA, p);
        Response response = Communication.getInstance().vratiListuSviPoslastica(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Poslastica>) response.getResult();
        throw response.getException();
    }

    public void obrisiPoslasticu(Poslastica p) throws Exception {
        Request request = new Request(Operation.OBRISI_POSLASTICA, p);
        Response response = Communication.getInstance().obrisiPoslastica(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Poslastica> vratiListuNekiPoslastica(Poslastica p) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_POSLASTICA, p);
        Response response = Communication.getInstance().vratiListuSviPoslastica(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Poslastica>) response.getResult();
        throw response.getException();
    }
    
    public void obrisiPoslastica(Poslastica p) throws Exception {
        Request request = new Request(Operation.OBRISI_POSLASTICA, p);
        Response response = Communication.getInstance().obrisiPoslastica(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }
    
    public void promeniPoslastica(Poslastica p) throws Exception {
        Request request = new Request(Operation.PROMENI_POSLASTICA, p);
        Response response = Communication.getInstance().promeniPoslastica(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void kreirajPoslasticar(Poslasticar p) throws Exception {
        Request request = new Request(Operation.KREIRAJ_POSLASTICAR, p);
        Response response = Communication.getInstance().kreirajPoslasticar(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Poslasticar> vratiListuSviPoslasticar(Poslasticar p) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_POSLASTICAR, p);
        Response response = Communication.getInstance().vratiListuSviPoslasticar(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Poslasticar>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Poslasticar> vratiListuNekiPoslasticar(Poslasticar p) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_POSLASTICAR, p);
        Response response = Communication.getInstance().vratiListuSviPoslasticar(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Poslasticar>) response.getResult();
        throw response.getException();
    }
    
    public void obrisiPoslasticar(Poslasticar p) throws Exception {
        Request request = new Request(Operation.OBRISI_POSLASTICAR, p);
        Response response = Communication.getInstance().obrisiPoslasticar(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniPoslasticar(Poslasticar p) throws Exception {
        Request request = new Request(Operation.PROMENI_POSLASTICAR, p);
        Response response = Communication.getInstance().promeniPoslasticar(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void ubaciKvalifikacija(Kvalifikacija k) throws Exception {
        Request request = new Request(Operation.UBACI_KVALIFIKACIJA, k);
        Response response = Communication.getInstance().ubaciKvalifikcija(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Kvalifikacija> vratiListuSviKvalifikacija(Kvalifikacija k) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_KVALIFIKACIJA, k);
        Response response = Communication.getInstance().vratiListuSviKvalifikcija(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Kvalifikacija>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Kvalifikacija> vratiListuNekiKvalifikacija(Kvalifikacija k) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_KVALIFIKACIJA, k);
        Response response = Communication.getInstance().vratiListuSviKvalifikcija(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Kvalifikacija>) response.getResult();
        throw response.getException();
    }

    public void obrisiKvalifikacija(Kvalifikacija k) throws Exception {
        Request request = new Request(Operation.OBRISI_KVALIFIKACIJA, k);
        Response response = Communication.getInstance().obrisiKvalifikcija(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniKvalifikacija(Kvalifikacija k) throws Exception {
        Request request = new Request(Operation.PROMENI_KVALIFIKACIJA, k);
        Response response = Communication.getInstance().promeniKvalifikcija(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void kreirajKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.KREIRAJ_KUPAC, k);
        Response response = Communication.getInstance().kreirajKupac(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public ArrayList<Kupac> vratiListuSviKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_KUPAC, k);
        Response response = Communication.getInstance().vratiListuSviKupac(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Kupac>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Kupac> vratiListuNekiKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_KUPAC, k);
        Response response = Communication.getInstance().vratiListuSviKupac(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Kupac>) response.getResult();
        throw response.getException();
    }

    public void obrisiKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.OBRISI_KUPAC, k);
        Response response = Communication.getInstance().obrisiKupac(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniKupac(Kupac k) throws Exception {
        Request request = new Request(Operation.PROMENI_KUPAC, k);
        Response response = Communication.getInstance().promeniKupac(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void kreirajRacun(Racun r) throws Exception {
        Request request = new Request(Operation.KREIRAJ_RACUN, r);
        Response response = Communication.getInstance().kreirajRacun(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }

    public void promeniRacun(Racun r) throws Exception {
        Request request = new Request(Operation.PROMENI_RACUN, r);
        Response response = Communication.getInstance().promeniRacun(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) throw response.getException();
    }
    
    public Racun pretraziRacun(Racun r) throws Exception {
        Request request = new Request(Operation.PRETRAZI_RACUN, r);
        Response response = Communication.getInstance().pretraziRacun(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (Racun) response.getResult();
        throw response.getException();
    }

    public ArrayList<Racun> vratiListuSviRacun(Racun r) throws Exception {
        Request request = new Request(Operation.LISTA_SVI_RACUN, r);
        Response response = Communication.getInstance().vratiListuSviRacun(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Racun>) response.getResult();
        throw response.getException();
    }

    public ArrayList<Racun> vratiListuNekiRacun(Racun r) throws Exception {
        Request request = new Request(Operation.LISTA_NEKI_RACUN, r);
        Response response = Communication.getInstance().vratiListuSviRacun(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS))
            return (ArrayList<Racun>) response.getResult();
        throw response.getException();
    }
}