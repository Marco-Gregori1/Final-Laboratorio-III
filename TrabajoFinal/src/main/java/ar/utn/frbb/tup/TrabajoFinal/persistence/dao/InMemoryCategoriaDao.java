package ar.utn.frbb.tup.TrabajoFinal.persistence.dao;

import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class InMemoryCategoriaDao {

    public static ArrayList<Categoria> categorias = new ArrayList<>();

    public Categoria save(Categoria c){
        c.setId(String.valueOf(( new Random().nextInt(1000000))));
        categorias.add(c);
        return c;
    }


    public boolean delete(Categoria c){
        try {
            categorias.remove(c);
            System.out.println("Se encontro y se elimino");
            return true;
        }catch (Exception e){
            System.out.println("No se pudo eliminar");
            return false;
        }}

    public Categoria findCategoria(String id) {
        if (categorias.size() == 0){throw new RuntimeException("No hay categorias a mostrar;");}
        for (Categoria categoria : categorias) {
            if (categoria.getId().equalsIgnoreCase(id)){
                return categoria;
            }
        }
        throw new RuntimeException("No se encontro una catecoria con el identificador :"+id);
    }

    public ArrayList<Categoria> displayCategorias(){
        if (categorias.size() == 0){throw new RuntimeException("No hay categorias a mostrar;");}
        ArrayList<Categoria>listaCategorias = new ArrayList<>();
        for (Categoria categoria : categorias) {
            listaCategorias.add(categoria);
        }
        return listaCategorias;
    }

}
