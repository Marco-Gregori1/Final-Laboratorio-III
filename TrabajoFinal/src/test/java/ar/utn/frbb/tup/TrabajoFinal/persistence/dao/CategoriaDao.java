package ar.utn.frbb.tup.TrabajoFinal.persistence.dao;

import ar.utn.frbb.tup.TrabajoFinal.business.CategoriaBusinessImplementation;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CategoriaDao {

    Categoria categoria;

    @Mock
    CategoriaBusinessImplementation catBusiness;


    @Test
    public void testAgregarProducto_OK(){
        categoria = new Categoria("01","Electrodomesticos","Aparatos para el hogar");
        assertEquals(categoria.getListaProductos().size(), 0);
        Producto p = new Producto("Samsung",18000);
        categoria.agregarProducto(p);
        assertEquals(categoria.getListaProductos().size(), 1);
    }


}
