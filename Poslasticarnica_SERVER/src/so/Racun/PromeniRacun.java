/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import java.util.ArrayList;
import model.Racun;
import model.StavkaRacuna;
import so.OpstaSO;

public class PromeniRacun extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Racun))
            throw new Exception("Parametri nisu validni!");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Void executeOperation(Object param) throws Exception {
        Racun r = (Racun) param;

       StavkaRacuna filter = new StavkaRacuna();
        filter.setRacun(r);
        ArrayList<StavkaRacuna> stareStavke;
        try {
            stareStavke = (ArrayList<StavkaRacuna>) (ArrayList<?>) dbr.vratiListuSlozenihSlogova(filter);
        } catch (Exception ex) {
            stareStavke = new ArrayList<>();
        }
        for (StavkaRacuna s : stareStavke) {
            s.setRacun(r);
        }

        ArrayList<StavkaRacuna> noveStavke = r.getStavke();
        for (StavkaRacuna s : noveStavke) {
            s.setRacun(r);
        }

        for (StavkaRacuna stara : stareStavke) {
            boolean postojiUNovim = false;
            for (StavkaRacuna nova : noveStavke) {
                if (stara.getRacun().getIdRacun() == nova.getRacun().getIdRacun() && stara.getRb() == nova.getRb()) {
                    postojiUNovim = true;
                    dbr.brisiSlog(stara);
                    dbr.pamtiSlog(nova);
                    break;
                }
            }
            if (!postojiUNovim) {
                dbr.brisiSlog(stara);
            }
        }

        for (StavkaRacuna nova : noveStavke) {
            boolean postojiUStarim = false;
            for (StavkaRacuna stara : stareStavke) {
                if (stara.getRacun().getIdRacun() == nova.getRacun().getIdRacun() && stara.getRb() == nova.getRb()) {
                    postojiUStarim = true;
                    break;
                }
            }
            if (!postojiUStarim) {
                dbr.pamtiSlog(nova);
            }
        }

        dbr.promeniSlog(r); // Izmena zaglavlja računa
        return null;
    }
}