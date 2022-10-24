package ar.utn.frbb.tup.TrabajoFinal.business;

import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaProductoDto;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.CategoriaDao;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryCategoriaDao;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.InMemoryProductoDao;
import ar.utn.frbb.tup.TrabajoFinal.persistence.dao.ProductoDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CategoriasBusinessTest {

    @Mock
    private InMemoryCategoriaDao catDao;

    @InjectMocks
    private CategoriaBusinessImplementation catBusiness;

    @Test
    public void test_altaCategoria_OK(){

        // Se crea categoria y Dto de esta
        Categoria cat = new Categoria("id","123","a");
        AltaCategoriaDto catDto = new AltaCategoriaDto(cat.getNombre(),cat.getDescripcion());
        catDto.setId("id");

        Mockito.when(catBusiness.altaCategoria(catDto)).thenReturn(new Categoria());
        assertNotNull(catBusiness.displayCategorias());
    }
}
