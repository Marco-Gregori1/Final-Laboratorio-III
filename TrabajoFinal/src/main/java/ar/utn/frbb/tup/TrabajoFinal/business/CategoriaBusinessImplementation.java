package ar.utn.frbb.tup.TrabajoFinal.business;

import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryCategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CategoriaBusinessImplementation {

    // No hice una interfaz ya que no valia la pena para este proyecto.

    @Autowired
    InMemoryCategoriaDao dao;

    // TODO Desarrolar excepciones generales para todos los metodos

    public Categoria altaCategoria(AltaCategoriaDto dto){
        Categoria c = new Categoria();
        c.setNombre(dto.getNombre());
        c.setDescripcion(dto.getDescripcion());
        dao.save(c);
        return c;
    }
    public boolean deleteCategoria(AltaCategoriaDto dto){
        Categoria c = dao.findCategoria(dto.getId());
        System.out.println(dto.getId());
        if (dao.delete(c)){return true;}
            else {return false;}
    }
    
    public Categoria editCategoria(AltaCategoriaDto dto){
        Categoria c = dao.findCategoria(dto.getId());
        c.setNombre(dto.getNombre());
        c.setDescripcion(dto.getDescripcion());
        return c;
    }

    public Categoria displayCategoria(AltaCategoriaDto dto){
        Categoria c = dao.findCategoria(dto.getId());
        return c;
    }

    public ArrayList<Categoria> displayCategorias(){
        ArrayList<Categoria> l = dao.displayCategorias();
        return l;
    }

    public Categoria displayCategoriaSortedAsc(AltaCategoriaDto dto){
        Categoria c = dao.findCategoria(dto.getId());
        c.OrdenarPrecioAscendente();
        return c;
    }

    public Categoria displayCategoriaSortedDes(AltaCategoriaDto dto){
        Categoria c = dao.findCategoria(dto.getId());
        c.OrdenarPrecioDescendente();
        return c;
    }
    public Categoria displayCategoriaPorRango(AltaCategoriaDto dto, @Nullable int min, @Nullable int max){
        Categoria c = dao.findCategoria(dto.getId());
        c.OrdenarPorRango(min, max);
        return c;
    }
    public ArrayList<Producto> displayAllProductos (){
        ArrayList<Producto> results = new ArrayList<>();
        for (Categoria c: displayCategorias()) {
            results.addAll(c.getListaProductos());
        }
        return results;
    }

    // GET Con querys
    // Obtener todos los productos ordenados por precio (ascendente o descendente)
    // GET: /categoria?oder_price=asc (u order_price=desc)
    // Obtener productos filtrando por precio
    // GET: /categoria?precio_min=35000&precio_max=6000
    // y con marca

    // Tratando de manejar los casos en donde uno de los valores es nulo

    public List<Producto> getCategoriasByQuerys(Map qparams){

        int min, max;


        if (!(qparams.containsKey("precio_min"))) min = 0; else min = Integer.parseInt(String.valueOf(qparams.get("precio_min")));
        if (!(qparams.containsKey("precio_max"))) max = 999999999; else max = Integer.parseInt(String.valueOf(qparams.get("precio_max")));

        // De forma Ascendente
        if (qparams.containsValue("asc")) {
            List<Producto> filtered = displayAllProductos().stream().sorted(Comparator.comparing(Producto::getPrecioLista))
                    .filter(Producto -> Producto.getPrecioLista() > min && Producto.getPrecioLista() < max && Producto.hasThisMarca((String) qparams.get("Marca")))
                    .collect(Collectors.toList());
            return filtered;
        }
        // De forma Descendente
        else if (qparams.containsValue("desc")) {
            List<Producto> filtered = displayAllProductos().stream().sorted(Comparator.comparing(Producto::getPrecioLista).reversed())
                    .filter(Producto -> Producto.getPrecioLista() > min && Producto.getPrecioLista() < max && Producto.hasThisMarca((String) qparams.get("Marca")))
                    .collect(Collectors.toList());
            return filtered;
        }
        // Sin orden
        else{
            List<Producto> filtered = displayAllProductos().stream()
                    .filter(Producto -> Producto.getPrecioLista() > min && Producto.getPrecioLista() < max && Producto.hasThisMarca((String) qparams.get("Marca")))
                    .collect(Collectors.toList());
            return filtered;
        }
    }





}
