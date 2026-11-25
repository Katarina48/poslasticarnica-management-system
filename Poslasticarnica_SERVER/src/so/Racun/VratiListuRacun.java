/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import java.util.ArrayList;
import model.Racun;
import model.StavkaRacuna;
import so.OpstaSO;

public class VratiListuRacun extends OpstaSO<ArrayList<Racun>> {

    @Override
    public void precondition(Object param) throws Exception {
        // Dozvoljavamo null ako klijent traži sve račune
        if (param != null && !(param instanceof Racun))
            throw new Exception("Parametri nisu validni!");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected ArrayList<Racun> executeOperation(Object param) throws Exception {
        Racun uslov = (param == null) ? new Racun() : (Racun) param;
        
        ArrayList<Racun> racuni = (ArrayList<Racun>) (ArrayList<?>) dbr.vratiListuSlozenihSlogova(uslov);

        for (Racun r : racuni) {
            StavkaRacuna filter = new StavkaRacuna();
            filter.setRacun(r); // Vežemo filter za konkretan račun
            try {
                ArrayList<StavkaRacuna> stavke = (ArrayList<StavkaRacuna>) (ArrayList<?>) dbr.vratiListuSlozenihSlogova(filter);
                r.setStavke(stavke);
            } catch (Exception ex) {
                // Ako nema stavki, postavljamo praznu listu umesto null
                r.setStavke(new ArrayList<>());
            }
        }

        return racuni;
    }
}