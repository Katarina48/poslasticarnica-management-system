/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Poslastica;

import java.util.ArrayList;
import model.Poslastica;
import so.OpstaSO;

public class VratiListuSviPoslastica extends OpstaSO<ArrayList<Poslastica>> {

    @Override
    public void precondition(Object param) throws Exception {
        // Dozvoljavamo null parametar za povlačenje svih podataka sa servera
        if (param != null && !(param instanceof Poslastica)) {
            throw new Exception("Parametri nisu validni!");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected ArrayList<Poslastica> executeOperation(Object param) throws Exception {
        Poslastica p = (param == null) ? new Poslastica() : (Poslastica) param;
        return (ArrayList<Poslastica>) (ArrayList<?>) dbr.vratiListuSvihSlogova(p);
    }
}