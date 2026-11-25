/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Poslasticar;

import java.util.ArrayList;
import model.Poslasticar;
import so.OpstaSO;

public class VratiListuPoslasticar extends OpstaSO<ArrayList<Poslasticar>> {

    @Override
    public void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Poslasticar)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected ArrayList<Poslasticar> executeOperation(Object param) throws Exception {
        return (ArrayList<Poslasticar>) (ArrayList<?>) dbr.vratiListuSlogovaKriterijum((Poslasticar) param);
    }
}