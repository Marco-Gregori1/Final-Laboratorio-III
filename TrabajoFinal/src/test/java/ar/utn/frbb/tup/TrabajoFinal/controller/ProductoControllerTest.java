package ar.utn.frbb.tup.TrabajoFinal.controller;



import ar.utn.frbb.tup.TrabajoFinal.business.CategoriaBusinessImplementation;
import ar.utn.frbb.tup.TrabajoFinal.business.ProductoBusinessImplementation;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaProductoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(ar.utn.frbb.tup.TrabajoFinal.business.controller.ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoBusinessImplementation prodBusiness;

    @MockBean
    private CategoriaBusinessImplementation catBusiness;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void crearProductoTest_OK() throws Exception {

        AltaProductoDto productoDto = new AltaProductoDto("Samsung","asdh-123",2000);

        mockMvc.perform(MockMvcRequestBuilders.post("/categoria441923/producto/creator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(productoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());



    }
}