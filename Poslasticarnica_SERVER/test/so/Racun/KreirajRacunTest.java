package so.Racun;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Kupac;
import model.Poslastica;
import model.Poslasticar;
import model.Racun;
import model.StavkaRacuna;
import org.junit.Test;
import static org.junit.Assert.*;

public class KreirajRacunTest {

    KreirajRacun soKreirajRacun = new KreirajRacun();

    private Racun napraviValidanRacun() {
        Kupac kupac = new Kupac();
        kupac.setIdKupac(1);

        Poslasticar poslasticar = new Poslasticar();
        poslasticar.setIdPoslasticar(1);

        Poslastica poslastica = new Poslastica();
        poslastica.setIdPoslastica(1);

        StavkaRacuna stavka = new StavkaRacuna(100.0, 1, 100.0, poslastica);

        ArrayList<StavkaRacuna> stavke = new ArrayList<>();
        stavke.add(stavka);

        return new Racun(0, LocalDate.now(), 1, 100.0, "Gotovina", 0, 100.0, poslasticar, kupac, stavke);
    }

    @Test
    public void saveSuccessTest() throws Exception {
        Racun racun = napraviValidanRacun();

        soKreirajRacun.execute(racun);

        assertNotNull(racun);
        assertTrue(racun.getIdRacun() != 0);
    }

    @Test(expected = Exception.class)
    public void savePreconditionNullTest() throws Exception {
        soKreirajRacun.execute(null);
    }

    @Test(expected = Exception.class)
    public void savePreconditionBezKupcaTest() throws Exception {
        Racun racun = napraviValidanRacun();
        racun.setKupac(null);

        soKreirajRacun.execute(racun);
    }

    @Test(expected = Exception.class)
    public void savePreconditionPogresanUkupanIznosTest() throws Exception {
        Racun racun = napraviValidanRacun();
        racun.setUkupanIznos(9999.0);

        soKreirajRacun.execute(racun);
    }
}
