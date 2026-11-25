/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Kvalifikacija;

import model.Kvalifikacija;
import java.io.IOException;
import so.OpstaSO;

public class PromeniKvalifikacija extends OpstaSO<Void> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kvalifikacija)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    protected Void executeOperation(Object param) throws Exception {
        dbr.promeniSlog((Kvalifikacija) param);
        return null;
    }
}