package ar.utn.frbb.tup.TrabajoFinal.dto;

import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;

import java.util.ArrayList;

public class AltaCategoriaDto {

    private String id;
    private String nombre;
    private String descripcion;
    private ArrayList<Producto> listaProductos;



    public AltaCategoriaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        listaProductos = new ArrayList<>();;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
