/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Poslasticar;

import model.Poslasticar;
import so.OpstaSO;

public class PretraziPoslasticar extends OpstaSO<Poslasticar> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Poslasticar)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Poslasticar executeOperation(Object param) throws Exception {
        return (Poslasticar) dbr.vratiSlog((Poslasticar) param);
    }
}
