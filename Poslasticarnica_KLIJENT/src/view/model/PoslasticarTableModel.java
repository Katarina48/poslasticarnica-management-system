package view.model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Poslasticar;

public class PoslasticarTableModel extends AbstractTableModel {
    private ArrayList<Poslasticar> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Korisničko ime", "Telefon"};

    public PoslasticarTableModel(ArrayList<Poslasticar> lista) { 
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
        Poslasticar p = lista.get(row);
        switch (col) {
            case 0: return p.getIdPoslasticar();
            case 1: return p.getIme();
            case 2: return p.getPrezime();
            case 3: return p.getKorisnickoIme();
            case 4: return p.getTelefon();
            default: return null;
        }
    }
    public Poslasticar getPoslasticar(int row) { 
        return lista.get(row);
    }
    
    @Override
    public String getColumnName(int col) { 
        return kolone[col]; 
    }
}
