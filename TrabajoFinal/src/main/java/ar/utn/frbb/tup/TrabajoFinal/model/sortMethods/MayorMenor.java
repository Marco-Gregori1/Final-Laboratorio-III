package ar.utn.frbb.tup.TrabajoFinal.model.sortMethods;

import ar.utn.frbb.tup.TrabajoFinal.model.Producto;

import java.util.Comparator;

public class MayorMenor implements Comparator<Producto> {

    @Override
    public int compare(Producto p1, Producto p2){
        if (p1.getPrecioLista() > p2.getPrecioLista()) return -1;
        if (p1.getPrecioLista() < p2.getPrecioLista()) return  1;
        return 0;
    }
}
