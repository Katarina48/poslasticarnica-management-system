package view.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Kvalifikacija;

public class KvalifikacijaTableModel extends AbstractTableModel {
    private ArrayList<Kvalifikacija> lista;
    private String[] kolone = {"ID", "Naziv", "Ustanova"};

    public KvalifikacijaTableModel(ArrayList<Kvalifikacija> lista) { 
        this.lista = lista;
    }

    @Override
    public int getRowCount() { 
        return lista.size();
    }
    
    @Override 
    public int getColumnCount() {
        return kolone.length; 
    }
    

    @Override
    public Object getValueAt(int row, int col) {
        Kvalifikacija k = lista.get(row);
        switch (col) {
            case 0: return k.getIdKvalifikacija();
            case 1: return k.getNaziv();
            case 2: return k.getUstanova();
            default: return null;
        }
    }
    
    @Override 
    public String getColumnName(int col) {
        return kolone[col];
    }
    
    public Kvalifikacija getkKvalifikacija(int row) { 
        return lista.get(row); 
    }
    
    
}



