package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.List;

public class Brotes {
    String id;
    List<Casos> listaCasos;

    public Brotes() { this.id = RandomUtils.getId();    }


    public Brotes(List<Casos> listaCasos) {
        this();
        this.listaCasos = listaCasos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Casos> getListaCasos() {
        return listaCasos;
    }

    public void setListaCasos(List<Casos> listaCasos) {
        this.listaCasos = listaCasos;
    }

    @Override
    public String toString() {
        return "Brotes{" +
                "id='" + id + '\'' +
                ", listaCasos=" + listaCasos +
                '}';
    }
}
