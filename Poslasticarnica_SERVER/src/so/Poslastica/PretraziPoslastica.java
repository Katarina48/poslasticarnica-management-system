/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Poslastica;

import model.Poslastica;
import so.OpstaSO;

public class PretraziPoslastica extends OpstaSO<Poslastica> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Poslastica)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Poslastica executeOperation(Object param) throws Exception {
        return (Poslastica) dbr.vratiSlog((Poslastica) param);
    }
}