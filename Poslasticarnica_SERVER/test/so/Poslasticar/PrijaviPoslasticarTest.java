package so.Poslasticar;

import model.Poslasticar;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrijaviPoslasticarTest {

    PrijaviPoslasticar soPrijaviPoslasticar = new PrijaviPoslasticar();

    @Test
    public void loginSuccessTest() throws Exception {
        Poslasticar poslasticar = new Poslasticar();
        poslasticar.setKorisnickoIme("andrea");
        poslasticar.setLozinka("andrea");

        soPrijaviPoslasticar.execute(poslasticar);
    }

    @Test(expected = Exception.class)
    public void loginPreconditionNullTest() throws Exception {
        soPrijaviPoslasticar.execute(null);
    }

    @Test(expected = Exception.class)
    public void loginWrongPasswordTest() throws Exception {
        Poslasticar poslasticar = new Poslasticar();
        poslasticar.setKorisnickoIme("andrea");
        poslasticar.setLozinka("pogresna_lozinka");

        soPrijaviPoslasticar.execute(poslasticar);
    }
}