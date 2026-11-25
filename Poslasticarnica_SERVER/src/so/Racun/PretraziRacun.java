/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import java.util.ArrayList;
import model.Racun;
import model.StavkaRacuna;
import so.OpstaSO;

public class PretraziRacun extends OpstaSO<Racun> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Racun)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Racun executeOperation(Object param) throws Exception {
        // Koristimo složeni upit da bismo povukli i Kupca i Poslastičara
        ArrayList<Racun> lista = (ArrayList<Racun>) (ArrayList<?>) dbr.vratiListuSlozenihSlogova((Racun) param);
        if (lista.isEmpty()) {
            throw new Exception("Sistem ne može da pronađe račun.");
        }
        Racun r = lista.get(0);
 
        StavkaRacuna filter = new StavkaRacuna();
        filter.setRacun(r);
        try {
            ArrayList<StavkaRacuna> stavke = (ArrayList<StavkaRacuna>) (ArrayList<?>) dbr.vratiListuSlozenihSlogova(filter);
            r.setStavke(stavke);
        } catch (Exception ex) {
            r.setStavke(new ArrayList<>());
        }
        return r;
    }
}
