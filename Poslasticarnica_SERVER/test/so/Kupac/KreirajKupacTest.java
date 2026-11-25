package so.Kupac;

import model.KategorijaKupca;
import model.Kupac;
import org.junit.Test;
import static org.junit.Assert.*;

public class KreirajKupacTest {

    KreirajKupac soKreirajKupac = new KreirajKupac();

    @Test
    public void saveSuccessTest() throws Exception {
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(1);
        
        long time = System.currentTimeMillis() % 10000;
        Kupac kupac = new Kupac("Test", "Testic", "t" + time + "@m.com", kk);

        soKreirajKupac.execute(kupac);

        assertNotNull(kupac);
        assertTrue(kupac.getIdKupac() != 0);
    }

    @Test(expected = Exception.class)
    public void savePreconditionNullTest() throws Exception {
        soKreirajKupac.execute(null);
    }

    @Test(expected = Exception.class)
    public void saveDuplicateEmailTest() throws Exception {
        KategorijaKupca kk = new KategorijaKupca();
        kk.setIdKategorijaKupca(1);
        
        Kupac kupac = new Kupac("Marko", "Markovic", "marko@gmail.com", kk);

        soKreirajKupac.execute(kupac);
    }
}
