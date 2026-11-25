/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import model.Racun;
import model.StavkaRacuna;
import so.OpstaSO;

public class KreirajRacun extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Racun))
            throw new Exception("Parametri nisu validni!");

        Racun r = (Racun) param;

        if (r.getKupac() == null) throw new Exception("Račun mora imati kupca!");
        if (r.getPoslasticar() == null) throw new Exception("Račun mora imati poslastičara!");

        if (r.getDatumIzdavanja() == null) throw new Exception("Datum izdavanja ne sme biti prazan!");

        if (r.getNacinPlacanja()== null || r.getNacinPlacanja().isEmpty()) throw new Exception("Tip plaćanja ne sme biti prazan!");
        if (!r.getNacinPlacanja().equals("Gotovina") && !r.getNacinPlacanja().equals("Kartica") && !r.getNacinPlacanja().equals("Čekovi"))
            throw new Exception("Način plaćanja mora biti: Gotovina, Kartica ili Čekovi!");

        if (r.getPopust() < 0 || r.getPopust() > 100) throw new Exception("Popust mora biti između 0 i 100!");

        if (r.getKupac().getKategorijaKupca() != null && r.getPopust() != r.getKupac().getKategorijaKupca().getPopust())
            throw new Exception("Popust ne odgovara kategoriji kupca!");

        if (r.getBrojStavki() != r.getStavke().size()) throw new Exception("Broj stavki nije ispravan!");

        double sumaIznosa = 0;
        for (StavkaRacuna s : r.getStavke()) {
            sumaIznosa += s.getUkupanIznos();
        }
        if (Math.abs(r.getUkupanIznos() - sumaIznosa) > 0.001)
            throw new Exception("Ukupan iznos nije ispravan!");

        double ocekivaniIznos = r.getUkupanIznos() - r.getUkupanIznos() * r.getPopust() / 100.0;
        if (Math.abs(r.getIznosSaPopustom() - ocekivaniIznos) > 0.001)
            throw new Exception("Iznos sa popustom nije ispravan!");
        if (r.getIznosSaPopustom() <= 0)
            throw new Exception("Iznos sa popustom mora biti veći od 0!");
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        Racun r = (Racun) param;
        dbr.pamtiSlog(r); 
        for (StavkaRacuna s : r.getStavke()) {
            s.setRacun(r);
            dbr.pamtiSlog(s); 
        }
        return null;
    }
}