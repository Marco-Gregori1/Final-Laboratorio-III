package ar.utn.frbb.tup.TrabajoFinal.persistence.dao;

import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductoDao {

    @Test
    public void test_empleadoPrecioNotValido_fail(){
        assertThrows(IllegalArgumentException.class,()-> new Producto("Samsung",0));
    }
}
