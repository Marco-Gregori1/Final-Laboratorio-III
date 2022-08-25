package ar.utn.frbb.tup.TrabajoFinal.business;


import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryCategoriaDao;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryProductoDao;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.rowset.serial.SerialStruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProductoBusinessImplementation {

    // No hice una interfez ya que no valia la pena para este proyecto.
    @Autowired
    InMemoryProductoDao dao;

    @Autowired
    InMemoryCategoriaDao catDao;


    public Producto altaProdcto(AltaProductoDto dto, AltaCategoriaDto catDto){
        Producto p = new Producto();
        p.setMarca(dto.getMarca());
        p.setModelo(dto.getModelo());
        p.setPrecioContado(dto.getPrecioContado());
        p.setPrecioLista(dto.getPrecioLista());
        p.setVentaOnline(false);
        p.setConfigurable(false);
        p.setCategoria(catDto.getNombre());
        // Acceder a la lista de Categorias para guardar dentro de esta el producto
        Categoria c = catDao.findCategoria(catDto.getId());
        dao.save(p,c);
        return p;
    }
    public Producto editProducto(AltaProductoDto dto, AltaCategoriaDto catDto){
        Categoria c = catDao.findCategoria(catDto.getId());
        Producto p = dao.findProductoInCategoria(dto.getId(),c);
        p.setMarca(dto.getMarca());
        p.setModelo(dto.getModelo());
        p.setPrecioContado(dto.getPrecioContado());
        p.setPrecioLista(dto.getPrecioLista());
        return p;
    }

    public boolean deleteProducto(AltaProductoDto dto, AltaCategoriaDto catDto){
        Categoria c = catDao.findCategoria(catDto.getId());
        Producto p =dao.findProductoInCategoria(dto.getId(), c);
        if (dao.delete(p,c)){return true;}
            else{return false;}
    }

    public ArrayList<Producto> displayAllProductos (){
        ArrayList<Producto> results = new ArrayList<>();
        for (Categoria c:catDao.displayCategorias()) {
            results.addAll(c.getListaProductos());
        }
        return results;
    }


    public Producto searchProductoById(AltaProductoDto dto){
        for (Categoria categoria: catDao.displayCategorias()) {
            for (Producto producto : categoria.getListaProductos()){
                if (producto.getId().equalsIgnoreCase(dto.getId())){
                    return producto;
                }
            }
        }
        throw new RuntimeException("No se encontro el producto en ninguna categoria");}


    public List<Producto> searchProductByQuerys(Map querys){

        // Gracias a que los comparadores de atributos permiten pasar variables nulas por parametro puedo hacer un filter general
        // y no uno por cada combinacion de querys pasada por el controllorer

        List<Producto> filtered = displayAllProductos().stream()
                .filter(Producto -> Producto.hasThisMarca((String) querys.get("Marca")) && Producto.hasThisModelo((String) querys.get("Modelo")) && Producto.hasThisCategoria((String) querys.get("Categoria")))
                .collect(Collectors.toList());

        return filtered;
    }


}
