package ar.utn.frbb.tup.TrabajoFinal.persistence.dao;

import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class InMemoryProductoDao {

    public Producto save(Producto p,Categoria c){
        p.setId(String.valueOf(( new Random().nextInt(1000000))));
        c.agregarProducto(p);
        return p;
    }

    // Gracias a este metodo me ahorro la iteracion en cada funcion
    // que necesite recorren la memoria y directamente pido
    // por parametros el objeto en cuestion buscado y encontrado.
    public Producto findProductoInCategoria(String id,Categoria c){
        if (c.getListaProductos().size() == 0){throw new RuntimeException("No hay productos en esa categoria");}
        for (Producto producto : c.getListaProductos()) {
            if (producto.getId().equalsIgnoreCase(id)){
                System.out.println("Se encontro");
                return producto;
            }
        }
        throw new RuntimeException("No se encontro un producto con el identificador :"+id);
    }

    public boolean delete(Producto p,Categoria c){
        try {
            c.getListaProductos().remove(p);
            System.out.println("Se encontro y se elimino");
            return true;
        }catch (Exception e){
            System.out.println("No se pudo eliminar");
            return false;
        }
    }

}
