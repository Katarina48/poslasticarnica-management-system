/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Kvalifikacija;

import model.Kvalifikacija;
import so.OpstaSO;

public class PretraziKvalifikacija extends OpstaSO<Kvalifikacija> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kvalifikacija)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Kvalifikacija executeOperation(Object param) throws Exception {
        return (Kvalifikacija) dbr.vratiSlog((Kvalifikacija) param);
    }
}
