package edu.upc.dsa;

import edu.upc.dsa.models.Brotes;
import edu.upc.dsa.models.Casos;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BrotesManagerImpTest {


    Casos caso1;
    Casos caso2;
    Casos caso3;
    Brotes Brote;
    String idBrote;
    BrotesManager manager;


    @Before
    public void setUp() throws Exception {
        this.manager = BrotesManagerImp.getInstance();
        caso1 = new Casos("Jordi", "Rodriguez", "1998-08-01", "1998-08-01", "bajo", "hombre", "jrodrisant@hotmail.com", "6666666","PaseoFrigo", "sospechoso");
        caso2 = new Casos("Carlos", "Garcia", "2000-08-02", "2000-08-02", "alto", "hombre", "cagm@hotmail.com", "6666664", "mongolia", "confirmado");
        caso3 = new Casos("Miguel", "Rincon", "1970-01-10", "1970-01-10", "medio", "hombre", "miguel@hotmail.com", "33333333", "Barcelona", "no_es_un_caso");
        Brote = this.manager.crearBrote();
        idBrote = Brote.getId();
    }

    @After
    public void tearDown(){

        this.manager.clearAll();
    }


    @Test
    public void testAddBrote() throws Exception {

        this.manager.crearBrote();
        Assert.assertEquals(2, this.manager.sizeBrote());
    }



    @Test
    public void testaddCaso() throws Exception {
        this.manager.añadirCaso(caso1, idBrote);
        Assert.assertEquals(1, this.manager.sizeCaso(idBrote));
        this.manager.añadirCaso(caso2, idBrote);
        Assert.assertEquals(2, this.manager.sizeCaso(idBrote));
    }




}
