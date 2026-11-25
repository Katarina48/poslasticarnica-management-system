package view.model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Racun;

public class RacunTableModel extends AbstractTableModel {
    private ArrayList<Racun> lista;
    private String[] kolone = {"ID", "Datum", "Poslastičar", "Kupac", "Ukupno", "Popust%", "Sa popustom", "Način plaćanja"};

    public RacunTableModel(ArrayList<Racun> lista) {
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
        Racun r = lista.get(row);
        switch (col) {
            case 0: return r.getIdRacun();
            case 1: return r.getDatumIzdavanja();
            case 2: return r.getPoslasticar()!= null ? r.getPoslasticar().getIme() + " " + r.getPoslasticar().getPrezime() : "";
            case 3: return r.getKupac() != null ? r.getKupac().getIme() + " " + r.getKupac().getPrezime() : "";
            case 4: return r.getUkupanIznos();
            case 5: return r.getPopust();
            case 6: return r.getIznosSaPopustom();
            case 7: return r.getNacinPlacanja();
            default: return null;
        }
    }
    
    @Override 
    public String getColumnName(int col) { 
        return kolone[col]; 
    }
    
    public Racun getRacun(int row) {
        return lista.get(row); 
    }
}


