package view.model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Poslastica;

public class PoslasticaTableModel extends AbstractTableModel {
    private ArrayList<Poslastica> lista;
    private String[] kolone = {"ID", "Naziv", "Opis", "Rok trajanja", "Cena","Jedinica mere"};

    public PoslasticaTableModel(ArrayList<Poslastica> lista) { 
        this.lista = lista;
    }

    @Override
    public int getRowCount() { 
        return lista.size();
    }
    
    @Override public int getColumnCount() { 
        return kolone.length; 
    }
    
    

    @Override
    public Object getValueAt(int row, int col) {
        Poslastica p = lista.get(row);
        switch (col) {
            case 0: return p.getIdPoslastica();
            case 1: return p.getNaziv();
            case 2: return p.getOpis();
            case 3: return p.getRokTrajanja();
            case 4: return p.getCena();
            case 5: return p.getJedinicaMere();
            default: return null;
        }
    }
    public Poslastica getPoslastica(int row) {
        return lista.get(row); 
    }
    
    @Override public String getColumnName(int col) { 
        return kolone[col];
    }
    
}
