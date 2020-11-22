package edu.upc.dsa;

import edu.upc.dsa.models.Brotes;
import edu.upc.dsa.models.Casos;
import org.apache.log4j.Logger;

import java.util.*;

public class BrotesManagerImp implements BrotesManager {

    protected List<Casos> listaCasos;
    private static BrotesManager instance;
    protected List<Brotes> listaBrotes;
    protected HashMap<String, Brotes> brotesContendor;

    final static Logger logger = Logger.getLogger(BrotesManagerImp.class);

    public BrotesManagerImp() {
        this.listaBrotes = new LinkedList<>();
        this.listaCasos = new LinkedList<>();

        Casos Caso1 = new Casos("Jordi", "Rodriguez", "1998-08-01", "1998-08-01", "bajo", "hombre", "jrodrisant@hotmail.com", "6666666","PaseoFrigo", "sospechoso");
        Casos Caso2 = new Casos("Carlos", "Garcia", "2000-08-02", "2000-08-02", "alto", "hombre", "cagm@hotmail.com", "6666664", "mongolia", "confirmado");
        Casos Caso3 = new Casos("Miguel", "Rincon", "1970-01-10", "1970-01-10", "medio", "hombre", "miguel@hotmail.com", "33333333", "Barcelona", "no_es_un_caso");

        this.listaCasos.add(Caso1);
        this.listaCasos.add(Caso2);
        this.listaCasos.add(Caso3);

        this.brotesContendor = new HashMap<String, Brotes>();
    }


    public static BrotesManager getInstance() {
        if (instance==null) instance = new BrotesManagerImp();
        return instance;
    }


    @Override
    public Brotes crearBrote() {

        Brotes BroteFinal = new Brotes(new LinkedList<Casos>());
        this.brotesContendor.put(BroteFinal.getId(), BroteFinal);
        listaBrotes.add(BroteFinal);
        logger.info("el id del brote es " +BroteFinal.getId());
        logger.info("la lista del brote es " +this.brotesContendor.get(BroteFinal.getId()));
        return BroteFinal;


    }

    @Override
    public List<Brotes> listarBrotes() {

        List<Brotes> listaBrotesGet = new LinkedList<>();
        for (Brotes b : brotesContendor.values()){
            listaBrotesGet.add(b);
            logger.info("el brote añadido es: " +b);
        }
        logger.info("la lista de brote es : " +listaBrotesGet);
        return listaBrotesGet;
    }

    @Override
    public void añadirCaso(Casos o, String idBrote) {

        this.brotesContendor.get(idBrote).getListaCasos().add(o);
        logger.info("se ha añadido el caso  " + o.getId() + this.brotesContendor.get(idBrote).getListaCasos() );

    }

    @Override
    public List<Casos> listarCasos(String idBrote) {

        List<Casos> listaCasosFinal = new LinkedList<Casos>();
        List<Casos> listaCasosConfirmado =  new LinkedList<Casos>();
        List<Casos> listaCasosSospechoso = new LinkedList<Casos>();
        List<Casos> listaCasosNoCaso = new LinkedList<Casos>();

        logger.info("listar casos por id brote " +idBrote );

        if (this.brotesContendor.get(idBrote) == null){
            logger.error("ListaCasos es nullo , no existe idBrote");
            return null;
        }

        listaCasosFinal = this.brotesContendor.get(idBrote).getListaCasos();
        logger.error("ListaCasosFinal antes " +listaCasosFinal );

        listaCasosFinal = ordenarCasos(listaCasosFinal);

        for(Casos c : listaCasosFinal){
            switch (c.getClasificacion()) {
                case "confirmado":
                    listaCasosConfirmado.add(c);
                    break;
                case "sospechoso":
                    listaCasosSospechoso.add(c);
                    break;
                case "no caso":
                    listaCasosNoCaso.add(c);
                    break;
                default:
                    logger.error("error al introducir un caso no apto " +c );
            }
        }

        listaCasosFinal.clear();
        listaCasosFinal.addAll(listaCasosConfirmado);
        listaCasosFinal.addAll(listaCasosSospechoso);
        listaCasosFinal.addAll(listaCasosNoCaso);

        return listaCasosFinal;
    }

    @Override
    public int sizeBrote() {
        return this.brotesContendor.size();
    }

    @Override
    public int sizeCaso(String idBrote) {
        return this.brotesContendor.get(idBrote).getListaCasos().size();
    }

    @Override
    public void clearAll() {
        this.brotesContendor.clear();
    }


    public List<Casos> ordenarCasos(List<Casos> listaCasosOrden) {

        Collections.sort(listaCasosOrden, new Comparator<Casos>(){
            @Override
            public int compare(Casos caso1, Casos caso2) {

                logger.info("comparing por fecha el primer caso: " +caso1 +" segundo caso: " +caso2);
                return (int)(caso2.getFechaInforme().compareTo(caso1.getFechaInforme()));
            }
        });
        logger.info("return lista de casos ordenados por fecha (En String) " + listaCasosOrden);
        return listaCasosOrden;
    }



}
