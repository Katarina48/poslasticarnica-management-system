/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Kvalifikacija;

import model.Kvalifikacija;
import so.OpstaSO;

public class ObrisiKvalifikacija extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kvalifikacija)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.brisiSlog((Kvalifikacija) param);
        return null;
    }
}