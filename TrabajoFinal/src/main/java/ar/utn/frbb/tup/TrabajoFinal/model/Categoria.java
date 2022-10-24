package ar.utn.frbb.tup.TrabajoFinal.model;

import ar.utn.frbb.tup.TrabajoFinal.model.sortMethods.MayorMenor;
import ar.utn.frbb.tup.TrabajoFinal.model.sortMethods.MenorMayor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categoria {
    private String id;
    private String nombre;
    private String descripcion;
    private ArrayList<Producto> listaProductos;

    public Categoria(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaProductos = new ArrayList<>();;
    }
    public Categoria(ArrayList<Producto> listaProductos){
        this.id = "";
        this.nombre = "";
        this.descripcion = "";
        this.listaProductos = listaProductos;
    }
    public Categoria(){
        this.id = "";
        this.nombre = "";
        this.descripcion = "";
        this.listaProductos = new ArrayList<>();}

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


    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }

    public void listarProductos (){
        for (Producto producto : listaProductos){
            System.out.println("Marca :"+producto.getMarca()+" Precio Lista :"+producto.getPrecioLista());
        }
    }

    public int contarProductos(){
        int Num = 0;
        for (Producto producto : listaProductos){++Num;}
        return Num;
    }

    public void OrdenarPrecioAscendente(){
        Collections.sort(listaProductos, new MenorMayor());
    };

    public void OrdenarPrecioDescendente(){
        Collections.sort(listaProductos,new MayorMenor());
    };

    public void OrdenarPorMarca(String marca){
        ArrayList<Producto> results = new ArrayList();
        if (listaProductos.size() == 0){throw new RuntimeException("La lista de productos esta vacia, no hay nada que filtrar...");}
        for (Producto producto : listaProductos) {
            if(producto.getMarca().equalsIgnoreCase(marca)) {
                results.add(producto);
            }
        };
        setListaProductos(results);
    };

    public void OrdenarPorRango(int min, int max){
        ArrayList<Producto> results = new ArrayList();
        listaProductos.stream().filter(Producto -> Producto.getPrecioLista() > min && Producto.getPrecioLista() < max).forEach(results::add);
        setListaProductos(results);
    }
}
