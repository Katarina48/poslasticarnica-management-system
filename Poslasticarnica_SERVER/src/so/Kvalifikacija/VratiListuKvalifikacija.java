/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Kvalifikacija;

import java.util.ArrayList;
import model.Kvalifikacija;
import so.OpstaSO;

public class VratiListuKvalifikacija extends OpstaSO<ArrayList<Kvalifikacija>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Kvalifikacija)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected ArrayList<Kvalifikacija> executeOperation(Object param) throws Exception {
        return (ArrayList<Kvalifikacija>) (ArrayList<?>) dbr.vratiListuSlogovaKriterijum((Kvalifikacija) param);
    }
}