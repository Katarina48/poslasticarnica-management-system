package so.Poslastica;

import model.JedinicaMere;
import model.Poslastica;
import org.junit.Test;
import static org.junit.Assert.*;

public class KreirajPoslasticaTest {

    KreirajPoslastica soKreirajPoslastica = new KreirajPoslastica();

    @Test
    public void saveSuccessTest() throws Exception {
        Poslastica poslastica = new Poslastica("Test kolac " + System.currentTimeMillis(),
                "Opis test kolaca", "5 dana", 300.0, JedinicaMere.KOMAD);

        soKreirajPoslastica.execute(poslastica);

        assertNotNull(poslastica);
        assertTrue(poslastica.getIdPoslastica() != 0);
    }

    @Test(expected = Exception.class)
    public void savePreconditionNullTest() throws Exception {
        soKreirajPoslastica.execute(null);
    }

    @Test(expected = Exception.class)
    public void saveDuplicateNazivTest() throws Exception {
        Poslastica poslastica = new Poslastica("Krempita", "Opis", "3 dana", 250.0, JedinicaMere.KOMAD);

        soKreirajPoslastica.execute(poslastica);
    }
}