package ar.utn.frbb.tup.TrabajoFinal.business.controller;



import ar.utn.frbb.tup.TrabajoFinal.business.ProductoBusinessImplementation;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaProductoDto;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;

import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductoController {

    @Autowired
    ProductoBusinessImplementation productoBusiness;


    @PostMapping(value = "/categoria{idCat}/producto/creator", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto crearProducto(@RequestBody AltaProductoDto dto,@PathVariable String idCat) {
        AltaCategoriaDto catDto = new AltaCategoriaDto("","");
        catDto.setId(idCat);
        return productoBusiness.altaProdcto(dto, catDto);
    }

    @PutMapping(value = "/categoria{idCat}/producto{idProducto}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto editProducto(@RequestBody AltaProductoDto dto,@PathVariable String idProducto,@PathVariable String idCat){
        AltaCategoriaDto catDto = new AltaCategoriaDto("","");
        catDto.setId(idCat);
        dto.setId(idProducto);
        return productoBusiness.editProducto(dto,catDto);
    }

    @DeleteMapping(value = "/categoria{idCat}/producto{idProducto}")
        public String deleteProducto(@PathVariable String idProducto,@PathVariable String idCat){
        AltaCategoriaDto catDto = new AltaCategoriaDto("","");
        AltaProductoDto dto = new AltaProductoDto("","",0);
        catDto.setId(idCat);
        dto.setId(idProducto);
        if(productoBusiness.deleteProducto(dto,catDto)){return "Se ha borrado correctamente";}
        else{return "No se ha podido borrar";}
    }

    // Get producto by ID // sin categoria
    @GetMapping(value = "/producto{id}")
        public Producto getProductoById(@PathVariable String id){
        AltaProductoDto dto = new AltaProductoDto("","",0);
        dto.setId(id);
        return productoBusiness.searchProductoById(dto);
    }


    @GetMapping(value = "/producto")
    public List<Producto> getProductoByQuerys(@RequestParam(required = false) Map<String,String> qparams) {
        if (qparams.size() == 0){return productoBusiness.displayAllProductos();}
        for (String s: qparams.keySet()) {
            if (!(s.equals("Marca") || s.equals("Modelo") || s.equals("Categoria")) ){
                System.out.println("mal querys");
            }
        }
        return productoBusiness.searchProductByQuerys(qparams);
    }

}
