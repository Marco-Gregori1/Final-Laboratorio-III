package ar.utn.frbb.tup.TrabajoFinal.business;

import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryCategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
    public Categoria displayCategoriaPorRango(AltaCategoriaDto dto,int min,int max){
        Categoria c = dao.findCategoria(dto.getId());
        c.OrdenarPorRango(min, max);
        return c;
    }





}
