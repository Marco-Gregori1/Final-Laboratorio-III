package ar.utn.frbb.tup.TrabajoFinal.business;

import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaProductoDto;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.CategoriaDao;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryCategoriaDao;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryProductoDao;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.ProductoDao;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductoBusinessTest {

    @Mock
    InMemoryProductoDao daoMock;

    @Mock
    InMemoryCategoriaDao categoriaDaoMock;

    @InjectMocks
    ProductoBusinessImplementation implementation;

    @InjectMocks
    CategoriaBusinessImplementation catImplementation;

    @Test
    public void test_altaProducto_OK(){

        // Se crea categoria y Dto de esta
        Categoria cat = new Categoria("id","123","a");
        AltaCategoriaDto catDto = new AltaCategoriaDto(cat.getNombre(),cat.getDescripcion());
        catDto.setId("id");

        // Se crea producto
        AltaProductoDto dto = new AltaProductoDto("LG", "A0H234", 17000);

        Mockito.when(categoriaDaoMock.save(Mockito.<Categoria>any())).thenReturn(new Categoria());
        Producto p = implementation.altaProdcto(dto,catDto);

        assertEquals(1, cat.getListaProductos().size());
    }


}
