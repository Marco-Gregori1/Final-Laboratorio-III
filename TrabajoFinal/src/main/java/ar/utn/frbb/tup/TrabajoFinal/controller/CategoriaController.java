package ar.utn.frbb.tup.TrabajoFinal.controller;

import ar.utn.frbb.tup.TrabajoFinal.business.CategoriaBusinessImplementation;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaBusinessImplementation categoriaBusiness;

    // CRUD Basico

    @RequestMapping (value = "/categorias")
    public ArrayList<Categoria> displayCategorias(){
            return categoriaBusiness.displayCategorias();}

    @RequestMapping (value = "/categoria/{id}")
    public Categoria displayCategoria(@RequestBody AltaCategoriaDto dto , @PathVariable String id){
        dto.setId(id);
        return categoriaBusiness.displayCategoria(dto);}

    @PostMapping(value = "/categoria/creator",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria crearCategoria(@RequestBody AltaCategoriaDto dto){return categoriaBusiness.altaCategoria(dto);}

    @PutMapping(value = "/categoria/{id}")
    public Categoria editarCategoria(@RequestBody AltaCategoriaDto dto , @PathVariable String id){
        dto.setId(id);
        return categoriaBusiness.editCategoria(dto) ;}

    @DeleteMapping (value = "/categoria/{id}")
    public String borrarCategoria(@PathVariable String id){
        AltaCategoriaDto dto = new AltaCategoriaDto("","");
        dto.setId(id);
        if(categoriaBusiness.deleteCategoria(dto)){return "Se ha borrado correctamente";}
            else{return "No se ha podido borrar";}}


    // Metodos Sort (Se necesitan poder cargar articulos dentro de las categorias)

    @GetMapping (value = "/categorias/{id}/order_price=asc")
    public Categoria displayCategoriaSortedAsc(@PathVariable String id){
        AltaCategoriaDto dto = new AltaCategoriaDto("","");
        dto.setId(id);
        return categoriaBusiness.displayCategoriaSortedAsc(dto);}

    @GetMapping (value = "/categorias/{id}/order_price=desc")
    public Categoria displayCategoriaSortedDesc( @PathVariable String id){
        AltaCategoriaDto dto = new AltaCategoriaDto("","");
        dto.setId(id);
        return categoriaBusiness.displayCategoriaSortedDes(dto);}

    @GetMapping (value = "/categorias/{id}/precio_min={min}&precio_max={max}")
    public Categoria displayCategoriaPorRango( @PathVariable String id,@PathVariable int min,@PathVariable int max){
        AltaCategoriaDto dto = new AltaCategoriaDto("","");
        dto.setId(id);
        return categoriaBusiness.displayCategoriaPorRango(dto,min,max);}

}
