package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Casos {
    String id;
    String nombre;
    String apellido;
    String fechaNacimiento;
    String fechaInforme;
    String riesgo; //alto/medio/bajo
    String genero;
    String correo;
    String Telefono;
    String direccion;
    String clasificacion; //sospechoso/confirmado/nocaso

    public Casos(String nombre, String apellido, String fechaNacimiento, String fechaInforme, String riesgo, String genero, String correo, String telefono, String direccion, String clasificacion) {
        this();
        this.nombre = nombre;
        /*this.setNombre(nombre);*/
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInforme = fechaInforme;
        this.riesgo = riesgo;
        this.genero = genero;
        this.correo = correo;
        Telefono = telefono;
        this.direccion = direccion;
        this.clasificacion = clasificacion;
    }

    public Casos() { this.id = RandomUtils.getId();}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(String fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {

        return "Casos{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", fechaInforme='" + fechaInforme + '\'' +
                ", riesgo='" + riesgo + '\'' +
                ", genero='" + genero + '\'' +
                ", correo='" + correo + '\'' +
                ", Telefono=" + Telefono +
                ", direccion='" + direccion + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                '}';
    }
}
