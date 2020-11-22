package edu.upc.dsa;

import edu.upc.dsa.models.Brotes;
import edu.upc.dsa.models.Casos;

import java.util.List;

public interface BrotesManager {

    public Brotes crearBrote();
    public List<Brotes> listarBrotes();
    public void añadirCaso(Casos o, String idBrote);
    public List<Casos> listarCasos(String idBrote);
    public int sizeBrote();
    public int sizeCaso(String idBrote);
    public void clearAll();
}
